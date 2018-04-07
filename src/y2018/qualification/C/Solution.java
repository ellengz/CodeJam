package y2018.qualification.C;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main (String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int A = in.nextInt();
            int[][] grid;
            grid = new int[5][4];

            int[] center= {2,2,3,2,4,2,2,3,3,3,4,3,10};
            System.out.println(2 + " " + 2);
            int I = in.nextInt();
            int J = in.nextInt();
            prepare(in, I, J, grid, center, 0);
        }
    }

    public static void prepare(Scanner in, int I, int J, int[][] grid, int[] center, int count) {

        grid[I-1][J-1] = 1;
        if (checkFull(center[count], center[count+1], grid)){
            // full, move to the next center
            count += 2;
        }
        if(count > center[center.length-1]){
            return;
        }else{
            System.out.println(center[count] + " " + center[count+1]);
            I = in.nextInt();
            J = in.nextInt();
            if (I==0 && J==0 || I==-1 && J==-1){
                return;
            }else{
                prepare(in, I, J, grid, center, count);
            }
        }
    }

    public static boolean checkFull(int I, int J, int[][] grid){
        int count = 0;
        for(int i= -1; i<=1; i++){
            for(int j= -1; j<=1; j++){
                count += grid[I-1+i][J-1+j];
            }
        }
        return count==9;
    }

}
