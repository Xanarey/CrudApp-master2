package controller;

import model.Developer;
import model.Specialty;
import repository.Gson.GsonDeveloperRepositoryImpl;
import repository.Gson.GsonSpecialtyRepositoryImpl;

public class DeveloperController {

    GsonDeveloperRepositoryImpl gdri = new GsonDeveloperRepositoryImpl();
    GsonSpecialtyRepositoryImpl gsri = new GsonSpecialtyRepositoryImpl();

    public void addDeveloper(String firstName, String lastName) {
        gdri.save(gdri.addDeveloper(firstName, lastName));
    }

    public void getAllDeveloper() {
        System.out.println(gdri.getAll());
    }

    public void editDeveloper(Long id, String firstName, String lastName) {
        Developer developer = gdri.getById(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        gdri.update(developer);
    }

    public void deleteDeveloper(Long id) {
        gdri.deleteById(id);
    }

    public void deleteStatus(Long id) {
        gdri.deleteByStatus(id);
    }

    public void addSpecialtyForDeveloper(Long idDev, Long idSpec) {
        gdri.addSpecialtyDeveloper(idDev, idSpec);
    }

    public String getByIdDev(Long id) {
        return gdri.getById(id + 1L).getSpecialty().getName();
    }

    public Developer editSpecialDev(Long id, Long idNewSpec) {
        Developer developer = gdri.getById(id);
        Specialty specialty = gsri.getById(idNewSpec);
        developer.setSpecialty(specialty);
        gdri.update(developer);
        return developer;
    }

    public void deleteSpecialtyDev(Long id) {
        gdri.deleteSpecialtyByDeveloper(id);
    }
}
