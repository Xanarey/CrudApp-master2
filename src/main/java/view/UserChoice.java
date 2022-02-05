package view;

import controller.DeveloperController;

public class UserChoice {

    DeveloperController developerController = new DeveloperController();

    public void start() {
        developerController.editDeveloper(4L,"Timur","Bro");
        developerController.getAllDeveloper();
    }

}
