package Hard;

/*
        10. Regular Expression Matching
    Given an input string s and a pattern p, implement regular expression matching with support
    for '.' and '*' where:
        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

        Example 1:
    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".

        Example 2:
    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once,
    it becomes "aa".

        Example 3:
    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".

        Constraints:
    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character
    to match.
 */

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean matchCondition = !s.isEmpty() && (
                s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'
            );

        if(p.length() > 1 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (
                    matchCondition && isMatch(s.substring(1), p)
                );
        else return matchCondition && isMatch(s.substring(1), p.substring(1));
    }

    public boolean isMatchNonRecursive(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (pc == '.' || pc == sc)
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pc == '*') {
                    char prevPc = p.charAt(j - 2);
                    if (prevPc == '.' || prevPc == sc)
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[m][n];
    }
}
