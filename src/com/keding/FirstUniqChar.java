package com.keding;

/**
 * 387. 字符串中的第一个唯一字符
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * 提示：你可以假定该字符串只包含小写字母
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("leetcode"));
        System.out.println(new Solution().firstUniqChar("loveleetcode"));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            // 假定只有26个小写字母，那么把每一个小写字母都放到一个大小为26的数组里{a,b,c,d}， int[0]表示a的次数,int[1]表示b的次数，默认次数都是0
            // 遍历字符串，先判断每个字符应该出现在数组的索引值，再自增
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            // 再次遍历字符串，把数组中出现的第一个值为1的找出来，就是第一个唯一字符的下标。
            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
