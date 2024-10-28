package models;

import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("front_default")
    private String frontDefault;

    public void setFrontDefault(String url) {
        this.frontDefault = url;
    }

    public String getFrontDefault() {
        return this.frontDefault;
    }
}
