class LinkedList{
  

    public static class  Node {
                int data;
                Node next;

                public Node(int data){
                    this.data = data;
                    this.next = null;
                }
        
    }
    public Node head;
    public Node tail;

    // addfirst

    public void Addfirst(int data){
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    // addlast 

    public void AddlAst(int data){
        Node newNode = new Node(data);
        if (head==null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }


    // print a cycle

    public void print(){
        Node temp = head;
        if (head==null) {
            System.out.println("LinkedList Is Empty.");
        }
        while (temp!=null) {
            System.out.println(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    

    // search key in a cycle

    public int search(int key){
        Node temp = head;
        int i = 0;
        while(temp!=null){
        if (temp.data==key) {
            
            return i;
        }
        temp = temp.next;
        i++;
    }
        return -1;
    }

// reverse cycle

    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
 
    // insert from end

 public Node insertionAtEnd(Node head){
    Node newNode = new Node(0);
    if (head==null) {
        return newNode;
    }
    Node temp = head;
    while (temp!=null) {
       temp =  temp.next;
    }
    temp.next = new Node(0);
    return head;
 }




 // REMOVE FROM END 


 public Node Remove(Node head,int n){
    int size = 0;
    Node temp = head;
    while (temp!=null) {
        temp = temp.next;
        size++;
    }

    if (size ==n) {
        head = head.next;
        return head;
    }

    int i = 1;
    int ithNode = size-n;
    Node prev = head;
    while (i<ithNode) {
        prev = prev.next;
        i++;
    }
    prev.next = prev.next.next;
    return head;
 }
 
 
 // CHECK PALINDROME OR NOT 3 step me hoti hai 

 //1. mid nikalana vo slow and fast pointer se nikala jata haia
 //2. 2nd half ko reverse karna jo nirmally reverse function se kar sakte hai
 //3. left ke data ko aur right ke data ko compare karte chale jate hai 


 public Node findMid(Node head){
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
        slow  = slow.next;
        fast  = fast.next.next;
    }
    return slow;
 }

 public boolean isPalindrome(){


    if (head==null || head.next==null) {
        return true;
    }
  // step1.

             Node midNode  = findMid(head);// helper function
        // step 2.

        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // step 3.

            Node right = prev;
            Node left = head;
            while (right != null) {
                if (left.data != right.data) {
                    return false;
                }
                left = left.next;
                right = right.next;

            }
            return true;
 }

// Remove element from the linkedlist 


 public Node Remo(Node head,int data){
    Node dummy = new Node(0);
    dummy.next = head;
    Node prev = dummy;
    Node curr = head;
    while (curr!=null) {
        if (curr.data==data) {
            prev.next = curr.next;
        }else{
            prev = curr;
        }
        curr =curr.next;
    }
    return dummy.next;
 }
 

 // detect a cycle in linked list

 public boolean Cycle(Node head){
    Node slow = head;
    Node fast = head;
    while (fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow==fast) {
            return true;
        }
    }
    return false;
 }


 // detect a cycle 

 public Node CycleSecond(Node head){
    Node slow = head;
    Node fast = head;
    while (fast!=null && fast.next !=null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow==fast) {
            Node newFast = head;
            while (slow!=newFast) {
                slow = slow.next;
                newFast = newFast.next;
            }
            return newFast;
        }
    }
    return null;
 }


// remove cycle

public void removeCycle(){

    // teen step me kaam hoga pahle step me cycle detect karenge dusre step find karenege lastindex ko aur teesre step me last ko null kar denege

// cycle detect karenge 
    Node slow = head;
    Node fast = head;
    boolean cycle = false;
    while (fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow==fast) {
            cycle = true;
            break;
        }
    }
         // agar cycle hii nahi hogi to detect kise karenge 
    if (cycle ==false) {
        return ;
    }

    // meeting point nikalange jaha per dusri  baar mile the slow and fast pointer
    
    Node newslow = head;
    Node prev = null;
    while (newslow!=fast) {
        prev = fast;
        newslow = newslow.next;
        fast = fast.next;
    } 
    prev.next = null;
}



// merge sort on linked list


private Node getmid(Node head){
    Node slow  = head;
    Node fast = head.next;
    while (fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

private Node merge(Node head1,Node head2){
    Node mergell = new Node(-1);
    Node temp = mergell;

    while (head1!=null && head2!=null) {
        if (head1.data <=head2.data) {
            temp.next = head1;
            head1 = head1.next ;
            temp = temp.next;
        }else{
             temp.next = head2;
            head2 = head2.next ;
            temp = temp.next;
        }
    }
    while (head1!=null) {
        temp.next = head1;
            head1 = head1.next ;
            temp = temp.next;
    }
    while (head2!=null) {
        temp.next = head2;
            head2 = head2.next ;
            temp = temp.next;
    }
    return mergell.next;
}
public Node mergeSort(Node head){
    if (head==null || head.next==null) {
        return head;
    }

    Node mid = getmid(head);
    Node righthead = mid.next;
    mid.next = null;

    Node newleftNode = mergeSort(head);
    Node newRighNode = mergeSort(righthead);

    return merge(newleftNode,newRighNode);

}

// remove duplicate from linkedlist



public Node Duplicate(Node head){

    if (head ==null) {
        return null;
    }
    Node prev = head;
    Node curr = head.next;
    while (curr!=null) {
        if (prev.data == curr.data) {
            prev.next = curr.next;
        }else{
            prev = curr;
        }
        curr = curr.next;
    }
    return head;
}

// Main class
 public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        
        ll.AddlAst(1);
        ll.AddlAst(2);
        ll.AddlAst(3);
     System.out.println(ll.search(3));
    }
}