package company;

import company.model.Model;
import company.view.View;
import company.controller.Controller;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Model(), new View());
        // Run
        controller.processUser();
    }
}
