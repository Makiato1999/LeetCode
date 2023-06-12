/**
 * medium
 * 
 * 如何使用优先队列里的最大堆，其余思路非常简单
 * 难度在使用PriorityQueue，以及其中Comparator接口的实现，这是因为reverseOrder是static方法，故不需要实现Comparator就能调用
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < nums.length; i++)
        {
            maxHeap.add(nums[i]);
        }
        int counter = 1;

        while(counter < k) {
            maxHeap.poll();
            counter++;
        }
        return maxHeap.poll();

    } 
}