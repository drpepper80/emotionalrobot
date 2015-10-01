package com.blindcarboncopy.emotionalrobot.data;

/**
 * Defines behaviour for handling remote feed connections.
 */
interface IConnectionManager {
    void attachToInterface();
    void detachFromInterface();
}
