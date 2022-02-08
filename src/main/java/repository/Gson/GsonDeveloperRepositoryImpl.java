package repository.Gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Developer;
import repository.DeveloperRepository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {

    private static final String DEVELOPER_PATH = "developer.json";

    @Override
    public Developer getById(Long aLong) {
        return getAllDeveloperInternal().stream()
                .filter(s -> s.getId().equals(aLong)).findFirst().orElse(null);
    }

    @Override
    public List<Developer> getAll() {
        return getAllDeveloperInternal();
    }

    @Override
    public Developer save(Developer developer) {
        List<Developer> currentDeveloper = getAllDeveloperInternal();
        developer.setId(generateMaxId(currentDeveloper));
        currentDeveloper.add(developer);
        writeDeveloperToFile(currentDeveloper);
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        List<Developer> currentDeveloper = getAllDeveloperInternal();
        currentDeveloper.set(currentDeveloper.indexOf(getById(developer.getId())), developer);
        writeDeveloperToFile(currentDeveloper);
        return developer;
    }

    @Override
    public void deleteById(Long aLong) {
        List<Developer> currentDeveloper = getAllDeveloperInternal();
        Developer developer = getById(aLong);
        currentDeveloper.remove(currentDeveloper.indexOf(getById(developer.getId())));
        writeDeveloperToFile(currentDeveloper);
    }

    private Long generateMaxId(List<Developer> developers) {
        Developer developerWithMaxId = developers.stream().max(Comparator.comparing(Developer::getId)).orElse(null);
        return Objects.nonNull(developerWithMaxId) ? developerWithMaxId.getId() + 1 : 1L;
    }

    private void writeDeveloperToFile(List<Developer> developers) {
        try {
            String jsonString = new Gson().toJson(developers);
            Files.write(Paths.get(DEVELOPER_PATH), jsonString.getBytes());

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private List<Developer> getAllDeveloperInternal() {

        try (Reader reader = new FileReader(DEVELOPER_PATH)) {
            Type targetClassType = new TypeToken<ArrayList<Developer>>() { }.getType();

            return new Gson().fromJson(reader, targetClassType);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        return new ArrayList<>();
    }
}
