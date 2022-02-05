package controller;

import model.Developer;
import repository.Gson.GsonDeveloperRepositoryImpl;

public class DeveloperController {

    GsonDeveloperRepositoryImpl gsri = new GsonDeveloperRepositoryImpl();

    public void addDeveloper(String firstName, String lastName) {
        gsri.save(gsri.addDeveloper(firstName, lastName));
    }

    public void getAllDeveloper() {
        System.out.println(gsri.getAll());
    }

    public void editDeveloper(Long id, String firstName, String lastName) {
        Developer developer = gsri.getById(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        gsri.update(developer);
    }

    public void deleteDeveloper(Long id) {
        gsri.deleteByStatus(id);
    }

}
