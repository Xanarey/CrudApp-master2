package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Skill;
import repository.SkillsRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GsonSkillRepositoryImpl implements SkillsRepository {

    private static final String SKILL_PATH = "skills.json";

    @Override
    public Skill getById(Long aLong) {
        return getAllSkillsInternal().stream()
                .filter(s -> s.getId().equals(aLong)).findFirst().orElse(null);
    }

    @Override
    public List<Skill> getAll() {
        return getAllSkillsInternal();
    }

    @Override
    public void save(Skill skill) {
        List<Skill> currentSkills = getAllSkillsInternal();
        skill.setId(generateMaxId(currentSkills));
        currentSkills.add(skill);
        writeSkillsToFile(currentSkills);
    }

    @Override
    public Skill update(Skill skill) {
        List<Skill> currentSkills = getAllSkillsInternal();
        currentSkills.set(currentSkills.indexOf(getById(skill.getId())), skill);
        writeSkillsToFile(currentSkills);
        return skill;
    }

    @Override
    public void deleteById(Long aLong) {
        List<Skill> currentSkills = getAllSkillsInternal();
        currentSkills.remove(getById(aLong));
        writeSkillsToFile(currentSkills);
    }

    private Long generateMaxId(List<Skill> skills) {
        Skill skillWithMaxId = skills.stream().max(Comparator.comparing(Skill::getId)).orElse(null);
        return Objects.nonNull(skillWithMaxId) ? skillWithMaxId.getId() + 1 : 1L;
    }

    private void writeSkillsToFile(List<Skill> skills) {
        try {
            String jsonString = new Gson().toJson(skills);
            Files.write(Paths.get(SKILL_PATH), jsonString.getBytes());

        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    private List<Skill> getAllSkillsInternal() {

        try (Reader reader = new FileReader(SKILL_PATH)) {
            Type targetClassType = new TypeToken<ArrayList<Skill>>() { }.getType();
            return new Gson().fromJson(reader, targetClassType);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return new ArrayList<>();
    }

}
