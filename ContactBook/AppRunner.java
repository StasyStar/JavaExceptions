package ContactBook;

import ContactBook.Controller.Controller;
import ContactBook.Model.Repository;
import ContactBook.Model.impl.UserRepository;
import ContactBook.View.impl.View;

public class AppRunner {
    public static void run() {
        Repository repository = new UserRepository();
        Controller controller = new Controller(repository);
        InputData data = new InputData();
        View userView = new View(controller, data);
        userView.run();
    }
}
