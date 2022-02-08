package controller;

import model.Specialty;
import repository.Gson.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {

    GsonSpecialtyRepositoryImpl gsri = new GsonSpecialtyRepositoryImpl();

    public List<Specialty> getAllSpecialty() {
        return gsri.getAll();
    }

    public void addSpecialty(String nameSpec) {
        gsri.save(gsri.addSpecialty(nameSpec));

    }

    public void deleteSpecialtyOnList(Long id) {
        gsri.deleteById(id);
    }

    public String getByIDSpec(Long id) {
        return gsri.getById(id).getName();
    }


}
