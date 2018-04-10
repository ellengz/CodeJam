package y2018.qualification.B;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i=1; i<=T; i++) {
            int N = in.nextInt();
            int[] odd = new int[(N%2==0)? (N/2):(N/2+1)];
            int[] even = new int[N/2];
            for (int j=0; j<N/2; j++) {
                odd[j] = in.nextInt();
                even[j] = in.nextInt();
            }
            if(N%2!=0){
                odd[N/2] = in.nextInt();
            }
            sort(odd);
            sort(even);
            int position = checkOrder(odd, even);
            System.out.println("Case #" + i + ": " + (position == -1? "OK" : position));
        }
        in.close();
    }

    /**
     * quick sort
     * O(N log N)
     * http://blog.51cto.com/flyingcat2013/1281614
     * @param arr
     */
    static void sort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }

    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high); // divide the array into two
            qsort(arr, low, pivot-1);      // recursion for the left child
            qsort(arr, pivot+1, high);      // recursion for the right child
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low<high){
            while (low<high && arr[high]>=pivot) --high;
            arr[low]=arr[high];             //exchange the record < pivot to the left
            while (low<high && arr[low]<=pivot) ++low;
            arr[high] = arr[low];           //exchange the record < pivot to the right
        }
        arr[low] = pivot;
        return low;
    }

    /**
     * Check if sorted correctly
     * @param odd
     * @param even
     * @return -1 if correct, or the position of first error
     */
    static int checkOrder(int[] odd, int[] even){
        int[] interleaved = new int[odd.length + even.length];
        for (int i=0; i<odd.length-1; i++){
            interleaved[2*i] = odd[i];
            interleaved[2*i + 1] = even[i];
        }
        if(odd.length > even.length){
            interleaved[2*even.length] = odd[odd.length-1];
        }

        for (int i=1; i<interleaved.length; i++){
            if(interleaved[i] < interleaved[i-1]){
                return i-1;
            }
        }
        return -1;
    }
}
