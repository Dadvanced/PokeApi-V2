package models;

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

    private void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return this.name;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private String getUrl() {
        return this.url;
    }
}
