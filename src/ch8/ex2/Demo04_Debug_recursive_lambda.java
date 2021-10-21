package ch8.ex2;

import java.util.function.Consumer;

public class Demo04_Debug_recursive_lambda {
	
	private static Consumer<Node> inorder;
	
    public static void main(String[] args) {
    	
    	Node root = getRootNode();
    	
    	inorder = (Node node) -> {
    		if(node == null) {
    			return;
    		} else {
				inorder.accept(node.left());
				System.out.print(node.getValue() + " ");
				inorder.accept(node.right());
			}
    	};
    	
    	inorder.accept(root);
    }

	private static Node getRootNode() {
		Node root = new Node(12);
	    root.addLeft(8).addRight(9);
	    root.addRight(18).addLeft(14).addRight(17);
		return root;
	}
    
}
