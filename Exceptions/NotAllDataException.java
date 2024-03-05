package seminar3.hw.Exceptions;

public class NotAllDataException extends Exception{
    public NotAllDataException() {
        System.out.println("You didn't enter all data!");
    }
}
