package ContactBook.Model;

public interface Repository {
    void saveContact(Contact contact) throws Exception;
    void readAll(String lastName);
}
