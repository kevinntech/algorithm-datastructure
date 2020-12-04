package algorithm.basic_ps.graph;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(a.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        // 재귀를 이용한 문제 해결 (후위 순회)
        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);    // 왼쪽 자식 노드를 방문
        int rightMax = maxDepth(root.right);  // 오른쪽 자식 노드를 방문

        // System.out.println("[현재 노드] " + root.val + " : " + leftMax + " , " + rightMax);

        return Math.max(leftMax, rightMax) + 1;
    }

}
