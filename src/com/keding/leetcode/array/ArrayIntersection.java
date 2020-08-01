package com.keding.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sunkeding
 * 两个数组交集2
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 2, 1};
        int[] num2 = {2, 2, 3};
        int[] intersect = new Solution().intersect(num1, num2);
        System.out.println(Arrays.toString(intersect));
    }

    static class Solution {

        /**
         * 方法一：哈希表
         * 由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
         *
         * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
         *
         * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            // 遍历短数组，哈希表中记录每个数字以及对应出现的次数
            for (int num : nums1) {
                int count = hashMap.getOrDefault(num, 0) + 1;
                // key代表值，value代表key出现的次数。
                hashMap.put(num, count);
            }
            //短数组节省内存
            int[] intersection = new int[nums1.length];
            int index = 0;
            //遍历长数组
            for (int num : nums2) {
                int numCount = hashMap.getOrDefault(num, 0);
                if (numCount > 0) {
                    // 说明是重复元素，添加到交集的数组中，并且数组下标+1
                    intersection[index++] = num;
                    numCount--;
                    if (numCount > 0) {
                        hashMap.put(num, numCount);
                    } else {
                        //说明在长数组中的重复数字，但短数组中已经没有了，移除hashmap的key，减少后续遍历次数
                        hashMap.remove(num);
                    }
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }

}




