/*
need = 1
have = 2
covered = 3
 */
class Solution {
    int res = 0;
    public int liftUp(TreeNode node)
    {
        if(node == null)
        {
            return 3;
        }
        if(node.val == 0)
        {
            int lc, rc;
            if(node.left == null || node.left.val == 0)lc = liftUp(node.left);
            else lc = node.left.val;
            if(node.right == null || node.right.val == 0)rc = liftUp(node.right);
            else rc = node.right.val;
            if(lc==1 || rc==1)
            {
                node.val = 2;
                res++;
            }
            else if(lc==3&&rc==3)
            {
                node.val = 1;
            }
            else
            {
                node.val = 3;
            }
        }
        return node.val;
    }
    public int minCameraCover(TreeNode root) {
        liftUp(root);
        if(root.val == 1)res++;
        return res;
    }
}
