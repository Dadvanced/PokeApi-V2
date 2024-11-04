package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.StringJoiner;

public class Pokemon {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;
    private List<Form> forms;
    private Sprites sprites;
    private List<Stats> stats;

    @SerializedName("base_experience")
    private int baseExperience;

    public Pokemon() {
    }

    public Pokemon(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "Pokemon{", "}");

        if (id > 0) joiner.add("id=" + id);
        if (name != null) joiner.add("name='" + name + "'");
        if (baseExperience > 0) joiner.add("baseExperience=" + baseExperience);
        if (height > 0) joiner.add("height=" + height);
        if (weight > 0) joiner.add("weight=" + weight);
        if (sprites != null && sprites.getFrontDefault() != null) joiner.add("sprite='" + sprites.getFrontDefault() + "'");
        if (stats != null && !stats.isEmpty()) joiner.add(stats.toString());

        return joiner.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Sprites getSprites() {
        return this.sprites;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }
}
