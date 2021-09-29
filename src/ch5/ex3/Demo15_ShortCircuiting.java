package ch5.ex3;

import ch5.ex1.Node;

public class Demo15_ShortCircuiting {
    
    private static int count1 = 0;
    private static int count2 = 0;
    
    public static void main(String[] args) {
        Node root = getRootNode();
        
        inOrder1(root);
        System.out.println("\ncount1:" + count1);

        inOrder2(root);
        System.out.println("\ncount2:" + count2);
        
        /*
        8 9 12 14 17 18 
        count1:13
        8 9 12 14 17 18 
        count2:6
        */
    }
    
    private static void inOrder1(Node root) {
        count1++;
        if(root == null) {
            return;
        }
        inOrder1(root.left());
        System.out.printf("%d ", root.getValue());
        inOrder1(root.right());
    }

    private static void inOrder2(Node root) {
        count2++;
        if(root == null) {
            return;
        }
        if(root.left() != null) {
            inOrder2(root.left());
        }
        System.out.printf("%d ", root.getValue());
        if(root.right() != null) {
            inOrder2(root.right());
        }
    }

    private static Node getRootNode() {
        Node root = new Node(12);
        root.addLeft(8).addRight(9);
        root.addRight(18).addLeft(14).addRight(17);
        return root;
    }
}
