public class LinkedList {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }   
    Node head;
 
    static private Node reverseRecursively(Node head){
        if(head.next == null){
            return head;
        }
        
        Node rem = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        
        return rem;
    }
    
    static private Node reverseIteratively(Node head){
        Node prev = null;
        Node next = null;
        
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        return prev;
    }
    
    static private void print(Node head){   
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    
    public static void main(String args[]) {
        LinkedList list1 = new LinkedList();
        list1.head = new Node(1);
        list1.head.next = new Node(5); 
        list1.head.next.next = new Node(4); 
        list1.head.next.next.next = new Node(2);
        
        LinkedList list2 = new LinkedList();
        list2.head = new Node(6);
        list2.head.next = new Node(7); 
        list2.head.next.next = new Node(8); 
        list2.head.next.next.next = new Node(9);
        
        System.out.println("List-1 Before Reverse");
        print(list1.head);
        list1.head = reverseRecursively(list1.head);
        System.out.println("List-1 After Reverse Recursively!");
        print(list1.head);
        
        System.out.println("List-2 Before Reverse");
        print(list2.head);
        list2.head = reverseIteratively(list2.head);
        System.out.println("List-2 After Reverse Iteratively!");
        print(list2.head);
    }
}
