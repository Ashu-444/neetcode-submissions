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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ds = new ArrayList<>();
        rightView(root , 0 , ds);
        return ds;
    }
    public void rightView(TreeNode node , int level , List<Integer> ds){
        if(node == null){
            return;
        }
        if(level == ds.size()){
            ds.add(node.val);
        }
        rightView(node.right , level + 1 , ds);
        rightView(node.left , level + 1 , ds);
    }
}
