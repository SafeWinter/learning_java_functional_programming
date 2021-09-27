package ch5.ex1;

public class Node {
    private int value;
    private Node left;
    private Node right;
    
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public Node(Node node) {
        this.value = node.value;
        this.left = null;
        this.right = null;
    }
    
    // getter
    public int getValue() {
        return this.value;
    }
    public Node left() {
        return this.left;
    }
    public Node right() {
        return this.right;
    }
    
    public Node addLeft(int value) {
        Node left = new Node(value);
        this.left = left;
        return left;
    }
    public Node addLeft(Node left) {
        this.left = left;
        return this;
    }
    
    public Node addRight(int value) {
        Node right = new Node(value);
        this.right = right;
        return right;
    }
    public Node addRight(Node right) {
        this.right = right;
        return this;
    }
}
