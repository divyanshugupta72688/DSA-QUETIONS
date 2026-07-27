import java.util.*;

public class Classroom {

    static ArrayList<Integer> arr = new ArrayList<>();

    // Add element in Min Heap
    public static void add(int data) {
        arr.add(data);

        int x = arr.size() - 1;   // Child index
        int par = (x - 1) / 2;    // Parent index

        while (x > 0 && arr.get(x) < arr.get(par)) {

            // Swap
            int temp = arr.get(x);
            arr.set(x, arr.get(par));
            arr.set(par, temp);

            // Move upward
            x = par;
            par = (x - 1) / 2;
        }
    }

    // Peek (Minimum element)
    public static int peek() {
        return arr.get(0);
    }

    // Heapify
    public static void heapify(int i) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int minIndex = i;

        if (left < arr.size() && arr.get(left) < arr.get(minIndex)) {
            minIndex = left;
        }

        if (right < arr.size() && arr.get(right) < arr.get(minIndex)) {
            minIndex = right;
        }

        if (minIndex != i) {

            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);

            heapify(minIndex);
        }
    }

    // Remove minimum element
    public static int remove() {

        int data = arr.get(0);

        // Step 1 : Swap first and last element
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, temp);

        // Step 2 : Remove last element
        arr.remove(arr.size() - 1);

        // Step 3 : Heapify
        if (!arr.isEmpty()) {
            heapify(0);
        }

        return data;
    }

    public static void main(String[] args) {

        add(3);
        add(4);
        add(2);
        add(5);
        add(1);

        System.out.println("Heap = " + arr);

        System.out.println("Peek = " + peek());

        System.out.println("Removed = " + remove());

        System.out.println("Heap after remove = " + arr);
    }
}            