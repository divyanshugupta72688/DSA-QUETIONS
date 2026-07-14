 class Operations {
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

 public void addFirst(int data){
    Node newNode = new Node(data);
    if (head==null) {
        head = tail= newNode;
        return;
    }
    newNode.next = head;
    head = newNode;
 }

 public void addLast(int data){
    Node newNode = new Node(data);
    if (head ==null) {
        head = tail = newNode;
        return ;
    }
    tail.next = newNode;
    tail = newNode;
 }

 public void Print(){
    if (head==null) {
        System.out.println("LinkedList Is Empty.");
        return ;
    }
    Node temp= head;
    while (temp != null) {
        System.out.print(temp.data+" -> ");
        temp = temp.next;
    }
    System.out.println("Null");
 }

 public int itersearch(int key){
    int i = 0;
    Node temp = head;
    while (temp !=null) {
        if (temp.data==key) {
            return i;
        }
        temp = temp.next;
        i++;
    }
    return -1;
 }
 public static void main(String[] args) {
    Operations ll = new Operations();
    
    ll.addFirst(1);
    
    ll.addFirst(2);
    
    ll.addFirst(3);
    ll.Print();
    System.out.println(ll.itersearch(1));
 }
}
