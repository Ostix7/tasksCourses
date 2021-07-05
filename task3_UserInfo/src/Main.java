public class Main {

    public static void main(String[] args) {
        // Initialization
        User user = new User();
        View view = new View();
        Controller controller = new Controller(user, view);
        // Run
        controller.processUser();

    }


}