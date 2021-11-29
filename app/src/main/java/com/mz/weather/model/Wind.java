package com.mz.weather.model;

import java.io.Serializable;

public class Wind implements Serializable {
    private float speed;

    public Wind(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
