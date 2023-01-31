import java.util.Stack;

/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
    // global index of string s
    int i = 0;

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // default operator is +
        char operator = '+';

        int num = 0;

        while (i < s.length()) {
            char currChar = s.charAt(i);
            i++;

            // check currChar if is integer from 0~9
            if (currChar >= '0' && currChar <= '9') {
                // since input is string, so which we read is character
                // we need to compose decimal number by mutiple read results
                num = num * 10 + (currChar - '0');
            }

            // '()'' condition
            if (currChar == '(') {
                // expression in parentheses has higher priority
                num = calculate(s);
            }
            if (i >= s.length() || currChar == '+' || currChar == '-' || currChar == ')') {
                // compare operator, not compare currChar! default operator is +
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                }
                // update operator
                operator = currChar;
                // update num for next num
                num = 0;
            }
            if (currChar == ')') {
                break;                
            }
        }
        // pop each element on stack and sum them
        int results = 0;
        while (stack.size() != 0) {
            results += stack.pop();
        }
        return results;
    }
}
// @lc code=end

