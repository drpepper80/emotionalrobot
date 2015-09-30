package com.blindcarboncopy.emotionalrobot.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blindcarboncopy.emotionalrobot.R;

/**
 * ViewHolder for rows in the News Feed.
 */
public class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title;
    public TextView payload;

    public Context context;
    public String url;

    public FeedViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.article_title);
        payload = (TextView) itemView.findViewById(R.id.article_payload);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO: This shouldnt live here! Fix it.
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }
}
