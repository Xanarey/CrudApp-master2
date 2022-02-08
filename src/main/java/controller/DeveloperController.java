package controller;

import model.Developer;
import repository.Gson.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController extends GsonDeveloperRepositoryImpl {

    @Override
    public Developer getById(Long aLong) {
        return super.getById(aLong);
    }

    @Override
    public List<Developer> getAll() {
        return super.getAll();
    }

    @Override
    public Developer save(Developer developer) {
        return super.save(addDeveloper(developer));
    }

    @Override
    public Developer update(Developer developer) {
        return super.update(editDeveloper(developer));
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    private Developer addDeveloper(Developer developer) {
        return new Developer(developer.getFirstName(), developer.getLastName());
    }

    private Developer editDeveloper(Developer developer) {
        Developer developerTarget = getById(developer.getId());
        developerTarget.setFirstName(developer.getFirstName());
        developerTarget.setLastName(developer.getLastName());
        return developerTarget;
    }

}
