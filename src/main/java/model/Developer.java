package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Developer {

    private Long id;
    private String firstName;
    private String lastName;
    private Status status;
    private Specialty specialty;
    private List<Skill> skills;

    public Developer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        status = Status.ACTIVE;
        specialty = new Specialty();
        skills = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "\n" + "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", specialty=" + specialty +
                "\n" + ", skills=" + skills +
                '}';
    }
}
