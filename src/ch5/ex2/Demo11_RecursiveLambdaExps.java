package ch5.ex2;

import java.util.function.Consumer;

import ch5.ex1.Node;

public class Demo11_RecursiveLambdaExps {

    private static Consumer<Node> inorder;  // Instance variable

    public static void main(String[] args) {

        inorder = node -> {
            if(node == null) {
                return;
            }
            inorder.accept(node.left());
            System.out.printf("%d ", node.getValue());
            inorder.accept(node.right());
        };
        
        Node root = getRootNode();
        inorder.accept(root);
    }
    
    private static Node getRootNode() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        return root;
    }
}