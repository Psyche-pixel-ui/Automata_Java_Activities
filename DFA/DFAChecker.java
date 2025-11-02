package labAct1;

import java.util.Scanner;

public class DFAChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String input = scan.nextLine();

        String state = "q0";

        for (char c : input.toCharArray()) {
            if (state.equals("q0")) {
                state = (c == '0') ? "q1" : "q0";
            } else if (state.equals("q1")) {
                state = (c == '1') ? "q2" : "q1";
            } else if (state.equals("q2")) {
                state = (c == '0') ? "q1" : "q0";
            } else {
                state = "error";
                break;
            }
        }

        if (state.equals("q2")) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        scan.close();
    }
}
