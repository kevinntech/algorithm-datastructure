package datastructure.binarytree;

class Node{
    int data;
    Node left, right; // 왼쪽, 오른쪽 자식 노드
}

class BinaryTree
{
    // 이진 트리의 루트 노드
    private Node root;

    public void setRoot(Node node){
        this.root = node;
    }
    public Node getRoot(){
        return root;
    }

    // 노드를 만든다.
    public Node makeNode(Node left, int data, Node right){
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    public void preorder(Node node){
        if (node == null)
            return;

        // node가 null이 아닌 동안 재귀 호출을 반복한다.
        System.out.print(node.data + " ");  // 루트 노드의 방문
        preorder(node.left);                // 왼쪽 서브 트리의 순회
        preorder(node.right);               // 오른쪽 서브 트리의 순회
    }

    public void inorder(Node node){
        if (node == null)
            return;

        inorder(node.left);                 // 왼쪽 서브 트리의 순회
        System.out.print(node.data + " ");  // 루트 노드의 방문
        inorder(node.right);                // 오른쪽 서브 트리의 순회
    }

    public void postorder(Node node){
        if (node == null)
            return;

        postorder(node.left);               // 왼쪽 서브 트리의 순회
        postorder(node.right);              // 오른쪽 서브 트리의 순회
        System.out.print(node.data + " ");  // 루트 노드의 방문
    }

}

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n3 = tree.makeNode(null, 3, null);
        Node n1 = tree.makeNode(n2, 1, n3);
        tree.setRoot(n1);

        tree.preorder(tree.getRoot());
        System.out.println();
        tree.inorder(tree.getRoot());
        System.out.println();
        tree.postorder(tree.getRoot());

        /*
                    1
                ⧸       ⧹
               2         3
             ⧸   ⧹
            4    5

            Inorder (Left, Root, Right) : 4 2 5 1 3
            Preorder (Root, Left, Right) : 1 2 4 5 3
            Postorder (Left, Right, Root) : 4 5 2 3 1
        */
    }
}

