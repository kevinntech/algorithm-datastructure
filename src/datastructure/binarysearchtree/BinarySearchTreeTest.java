package datastructure.binarysearchtree;

class BinarySearchTree{
    class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    Node root;

    public Node search(Node root, int key){
        if(root == null || root.data == key)
            return root;
        if(root.data > key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public void insert(int data){
        root = insert(root, data);
    }
    public Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data)
            root.left = insert(root.left, data);
        else if(data > root.data)
            root.right = insert(root.right, data);
        return root;
    }

    public void delete(int data){
        root = delete(root, data);
    }
    private Node delete(Node root, int data){
        if (root == null) return root;
        if (data < root.data)
            root.left = delete(root.left, data);
        else if(data > root.data)
            root.right = delete(root.right, data);
        else{
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int findMin(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
    public void inorder(){
        inorder(root);
        System.out.println("");
    }
    private void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);                 // 왼쪽 서브 트리의 순회
        System.out.print(root.data + " ");  // 루트 노드의 방문
        inorder(root.right);                // 오른쪽 서브 트리의 순회
    }
}

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(12);
        tree.insert(8);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(7);
        tree.insert(10);
        tree.insert(17);
        tree.insert(13);
        tree.insert(21);
        tree.inorder();
        tree.delete(8);
        tree.inorder();

        /*
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inorder();
        tree.delete(7);
        tree.inorder();

         */
    }
}
