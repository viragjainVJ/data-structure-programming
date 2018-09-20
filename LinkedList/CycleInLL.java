public class CycleInLL {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }   
    Node head;
    
    //Print the Linked List
    static private void print(Node head){   
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    //Return Intersection point of cycle in the Linked list
    static private Node cycle(Node head){
        Node slow = head;
        Node fast = head;
        
        while(slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                return slow.next;
            }
        }
        return null;
    }
    
    public static void main(String args[]) {
        CycleInLL list = new CycleInLL();
        list.head = new Node(1);
        list.head.next = new Node(5); 
        list.head.next.next = new Node(4); 
        list.head.next.next.next = new Node(2);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = list.head.next;
        
        Node intersection = cycle(list.head);
        
        //Work for Null/No Cycle and Cycled Linked List
        System.out.println(intersection != null ? "Cycle at intersection point: "+intersection.data: "No Cycle");
    }
}
