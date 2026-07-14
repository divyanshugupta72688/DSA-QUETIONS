package BITMANIPULATION;
import java.util.*;
class Prac {
// FINDOUT MISSING NUMBER FROM THE GIVEN ARRAY.
static int Missing(int[]nums){
    int n = nums.length;
    int sum = (n+(n+1))/2;
    int s2 = 0;
    for(int i  = 0;i<n;i++){
        s2 += nums[i];
    }
    return sum-s2;
}
// count 1 bits in given number
public int Single(int n){
    int count  = 0;
    while (n!=0) {
        n = n&n-1;
        count++;
    }
    return count;
}

// to CHECK NUMBER HAS ALTERNATE SINGLE BIT OR NOT.
public boolean Check(int n){
    int x = n^n>>1;
    return (x&(x+1))==0;
}
// to check given number is a power of two or not 
public boolean Power(int n){
    return (n>0)&&(n&n-1)==0;
}

// SINGLE NUMBER OR NOT 

public  int Single(int[]nums){
    int xor = 0;
    for (int i : nums) {
        xor = xor^nums[i];
    }
    return xor;
}

// SINGLE NUMBER(137)

public int SingleNumber(int[]nums){
    HashMap<Integer,Integer>map = new HashMap<>();
    for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0)+1);
    }
    for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        if (entry.getKey()==1) {
            return entry.getValue();
        }
    }
    return -1;
}
// RETURN AN ARRAY WHICH CONTAIN SINGLE NUMBER.
public int[] Third(int[]nums){
    HashMap<Integer,Integer>map = new HashMap<>();
    int n = nums.length;
    for (int i : nums) {
        map.put(i, map.getOrDefault(i, 0)+1);
    }
    int[] res = new int[n];
    int index = 0;
    for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        if (entry.getKey()==1) {
            res[index++] = entry.getValue();
        }
    }
    return res;
}
}