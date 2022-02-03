package gson;


public class Main {
    public static void main(String[] args) {
        GsonSkillRepositoryImpl gs = new GsonSkillRepositoryImpl();
        GsonSpecialtyRepositoryImpl sr = new GsonSpecialtyRepositoryImpl();



        System.out.println(sr.getAll());

    }
}
