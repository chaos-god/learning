package com.chaos.leetcode.common;


import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * TreeNode 反序列化，层次遍列
     *
     * @param vars 数组
     * @return TreeNode
     */
    public static TreeNode valueOf(Integer[] vars) {
        if (vars == null || vars.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(vars[0]);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < vars.length; ) {
            TreeNode parent = q.poll();
            Integer left = vars[i++];
            if (left != null) {
                parent.left = new TreeNode(left);
                q.offer(parent.left);
            } else {
                parent.left = null;
            }

            Integer right = vars[i++];
            if (right != null) {
                parent.right = new TreeNode(right);
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }

        return root;
    }

    public static Integer[] toArray(TreeNode root) {
        if (root == null) {
            return new Integer[0];
        }

        LinkedList<Integer> out = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                out.add(null);
                continue;
            }
            out.add(curr.val);

            q.offer(curr.left);
            q.offer(curr.right);

        }

        return out.toArray(new Integer[0]);
    }
}
