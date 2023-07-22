import exeptions.WrongPasswordException;
import util.AuthenticationValidator;

public class Main {
    public static void main(String[] args) {
        try {
            AuthenticationValidator.checkAuthentification("login", "12345", "12345");
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



