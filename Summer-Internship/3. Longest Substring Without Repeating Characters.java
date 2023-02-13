// hash map
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        // set a pointer to control substring's beginning Character
        int left = 0;
        int curr_length = 0;
        int max_length = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // for instance: "abba"
                // when i = 2, map.get("b") = 1, update left
                left = Math.max(left, map.get(c) + 1);
                // then left = 2, which means substring should begin at index 2
                //
                // if we go ahead to next loop, index 3 is "a"
                // when i = 3, map.get("a") = 0, update left
                //      left = Math.max(left, map.get(c) + 1);
                // then left = 2, which means substring should begin at index 2
                // (we don't consider index 0 "a" any more!)
            }
            curr_length = i - left + 1;
            if (curr_length > max_length) {
                max_length = curr_length;
            }
            map.put(c, i);
        }
        return max_length;
    }
}