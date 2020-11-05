package algorithm.basic_ps.graph;

import java.util.*;

public class MaximumDepthOfBinaryTree_DFS {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_DFS a = new MaximumDepthOfBinaryTree_DFS();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(a.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();

        stack.push(root);
        value.push(1);

        int max = 0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //System.out.println("node: "+node.val);

            int count = value.pop();
            max = Math.max(max, count);

            if(node.left != null) {
                stack.push(node.left);
                value.push(count + 1);
            }

            if(node.right != null) {
                stack.push(node.right);
                value.push(count + 1);
            }
        }

        return max;
    }

}