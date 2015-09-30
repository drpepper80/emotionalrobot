package com.blindcarboncopy.emotionalrobot.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.data.WebSocketManager;
import com.blindcarboncopy.emotionalrobot.event.NodeRedMessageEvent;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private WebSocketManager mWebSocketManager;
    private List<NodeRedMessage> mDataFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        mWebSocketManager = new WebSocketManager();

        mRecyclerView = (RecyclerView) findViewById(R.id.feed);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);

        initialiseFeed();
    }

    public void onEvent(final NodeRedMessageEvent messageEvent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mDataFeed.add(0, messageEvent.message);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    void initialiseFeed() {
        mDataFeed = new ArrayList<>();
        mAdapter = new FeedAdapter(mDataFeed, this);
        mRecyclerView.setAdapter(mAdapter);

        mWebSocketManager.startListening();
    }
}
