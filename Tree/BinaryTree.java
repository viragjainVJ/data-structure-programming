public class BinaryTree {
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static Node root;
    
    BinaryTree() {
        root = null;
    }
    
    static private void insert(int data) {
        root = insertRecursively(root, data);
    }
    
    //Insert in Binary tree Recursively
    static private Node insertRecursively(Node root, int data){
        
        if(root == null){
            root = new Node(data);
            return root;
        }
        
        if(root != null){
            if(root.data > data){
                root.left = insertRecursively(root.left, data);
            } else {
                root.right = insertRecursively(root.right, data);
            }
        }
        
        return root;
    }
    
    /*
    *Print Binary Tree in Inorder
    *Left Element - Node Element - Right Element
    */
    static private void printInorder(Node root) {
        
        if(root == null) {
            return;
        }
        
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        
        insert(6);
        insert(4);
        insert(3);
        insert(10);
        insert(9);
        insert(5);
        
        printInorder(root);
    }
}
