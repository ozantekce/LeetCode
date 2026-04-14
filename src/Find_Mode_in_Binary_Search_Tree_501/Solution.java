package Find_Mode_in_Binary_Search_Tree_501;
import java.util.ArrayList;

public class Solution {
    
    public static int Value = Integer.MIN_VALUE;
    public static int Counter = 0;
    
    public static int MaxCounter = 0;
    public static ArrayList<Integer> Result = new ArrayList<>();
    
    public static int[] findMode(TreeNode root) {
        
        Value = Integer.MIN_VALUE;
        Counter = 0;
        MaxCounter = 0;
        Result.clear();
        
        find(root);
        
        if(Counter > MaxCounter){
            Result.clear();
            Result.add(Value);
            MaxCounter = Counter;
        }else if(Counter == MaxCounter){
            Result.add(Value);
        }
        
        int[] array = new int[Result.size()];
        for (int i = 0; i < Result.size(); i++) {
            array[i] = Result.get(i);
        }
        
        return array;
    }
    
    public static void find(TreeNode node){
        int val = node.val;
        TreeNode left = node.left;
        TreeNode right = node.right;
        if(left != null) find(left);
        
        if(val == Value){
            Counter++;
        }else{
            if(Counter > MaxCounter){
                Result.clear();
                Result.add(Value);
                MaxCounter = Counter;
            }else if(Counter == MaxCounter){
                Result.add(Value);
            }
            Value = val;
            Counter = 1;
        }

        if(right != null) find(right);
    }
    
    
    public class TreeNode {
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
