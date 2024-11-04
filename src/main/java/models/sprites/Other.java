package models.sprites;

import com.google.gson.annotations.SerializedName;

public class Other {
    private Showdown showdown;

    @SerializedName("dream_world")
    private DreamWorld dreamWorld;

    @SerializedName("official-artwork")
    private OfficialArtWork officialArtWork;

    public Showdown getShowdown() {
        return showdown;
    }

    public void setShowdown(Showdown showdown) {
        this.showdown = showdown;
    }

    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorld dreamWorld) {
        this.dreamWorld = dreamWorld;
    }

    public OfficialArtWork getOfficialArtWork() {
        return officialArtWork;
    }

    public void setOfficialArtWork(OfficialArtWork officialArtWork) {
        this.officialArtWork = officialArtWork;
    }
}
