package com.blindcarboncopy.emotionalrobot.data;

import android.os.AsyncTask;
import android.util.Log;

import com.blindcarboncopy.emotionalrobot.event.NodeRedMessageEvent;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;
import com.google.gson.Gson;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;

import de.greenrobot.event.EventBus;

/**
 * Handles all web socket interactions with the NodeRed server.
 */
public class WebSocketManager {

    private static String TAG = WebSocketManager.class.getName();

    private static String HAPPY_URL = "ws://emo-node.eu-gb.mybluemix.net/ws/happy";
    private static String ALL_URL = "ws://emo-node.eu-gb.mybluemix.net/ws/all";

    private WebSocket mWebSocket;

    public WebSocketManager() {
    }

    public void switchToHappyFeed() {
        stopListening();
        Log.d(TAG, "Switching to HAPPY feed.");
        startListening(HAPPY_URL);
        Log.d(TAG, "Switched to HAPPY feed.");
    }

    public void switchToAllFeed() {
        stopListening();
        Log.d(TAG, "Switching to ALL feed.");
        startListening(ALL_URL);
        Log.d(TAG, "Switched to ALL feed.");
    }

    /**
     * Starts listening for messages on a remote web socket.
     */
    private void startListening(final String feedUrl) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mWebSocket = new WebSocketFactory().createSocket(feedUrl);
                    mWebSocket.addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket websocket, final String text) throws Exception {
                            notifyTextMessage(text);
                        }
                    });

                    mWebSocket.connect();
                } catch (IOException | WebSocketException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void stopListening() {
        if (mWebSocket != null) {
            mWebSocket.disconnect();
        }
    }

    private void notifyTextMessage(String text) {
        Gson gson = new Gson();
        NodeRedMessage message = gson.fromJson(text, NodeRedMessage.class);

        NodeRedMessageEvent messageEvent = new NodeRedMessageEvent(message);
        EventBus.getDefault().post(messageEvent);
    }
}
