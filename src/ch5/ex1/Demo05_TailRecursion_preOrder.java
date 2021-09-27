package ch5.ex1;

public class Demo05_TailRecursion_preOrder {

    public static void main(String[] args) {
        // $5.2.3 Using tail recursion: Node implementation
        Node root = getRootNode();
        preOrder(root);
    }
    
    private static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.printf("%d ", node.getValue());
        preOrder(node.left());
        preOrder(node.right());
    }

    private static Node getRootNode() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        return root;
    }

}