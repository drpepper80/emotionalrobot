package com.blindcarboncopy.emotionalrobot.data;

import android.os.AsyncTask;

import com.blindcarboncopy.emotionalrobot.event.NodeRedMessageEvent;
import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;
import com.google.gson.Gson;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import com.neovisionaries.ws.client.WebSocketFrame;

import java.io.IOException;

import de.greenrobot.event.EventBus;

/**
 * Handles all web socket interactions with the NodeRed server.
 */
public class WebSocketManager implements IConnectionManager {

    private WebSocket mWebSocket;

    @Override
    public void attachToInterface() {
        detachFromInterface();
        startListening("ws://emo-node.eu-gb.mybluemix.net/ws/all");
    }

    @Override
    public void detachFromInterface() {
        if (mWebSocket != null && mWebSocket.isOpen()) {
            mWebSocket.disconnect();
        }
    }

    /**
     * Starts listening for messages on a remote web socket.
     */
    private void startListening(final String feedUrl) {
        detachFromInterface();

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

                        @Override
                        public void onDisconnected(WebSocket websocket,
                                                   WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame,
                                                   boolean closedByServer) throws Exception {
                            resetConnection();
                        }
                    });

                    mWebSocket.connect();
                } catch (IOException | WebSocketException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void notifyTextMessage(String text) {
        Gson gson = new Gson();
        NodeRedMessage message = gson.fromJson(text, NodeRedMessage.class);

        EventBus.getDefault().post(new NodeRedMessageEvent(message));
    }

    /**
     * Resets the current connection.
     */
    private void resetConnection() {
        attachToInterface();
    }
}
