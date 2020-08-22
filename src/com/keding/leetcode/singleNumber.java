package com.keding.leetcode;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 136. 只出现一次的数字
 *给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 输入: [2,2,1]
 * 输出: 1
 */
public class singleNumber {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,24,5,5,3,3};
        System.out.println(new Solution().singleNumber(nums));
    }
    static class Solution {
        // 最佳思路：异或
        public int singleNumber(int[] nums) {
            int result=nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                result=result^nums[i+1];
            }
            return result;
        }
    }
}
