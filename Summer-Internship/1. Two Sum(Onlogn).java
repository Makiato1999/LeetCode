// O(nlogn)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // copy array and its index
        int[] dummy = nums.clone();
        int N = nums.length;
        Arrays.sort(nums);
        // set two pointers which are located on head and tail
        int left = 0, right = N - 1;
        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] > target) {
                right --;
            } else {
                left ++;
            }
        }
        // quit loop if we find the correct sum result

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // dummy is original order, nums is sorted
            if (dummy[i] == nums[left]) {
                result[0] = i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dummy[i] == nums[right]) {
                result[1] = i;
            }
        }
        return result;
    }
}