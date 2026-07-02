class Solution {

    Integer[][] dp;

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        dp = new Integer[m + 1][n + 1];
        lcs(0, 0, str1, str2);

        StringBuilder ans = new StringBuilder();

        int i = 0, j = 0;

        while (i < m && j < n) {
            if (str1.charAt(i) == str2.charAt(j)) {
                ans.append(str1.charAt(i));
                i++;
                j++;
            } else {
                int skipS1 = lcs(i + 1, j, str1, str2);
                int skipS2 = lcs(i, j + 1, str1, str2);

                if (skipS1 >= skipS2) {
                    ans.append(str1.charAt(i));
                    i++;
                } else {
                    ans.append(str2.charAt(j));
                    j++;
                }
            }
        }

        while (i < m) {
            ans.append(str1.charAt(i++));
        }

        while (j < n) {
            ans.append(str2.charAt(j++));
        }

        return ans.toString();
    }

    int lcs(int i, int j, String s1, String s2) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcs(i + 1, j + 1, s1, s2);
        }

        return dp[i][j] = Math.max(lcs(i + 1, j, s1, s2),lcs(i, j + 1, s1, s2));
    }
}