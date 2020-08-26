package com.keding.leetcode.linkedlist;

import java.util.HashSet;

/**
 * 141. 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = listNode;
        System.out.println(new Solution().hasCycle(listNode));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        // 遍历链表，把访问过的放到HashSet,判断HashSet中是否有重复节点，就代表是否有环
        public boolean hasCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)) {
                    return true;
                } else {
                    set.add(head);
                }
                head = head.next;
            }
            return false;
        }
    }
}
