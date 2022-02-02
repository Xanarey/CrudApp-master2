package gson;


public class Main {
    public static void main(String[] args) {
        GsonSkillRepositoryImpl gs = new GsonSkillRepositoryImpl();

        System.out.println(gs.getAll());

        //gs.save(gs.addSkill("devops"));

        System.out.println("Result 1: ");
        System.out.println(gs.getAll());

        //gs.deleteById(3L);



        System.out.println("Result 2: ");
        System.out.println(gs.getAll());
    }
}









//[
//        {
//        "id": 1,
//        "name": "backend"
//        },
//        {
//        "id": 2,
//        "name": "frontend"
//        }
//        ]