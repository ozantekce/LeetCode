package Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106;

import java.util.HashMap;

public class Solution {



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

        buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});

    }


    static HashMap<Integer,Integer> ValueIndex;
    static int [] Inorder;
    static int [] Postorder;
    static int RootIndex;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Inorder = inorder;
        Postorder = postorder;
        ValueIndex = new HashMap<>(inorder.length);
        RootIndex = inorder.length-1;

        for (int i = 0; i < inorder.length; i++) {
            ValueIndex.put(inorder[i],i);
        }

        return helper(0,inorder.length-1);
    }


    public static TreeNode helper(int first, int last){

        if(first>last) return null;

        int value = Postorder[RootIndex--];
        TreeNode root = new TreeNode(value);

        root.right = helper(ValueIndex.get(value)+1,last);
        root.left = helper(first,ValueIndex.get(value)-1);

        return root;
    }


}
