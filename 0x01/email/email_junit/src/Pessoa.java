package src;

public class Pessoa {
    public static boolean emailValid(String email) {
        if (email == null) return false;
        return email.contains("@") && email.length() <= 50;
    }
}
