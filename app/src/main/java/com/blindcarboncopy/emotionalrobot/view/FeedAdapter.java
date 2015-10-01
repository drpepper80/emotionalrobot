package com.blindcarboncopy.emotionalrobot.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blindcarboncopy.emotionalrobot.R;
import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * RecyclerView adapter for the RSS data feed.
 */
class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<NodeRedMessage> mDataFeed;
    private final Context mContext;

    public FeedAdapter(final List<NodeRedMessage> dataFeed, final Context context) {
        mDataFeed = dataFeed;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_card_view, parent, false);

        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        NodeRedMessage message = mDataFeed.get(i);
        FeedViewHolder feedViewHolder = (FeedViewHolder) viewHolder;
        int sentimentScore = Math.round(message.getSentiment().getScore());
        feedViewHolder.context = mContext;
        feedViewHolder.title.setText(message.getArticle().getTitle());
        feedViewHolder.payload.setText(Html.fromHtml(StringUtils.abbreviate(message.getPayload(), 120)));
        feedViewHolder.url = message.getArticle().getLink();

        // A neutral message
        if (sentimentScore == 0) {
            Log.d("SENTIMENT", message.get_msgid() + " This is a neutral message, it has a score of " + sentimentScore);
            feedViewHolder.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.neutral_message));
        }
        // A happy Message
        else if (sentimentScore > 0) {
            Log.d("SENTIMENT", message.get_msgid() + " This is a happy message, it has a score of " + sentimentScore);
            feedViewHolder.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.happy_message));
        }
        // A sad Message
        else {
            Log.d("SENTIMENT", message.get_msgid() + " This is a sad message, it has a score of " + sentimentScore);
            feedViewHolder.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.sad_message));
        }
    }

    @Override
    public int getItemCount() {
        return mDataFeed.size();
    }
}
