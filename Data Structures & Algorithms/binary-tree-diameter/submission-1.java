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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        height(root , d);
        return d[0];
    }
    public int height(TreeNode root , int[] d){
        if(root == null) return 0;

        int leftmost = height(root.left , d);
        int rightmost = height(root.right , d);

        d[0] = Math.max(d[0] , leftmost + rightmost);
        return 1 + Math.max(leftmost , rightmost);
    }

}
