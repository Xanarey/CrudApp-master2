package controller;

import model.Developer;
import model.Skill;
import repository.DeveloperRepository;
import repository.gson.GsonDeveloperRepositoryImpl;

import java.util.Comparator;
import java.util.List;


public class DeveloperController implements Comparator<Skill>{

    private final DeveloperRepository repo = new GsonDeveloperRepositoryImpl();

    public Developer getById(Long id) { return repo.getById(id); }

    public List<Developer> getAll() {
        return repo.getAll();
    }

    public void save(Developer developer) {
        repo.save(developer);
    }

    public void update(Developer developer) {
        developer.setSkills(sortSkills(developer.getSkills()));
        repo.update(developer);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    private List<Skill> sortSkills(List<Skill> skills) {
        Comparator<Skill> skillsComparator = new DeveloperController();
        skills.sort(skillsComparator);
        return skills;
    }

    @Override
    public int compare(Skill o1, Skill o2) {
        return (int) (o1.getId() - o2.getId());
    }

}
