package y2018.women.A;

public class Permute {

    public int min;

    public Permute(){
        min = -1;
    }

    public int perm(int[] optimums, int begin){

        if (begin == optimums.length){
//            for(int i = 0; i < optimums.length; i++) {
//                System.out.print(optimums[i] + " ");
//            }
//            System.out.println();
            int sum = 0;
            int mid = (optimums.length % 2 == 0)? optimums.length/2 -1 : (optimums.length-1)/2;
            for (int i = 0; i < optimums.length; i++) {
                if (i <= mid) {
                    sum += (optimums[i] - i) * (optimums[i] - i);
                } else {
                    sum += (optimums[i] - (optimums.length - 1 - i)) * (optimums[i] - (optimums.length - 1 - i));
                }
            }

            // find minimum sum
            min = (min < 0 || sum < min)? sum : min;

            return 1;
        }

        int count = 0;
        for (int i = begin; i < optimums.length; i++) {
            if (isSwap(optimums, begin, i)){
                swap(optimums, begin, i);
                count += perm(optimums, begin + 1);
                swap(optimums, begin, i);
            }
        }
        return count;
    }

    private void swap(int[] a, int begin, int end) {
        int temp = a[begin];
        a[begin] = a[end];
        a[end] = temp;
    }

    private boolean isSwap(int[] a,int begin,int end){
        for (int i = end; i > begin; i--){
            if (a[end] == a[i-1]){
                return false;
            }
        }
        return true;
    }

}
