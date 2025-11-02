# DFA String Acceptance Checker (Automata Java Activity)

## Objective
Create a Java program that simulates a Deterministic Finite Automaton (DFA) that **accepts binary strings ending in `01`**.

## DFA Details
| Component | Description |
|-----------|-------------|
| **Alphabet** | {0, 1} |
| **States** | q0 (start), q1, q2 (accept) |
| **Accepting State** | q2 |
| **Language** | All binary strings that end in `01` |


## How the DFA Works
- The program reads a binary string input from the user.
- It simulates state transitions based on each character (`0` or `1`).
- If the final state is **q2**, the string is **Accepted**.
- Otherwise, it is **Rejected**.
  

## Sample Output Screenshot

Below is a sample run of the DFA program:

https://github.com/Psyche-pixel-ui/Automata_Java_Activities/blob/main/Screenshot%202025-11-02%20192307.png
https://github.com/Psyche-pixel-ui/Automata_Java_Activities/blob/main/Screenshot%202025-11-02%20192316.png

## 💻 Java Code Used

```java
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



