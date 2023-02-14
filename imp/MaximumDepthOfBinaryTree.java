package testds.imp;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaximumDepthOfBinaryTree{
    public static void main(String[] args){
        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();
        /*
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);*/
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);       
        System.out.println("Maximum Depth "+obj.maxDepthRec(root));
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N) for Stack
     */
    public int maxDepthRec(TreeNode root){
        return maxDepthRec(root, 1);
    }
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepthRec(TreeNode root, int currDepth) {
        if(root == null) return 0;
    
        if(root.left == null && root.right == null){
            maxDepth = Math.max(maxDepth, currDepth);
        }

        maxDepthRec(root.left, currDepth + 1);
        maxDepthRec(root.right, currDepth + 1);

        return maxDepth;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N) for Stack, hight of the tree (O(Log N) for balanced tree) & 
    O(N) for HashMap
     */
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int maxDepth = Integer.MIN_VALUE;
        // traverse through all the branches till you reach leaf node
        // then check if the depth is greater than maxDepth and if yes, update the depth
        // Node -- currDepth
        Map<TreeNode, Integer> hMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        hMap.put(root, 1);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            int currDepth = hMap.get(curr);
            if(curr.left == null && curr.right == null){
                maxDepth = Math.max(maxDepth, currDepth);
            }else{
                if(curr.left != null){
                    stack.push(curr.left);
                    hMap.put(curr.left, currDepth + 1);
                }
                if(curr.right != null){
                    stack.push(curr.right);
                    hMap.put(curr.right, currDepth + 1);
                }
            }
        }
        return maxDepth;
    }
}