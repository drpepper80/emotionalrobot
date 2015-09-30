package com.blindcarboncopy.emotionalrobot.data;

import android.os.AsyncTask;

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

    /**
     * Starts listening for messages on a remote web socket.
     */
    public void startListening() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    WebSocket webSocket = new WebSocketFactory().createSocket("ws://emo-node.eu-gb.mybluemix.net/ws/happy");
                    webSocket.addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket websocket, final String text) throws Exception {
                            notifyTextMessage(text);
                        }
                    });

                    webSocket.connect();
                } catch (IOException | WebSocketException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void notifyTextMessage(String text) {
        Gson gson = new Gson();
        NodeRedMessage message = gson.fromJson(text, NodeRedMessage.class);

        NodeRedMessageEvent messageEvent = new NodeRedMessageEvent(message);
        EventBus.getDefault().post(messageEvent);
    }

    /**
     * Stops listening for messages on a remote web socket.
     */
    public void stopListening() {

    }
}
