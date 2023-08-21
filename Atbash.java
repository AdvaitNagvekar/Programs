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
            if (Character.isLowerCase(c))
                c = (char) (122 + 97 - c);
            s1 = s1 + c;
        }
        System.out.println("Atbash Ciper:" + s1);
    }
}

