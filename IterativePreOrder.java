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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        if(root==null)return ll;
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode node = s.pop();
            ll.add(node.val);
            if(node.right!=null)
            {
                s.push(node.right);
            }
            if(node.left!=null)
            {
                s.push(node.left);
            }
        }
        return ll;
    }
}
