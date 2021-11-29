package com.mz.weather.model;

import java.io.Serializable;

public class Weather implements Serializable {
    private String icon;
    private String description;

    public Weather(String icon, String main) {
        this.icon = icon;
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
