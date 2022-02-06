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
                System.out.println("Разработчик: [" + FIRST_NAME + " " + LAST_NAME + "] успешно добавлен");
            }
            if (CHOICE_MENU == 4) {
                developerController.getAllDeveloper();
                System.out.println("Введите id для удаления записи:");
                do {
                    ID = scanner.nextLong();
                } while (ID == 0);
                try {
                    developerController.deleteDeveloper(ID);
                } catch (NullPointerException e) {
                    System.out.println("Разработчика по указанному ID не существует" + e);
                }
            }
            if (CHOICE_MENU == 5) {
                do {
                    System.out.println(SUB_MENU);
                    CHOICE_SUB_MENU = scanner.nextLong();

                    if (CHOICE_SUB_MENU == 2) {
                        developerController.getAllDeveloper();
                    }
                    if (CHOICE_SUB_MENU == 3) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id для редактирования: ");
                        do {
                            ID_SPEC = scanner.nextLong();
                        } while (ID_SPEC == 0);
                        try {
                            System.out.println("Введите имя:");
                            do {
                                FIRST_NAME = scanner.nextLine();
                            } while (Objects.equals(FIRST_NAME, ""));
                            System.out.println("Введите фамилию:");
                            do {
                                LAST_NAME = scanner.nextLine();
                            } while (Objects.equals(LAST_NAME, ""));
                            developerController.editDeveloper(ID_SPEC, FIRST_NAME, LAST_NAME);
                        } catch (NullPointerException e) {
                            System.out.println("Разработчика по указанному ID не существует" + e);
                        }
                    }
                    if (CHOICE_SUB_MENU == 4) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id для изменения статуса ACTIVE на статус DELETED");
                        do {
                            ID = scanner.nextLong();
                            try {
                                developerController.deleteStatus(ID);
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID == 0);
                    }
                    if (CHOICE_SUB_MENU == 5) {
                        System.out.println(specialtyController.getAllSpecialty());
                    }
                    if (CHOICE_SUB_MENU == 6) {
                        System.out.println("Введите название новой специальности: ");
                        do {
                            NAME_SPEC = scanner.nextLine();
                        } while (Objects.equals(NAME_SPEC, ""));
                        specialtyController.addSpecialty(NAME_SPEC);
                        System.out.println("Специальность : " + NAME_SPEC + " успешно добавлена");
                    }
                    if (CHOICE_SUB_MENU == 7) {
                        System.out.println(specialtyController.getAllSpecialty());
                        System.out.println("Введите id специальности:   (0 - для выхода)");
                        do {
                            try {
                                ID_SPEC = scanner.nextLong();
                                System.out.println("Специальность : " + specialtyController.getByIDSpec(ID_SPEC) + " успешно удалена");
                                specialtyController.deleteSpecialtyOnList(ID_SPEC);
                            } catch (NullPointerException e) {
                                System.out.println("Специальности по такому id не существует");
                            }
                        } while (ID_SPEC != 0);
                    }
                    if (CHOICE_SUB_MENU == 8) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id разработчика для добавления специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(specialtyController.getAllSpecialty());
                                System.out.println("Введите id специальности: ");
                                ID_SPEC = scanner.nextLong();
                                developerController.addSpecialtyForDeveloper(ID, ID_SPEC);
                                System.out.println("Специальность установлена");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 9) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id разработчика для редактирования специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(specialtyController.getAllSpecialty());
                                System.out.println("Введите id новой специальности: ");
                                ID_SPEC = scanner.nextLong();
                                developerController.editSpecialDev(ID, ID_SPEC);
                                System.out.println("Специальность успешно изменена ");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 10) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id разработчика для удаления специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(specialtyController.getAllSpecialty());
                                developerController.deleteSpecialtyDev(ID);
                                System.out.println("Специальность успешно удалена ");
                                break;
                            } catch (NullPointerException e) {
                                    System.out.println("Разработчика по указанному ID не существует" + e);
                                }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 11) {
                        System.out.println(skillsController.getAllSkills());

                    }
                    if (CHOICE_SUB_MENU == 12) {
                        System.out.println("Введите название нового скилла: ");
                        do {
                            SKILL_NAME = scanner.nextLine();
                        } while (Objects.equals(SKILL_NAME, ""));
                        skillsController.addSkillList(SKILL_NAME);
                        System.out.println("Скилл: " + SKILL_NAME + " успешно добавлен");
                    }
                    if (CHOICE_SUB_MENU == 13) {
                        System.out.println(skillsController.getAllSkills());
                        System.out.println("Введите id скилла для удаления");
                        do {
                            ID = scanner.nextLong();
                            skillsController.deleteSkill(ID);
                            break;
                        } while (ID != 0);
                        System.out.println("Скилл успешно удалён");
                    }
                    if (CHOICE_SUB_MENU == 14) {
                        skillsController.deleteAllSkills();
                        System.out.println("Все скиллы удалены");
                    }
                    if (CHOICE_SUB_MENU == 15) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id разработчика: ");
                        do {
                                ID = scanner.nextLong();
                                System.out.println("Выберите скилл по id");
                                System.out.println(skillsController.getAllSkills());
                                ID_SKILL = scanner.nextLong();
                                skillsController.addSkillDeveloper(ID, ID_SKILL);
                                break;
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 16) {
                        developerController.getAllDeveloper();
                        System.out.println("Введите id разработчика для удаления скилла: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(skillsController.getAllSkillDeveloper(ID));
                                System.out.println("Введите id скилла для удаления: ");
                                id_skill = scanner.nextInt();
                                skillsController.deleteSkillDeveloper(ID, id_skill);
                                System.out.println("Скилл удален");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                } while (CHOICE_SUB_MENU != 1);
            }
        } while (CHOICE_MENU != 1);
    }

    public static String SUB_MENU = """
            ______EDIT_MENU__________
            1.  Выйти из режима редактирования разработчика
            2.  Вывести базу данных
            3.  Изменить имя и фамилию
            4.  Удалить разработчика (статус -> DELETED)
            
            5.  Вывести список текущих специальностей
            6.  Добавить новую специальность в список
            7.  Удалить специальность из списка
            
            8.  Добавить специальность разработчику
            9.  Редактировать специальность у разработчика
            10. Удалить специальность у разработчика
            
            11. Вывести список доступных скиллов
            12. Добавить новый скилл в список
            13. Удалить скилл из списка
            14. Удалить все скиллы из списка
            
            15. Добавить скилл разработчику
            16. Удалить скилл у разработчика
            """;

    public static String MENU = """
            __________MENU__________
            1.  Выход
            2.  Вывести базу данных
            3.  Добавить разработчика
            4.  Удалить разработчика
            5.  Режим редактирования разработчика
            """;


    public static Long ID ;
    public static Long ID_SPEC;
    public static Long ID_SKILL;
    public static Integer id_skill;
    public static Long CHOICE_MENU;
    public static Long CHOICE_SUB_MENU;
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static String NAME_SPEC;
    public static String SKILL_NAME;
}
