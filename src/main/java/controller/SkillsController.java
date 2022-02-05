package controller;

import model.Developer;
import model.Skill;
import repository.Gson.GsonDeveloperRepositoryImpl;
import repository.Gson.GsonSkillRepositoryImpl;

import java.util.ArrayList;

public class SkillsController {

    GsonSkillRepositoryImpl gsri = new GsonSkillRepositoryImpl();
    GsonDeveloperRepositoryImpl gdri = new GsonDeveloperRepositoryImpl();

    public void getAllSkills() {
        gsri.getAll();
    }

    public void addSkill(Long id, String nameSkill) {
        Skill skill = new Skill();
        Developer developer = new Developer();
        skill = gsri.addSkill(nameSkill);
        developer = gdri.getById(id);


    }

    // TODO в процессе

}
