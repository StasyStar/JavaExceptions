package seminar3.hw.Controller;

import seminar3.hw.Model.Contact;
import seminar3.hw.Model.Repository;

public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void saveContact(Contact contact) throws Exception{
        repository.saveContact(contact);
    }

    public void readAll(String lastName) {
        repository.readAll(lastName);
    }
}
