package org.mindrot.jbcrypt;

public class App {
    public static String hashPassword(String password) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(password, salt);
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "abc123";

        String hashedPassword = hashPassword(password);

        if (verifyPassword(password, hashedPassword)) {
            System.out.println("Password verification succeeded.");
        } else {
            System.out.println("Password verification failed.");
        }
    }
}
