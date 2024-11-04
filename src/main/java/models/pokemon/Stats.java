package models.pokemon;

import com.google.gson.annotations.SerializedName;

public class Stats {

    @SerializedName("base_stat")
    private int baseStat;

    private int effort;
    private Stat stat;

    @Override
    public String toString() {
        return "Stats{" +
                "baseStat=" + baseStat +
                ", effort=" + effort +
                ", stat=" + stat +
                '}';
    }

    private void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }
}
