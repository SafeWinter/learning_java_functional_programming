package ch5.ex1;

public class Demo03_HeadRecursion_postOrder {

    public static void main(String[] args) {
        
        // init root node
        Node root = getRootNode();
        
        // post order traversal
        postOrder(root);
    }

    private static Node getRootNode() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        return root;
    }

    private static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left());
        postOrder(node.right());
        System.out.print(node.getValue() + " ");
    }
    
}