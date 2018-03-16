package women2018.C;

import java.io.*;
import java.util.Scanner;

public class Main {

    static String readpath = "./ins/C-small-practice.in";
    static String outpath = "./outs/C-small-output.txt";

    public static void main(String[] args) throws IOException{

        // read file
        Scanner in = new Scanner(new FileReader(readpath));
        // prepare output
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));

        // get total number of cases
        int T = in.nextInt();

        // handle each case
        for(int i=0; i<T; i++) {
            // get length of name
            int L = in.nextInt();
            // get each candidate
            String c1 = in.next();
            String c2 = in.next();
            String c3 = in.next();

            //
        }
    }
}
