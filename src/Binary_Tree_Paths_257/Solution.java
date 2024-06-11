package Binary_Tree_Paths_257;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        if(root.left == null && root.right == null){
            result.add(stringBuilder.toString());
        }else{
            recursive(root.left, stringBuilder, result);
            recursive(root.right, stringBuilder, result);
        }
        return result;
    }


    private static void recursive(TreeNode root, StringBuilder stringBuilder, List<String> result){

        if(root == null){
            return;
        }
        int oldLength = stringBuilder.length();
        stringBuilder.append("->");
        stringBuilder.append(root.val);

        if(root.left == null && root.right == null){
            result.add(stringBuilder.toString());
            stringBuilder.setLength(oldLength);
            return;
        }

        recursive(root.left, stringBuilder, result);
        recursive(root.right, stringBuilder, result);

        stringBuilder.setLength(oldLength);
    }



    private static class TreeNode {
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


}
