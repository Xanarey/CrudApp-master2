package controller;

import model.Skill;
import repository.Gson.GsonSkillRepositoryImpl;
import repository.SkillsRepository;
import java.util.List;

public class SkillsController{

    private final SkillsRepository repo = new GsonSkillRepositoryImpl();

    public Skill getById(Long aLong) {
        return repo.getById(aLong);
    }

    public List<Skill> getAll() {
        return repo.getAll();
    }

    public Skill save(Skill skill) {
        return repo.save(skill);
    }

    public Skill update(Skill skill) {
        return repo.update(skill);
    }

    public void deleteById(Long aLong) {
        repo.deleteById(aLong);
    }

}
