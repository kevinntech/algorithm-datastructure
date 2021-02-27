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
        // 트리를 탐색하다가 리프 노드에 도달하면 null을 반환하고
        // 찾고자 하는 값을 찾았다면 해당 노드를 반환한다.
        if(root == null || root.data == key)
            return root;

        // 아직 찾지 못했다면 노드의 값과 찾는 값(key)을 비교하여 찾는 값이 더 작다면 왼쪽으로 이동
        if(root.data > key)
            return search(root.left, key);
        else // 반대면 오른쪽으로 이동한다.
            return search(root.right, key);
    }

    public void insert(int data){
        root = insert(root, data);
    }

    public Node insert(Node root, int data){
        // root가 null이면 (리프 노드에 도달하면) 전달 받은 데이터로 노드를 생성해서 반환한다.
        if(root == null){
            root = new Node(data);
            return root;
        }

        // 삽입할 위치를 찾지 못했다면 노드의 값과 찾는 값(data)을 비교하여 찾는 값이 더 작다면 왼쪽으로 이동하여 삽입할 위치를 찾는다.
        if(data < root.data)
            root.left = insert(root.left, data);
        else if(data > root.data) // 반대면 오른쪽으로 이동하여 삽입할 위치를 찾는다.
            root.right = insert(root.right, data);

        return root; // 자기 자신을 반환한다.
    }

    public void delete(int data){
        // 루트 노드와 삭제할 데이터를 가지고 재귀 함수를 호출한다.
        // 재귀 함수를 호출한 이후 root 노드가 삭제 될 수도 있기 때문에 결과를 받아서 저장한다.
        root = delete(root, data);
    }
    private Node delete(Node root, int data){
        // 노드가 null이면 null을 반환한다.
        if (root == null)
            return root;

        // 아니면 삭제할 노드를 찾는다.
        if (data < root.data) // 삭제 할 데이터(data)가 루트 데이터 보다 작다면 왼쪽으로 탐색
            root.left = delete(root.left, data);
        else if(data > root.data) // 삭제 할 데이터(data)가 루트 데이터 보다 크다면 오른쪽으로 탐색
            root.right = delete(root.right, data);
        else{ // 삭제할 데이터를 찾은 경우
            if(root.left == null && root.right == null) // 왼쪽과 오른쪽 자식 둘 다 없는 경우
                return null; // null을 반환한다. (null을 반환하면 링크가 끊어져서 삭제가 됨)
            else if(root.left == null) // 자식 노드가 한쪽에만 있는 경우, 자식을 들어서 올리면 된다.
                return root.right;
            else if(root.right == null)
                return root.left;

            // 자식이 둘 다 있는 경우에는 오른쪽 서브트리 중 가장 작은 값을 찾아서 삭제 대상 노드에 값을 저장한다.
            // 오른쪽 서브트리 중 가장 작은 값을 가지는 노드가 그대로 남아 있기 때문에 해당 노드를 삭제한다.
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data); // 내 오른쪽 자식 중 해당 값을 가지는 지우라는 함수 호출을 한다.
        }
        return root;
    }

    int findMin(Node root){
        int min = root.data;

        // 루트노드를 받아서 null을 만나기 전까지는 왼쪽 자식 노드로 이동한다.
        // 왼쪽 자식이 null인 노드를 만나면 그 노드가 해당 트리에서 가장 작은 값이 된다.
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }

        // 가장 작은 값을 리턴한다.
        return min;
    }

    public void inorder(){
        inorder(root);
        System.out.println("");
    }

    private void inorder(Node root) {
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
