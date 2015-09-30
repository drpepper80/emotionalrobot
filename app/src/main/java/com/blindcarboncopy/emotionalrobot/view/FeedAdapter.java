package com.blindcarboncopy.emotionalrobot.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import java.util.List;

/**
 * RecylerView adapter for the RSS data feed.
 */
public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NodeRedMessage> mDataFeed;
    private Context mContext;

    public FeedAdapter(List<NodeRedMessage> dataFeed, Context context) {
        mDataFeed = dataFeed;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_row_view, parent, false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NodeRedMessage message = mDataFeed.get(i);

        FeedViewHolder feedViewHolder = (FeedViewHolder) viewHolder;
        feedViewHolder.context = mContext;
        feedViewHolder.title.setText(message.getTitle());
        feedViewHolder.payload.setText(message.getPayload());
        feedViewHolder.url = message.getUrl();
    }

    @Override
    public int getItemCount() {
        return mDataFeed.size();
    }
}
