package Binary_Tree_Right_Side_View_199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(rightSideView(root));

    }

    public static List<Integer> rightSideView(TreeNode root) {

        degreeValuePair = new HashMap<>();
        recursive(0,null,root);
        List<Integer> list = new ArrayList<>();
        for (int val:degreeValuePair.values()) {
            list.add(val);
        }
        //System.out.println(list);
        return list;
    }

    private static HashMap<Integer,Integer> degreeValuePair;

    public static void recursive(int degree,TreeNode parent,TreeNode current){

        if(current==null)
            return;

        if(current.right!=null)
            recursive(degree+1,current,current.right);

        //System.out.println(degree+" "+current.val);
        if(!degreeValuePair.containsKey(degree)){
            degreeValuePair.put(degree, current.val);
        }
        if(current.left!=null)
            recursive(degree+1,current,current.left);

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