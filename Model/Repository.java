package seminar3.hw.Model;

import java.util.List;

public interface Repository {
    void saveContact(Contact contact) throws Exception;
    void readAll(String lastName);
}
