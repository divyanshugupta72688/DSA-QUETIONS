class Linkedlist {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    // Add at First
    public void AddFirst(int data) {

        Node newNode = new Node(data);

        // If LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Add at Last
    public void addLast(int data) {

        Node newNode = new Node(data);

        // If LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Print LinkedList
    public void print() {

        if (head == null) {
            System.out.println("LinkedList is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Linkedlist ll = new Linkedlist();

        ll.print();

        ll.AddFirst(1);
        ll.print();

        ll.AddFirst(2);
        ll.print();

        ll.addLast(3);
        ll.print();

        ll.addLast(4);
        ll.print();
    }
}