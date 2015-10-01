package com.blindcarboncopy.emotionalrobot.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.data.FeedProvider;
import com.blindcarboncopy.emotionalrobot.data.IFeedProvider;
import com.blindcarboncopy.emotionalrobot.data.WebSocketManager;
import com.blindcarboncopy.emotionalrobot.event.FeedUpdatedEvent;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<NodeRedMessage> mDataFeed = new ArrayList<>();

    private TextView mAllIcon;
    private TextView mHappyIcon;
    private Switch mMoodSwitch;
    private IFeedProvider mFeedProvider = new FeedProvider(new WebSocketManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        mAllIcon = (TextView) findViewById(R.id.all_label);
        mHappyIcon = (TextView) findViewById(R.id.happy_label);

        mHappyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoodSwitch.setChecked(true);
            }
        });

        mAllIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoodSwitch.setChecked(false);
            }
        });

        mMoodSwitch = (Switch) findViewById(R.id.mood_switch);
        mMoodSwitch.setOnCheckedChangeListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.feed);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setHasFixedSize(true);

        initialiseFeed();
    }

    @Override
    public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
        refreshFeed(isChecked);
    }

    public void onEvent(final FeedUpdatedEvent feedUpdatedEvent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                refreshFeed(mMoodSwitch.isChecked());
            }
        });
    }

    /**
     * Does the initial setup of the feed and populates it.
     */
    void initialiseFeed() {
        mAdapter = new FeedAdapter(mDataFeed, this);
        mRecyclerView.setAdapter(mAdapter);

        refreshFeed(mMoodSwitch.isChecked());
    }

    /**
     * Fetches message data from the FeedProvider and refreshes the list.
     *
     * @param showOnlyHappy If true, only feed data considered to be "happy" will be returned.
     */
    void refreshFeed(final boolean showOnlyHappy) {
        mDataFeed.clear();
        mDataFeed.addAll(mFeedProvider.getMessages(showOnlyHappy));

        mAdapter.notifyDataSetChanged();
    }
}