import java.util.*;

public class XandO {
    static String s = "_1_|_2_|_3_\n_4_|_5_|_6_\n 7 | 8 | 9 ";
    char ch[][] = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
    int z;

    void locAndPri(int n, char c) {
        int i;
        if (ch[(n - 1) / 3][(n - 1) % 3] == 'X' || ch[(n - 1) / 3][(n - 1) % 3] == 'O') {
            System.out.println("Position is already occupied, please enter a valid position");
            acceptVal(z);
        }
        for (i = 0; i < s.length(); i++) {
            if (n == (s.charAt(i) - 48)) {
                s = s.replace(s.charAt(i), c);
                ch[(n - 1) / 3][(n - 1) % 3] = c;
            }
        }
        System.out.println("\033[H \033[2J");
        System.out.println(s);
    }

    void check(int i) {
        int k, m, c = 0;
        char l = 'c';
        for (k = 0; k < 3; k++) {
            if (ch[k][0] == ch[k][1] && ch[k][0] == ch[k][2]) {
                c = 1;
                l = ch[k][0];
                System.out.println("\033[H \033[2J");
                System.out.println("Row number " + (k + 1));
                break;
            }
        }
        for (m = 0; m < 3; m++) {
            if (ch[0][m] == ch[1][m] && ch[0][m] == ch[2][m]) {
                c = 1;
                l = ch[0][m];
                System.out.println("\033[H \033[2J");
                System.out.println("Column number " + (m + 1));
                break;
            }
        }
        if (ch[0][0] == ch[1][1] && ch[0][0] == ch[2][2]) {
            c = 1;
            l = ch[0][0];
            System.out.println("\033[H \033[2J");
            System.out.println("Leading diagonal");
        }
        if (ch[0][2] == ch[1][1] && ch[0][2] == ch[2][0]) {
            c = 1;
            l = ch[0][2];
            System.out.println("\033[H \033[2J");
            System.out.println("Counter Diagonal");
        }
        if (c == 0 && i == 1)
            System.out.println("Tie");
        if (c == 1 && i == 0) {
            for (k = 0; k < s.length(); k++) {
                if (Character.isDigit(s.charAt(k))) {
                    if (k < 24)
                        s = s.replace(s.charAt(k), '_');
                    else
                        s = s.replace(s.charAt(k), ' ');
                }
            }
            System.out.println(s);
            System.out.println("Winner is " + l);
            System.exit(0);
        }
    }

    void acceptVal(int n) {
        Scanner sc = new Scanner(System.in);
        int i;
        for (i = n; i <= 9; i++) {
            z = i;
            if (i % 2 == 0) {
                System.out.print("Position of 0:");
                n = sc.nextInt();
                if (n < 1 || n > 9) {
                    System.out.println("Please enter the correct position");
                    acceptVal(i);
                }
                locAndPri(n, 'O');
                check(0);
            } else {
                System.out.print("Position of X:");
                n = sc.nextInt();
                if (n < 1 || n > 9) {
                    System.out.println("Please enter the correct position");
                    acceptVal(i);
                }
                locAndPri(n, 'X');
                check(0);
            }
        }
    }

    public static void main(String[] args) {
        XandO ob = new XandO();
        System.out.println(s);
        ob.acceptVal(1);
        ob.check(1);
    }
}
