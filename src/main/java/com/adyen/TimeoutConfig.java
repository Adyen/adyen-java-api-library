package com.adyen;

public class TimeoutConfig {
    private int connectionTimeoutMillis;
    private int readTimeoutMillis;

    public TimeoutConfig(int connectionTimeoutMillis, int readTimeoutMillis) {
        this.connectionTimeoutMillis = connectionTimeoutMillis;
        this.readTimeoutMillis = readTimeoutMillis;
    }

    public int getConnectionTimeoutMillis() {
        return connectionTimeoutMillis;
    }

    public int getReadTimeoutMillis() {
        return readTimeoutMillis;
    }
}
