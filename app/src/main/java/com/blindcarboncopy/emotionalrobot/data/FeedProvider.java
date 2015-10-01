package com.blindcarboncopy.emotionalrobot.data;

import com.blindcarboncopy.emotionalrobot.event.FeedUpdatedEvent;
import com.blindcarboncopy.emotionalrobot.event.NodeRedMessageEvent;
import com.blindcarboncopy.emotionalrobot.model.NodeRedMessage;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Responsible for fetching and caching RSS feed data, and providing it to consumers
 * upon request. Can provide either all or only "happy" feed data.
 */
public class FeedProvider implements IFeedProvider {

    private List<NodeRedMessage> mMessagesCache;
    private IConnectionManager connectionManager;

    private final Object syncLock = new Object();

    public FeedProvider(IConnectionManager connectionManager) {
        EventBus.getDefault().register(this);

        mMessagesCache = new ArrayList<>();
        this.connectionManager.startListening();

        this.connectionManager = connectionManager;
    }

    @Override
    public List<NodeRedMessage> getMessages(boolean showOnlyHappy) {
        synchronized (syncLock) {
            if (showOnlyHappy) {
                return filterMessages(mMessagesCache);
            } else {
                return mMessagesCache;
            }
        }
    }

    /**
     * Event handler for when a new NodeRedMessage is received from the server.
     *
     * @param messageEvent The received message event.
     */
    public void onEvent(final NodeRedMessageEvent messageEvent) {
        synchronized (syncLock) {
            mMessagesCache.add(messageEvent.message);
            EventBus.getDefault().post(new FeedUpdatedEvent());
        }
    }

    /**
     * Takes the local message cache and returns a subset containing only content considered to be
     * "happy".
     *
     * @param messages The list of messages to be filtered.
     * @return The filtered message list.
     */
    private List<NodeRedMessage> filterMessages(List<NodeRedMessage> messages) {
        List<NodeRedMessage> happyMessages = new ArrayList<>();

        for (NodeRedMessage message : messages) {
            boolean messageIsHappy = Math.round(message.getSentiment().getScore()) > 0;
            if (messageIsHappy) {
                happyMessages.add(message);
            }
        }

        return happyMessages;
    }
}