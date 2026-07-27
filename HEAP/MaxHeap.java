import java.util.*;
public class MaxHeap {
    
    // add function for maxheap
ArrayList<Integer>res  = new ArrayList<>();
    public void add(int data){
        res.add(data);
        int x = res.size()-1;
        int par = (x-1)/2;
        while (x>0 && res.get(x)>res.get(par)) {
            int temp = res.get(x);
            res.set(x,res.get(par) );
            res.set(par, temp);
            x = par;
            par =(x-1)/2;
        }
    }

    public int peek(){
        return res.get(0);
    }


    // heapify function 

    public void heapify(int i){
        int left = i*2+1;
        int right = i*2+2;
        int maxIdx = i;
        if (left<res.size() && res.get(left)>res.get(maxIdx)) {
            maxIdx = left;
        }
         if (right<res.size() && res.get(right)>res.get(maxIdx)) {
            maxIdx = right;
        }
        if (maxIdx!=i) {
            // swap

            int temp = res.get(i);
            res.set(i, res.get(maxIdx));
            res.set(maxIdx, temp);
            heapify(maxIdx);
        }
    }
    // remove function

    public int remove(){
        int data = res.get(0);

        // first step last index aur first index ko aapas me swap kr denge 

        int temp = res.get(0);
        res.set(0, res.get(res.size()-1));
        res.set(res.size()-1, temp);

        // second step last index ko remove kr denge 

        res.remove(res.size()-1);


        // if list empty nahi hai to will call heapify
        if (!res.isEmpty()) {
            heapify(0);
        }
        return data;

    }
}
