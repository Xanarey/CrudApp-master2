package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "\n" + "   Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
