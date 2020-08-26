package com.keding.leetcode.linkedlist;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public static void main(String[] args) {

        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        System.out.println(listNode.toString());
        ListNode reverseList = new Solution().reverseList(listNode);
        System.out.println(reverseList);
    }
    static class Solution {
        public ListNode reverseList(ListNode curr) {
            ListNode pre =null;
            ListNode next =null;
            while (curr!=null){
                // 保存下一个结点，供下一次遍历
                next=curr.next;
                curr.next=pre;
                pre=curr;
                //依次往后去遍历
                curr=next;
            }
            return pre;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
