package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    // TODO añadir más atributos como imagen, gif estadísticas...

    private int id;
    private String name;
    private int height;
    private int weight;
    private List<Ability> abilities;
    private List<Form> forms;
    private Sprites sprites;

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
        return "Pokemon{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", baseExperience = " + baseExperience +
                ", height = " + height +
                ", weight = " + weight +
                ", abilities = " + abilities +
                ", forms = " + forms +
                ", sprites = " + sprites +
                '}';
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
}
