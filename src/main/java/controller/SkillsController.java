package controller;

import model.Developer;
import model.Skill;
import repository.Gson.GsonDeveloperRepositoryImpl;
import repository.Gson.GsonSkillRepositoryImpl;

import java.util.*;

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
        if (getDuplicate(developer.getSkills())) {
            System.out.println("Разработчик уже обладает данным скиллом");
        } else {
            System.out.println("Скилл успешно добавлен");

            gdri.update(developer);
            gdri.update(sortSkills(developer));
        }
    }

    public boolean getDuplicate(List<Skill> skills) {
        Set<Skill> set = new HashSet<>();
        for (Skill each: skills) {
            if (!set.add(each))
                return true;
        }
        return false;
    }

    public List<Skill> getAllSkillDeveloper(Long id) {
        return gdri.getAll().get(Math.toIntExact(id)).getSkills();
    }

    public void deleteSkillDeveloper(Long idDev, int idSkill) {
        Developer developer = gdri.getById(idDev);
        developer.getSkills().remove(idSkill);
        gdri.update(developer);
    }

    public Developer sortSkills(Developer developer) {
        List<Skill> skills = developer.getSkills();
        Collections.sort(skills, new Comparator<Skill>() {
            public int compare(Skill o1, Skill o2) {
                return o1.getId().toString().compareTo(o2.getId().toString());
            }
        });
        return developer;
    }

}
