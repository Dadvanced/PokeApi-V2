package models.sprites;

import com.google.gson.annotations.SerializedName;

public class OfficialArtWork {

    @SerializedName("front_default")
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }
}
