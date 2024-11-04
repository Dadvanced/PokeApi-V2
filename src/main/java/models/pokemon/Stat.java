package models.pokemon;

public class Stat {
    private String name;
    private String url;

    @Override
    public String toString() {
        return "Stat{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
