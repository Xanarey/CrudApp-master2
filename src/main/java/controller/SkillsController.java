package controller;

import model.Skill;
import repository.gson.GsonSkillRepositoryImpl;
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

    public void save(Skill skill) {
        repo.save(skill);
    }

    public void update(Skill skill) {
        repo.update(skill);
    }

    public void deleteById(Long aLong) {
        repo.deleteById(aLong);
    }

}
