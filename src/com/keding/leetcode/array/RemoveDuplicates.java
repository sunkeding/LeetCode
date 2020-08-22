package com.keding.leetcode.array;


/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        int result = new Solution().removeDuplicates(nums);
        System.out.println(result);
//        for (int i = 0; i < result; i++) {
//            System.out.println(nums[i]);
//        }
    }

    static class Solution {
        // 时间复杂度O(n);空间复杂度O(1)
        public int removeDuplicates(int[] nums) {
            //重复次数
            int duplicatesCount = 0;
            //第一个元素肯定不会变的，所以新数组的索引从1开始
            int k = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    nums[k] = nums[i + 1];
                    k++;
                } else {
                    duplicatesCount++;
                }
            }
            System.out.println("重复的元素有" + duplicatesCount + "个");
            return k;
        }
    }
}
