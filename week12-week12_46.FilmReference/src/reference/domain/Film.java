package reference.domain;

import java.util.Objects;

public class Film {
    private String name;

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return name.equals(film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
