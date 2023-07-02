package Medium;

/*
        3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest substring without repeating characters.

        Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

        Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

        Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, max = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= left) {
                    max = Math.max(max, i - left);
                    left = map.get(c) + 1;
                }
            }
            map.put(c, i);
        }
        max = Math.max(max, n - left);
        return max;
    }

    /**
     * Una muy buena solucion de otro usuario
     *
     *      public int lengthOfLongestSubstring(String s) {
     *         int maxLength = 0;
     *         int start = 0;
     *         int[] position = new int[128];
     *         for( int cur = 0; cur<s.length(); cur++){
     *             // start update
     *             start = Math.max(start,position[s.charAt(cur)]);
     *             // maxLength update
     *             maxLength = Math.max(maxLength, cur-start+1);
     *             position[s.charAt(cur)] = cur +1;
     *         }
     *         return maxLength;
     *     }
     */
}
