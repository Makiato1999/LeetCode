import java.util.Stack;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    // global index of input string s
    int i = 0;

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // default operator is +
        char operator = '+';

        int num = 0;

        while (i < s.length()) {
            char currChar = s.charAt(i);
            i++;
            // check if currChar is integer
            if (Character.isDigit(currChar)) {
                num = num * 10 + (currChar - '0');
            }

            // parentheses have higher priority
            if (currChar == '(') {
                num = calculate(s);
            }
            if (i == s.length() || currChar == '+' || currChar == '-' 
                                || currChar == '*' || currChar == '/'
                                || currChar == ')') {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }

                operator = currChar;
                num = 0;
            }
            if (currChar == ')') {
                break;
            }
        }
        int results = 0;
        while (stack.isEmpty() == false) {
            results += stack.pop();
        }
        return results;
    }
}
// @lc code=end

