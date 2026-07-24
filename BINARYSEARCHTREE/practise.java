package BINARYSEARCHTREE;


class practise {

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

// insertion of BINARY SEARCH TREE

    public static Node insert(Node root,int val){
        if (root==null) {
            root = new Node(val);
            return root;
        }
        if (root.data>val) {
            root.left = insert(root.left, val);

        }else{
            root.right = insert(root.right, val);
        }
            return root;
    }
// INORDER BINARY SEARCH TREE ME HAMESHA SORTED DETA HAI !
    public static void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    
    // search in BST


    public boolean Search(Node root,int key){
        if (root==null) {
            return false;
        }
        if (root.data==key) {
            return true;
        }else if (root.data>key) {
           return Search(root.left, key);
        }else{
           return Search(root.right, key);
        }
        
    }
    
    //Convert Sorted Array to Binary Search Tree


    public Node helper(int[]nums,int s,int e){
        
        if (s>e) {
            return null;
        }

        int mid = s+(e-s)/2;
        Node root = new Node(nums[mid]);
        
        root.left = helper(nums, s, mid-1);
        root.right = helper(nums, mid+1, e);
        return root;
    }
    public Node Sorted(int[]nums){
        return helper(nums,0,nums.length-1);
    }
    

    // delete node from BST

    public static Node delete(Node root,int val){

        if (root==null) {
            return null;
        }
        if (root.data<val) {
          root.right=  delete(root.right, val);
        }else if (root.data>val) {
            root.left = delete(root.left, val);
        }else{
            // pahal case leaf node hai
            if (root.left==null && root.right==null) {
                return null;
            }else if (root.left==null) { // dusra case hai jisme 1 node hogi ya to right side hogi ya left side hogi
                return root.right;
            }else if (root.right==null) {
               return root.left ;
            }
            // teesre case middle me delete karna ho to
            Node inorderSuccessor = findinordersuccessor(root.right);
            root.data =  inorderSuccessor.data; 
            root.right = delete(root.right, inorderSuccessor.data);
        }
        return root;
    }

    public static Node findinordersuccessor(Node root){
        while (root.left!=null) {
            root = root.left;
        }
        return root;
    }




    // PRINT IN RANGE

    public void PrintInRange(Node root,int k1,int k2){
            if (root==null) {
                return;
            }
        if (root.data>=k1 && root.data<=k2) {
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data);
            PrintInRange(root.right, k1, k2);
        }else if (root.data<k1) {
            PrintInRange(root.right, k1, k2);
        }else{
            PrintInRange(root.left, k1, k2);
        }
    }


    public static void main(String[] args) {
        int[] values = {5,1,3,4,2,7};
        Node root = null;
       
        for(int i = 0;i<values.length;i++){
                root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();
    }
}
