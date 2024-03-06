/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftMax = Math.max(helper(root.left),0);
        int rightMax = Math.max(helper(root.right),0);
        int currSum = root.val+ leftMax + rightMax; //split sum
        maxSum = Math.max(currSum, maxSum);
        return root.val + Math.max(leftMax, rightMax); //no-split sum
    }
}
