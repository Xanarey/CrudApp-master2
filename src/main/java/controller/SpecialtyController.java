package controller;

import model.Specialty;
import repository.Gson.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController extends GsonSpecialtyRepositoryImpl {

    @Override
    public Specialty getById(Long aLong) {
        return super.getById(aLong);
    }

    @Override
    public List<Specialty> getAll() {
        return super.getAll();
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Specialty update(Specialty specialty) {
        return super.update(specialty);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
