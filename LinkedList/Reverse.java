class Reverse{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public Node tail;


    public void Addfirst(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int  data){
        Node newNode =  new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void Print(){
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return ;
        }
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public int Search(int key){
        Node temp = head;
        int i = 0;
        while (temp!=null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.Print();
       ll.reverse();;
       ll.Print();
    }
}