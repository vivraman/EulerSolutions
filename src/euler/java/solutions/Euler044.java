package euler.java.solutions;

import euler.java.main.Utility;

import java.util.ArrayList;

/**
 * Pentagonal numbers are generated by the formula, P_n=n(3n−1)/2. The first ten pentagonal numbers are: 1, 5, 12, 22,
 * 35, 51, 70, 92, 117, 145, ... It can be seen that P_4 + P_7 = 22 + 70 = 92 = P_8. However, their difference,
 * 70 − 22 = 48, is not pentagonal.
 *
 * Find the pair of pentagonal numbers, P_j and P_k, for which their sum and difference are pentagonal and
 * D = |P_k − P_j| is minimised. What is the value of D?
 */
public class Euler044 implements EulerProblem {

    /**
     * Brute force solution. Continuously generate pentagonal numbers and, for each generated number, iterate through
     * all previously generated numbers to find a new sum and difference. Use explicit formula to see if sum and
     * difference are both pentagonal, and return answer when found.
     *
     * @return solution to Problem 44
     */
    public String solve() {
        long answer = 0;
        ArrayList<Long> pentagonalNumbers = new ArrayList();
        for (int i = 1; answer == 0; i++) {
            long pentOne = Utility.getPentagonalNumber(i);
            pentagonalNumbers.add(pentOne);
            for (int j = i - 1; j > 0; j--) {
                long pentTwo = pentagonalNumbers.get(j);

                long sum = pentOne + pentTwo, difference = pentOne - pentTwo;
                if (Utility.isPentagonaNumber(sum) && Utility.isPentagonaNumber(difference) ) {
                   answer = pentOne - pentTwo;
                   break;
                }
            }
        }

        return answer + "";
    }
}

