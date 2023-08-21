import java.util.*;

public class BankAcc {
    static long s = 0;
    static long c;

    static void getValue() {
        Scanner ob = new Scanner(System.in);
        c = ob.nextLong();
        System.out.println("");
    }

    static void depo() {
        System.out.print("Enter Amount to be deposited: Rs. ");
        getValue();
        s = s + c;
    }

    static void withdr() {
        System.out.print("Enter Amount to be withdrawn: Rs. ");
        getValue();
        if (c > s) {
            System.out.println("Only Rs." + s + " can be withdrawn as balance is very low");
            System.out.print("Do you wish to continue?(1 for yes , any other number to go to main menu) : ");
            getValue();
            if (c == 1) {
                withdr();
            }
        } else
            s = s - c;
    }

    static void bal() {
        if (s <= 0)
            System.out.println("Account Empty\tPlease Deposit some Amount");
        else
            System.out.println("Balance= Rs. " + s);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.print(
                    ".Press 1 for Depositing\n.Press 2 for Withdrawing\n.Press 3 for Checking Balance\n.Press any other number to exit\n\n");
            getValue();
            if (c == 1)
                depo();
            else if (c == 2)
                withdr();
            else if (c == 3)
                bal();
            else
                break;
            System.out.println("\n");
        }
        System.out.println("THANK YOU");
    }
}
