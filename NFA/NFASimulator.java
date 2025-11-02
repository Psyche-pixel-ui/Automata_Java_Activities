package labAct2;

import java.util.*;
import java.util.function.BiConsumer;

public class NFASimulator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string (alphabet: a, b): ");
        String input = scan.nextLine().trim();

        // Build the NFA transitions:
        Map<String, Map<Character, Set<String>>> trans = new HashMap<>();

        // helper to add transitions
        BiConsumer<String, Map<Character, Set<String>>> putState = (state, m) -> trans.put(state, m);

        // q0 transitions
        Map<Character, Set<String>> q0 = new HashMap<>();
        q0.put('a', new HashSet<>(Arrays.asList("q0", "q1"))); 
        q0.put('b', new HashSet<>(Arrays.asList("q0")));      
        putState.accept("q0", q0);

        // q1 transitions
        Map<Character, Set<String>> q1 = new HashMap<>();
        q1.put('a', new HashSet<>(Arrays.asList("q1"))); 
        q1.put('b', new HashSet<>(Arrays.asList("q2"))); 
        putState.accept("q1", q1);

        // q2 transitions (accepting sink)
        Map<Character, Set<String>> q2 = new HashMap<>();
        q2.put('a', new HashSet<>(Arrays.asList("q2")));
        q2.put('b', new HashSet<>(Arrays.asList("q2")));
        putState.accept("q2", q2);

        // start simulation
        Set<String> current = new HashSet<>();
        current.add("q0"); // start state

        boolean invalid = false;
        for (char ch : input.toCharArray()) {
            if (ch != 'a' && ch != 'b') {
                System.out.println("Invalid input character: " + ch + " (only 'a' and 'b' allowed).");
                invalid = true;
                break;
            }
            Set<String> next = new HashSet<>();
            for (String s : current) {
                Map<Character, Set<String>> m = trans.get(s);
                if (m != null && m.containsKey(ch)) {
                    next.addAll(m.get(ch));
                }
            }
            current = next;
    
            if (current.isEmpty()) break;
        }

        if (!invalid) {
  
            if (current.contains("q2")) {
                System.out.println("Accepted");
            } else {
                System.out.println("Rejected");
            }
        }

        scan.close();
    }
}
