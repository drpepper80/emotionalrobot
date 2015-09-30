package com.blindcarboncopy.emotionalrobot.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.data.WebSocketManager;
import com.blindcarboncopy.emotionalrobot.event.NodeRedMessageEvent;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<NodeRedMessage> mDataFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        Switch mMoodSwitch = (Switch) findViewById(R.id.mood_switch);
        mMoodSwitch.setOnCheckedChangeListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.feed);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);

        initialiseFeed();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        buttonView.setText(isChecked ? R.string.happy_label : R.string.sad_label);
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
        WebSocketManager mWebSocketManager = new WebSocketManager();
        mDataFeed = new ArrayList<>();
        mAdapter = new FeedAdapter(mDataFeed, this);
        mRecyclerView.setAdapter(mAdapter);

        mWebSocketManager.startListening();
    }
}
