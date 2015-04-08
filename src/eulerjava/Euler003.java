package eulerjava;

import java.util.*;

/* Problem 3: Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler003 {

    ArrayList<Long> primes;

    public Euler003() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    /* Brute force; find all primes (skip 2 since our value is odd) less than
     * half of our value. If prime, divide (if divisible) our value by the new prime 
     * repeatedly until it is no longer divisible. Continue until value = 1 (done)
     */
    private long solve() {
        long value = 600851475143L;
        long answer = 0;
        primes = new ArrayList<Long>();
        primes.add(2L);
        for (long i = 3; i <= 600851475143L / 2; i+=2) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                while (value % i == 0) {
                    answer = i;
                    value /= i;
                    if(value == 1){
                        return answer;
                    }
                }
            }
        }
        return -1;
    }
}
