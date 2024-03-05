package seminar3.hw;

import seminar3.hw.Controller.Controller;
import seminar3.hw.Model.Repository;
import seminar3.hw.Model.impl.UserRepository;
import seminar3.hw.View.impl.View;

public class AppRunner {
    public static void run() {
        Repository repository = new UserRepository();
        Controller controller = new Controller(repository);
        InputData data = new InputData();
        View userView = new View(controller, data);
        userView.run();
    }
}
