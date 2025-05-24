package Easy;

/*
        9. Palindrome Number
    Given an integer x, return true if x is a palindrome, and false otherwise.

        Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

        Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
        Therefore it is not a palindrome.

        Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

        Constraints:
    -2^(31) <= x <= 2^(31) - 1

    Follow up: Could you solve it without converting the integer to a string?
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int rev = 0, aux = x;
        while(aux > 0) {
            rev *= 10;
            rev += aux % 10; //If overflow then number change
            aux /= 10;
        }
        return rev == x;
    }

    public boolean isPalindromeString(int x) {
        if(x < 0) return false;
        x = Math.abs(x);
        String s = String.valueOf(x);
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
