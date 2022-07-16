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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root!=null||(!s.isEmpty()))
        {
            if(root!=null)
            {
                s.push(root);
                root = root.left;
            }
            else
            {
                TreeNode node = s.pop();
                result.add(node.val);
                root = node.right;
            }
        }
        return result;
    }
}
