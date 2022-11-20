package Binary_Tree_Preorder_Traversal_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Solution {


    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            list.add(current.val);
            if(current.right!=null)
                stack.add(current.right);
            if(current.left!=null)
                stack.add(current.left);

        }

        return list;
    }

}

class TreeNode {
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



