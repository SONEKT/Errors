package util;

import exeptions.WrongLoginException;
import exeptions.WrongPasswordException;

import java.util.regex.Pattern;

public class AuthenticationValidator {

    private static final Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkAuthentification(String login, String password, String confirmedPassword)
            throws WrongPasswordException {
        checkLogin(login);
        checkPassword(password);
        checkConfirmedPassword(password,confirmedPassword);
    }


        private static void checkLogin(String login) {

            if (login.length() > 20) {
                throw new WrongLoginException("Логин должен быть меньше 20 символов");
            }
                if (!login.matches(regex.pattern())) {
                    throw new WrongLoginException("Логин содержит недупустимый символ");
                }
            }

    private static void checkPassword(String password) throws WrongPasswordException{
       if (!password.matches(regex.pattern())){
           throw new WrongPasswordException("Пароль должен содержать в себе только латинские " +
                   "буквы цифры и знак подчеркивания и содержать меньше 20 символов");
       }
    }

    private static void checkConfirmedPassword(String password, String confirmedPassword) throws WrongPasswordException{
        if (!password.equals(confirmedPassword)) {
            throw new WrongPasswordException("Пароль и повторный пароль не совпадают");
        }
    }
}
