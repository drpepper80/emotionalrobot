package com.blindcarboncopy.emotionalrobot.data;

/**
 * Defines behaviour for handling WebSockets.
 */
public interface IWebSocketManager {
    void startListening();
    void stopListening();
}
