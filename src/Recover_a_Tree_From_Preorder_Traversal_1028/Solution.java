package Recover_a_Tree_From_Preorder_Traversal_1028;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(recoverFromPreorder("3"));

    }

    public static TreeNode recoverFromPreorder(String traversal) {
        char[] chars = traversal.toCharArray();
        TreeNode root = new TreeNode();
        build(root, 0, 0, chars);
        return root;
    }

    public static int build(TreeNode node, int depth, int i, char[] chars) {
        int val = 0;
        do {
            val *= 10;
            val += chars[i] - '0';
            i++;
        } while (i < chars.length && chars[i] != '-');
        node.val = val;

        // find target depth
        int targetDepth = 0;
        do {
            if (i >= chars.length) break;
            i++;
            targetDepth++;
        } while (chars[i] == '-');

        if (targetDepth > depth) {
            node.left = new TreeNode();
            i = build(node.left, depth + 1, i, chars);
        } else {
            return i - targetDepth;
        }

        if (i >= chars.length) return i;

        // find target depth
        targetDepth = 0;
        do {
            i++;
            targetDepth++;
        } while (chars[i] == '-');

        if (targetDepth > depth) {
            node.right = new TreeNode();
            i = build(node.right, depth + 1, i, chars);
        } else {
            return i - targetDepth;
        }

        return i;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
