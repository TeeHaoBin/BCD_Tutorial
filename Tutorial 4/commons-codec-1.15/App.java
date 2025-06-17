// // Question 1

// public class App {
// 	public static void main(String[] args) {

// 		String str1 = "alice";
// 		String str2 = "bob";
		
//         /* hashcode for String object */
// 		System.out.println( String.join(":", str1,
//  			String.valueOf(str1.hashCode())) );
// 		System.out.println( String.join(":", str2, 
//             String.valueOf(str2.hashCode())) );
// 	}
// }



// // Question 2

// import java.util.ArrayList;
// import java.util.List;

// public class App {
// 	public static void main(String[] args) {

// 		String str1 = "alice";
// 		String str2 = "bob";

// 		/* string collection */
// 		List<String> lst = new ArrayList<>();
// 		lst.add(str1); 
//         lst.add(str2);
// 		System.out.println( "List = " + lst);
// 		System.out.println( "hashcode = "+ lst.hashCode() );	
// 	}
// }



// Question 5

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.security.*;

public class App {

    public static void main(String[] args) {

        String str1 = "alice";
        String str2 = "bob";

        List<String> lst = new ArrayList<>();
        lst.add(str1);
        lst.add(str2);
        System.out.println("List: " + lst);
        System.out.println("hashCode of list: " + lst.hashCode());

        System.out.println(String.join(":", str1, String.valueOf(str1.hashCode())));
        System.out.println(String.join(":", str2, String.valueOf(str2.hashCode())));

        System.out.println("MD5 of 'alice': " + md5(str1));
        System.out.println("SHA-256 of 'bob': " + sha256(str2));
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
}