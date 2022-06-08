package recursive.book;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public static void main(String[] args) {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');

        A.leftChild = B;
        B.leftChild = D;
        A.rightChild = C;
        C.leftChild = E;
        E.leftChild = G;
        E.rightChild = H;
        C.rightChild = F;

//        levelTraversal(A);
//        postOrderTraversal(A);
        inOrderTraversal(A);
    }

    public static void levelTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node item = queue.poll();
            if (item.leftChild != null)
                queue.add(item.leftChild);
            if (item.rightChild != null)
                queue.add(item.rightChild);
            System.out.print(item.value+" ");
        }
    }

    public static void postOrderTraversal(Node root) {
        if (root.leftChild != null)
            postOrderTraversal(root.leftChild);
        if (root.rightChild != null)
            postOrderTraversal(root.rightChild);
        System.out.print(root.value+" ");
    }

    public static void inOrderTraversal(Node root) {
        if (root.leftChild != null)
            inOrderTraversal(root.leftChild);
        System.out.print(root.value+" ");
        if (root.rightChild != null)
            inOrderTraversal(root.rightChild);
    }

}

class Node {
    char value;
    Node leftChild;
    Node rightChild;

    public Node(char value) {
        this.value = value;
    }
}
