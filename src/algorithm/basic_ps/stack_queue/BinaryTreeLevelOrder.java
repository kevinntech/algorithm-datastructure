package algorithm.basic_ps.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left, right;

    TreeNode(int x){
        this.val = x;
    }
}

public class BinaryTreeLevelOrder{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++) { // 큐의 사이즈가 레벨이라고 보면 됨
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list); // [3] [4, 5] [6, 7]
        }

        return result;
    }
}