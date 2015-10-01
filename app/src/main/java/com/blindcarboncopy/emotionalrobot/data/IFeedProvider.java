package com.blindcarboncopy.emotionalrobot.data;

import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

import java.util.List;

/**
 * Defines behaviour for a feed provider.
 */
public interface IFeedProvider {
    /**
     * Gets an un-filtered message feed list from the content provider.
     *
     * @param showOnlyHappy If true, only happy messages are included in the returned message list.
     * @return A list of messages.
     */
    public List<NodeRedMessage> getMessages(boolean showOnlyHappy);
}
