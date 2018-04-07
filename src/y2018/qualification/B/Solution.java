package y2018.qualification.B;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i=1; i<=T; i++){
            int N = in.nextInt();
            int[] list = new int[N];
            for (int j=0; j<N; j++){
                list[j] = in.nextInt();
            }
            list = troubleSort(list);
            int bad = -1;
            int j = 0;
            while(j < list.length-1){
                if (list[j] > list[j+1]){
                    bad = j;
                    break;
                }else{
                    j++;
                }
            }
            System.out.println("Case #" + i + ": " + (bad == -1? "OK" : bad));
        }

    }

    static int[] troubleSort(int[] list){

        Boolean flag = false;
        while(!flag){
            flag = true;
            for (int i=0; i<list.length-2; i++){
                if(list[i] > list[i+2]){
                    flag = false;
                    int temp = list[i];
                    list[i] = list[i+2];
                    list[i+2] = temp;
                }
            }
        }
        return list;
    }
}
