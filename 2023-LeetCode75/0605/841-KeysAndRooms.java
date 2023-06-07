/**
 * medium
 * 
 * 不难，但是因为是list套list，稍微有点绕，起初我超时死循环，是因为我忘了跳过已经判断为true的房间
 */

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);// room 0 is unlock
        boolean[] canBeVisited = new boolean[rooms.size()];
        canBeVisited[0] = true;

        while(!stack.isEmpty()) {
            int unlockedRoom = stack.pop();
            for(int i = 0; i < rooms.get(unlockedRoom).size(); i++) {
                if (!canBeVisited[rooms.get(unlockedRoom).get(i)]) {
                    canBeVisited[rooms.get(unlockedRoom).get(i)] = true;
                    stack.push(rooms.get(unlockedRoom).get(i));
                }
            }
        }
        boolean canVisitAll = true;
        for(Boolean room:canBeVisited) {
            if(!room) {
                canVisitAll = false;
                break;
            }
        }
        return canVisitAll;
    }
}