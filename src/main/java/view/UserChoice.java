package view;

import controller.DeveloperController;
import controller.SkillsController;
import controller.SpecialtyController;

import java.util.Objects;
import java.util.Scanner;

public class UserChoice {

    DeveloperController developerController = new DeveloperController();
    SpecialtyController specialtyController = new SpecialtyController();
    SkillsController skillsController = new SkillsController();
    Scanner scanner = new Scanner(System.in);

    public void start() {

        do {
            System.out.println(MENU);
            CHOICE_MENU = scanner.nextLong();


            if (CHOICE_MENU == 2) {
                developerController.getAllDeveloper();
            }

            if (CHOICE_MENU == 3) {
                System.out.println("Введите имя:");
                do {
                    FIRST_NAME = scanner.nextLine();
                } while (Objects.equals(FIRST_NAME, ""));
                System.out.println("Введите фамилию:");
                do {
                    LAST_NAME = scanner.nextLine();
                } while (Objects.equals(LAST_NAME, ""));

                developerController.addDeveloper(FIRST_NAME, LAST_NAME);
                System.out.println("Данные спешно добавлены");
            }

            if (CHOICE_MENU == 4) {
                developerController.getAllDeveloper();
                System.out.println("Введите id: ");
                do {
                    ID = scanner.nextLong();
                }  while (ID == 0);
                developerController.deleteDeveloper(ID);
            }

            if (CHOICE_MENU == 5) {
                System.out.println("Введите id");
                do {
                    ID = scanner.nextLong();
                } while (ID == 0);
                System.out.println("Введите имя:");
                do {
                    FIRST_NAME = scanner.nextLine();
                } while (Objects.equals(FIRST_NAME, ""));
                System.out.println("Введите фамилию:");
                do {
                    LAST_NAME = scanner.nextLine();
                } while (Objects.equals(LAST_NAME, ""));
                developerController.editDeveloper(ID, FIRST_NAME, LAST_NAME);
            } while (ID == 0);
        } while (CHOICE_MENU != 1);


    }

    public static String MENU = """
            __________MENU__________
            1.  Выход
            2.  Вывести базу данных
            3.  Добавить разработчика
            4.  Удалить разработчика (статус -> DELETED)
            5.  Изменить запись разработчика

            """;


    public static Long ID;
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static Long CHOICE_MENU;
}
