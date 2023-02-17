// Dynamic Programming
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || s == null) {
            return "";
        }
        boolean[][] isPalindrome = new boolean[n][n];
        int start = 0; // aim to be the start index of the return substring
        int currLength = 0; 
        int maxLength = 0; // aim to calculate the return substring span
        // assume we have the dynamic programming table
        // the diagonal values of table are all true since they are single characters, such as "a"
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        maxLength = 1;
        // if the nearest two characters are same, it is also Palindrome, such as "aa" 
        for (int i = 0; i < n-1; i++) {
            // for instance: "bbad"
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = true;
                start = i;
                maxLength = 2;
            } else { // for instance: "ab"
                isPalindrome[i][i+1] = false;
            }
        }

        // so far, we have saved one-char and two-char situation
        // then, we start to find >=3 chars situation
        // use dp from the down-right to up-left 
        for (int i = n - 1; i >= 0; i--) {
            // since we need to find >=3 chars, the index gap should be 2
            // then j++, it can cover all elements in table
            for (int j = i + 2; j < n; j++) {
                if (isPalindrome[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    currLength = j - i + 1;
                } else {
                    isPalindrome[i][j] = false;
                }
                // find the max length palindrome, and save the start index
                if (currLength > maxLength) {
                    start = i;
                    maxLength = currLength;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}