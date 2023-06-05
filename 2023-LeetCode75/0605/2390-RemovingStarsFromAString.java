/**
 * medium
 * 
 * 简单stack的使用，放在medium侮辱智商
 */
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < s.length()) {
            if(s.charAt(index) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(index));
            }
            index++;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}