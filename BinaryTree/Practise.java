package BinaryTree;

import java.util.*;

public class Practise {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    // build a binary tree

    public static Node buildTree(int[] arr) {

        idx++;

        if (arr[idx] == -1) {
            return null;
        }

        Node root = new Node(arr[idx]);

        root.left = buildTree(arr);
        root.right = buildTree(arr);

        return root;
    }

    // preorder tree pahle root left phir right

    public void PreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    // inorder traversal
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // post order traversal

    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    // dusre tareeke se level order jisme hme answer me list send krni hoti

    public List<List<Integer>> Traverse(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                level.add(curr.data);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }

    // to calculate maxheight of binary tree

    public int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        int maxheight = Math.max(lh, rh) + 1;
        return maxheight;
    }


    // minimumheight of binary tree

    public int Minimum(Node root){
        if (root==null) {
            return 0;
        }

        if (root.left==null) {
            return Minimum(root.right)+1;
        }
        if (root.right==null) {
            return Minimum(root.left)+1;
        }
        return Math.min(Minimum(root.left), Minimum(root.right))+1;
    }


// count of Nodes

public int Count(Node root){
    if (root==null) {
        return 0;
    }
    int lc = Count(root.left);
        int rc = Count(root.right);
        int totalCount   = lc+rc+1;
        return totalCount;

}

// sum of  nodes

public int Sum(Node root){
    if (root==null) {
        return 0;
    }
    int leftsum = Sum(root.left);
    int rightsum = Sum(root.right);
    int totalsum = leftsum+rightsum+1;
    return totalsum;
}

// zigzag traversal


public List<List<Integer>>ZigZag(Node root){
    List<List<Integer>>ans = new ArrayList<>();
    if (root==null) {
        return ans;
    }
    Queue<Node>q = new LinkedList<>();
    q.add(root);
    int level = 0;
    while (!q.isEmpty()) {
        int size = q.size();
        //sublist 
        List<Integer>sublist = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Node currval = q.remove();
            sublist.add(currval.data);
            if (currval.left!=null) {
                q.add(currval.left);
            }if (currval.right!=null) {
                q.add(currval.right);
            }
        }
        if (level % 2 ==1) {
            Collections.reverse(sublist);
        }
        ans.add(sublist);
        level++;
    }
    return ans;
}



// diameter of binary tree

 static class Info {
    int dia;
    int ht;

    public Info(int dia, int ht) {
        this.dia = dia;
        this.ht = ht;
    }
}

public Info diameter(Node root) {
    if (root == null) {
        return new Info(0, 0);
    }

    Info leftInfo = diameter(root.left);
    Info rightInfo = diameter(root.right);

    int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

    int diameter = Math.max(
            Math.max(leftInfo.dia, rightInfo.dia),
            leftInfo.ht + rightInfo.ht + 1
    );

    return new Info(diameter, height);
}


// subtree exists in the tree

public boolean isIdentical(Node root,Node subtree){
    if (root==null && subtree==null) {
        return true;
    }else if (root==null || subtree==null) {
        return false;
    }
     
    if (root.data != subtree.data) {
        return false;
    }
    return isIdentical(root.left, subtree.left) && isIdentical(root.right, subtree.right); 
}




public boolean isSubtree(Node root,Node subtree){
    if (root==null) {
        return false;
    }
    if (root.data==subtree.data) {
        if (isIdentical(root,subtree)) {
            return true;
        }
    }
    return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
}


// TOP VIEW OF BINARY TREE

class Pair{
    Node node;
    int hd;
    Pair(Node node,int hd){
        this.node = node;
        this.hd = hd;
    }
}

public ArrayList<Integer> topView(Node root){
    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    TreeMap<Integer,Integer> map = new TreeMap<>();
    Queue<Pair>q = new LinkedList<>();
    q.add(new Pair(root, 0));
    while (!q.isEmpty()) {
        Pair curr = q.remove();
        Node node  = curr.node;
        int hd = curr.hd;
        if (!map.containsKey(hd)) {
            map.put(hd, node.data);
        }
        if (node.left!=null) {
            q.add(new Pair(node.left, hd-1));
        }
        if (node.right!=null) {
            q.add(new Pair(node.right,hd+1));
        }
    }
    for (int  value : map.values()) {
        ans.add(value);
    }
    return ans;
}

public static void main(String[] args) {



    // SubTree Of Another tree


    
        int[] arr = {
                1, 2, 4, -1, -1, 5, -1, -1,
                3, -1, 6, -1, -1
        };
        // agar tum print krana chahte ho to uske liye tumhe
        //
        // binrarytree bt = new binarytree()
        // Node root = bt.buildtree(nodes)

    
    }
}