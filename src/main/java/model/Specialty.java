package model;

import java.util.Objects;

public class Specialty {

    private Long id;
    private String name;

    public Specialty(Long id, String spec) {
        this.id = id;
        this.name = spec;
    }

    public Specialty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", spec='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(getId(), specialty.getId()) && Objects.equals(getName(), specialty.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
