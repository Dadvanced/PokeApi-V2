package models.sprites;

import com.google.gson.annotations.SerializedName;

public class GenerationV {
    @SerializedName("black-white")
    private BlackWhite blackWhite;

    public BlackWhite getBlackWhite() {
        return blackWhite;
    }

    public void setBlackWhite(BlackWhite blackWhite) {
        this.blackWhite = blackWhite;
    }
}
