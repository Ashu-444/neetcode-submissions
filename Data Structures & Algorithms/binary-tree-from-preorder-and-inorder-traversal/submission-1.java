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
    public int search(int[] inorder , int left , int right , int val){
        for(int i = left; i <= right; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
    public TreeNode helper(int[] preorder, int[] inorder , int [] preIdx , int left , int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx[0]]);
        int inIdx = search(inorder , left , right , preorder[preIdx[0]]);
        preIdx[0]++;
        root.left = helper(preorder , inorder , preIdx  , left , inIdx - 1);   
        root.right = helper(preorder , inorder , preIdx  , inIdx + 1 , right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIdx = {0};
        return helper(preorder , inorder , preIdx , 0 , inorder.length -1);
    }
}
