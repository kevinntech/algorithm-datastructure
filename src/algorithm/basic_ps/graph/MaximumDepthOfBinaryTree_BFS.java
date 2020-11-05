package algorithm.basic_ps.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_BFS a = new MaximumDepthOfBinaryTree_BFS();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(a.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int count =0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            count++;
        }

        return count;
    }

}