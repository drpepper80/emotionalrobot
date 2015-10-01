package com.blindcarboncopy.emotionalrobot.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * RecylerView adapter for the RSS data feed.
 */
public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<NodeRedMessage> mDataFeed;
    private final Context mContext;

    public FeedAdapter(final List<NodeRedMessage> dataFeed, final Context context) {
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
        feedViewHolder.title.setText(message.getArticle().getTitle());
        feedViewHolder.payload.setText(StringUtils.abbreviate(message.getPayload(), 120));
        feedViewHolder.url = message.getArticle().getLink();

        // A neutral message
        if (Math.round(message.getSentiment().getScore()) == 0)
        {
            Log.d("SENTIMENT",message.get_msgid() + " This is a neutral message, it has a score of " + message.getSentiment().getScore());
            feedViewHolder.feedRelativeLayout.setBackgroundColor(Color.parseColor("#808080"));
        }
        // A happy Message
        else if (Math.round(message.getSentiment().getScore()) > 0)
        {
            Log.d("SENTIMENT",message.get_msgid() + " This is a happy message, it has a score of " + message.getSentiment().getScore());
            feedViewHolder.feedRelativeLayout.setBackgroundColor(Color.parseColor("#FFC0CB"));
        }
        // A sad Message
        else
        {
            Log.d("SENTIMENT",message.get_msgid() + " This is a sad message, it has a score of " + message.getSentiment().getScore());
            feedViewHolder.feedRelativeLayout.setBackgroundColor(Color.parseColor("#4f4fb6"));
        }


    }

    @Override
    public int getItemCount() {
        return mDataFeed.size();
    }
}
