package com.blindcarboncopy.emotionalrobot.event;

import com.blindcarboncopy.emotionalrobot.model.nodered.NodeRedMessage;

/**
 * Event containing a new incoming message from NodeRed.
 */
public class NodeRedMessageEvent {
    public NodeRedMessageEvent(final NodeRedMessage message) {
        this.message = message;
    }

    /**
     * The message from NodeRed.
     */
    public NodeRedMessage message;
}
