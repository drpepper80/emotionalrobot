package com.blindcarboncopy.emotionalrobot.data;

/**
 * Defines behaviour for handling remote feed connections.
 */
public interface IConnectionManager {
    void startListening();
    void stopListening();
}
