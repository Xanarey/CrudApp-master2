package controller;

import model.Specialty;
import repository.gson.GsonSpecialtyRepositoryImpl;
import repository.SpecialtyRepository;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyRepository repo = new GsonSpecialtyRepositoryImpl();

    public Specialty getById(Long id) {
        return repo.getById(id);
    }

    public List<Specialty> getAll() {
        return repo.getAll();
    }

    public Specialty save(Specialty specialty) {
        return repo.save(specialty);
    }

    public Specialty update(Specialty specialty) {
        return repo.update(specialty);
    }

    public void deleteById(Long aLong) {
        repo.deleteById(aLong);
    }
}
