/*
        5. Longest Palindromic Substring
    Given a string s, return the longest palindromic substring in s.

        Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.

        Example 2:
    Input: s = "cbbd"
    Output: "bb"

        Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters.
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1)
            return s;

        int center = 0, start = 0, max = 0, left, rigth;
        while (center < n && (n - center >= max / 2)) {
            left = center; rigth = center;
            while (rigth < n - 1 && s.charAt(rigth) == s.charAt(rigth + 1))
                rigth++;
            center = rigth + 1;
            while (left > 0 && rigth < n - 1 && s.charAt(left - 1) == s.charAt(rigth + 1)) {
                left--;
                rigth++;
            }
            if (rigth - left + 1 > max) {
                max = rigth - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + max);
    }
}
