package euler.java.solutions;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Problem 29: Distinct powers
 * How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 */
public class Euler029 extends EulerProblem {

    /**
     * Brute force iterate through all powers and hash results that haven't been found yet. Add to counter
     * for each result that the hashset doesn't already contain.
     *
     * @return solution to Problem 29
     */
    @Override
    protected String solve() {
        int counter = 0;
        HashSet<BigInteger> powers = new HashSet<>();
        for (int i = 2; i < 101; i++) {
            BigInteger currentPow = new BigInteger(i + ""), pow = new BigInteger(i + "");
            for (int j = 2; j < 101; j++) {
                currentPow = currentPow.multiply(pow);
                if (!powers.contains(currentPow)) {
                    powers.add(currentPow);
                    counter++;
                }
            }
        }
        return counter + "";
    }
}
