import java.util.*;

public class Calculator {
    static double calci(double a, double b, char c) {
        double z = 0;
        switch (c) {
            case '+':
                z = a + b;
                break;
            case '-':
                z = a - b;
                break;
            case '*':
                z = a * b;
                break;
            case '/':
                z = a / b;
                break;
            case '^':
                z = Math.pow(a, b);
                break;
            case '=':
                System.out.println("OFF");
                System.exit(0);
                break;
            default:
                System.out.println("Syntax Error");
                System.exit(0);
        }
        return (z);
    }

    static int checkInp(String s) {
        int i, k = 0;
        char c;
        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c) || c == '.')
                continue;
            else
                k++;
        }
        return (k);
    }

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        System.out.println("ON\nEnter Mathematical Expression:");
        String s = ob.nextLine();
        if (s.equalsIgnoreCase(""))
            calci(0, 0, '=');
        do {
            s = s + ' ';
            int i, k = 0;
            int n = checkInp(s);
            double num[] = new double[n];
            char c;
            char c1[] = new char[n - 1];

            for (i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (Character.isDigit(c) || c == '.') {

                } else {
                    num[k] = Double.parseDouble(s.substring(0, i));
                    if (k != (n - 1))
                        c1[k] = c;
                    s = s.substring(i + 1);
                    i = 0;
                    k++;
                }
            }
            for (i = 0; i < n - 1; i++) {
                num[i + 1] = calci(num[i], num[i + 1], c1[i]);
            }
            System.out.print(num[n - 1]);
            s = ob.nextLine();
            if (s.equalsIgnoreCase(""))
                calci(0, 0, '=');
            s = num[n - 1] + s;
            if (num[n - 1] < 0)
                s = 0 + s;
        } while (true);

    }

}
