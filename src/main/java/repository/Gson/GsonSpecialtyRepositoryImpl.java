package repository.Gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Specialty;
import repository.SpecialtyRepository;

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

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

    private static final String SPECIALTY_PATH = "specialty.json";

    @Override
    public Specialty getById(Long aLong) {
        return getAllSpecialtyInternal().stream()
                .filter(s -> s.getId().equals(aLong)).findFirst().orElse(null);
    }

    @Override
    public List<Specialty> getAll() {

        return getAllSpecialtyInternal();
    }

    @Override
    public Specialty save(Specialty specialty) {
        List<Specialty> currentSpecialty = getAllSpecialtyInternal();
        specialty.setId(generateMaxId(currentSpecialty));
        currentSpecialty.add(specialty);
        writeSpecialtyToFile(currentSpecialty);
        return specialty;
    }

    @Override
    public Specialty update(Specialty specialty) {
        List<Specialty> currentSpecialty = getAllSpecialtyInternal();
        currentSpecialty.set(Math.toIntExact(specialty.getId()) - 1, specialty);
        writeSpecialtyToFile(currentSpecialty);
        return specialty;
    }

    @Override
    public void deleteById(Long aLong) {
        List<Specialty> currentSpecialty = getAllSpecialtyInternal();
        currentSpecialty.remove(getById(aLong));
        writeSpecialtyToFile(currentSpecialty);
    }

    private Long generateMaxId(List<Specialty> specialties) {
        Specialty specialtyWithMaxId = specialties.stream().max(Comparator.comparing(Specialty::getId)).orElse(null);
        return Objects.nonNull(specialtyWithMaxId) ? specialtyWithMaxId.getId() + 1 : 1L;
    }

    private void writeSpecialtyToFile(List<Specialty> specialties) {
        try {
            String jsonString = new Gson().toJson(specialties);
            Files.write(Paths.get(SPECIALTY_PATH), jsonString.getBytes());

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private List<Specialty> getAllSpecialtyInternal() {

        try (Reader reader = new FileReader(SPECIALTY_PATH)) {
            Type targetClassType = new TypeToken<ArrayList<Specialty>>() { }.getType();
            return new Gson().fromJson(reader, targetClassType);

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return new ArrayList<>();
    }

    public Specialty addSpecialty(String name) {
        Specialty specialty = new Specialty();
        specialty.setName(name);
        return specialty;
    }
}

