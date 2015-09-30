package com.blindcarboncopy.emotionalrobot.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;
import com.google.gson.Gson;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.feed);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);

        initialiseFeed();
    }

    void initialiseFeed() {

        final List<NodeRedMessage> nodeRedMessages = new ArrayList<>();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    WebSocket webSocket = new WebSocketFactory().createSocket("ws://emo-node.eu-gb.mybluemix.net/ws/happy");
                    webSocket.addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket websocket, final String text) throws Exception {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Gson gson = new Gson();
                                    NodeRedMessage message = gson.fromJson(text, NodeRedMessage.class);
                                    nodeRedMessages.add(0, message);
                                    mAdapter.notifyDataSetChanged();
                                }
                            });
                        }
                    });

                    webSocket.connect();
                } catch (IOException | WebSocketException e) {
                    e.printStackTrace();
                }
            }
        });

        mAdapter = new FeedAdapter(nodeRedMessages, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
