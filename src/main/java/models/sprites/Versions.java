package models.sprites;

import com.google.gson.annotations.SerializedName;

public class Versions {
    @SerializedName("generation-v")
    private GenerationV generationV;

    public GenerationV getGenerationV() {
        return generationV;
    }

    public void setGenerationV(GenerationV generationV) {
        this.generationV = generationV;
    }
}
