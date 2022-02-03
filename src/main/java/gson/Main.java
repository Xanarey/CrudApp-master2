package gson;


public class Main {
    public static void main(String[] args) {
        GsonSkillRepositoryImpl gs = new GsonSkillRepositoryImpl();
        GsonSpecialtyRepositoryImpl sr = new GsonSpecialtyRepositoryImpl();
        GsonDeveloperRepositoryImpl dv = new GsonDeveloperRepositoryImpl();

        //dv.save(dv.addDeveloper("Tom","Cruise"));
        //dv.addSpecialtyDeveloper(2L,2L);
        //dv.addSkillDeveloper(1L);

        System.out.println(dv.getAll());
        System.out.println(sr.getAll());
        System.out.println("Установить специальность дев-ру: ");



        System.out.println("Проверить установленную специальность у дев-ра");
        System.out.println(dv.getAll());
    }
}
