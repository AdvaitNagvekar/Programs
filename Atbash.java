import java.util.*;

public class Atbash {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        System.out.println("Enter a String");
        String s = ob.nextLine();
        String s1 = "";
        int i, k;
        char c;
        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isUpperCase(c))
                c = (char) (90 + 65 - c);
            else if (Character.isLowerCase(c))
                c = (char) (122 + 97 - c);
            else
                continue;
            s1 = s1 + c;
        }
        /*
         * for (i = 0; i < s.length(); i++) {
         * if (Character.isUpperCase(s.charAt(i)))
         * k = 90 + 65 - s.charAt(i);
         * else if (Character.isLowerCase(s.charAt(i)))
         * k = 122 + 97 - s.charAt(i);
         * else
         * k = s.charAt(i);
         * s1 = s1 + s.substring(i, i + 1).replace(s.charAt(i), (char) k);
         * }
         */
        System.out.println("Atbash Ciper:" + s1);
    }
}
