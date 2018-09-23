public class BinaryTreeTraversal {
    
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
    
    BinaryTreeTraversal() {
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
    
    /*
    *Print Binary Tree in Preorder
    *Node Element - Left Element - Right Element
    */
    static private void printPreOrder(Node root) {
        if(root == null){
            return;
        }
        
        System.out.print(root.data+ " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
    
    /*
    *Print Binary Tree in Postorder
    *Left Element - Right Element - Node Element
    */
    static private void printPostOrder(Node root){
        if(root == null){
            return;
        }
        
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public static void main(String args[]) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        
        insert(6);
        insert(4);
        insert(3);
        insert(10);
        insert(9);
        insert(5);
        
        System.out.print("InOrder: ");
        printInorder(root);
        System.out.println();
        System.out.print("PreOrder: ");
        printPreOrder(root);
        System.out.println();
        System.out.print("PostOrder: ");
        printPostOrder(root);
    }
}
