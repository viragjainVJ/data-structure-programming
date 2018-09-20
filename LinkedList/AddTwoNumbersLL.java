public class AddTwoNumbersLL {
    
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }   
    Node head;
 
    //Reverese Linked List Recursively
    static private Node reverseRecursively(Node head){
        if(head.next == null){
            return head;
        }
        
        Node rem = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        
        return rem;
    }
    
    //Print the Linked List
    static private void print(Node head){   
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    //Add Two Numbers represented by Linked List
    static private Node add(Node head1, Node head2){
        
        if(head1 == null){
            return head2;
        } else if(head2 == null){
            return head1;
        }
        
        int carry = 0;
        int sum = 0;
        
        Node head = null;
        Node prev = null;
        Node temp = null;
        
        while(head1 != null || head2 != null){
            sum = carry + (head1 != null ? head1.data:0) + (head2 != null ? head2.data:0);
            
            carry = (sum>=10?1:0);
            
            sum = sum%10;
            
            temp = new Node(sum);
            
            if(head == null){
                head = temp;
            } else {
                prev.next = temp;
            }
            
            prev = temp;
            
            if(head1 != null){
                head1 = head1.next;
            }
            if(head2 != null){
                head2 = head2.next;
            }
        }
        
        if(carry>0){
            temp.next = new Node(carry);
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        AddTwoNumbersLL list1 = new AddTwoNumbersLL();
        list1.head = new Node(1);
        list1.head.next = new Node(5); 
        list1.head.next.next = new Node(4); 
        list1.head.next.next.next = new Node(2);
        
        AddTwoNumbersLL list2 = new AddTwoNumbersLL();
        list2.head = new Node(8);
        list2.head.next = new Node(7); 
        list2.head.next.next = new Node(8); 
        list2.head.next.next.next = new Node(9);
        
        System.out.print("List-1: ");
        print(list1.head);
        list1.head = reverseRecursively(list1.head);
        
        System.out.print("List-2: ");
        print(list2.head);
        list2.head = reverseRecursively(list2.head);
        
        Node head = add(list1.head, list2.head);
        
        head = reverseRecursively(head);
        System.out.print("Sum   : ");
        print(head);
    }
}
