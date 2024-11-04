package models.sprites;

import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("front_default")
    private String frontDefault;

    private Other other;

    private Versions versions;

    public void setFrontDefault(String url) {
        this.frontDefault = url;
    }

    public String getFrontDefault() {
        return this.frontDefault;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}
