package view;

import controller.DeveloperController;
import controller.SkillsController;
import controller.SpecialtyController;
import model.Developer;
import model.Skill;
import model.Specialty;
import model.Status;

import java.util.*;

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
                System.out.println(developerController.getAll());
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
                developerController.save(new Developer(FIRST_NAME, LAST_NAME));
                System.out.println("Разработчик: [" + FIRST_NAME + " " + LAST_NAME + "] успешно добавлен");
            }
            if (CHOICE_MENU == 4) {
                developerController.getAll();
                System.out.println("Введите id для удаления записи:");
                do {
                    ID = scanner.nextLong();
                } while (ID == 0);
                try {
                    developerController.deleteById(ID);
                } catch (NullPointerException e) {
                    System.out.println("Разработчика по указанному ID не существует" + e);
                }
            }
            if (CHOICE_MENU == 5) {
                do {
                    System.out.println(SUB_MENU);
                    CHOICE_SUB_MENU = scanner.nextLong();

                    if (CHOICE_SUB_MENU == 2) {
                        System.out.println(developerController.getAll());
                    }
                    if (CHOICE_SUB_MENU == 3) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id для редактирования: ");
                        do {
                            ID = scanner.nextLong();
                        } while (ID == 0);
                        try {
                            System.out.println("Введите имя:");
                            do {
                                FIRST_NAME = scanner.nextLine();
                            } while (Objects.equals(FIRST_NAME, ""));
                            System.out.println("Введите фамилию:");
                            do {
                                LAST_NAME = scanner.nextLine();
                            } while (Objects.equals(LAST_NAME, ""));
                            Developer developer = developerController.getById(ID);
                            developer.setFirstName(FIRST_NAME);
                            developer.setLastName(LAST_NAME);
                            developerController.update(developer);
                            System.out.println("Успешное редактирование");
                        } catch (NullPointerException e) {
                            System.out.println("Разработчика по указанному ID не существует" + e);
                        }
                    }
                    if (CHOICE_SUB_MENU == 4) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id для изменения статуса ACTIVE на статус DELETED");
                        do {
                            ID = scanner.nextLong();
                            try {
                                Developer developer = developerController.getById(ID);
                                developer.setStatus(Status.DELETED);
                                developerController.update(developer);
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID == 0);
                    }
                    if (CHOICE_SUB_MENU == 5) {
                        System.out.println(specialtyController.getAll());
                    }
                    if (CHOICE_SUB_MENU == 6) {
                        System.out.println("Введите название новой специальности: ");
                        do {
                            NAME_SPEC = scanner.nextLine();
                        } while (Objects.equals(NAME_SPEC, ""));
                        Specialty specialty = new Specialty();
                        specialty.setName(NAME_SPEC);
                        specialtyController.save(specialty);
                        System.out.println("Специальность : " + NAME_SPEC + " успешно добавлена");
                    }
                    if (CHOICE_SUB_MENU == 7) {
                        System.out.println(specialtyController.getAll());
                        System.out.println("Введите id специальности:   (0 - для выхода)");
                        do {
                            try {
                                ID_SPEC = scanner.nextLong();
                                System.out.println("Специальность : " + specialtyController.getById(ID_SPEC) + " успешно удалена");
                                specialtyController.deleteById(ID_SPEC);
                            } catch (NullPointerException e) {
                                System.out.println("Специальности по такому id не существует");
                            }
                        } while (ID_SPEC != 0);
                    }
                    if (CHOICE_SUB_MENU == 8) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id разработчика для добавления специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(specialtyController.getAll());
                                System.out.println("Введите id специальности: ");
                                ID_SPEC = scanner.nextLong();
                                Specialty specialty = specialtyController.getById(ID_SPEC);
                                Developer developer = developerController.getById(ID);
                                developer.setSpecialty(specialty);
                                developerController.update(developer);
                                System.out.println("Специальность установлена");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 9) {
                        developerController.getAll();
                        System.out.println("Введите id разработчика для редактирования специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                System.out.println(specialtyController.getAll());
                                System.out.println("Введите id новой специальности: ");
                                ID_SPEC = scanner.nextLong();
                                Developer developer = developerController.getById(ID);
                                Specialty specialty = specialtyController.getById(ID_SPEC);
                                developer.setSpecialty(specialty);
                                developerController.update(developer);
                                System.out.println("Специальность успешно изменена ");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 10) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id разработчика для удаления специальности: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                Developer developer = developerController.getById(ID);
                                developer.setSpecialty(new Specialty());
                                developerController.update(developer);
                                System.out.println("Специальность успешно удалена ");
                                break;
                            } catch (NullPointerException e) {
                                    System.out.println("Разработчика по указанному ID не существует" + e);
                                }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 11) {
                        System.out.println(skillsController.getAll());

                    }
                    if (CHOICE_SUB_MENU == 12) {
                        System.out.println("Введите название нового скилла: ");
                        do {
                            SKILL_NAME = scanner.nextLine();
                        } while (Objects.equals(SKILL_NAME, ""));
                        Skill skill = new Skill();
                        skill.setName(SKILL_NAME);
                        skillsController.save(skill);
                        System.out.println("Скилл: " + SKILL_NAME + " успешно добавлен");
                    }
                    if (CHOICE_SUB_MENU == 13) {
                        System.out.println(skillsController.getAll());
                        System.out.println("Введите id скилла для удаления");
                        do {
                            ID = scanner.nextLong();
                            skillsController.deleteById(ID);
                            break;
                        } while (ID != 0);
                        System.out.println("Скилл успешно удалён");
                    }
                    if (CHOICE_SUB_MENU == 14) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id разработчика: ");
                        do {
                            ID = scanner.nextLong();
                            System.out.println("Выберите скилл");
                            System.out.println(skillsController.getAll());
                            ID_SKILLS = scanner.nextLong();
                            Skill skill = skillsController.getById(ID_SKILLS);
                            Developer developer = developerController.getById(ID);
                            developer.getSkills().add(skill);
                            developerController.update(developer);
                            System.out.println("Скилл успешно добавлен");
                            break;
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 15) {
                        System.out.println(developerController.getAll());
                        System.out.println("Введите id разработчика для удаления скилла: ");
                        do {
                            try {
                                ID = scanner.nextLong();
                                Developer developer = developerController.getById(ID);
                                System.out.println("Введите id скилла для удаления: ");
                                ID_SKILLS = scanner.nextLong();
                                developer.getSkills().remove(ID_SKILLS);
                                developerController.update(developer);
                                System.out.println("Скилл удален");
                                break;
                            } catch (NullPointerException e) {
                                System.out.println("Разработчика по указанному ID не существует" + e);
                            }
                        } while (ID != 0);
                    }
                    if (CHOICE_SUB_MENU == 16) {
                        System.out.println(skillsController.getAll());
                        System.out.println("Введите id скилла для редактирования: ");
                        do {
                            ID_SKILLS = scanner.nextLong();
                            Skill skill = skillsController.getById(ID_SKILLS);
                            System.out.println("Введите новое названия скилла: ");
                            SKILL_NAME = scanner.nextLine();
                            skill.setName(SKILL_NAME);
                            skillsController.update(skill);
                        } while (ID_SKILLS != 0);
                        System.out.println("Изменение успешно внесены");
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
            14. Добавить скилл разработчику
            15. Удалить скилл у разработчика
            16. Изменить скилл в списке
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
    public static Long CHOICE_MENU;
    public static Long CHOICE_SUB_MENU;
    public static Long ID_SKILLS;
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static String NAME_SPEC;
    public static String SKILL_NAME;

}
