/**
 * medium
 * 
 * 拿迭代硬写，考察stack，不难
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length) {
            if (!stack.isEmpty()) {
                int pop = stack.pop();

                while(true) {
                    if (pop > 0 && asteroids[i] < 0) {
                        if (Math.abs(pop) > Math.abs(asteroids[i])) {
                            stack.push(pop);
                            break;
                        } else if (Math.abs(pop) < Math.abs(asteroids[i])) {
                            if (!stack.isEmpty()) {
                                pop = stack.pop();
                            } else {
                                stack.push(asteroids[i]);
                                break;
                            }
                        } else if (Math.abs(pop) == Math.abs(asteroids[i])) {
                            break;
                        }
                    } else {
                        stack.push(pop);
                        stack.push(asteroids[i]);
                        break;
                    }
                }
                
            } else {
                stack.push(asteroids[i]);
            }
            i++;
        }

        int[] result = new int[stack.size()];
        for (int j = stack.size()-1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return result;
    }
}