package com.keding.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: skd
 * @date 2020/5/5
 * @Desc 102.给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public static void main(String[] args) {
//        二叉树：[3,9,20,null,null,15,7],
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(100);
        root.left.right=new TreeNode(101);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
//        List<List<Integer>> lists = levelOrderByDFS(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }

    /**
     * BFS  广度优先遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> listList = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
//        int num=0;
        while (!nodes.isEmpty()) {
//            num++;
//            System.out.println("遍历第"+num+"层，当前节点数量="+nodes.size());
            ArrayList<Integer> list = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.pop();
                list.add(node.val);
                //把遍历到的每个节点都存起来，作为下一次遍历的内容
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            listList.add(list);
        }
        return listList;
    }

    /**
     * DFS  深度优先遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderByDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> listList = new ArrayList<>();
//        LinkedList<TreeNode> nodes = new LinkedList<>();
//        nodes.add(root);
//
        dfs(listList, root, 0);
        return listList;
    }

    public static void dfs(List<List<Integer>> listList, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (listList.size() < level + 1) {
            listList.add(new ArrayList<>());
        }
        listList.get(level).add(node.val);
        dfs(listList, node.left, level + 1);
        dfs(listList, node.right, level + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
