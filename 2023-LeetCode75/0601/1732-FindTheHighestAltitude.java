/**
 * easy
 * 
 * 主要还是依靠一个最大值，在遍历中不断更新最大值来实现
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int curr_altitude = 0;
        int max_altitude = 0;

        for (int curr_gain : gain) {
            curr_altitude = curr_altitude + curr_gain;
            max_altitude = Math.max(curr_altitude, max_altitude);
        }

        return max_altitude;
    }
}
