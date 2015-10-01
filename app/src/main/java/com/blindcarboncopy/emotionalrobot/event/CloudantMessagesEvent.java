package com.blindcarboncopy.emotionalrobot.event;

import com.blindcarboncopy.emotionalrobot.model.cloudant.messages.CloudantMessageRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DrPepper80 on 01/10/2015.
 */
public class CloudantMessagesEvent {

    public CloudantMessagesEvent(final ArrayList<CloudantMessageRecord> messages) {
        this.messages = messages;
    }

    /**
     * The messages from NodeRed.
     */
    public final List<CloudantMessageRecord> messages;
}
