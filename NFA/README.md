# NFA String Acceptance Simulator (Automata Java Activity)

## Objective
Create a Java program that simulates a **Nondeterministic Finite Automaton (NFA)** that **accepts strings containing the substring `ab`**.

---

## NFA Details
| Component | Description |
|-----------|-------------|
| **Alphabet** | {a, b} |
| **States** | q0 (start), q1, q2 (accept) |
| **Accepting Condition** | The substring `ab` appears anywhere in the input string |
| **Transitions** | Multiple next states possible per symbol |

---

## How the NFA Works
- The NFA starts in **q0**.
- As the input string is processed, the program tracks **all possible next states** based on each symbol.
- If **any path reaches the accepting state (`q2`)** after processing the whole string, the string is **Accepted**.
- Otherwise, the string is **Rejected**.

---

## Sample Output Screenshot

Below is a sample run of the NFA program:

(Screenshot folder to be added)

---

## 💻 Java Code Used

```java
// NFASimulator.java
import java.util.*;

public class NFASimulator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // NFA transitions represented using a map: state -> (symbol -> next states)
        Map<String, Map<Character, Set<String>>> transitions = new HashMap<>();

        // Transitions for state q0
        transitions.put("q0", new HashMap<>());
        transitions.get("q0").put('a', new HashSet<>(Arrays.asList("q0", "q1")));
        transitions.get("q0").put('b', new HashSet<>(Arrays.asList("q0")));

        // Transitions for state q1
        transitions.put("q1", new HashMap<>());
        transitions.get("q1").put('a', new HashSet<>(Arrays.asList("q1")));
        transitions.get("q1").put('b', new HashSet<>(Arrays.asList("q2")));

        // q2 is an accepting state with no outgoing transitions
        transitions.put("q2", new HashMap<>());

        System.out.print("Enter a string (a's and b's only): ");
        String input = scan.nextLine();

        // Start at initial state q0
        Set<String> currentStates = new HashSet<>();
        currentStates.add("q0");

        // Process each character in input
        for (char c : input.toCharArray()) {
            Set<String> nextStates = new HashSet<>();

            // For each possible current state, add all next states
            for (String state : currentStates) {
                if (transitions.containsKey(state) && transitions.get(state).containsKey(c)) {
                    nextStates.addAll(transitions.get(state).get(c));
                }
            }
            currentStates = nextStates;
        }

        // Accept if final states include q2
        if (currentStates.contains("q2")) {
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected");
        }

        scan.close();
    }
}
