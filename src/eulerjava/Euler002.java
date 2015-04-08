package eulerjava;

/* Problem 2: Even Fibonacci numbers
 * Each new term in the Fibonacci sequence is generated by adding the previous 
 * two terms. By starting with 1 and 2, the first 10 terms will be: 
 *                  1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * 
 * By considering the terms in the Fibonacci sequence whose values do not exceed
 * four million, find the sum of the even-valued terms.
 */
public class Euler002 {

    public Euler002() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }
    
    //Brute force solution, iterate through all fibonacci numbers:
    private int solve() {
        int answer = 0;
        int n = 1;
        int n_ = 1;
        while (n < 4000000) {
            int temp = n;
            n += n_;
            n_ = temp;
            if (n_ % 2 == 0) {
                answer += n_;
            }
        }
        return answer;
    }
}
