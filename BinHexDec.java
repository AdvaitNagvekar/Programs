import java.util.*;

//All final values are string

public class BinHexDec {
    static void bina(char f, long i) {
        int k = 0, s = 0;
        long h;
        String o = "";
        if (f == 'D') {
            while (i > 0) {
                s = s + (int) ((i % 10) * Math.pow(2, k));
                k++;
                i = i / 10;
            }
            o = String.valueOf(s);
            System.out.println("Decimal= " + o);
        }
        if (f == 'H') {

            while (i > 0) {
                k = 0;
                s = 0;
                h = i % 10000;

                while (h > 0) {
                    s = s + (int) ((h % 10) * Math.pow(2, k));
                    k++;
                    h = h / 10;
                }

                if (s == 10)
                    o = 'A' + o;
                else if (s == 11)
                    o = 'B' + o;
                else if (s == 12)
                    o = 'C' + o;
                else if (s == 13)
                    o = 'D' + o;
                else if (s == 14)
                    o = 'E' + o;
                else if (s == 15)
                    o = 'F' + o;
                else
                    o = s + o;
                i = i / 10000;
            }
            System.out.println("Hexadecimal= " + o);

        }
    }

    static void deci(char f, long i) {
        long o = 0;
        long k = 0, r;
        while (i > 0) {
            r = i % 2;
            o = o + (long) (Math.pow(10, k)) * r;
            k++;
            i = i / 2;
        }
        if (f == 'B')
            System.out.println("Binary= " + String.valueOf(o));
        else
            bina('H', o);
    }

    static void hexa(char f, String i) {
        int j, k = 1, n, r, c;
        long o = 0;
        for (j = (i.length() - 1); j >= 0; j--) {
            if (i.charAt(j) == 'A')
                o = o + (k * 1010);
            else if (i.charAt(j) == 'B')
                o = o + (k * 1011);
            else if (i.charAt(j) == 'C')
                o = o + (k * 1100);
            else if (i.charAt(j) == 'D')
                o = o + (k * 1101);
            else if (i.charAt(j) == 'E')
                o = o + (k * 1110);
            else if (i.charAt(j) == 'F')
                o = o + (k * 1111);
            else {
                n = i.charAt(j) - 48;
                c = 0;
                while (c < 4) {
                    r = n % 2;
                    o = o + (k * r);
                    k = k * 10;
                    n = n / 2;
                    c++;
                }
            }
            if (Character.isLetter(i.charAt(j)))
                k = k * 10000;
        }
        if (f == 'B')
            System.out.println("Binary= " + String.valueOf(o));
        else
            bina('D', o);
    }

    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        System.out.println(
                "(B-Binary,D-Decimal,H-Hexadecimal):");
        System.out.print("Input Number System: ");
        char i = ob.nextLine().charAt(0);
        System.out.print("Output Number System: ");
        char d = ob.nextLine().charAt(0);
        System.out.print("Enter the number:");
        String n = ob.nextLine();
        long num;

        int j;
        char c;

        if (d == 'B' || d == 'D' || d == 'H') {
            if (i == 'B') {
                for (j = 0; j < n.length(); j++) {
                    c = n.charAt(j);
                    if (c == '1' || c == '0')
                        continue;
                    else {
                        System.out.println("Invalid Number");
                        System.exit(0);
                    }
                }
                num = Long.parseLong(n);
                bina(d, num);
            } else if (i == 'D') {
                for (j = 0; j < n.length(); j++) {
                    c = n.charAt(j);
                    if (Character.isDigit(c))
                        continue;
                    else {
                        System.out.println("Invalid Number");
                        System.exit(0);
                    }
                }
                num = Long.parseLong(n);
                deci(d, num);
            } else if (i == 'H') {
                for (j = 0; j < n.length(); j++) {
                    c = n.charAt(j);
                    if (c == 'A' || c == 'B' || c == 'C' || c == 'D' || c == 'E' || c == 'F' || Character.isDigit(c))
                        continue;
                    else {
                        System.out.println("Invalid Number");
                        System.exit(0);
                    }
                }
                hexa(d, n);
            } else
                System.out.println("Invalid input!!");
        } else
            System.out.println("Invalid input!!");

    }
}
