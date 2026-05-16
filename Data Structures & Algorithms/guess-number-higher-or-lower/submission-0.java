/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    public int guessNumber(int start, int end) {
        int mid = end - (end - start) / 2;
        int guessN = guess(mid);
        if(guessN == 0) {
            return mid;
        }
        if(guessN == -1) {
            return guessNumber(start, mid - 1);
        }
        return guessNumber(mid + 1, end);
    }
}