/*
 * Week 6 - Hashing and Salt
 */
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.security.*;

public class App {

    public static void main(String[] args) {
        String str1 = "alice";
        String str2 = "bob";

        // List demonstration
        List<String> lst = new ArrayList<>();
        lst.add(str1);
        lst.add(str2);
        System.out.println("List: " + lst);
        System.out.println("hashCode of list: " + lst.hashCode());
        System.out.println();

        // Java hashCode demonstration
        System.out.println("=== Java Built-in hashCode ===");
        System.out.println(String.join(":", str1, String.valueOf(str1.hashCode())));
        System.out.println(String.join(":", str2, String.valueOf(str2.hashCode())));
        System.out.println();

        // Unsalted cryptographic hashes
        System.out.println("=== Unsalted Cryptographic Hashes ===");
        System.out.println("MD5 of 'alice': " + md5(str1));
        System.out.println("SHA-256 of 'bob': " + sha256(str2));
        System.out.println();

        // Salted cryptographic hashes
        System.out.println("=== Salted Cryptographic Hashes ===");
        byte[] salt1 = Salt.generate();
        byte[] salt2 = Salt.generate();
        
        System.out.println("Salt for alice (Base64): " + Base64.getEncoder().encodeToString(salt1));
        System.out.println("Salted MD5 of 'alice': " + hash(str1, salt1, "MD5"));
        System.out.println();
        
        System.out.println("Salt for bob (Base64): " + Base64.getEncoder().encodeToString(salt2));
        System.out.println("Salted SHA-256 of 'bob': " + hash(str2, salt2, "SHA-256"));
        System.out.println();

        // Demonstrate that same input with different salts produces different hashes
        System.out.println("=== Same Input, Different Salts ===");
        byte[] salt3 = Salt.generate();
        System.out.println("SHA-256 of 'alice' with salt1: " + hash(str1, salt1, "SHA-256"));
        System.out.println("SHA-256 of 'alice' with salt3: " + hash(str1, salt3, "SHA-256"));
    }


    private static String hash(String input, String algorithm) {
        String hashcode;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte[] digest = md.digest();
            hashcode = Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found", e);
        }
        return hashcode;
    }

    public static String md5(String input) {
        return hash(input, "MD5");
    }

    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    public static class Salt {
        /* generate salt */
        public static byte[] generate() {
            SecureRandom sr = new SecureRandom();
            byte[] b = new byte[16];
            sr.nextBytes(b);
            return b;
        }
    }


    private static String hash(String input, byte[] salt, String algorithm) {
        MessageDigest md; 
        try
        {
            //instantiate the MD object
            md = MessageDigest.getInstance(algorithm);
            //fetch input to MD
            md.update( input.getBytes() );
            md.update( salt );

            //digest it
            byte[] hashBytes = md.digest();
            //convert to Hex format with Hex API from Apache common 
            return Base64.getEncoder().encodeToString(hashBytes);

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}