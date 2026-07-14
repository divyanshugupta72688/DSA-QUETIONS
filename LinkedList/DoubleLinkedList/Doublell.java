package LinkedList.DoubleLinkedList;

public class Doublell {
    public class Node{
        int data ;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;


    // add first to doubly linked list

    public void AddFirst(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return ;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ADD LAST TO DUBLY LINKEDLIST

    public void AddLast(int data){
        Node newNode = new Node(data);
        if (head ==null) {
            head = tail = newNode;
            return ;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

// reverse a doubly linked list


    public Node Reverse(Node head){
            Node prev = null;
            Node curr = head;
            Node next;
            while (curr!=null) {
                next = curr.next;
                curr.next = prev;
                curr.prev = next;
                prev = curr;
                curr = next;
            }
            return prev;
    }
    public static void main(String[] args) {
        Doublell dll  = new Doublell();
        dll.AddFirst(5);
    }
}
