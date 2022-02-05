package controller;

import model.Developer;
import model.Skill;
import repository.Gson.GsonDeveloperRepositoryImpl;
import repository.Gson.GsonSkillRepositoryImpl;
import java.util.List;

public class SkillsController {

    GsonSkillRepositoryImpl gsri = new GsonSkillRepositoryImpl();
    GsonDeveloperRepositoryImpl gdri = new GsonDeveloperRepositoryImpl();

    public List<Skill> getAllSkills() {
        return gsri.getAll();
    }

    public void addSkillList(String nameSkill) {
        gsri.save(gsri.addSkill(nameSkill));
    }

    public void deleteSkill(Long id) {
        gsri.deleteById(id);
    }

    public void deleteAllSkills() {
        gsri.deleteAllSkills();
    }

    public void addSkillDeveloper(Long idDev, Long idSkill) {
        Developer developer = gdri.getById(idDev);
        Skill skill = gsri.getById(idSkill);
        developer.getSkills().add(skill);
        gdri.update(developer);
    }

}
