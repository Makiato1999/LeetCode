/**
 * easy
 * 
 * 在两个hashset中找不同，通过removeAll来实现，也可以用loop，注意类型转换
 */
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> itmesInNums1 = new HashSet<>();
        Set<Integer> itemsInNums2 = new HashSet<>();

        for(int i: nums1) {
            itmesInNums1.add(i);
        }
        for(int i: nums2) {
            itemsInNums2.add(i);
        }
        // 寻找nums1有，nums2没有的
        Set<Integer> onlyInNums1 = new HashSet<>(itmesInNums1);
        onlyInNums1.removeAll(itemsInNums2);
        List<Integer> list1 = new ArrayList<>(onlyInNums1);
        
        // 寻找nums2有，nums1没有的
        Set<Integer> onlyInNums2 = new HashSet<>(itemsInNums2);
        onlyInNums2.removeAll(itmesInNums1);
        List<Integer> list2 = new ArrayList<>(onlyInNums2);

        return Arrays.asList(list1, list2);
    }
} 
