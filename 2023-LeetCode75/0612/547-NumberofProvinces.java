/**
 * medium
 * 
 *这个难度不低啊，adjacency matrix，加上dfs，我觉得蛮绕的，可以再回来写下
 */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        // adjacency matrix
        boolean[] isVisited = new boolean[isConnected.length];
        // 初始化访问的array，默认都是没有访问
        for (boolean i: isVisited) {
            i = false;
        }
        int nummberOfProvinces = 0;
        // in adjacency matrix，row是城市，col是邻居
        for (int city = 0; city < isConnected.length; city++) {
            if (!isVisited[city]) {
                nummberOfProvinces++;
                dfs(city, isConnected, isVisited);
            }
        }
        return nummberOfProvinces;
    }

    public void dfs(int city, int[][] isConnected, boolean[] isVisited) {
        // 给访问过的城市加上记录，which means是一个省的（相连的）
        isVisited[city] = true;
        for (int neighbor = 0; neighbor < isConnected[0].length; neighbor++) {
            // 连接 且没有访问过，才会进dfs
            if (isConnected[city][neighbor] == 1 && !isVisited[neighbor]) {
                // 更新现在邻居为下一次递归的城市
                dfs(neighbor, isConnected, isVisited);
            }
        }
    }
}