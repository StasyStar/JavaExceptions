package ContactBook.Model.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ContactBook.Exceptions.DataSaveException;
import ContactBook.Model.Contact;
import ContactBook.Model.Repository;

public class UserRepository implements Repository {
    @Override
    public void saveContact(Contact contact) throws Exception {
        StringBuilder newContact = new StringBuilder();
        newContact.append("<").append(contact.getLastName()).append(">")
                .append("<").append(contact.getFirstName()).append(">")
                .append("<").append(contact.getPatronymicName()).append(">")
                .append("<").append(contact.getBirthday()).append(">")
                .append("<").append(contact.getPhone()).append(">")
                .append("<").append(contact.getGender()).append(">\n");
        String fileName = contact.getLastName() + ".txt";
        try {
            FileWriter file = new FileWriter(fileName, true);
            file.write(String.valueOf(newContact));
            System.out.println("Contact added successfully.");
            file.flush();
            file.close();
        } catch (Exception e) {
            throw new DataSaveException();
        }
    }

    @Override
    public void readAll(String lastName) {
        try {
            FileReader fr = new FileReader(lastName + ".txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
