package ch5.ex2;

import ch5.ex1.Node;

public class Demo06_inorder {

    public static void main(String[] args) {
        Node root = getRootNode();
        inOrder(root);
    }
    
    private static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left());
        System.out.printf("%s ", node.getValue());
        inOrder(node.right());
    }

    private static Node getRootNode() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        return root;
    }
}