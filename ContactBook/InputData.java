package ContactBook;

import java.util.Scanner;

import ContactBook.Exceptions.FormatDateException;
import ContactBook.Exceptions.FormatGenderException;
import ContactBook.Exceptions.NotAllDataException;
import ContactBook.Model.Contact;

public class InputData {
    public InputData() {}
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine().trim();
    }

    public Contact checkContact() throws Exception{
        String[] data = prompt("Enter your details separated by spaces: Last Name / First name / Patronic Name / Birthday(format DD.MM.YYYY) / Phone number / Gender (m/f)): ").split(" ");

        if (data.length != 6) {
            throw new NotAllDataException();
        }
        int i = 0;
        String name = data[i];
        i++;
        String secondName = data[i];
        i++;
        String patroniumName = data[i];
        i++;
        String birthday = data[i];
        if (!birthday.matches("\\d{2}.\\d{2}.\\d{4}")) {
            throw new FormatDateException();
        }
        i++;
        long phone = Long.parseLong(data[i]);
        i++;
        char gender = data[i].charAt(0);
        if (gender != 'f' && gender != 'm') {
            throw new FormatGenderException();
        }
        return new Contact(name, secondName, patroniumName, birthday, phone, gender);
    }
}
