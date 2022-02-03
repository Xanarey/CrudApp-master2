package gson;


import model.Skill;

public class Main {
    public static void main(String[] args) {
        GsonSkillRepositoryImpl gs = new GsonSkillRepositoryImpl();

        //gs.save(gs.addSkill("devops"));
        //gs.deleteById(4L);
        //gs.update(new Skill(2L, "FRONTISHE"));


        System.out.println("Result 1: ");
        System.out.println(gs.getAll());


        System.out.println("Result 2: ");
        System.out.println(gs.getAll());

    }
}
