package controller;

import model.Skill;
import repository.Gson.GsonSkillRepositoryImpl;

import java.util.List;

public class SkillsController extends GsonSkillRepositoryImpl {

    @Override
    public Skill getById(Long aLong) {
        return super.getById(aLong);
    }

    @Override
    public List<Skill> getAll() {
        return super.getAll();
    }

    @Override
    public Skill save(Skill skill) {
        return super.save(skill);
    }

    @Override
    public Skill update(Skill skill) {
        addSkill(skill);
        return super.update(skill);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    private Skill addSkill(Skill skill) {
        return new Skill(skill.getName());
    }
}
