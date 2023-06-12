/**
 * medium
 * 
 * 这个纯easy，完全0难度，只是我用的loop，可以用collection自带的reverse
 */

class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i = sArr.length-1; i >= 0; i--) {
            result.append(sArr[i]);
            if (i==0) break;
            result.append(" ");
        }
        return result.toString();
    }

    /*
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
    */
}