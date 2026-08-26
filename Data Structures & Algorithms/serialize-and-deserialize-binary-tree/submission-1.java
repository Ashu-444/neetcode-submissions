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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";

        return root.val +","
    + serialize(root.left) +","
    + serialize(root.right);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        int[] index = {0};
        return buildTree(nums , index);
    }
    public TreeNode buildTree(String[] nums , int[] index){
        if(nums[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nums[index[0]]));
        index[0]++;

        root.left = buildTree(nums , index);
        root.right = buildTree(nums , index);

        return root;
    }
}
