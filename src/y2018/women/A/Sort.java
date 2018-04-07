package y2018.women.A;

public class Sort {

    private int[] distances;

    public Sort(){

    }

    public int calculate(int[] optimums){

        this.distances = new int[optimums.length];
        int mid = (optimums.length % 2 == 0)? optimums.length/2 -1 : (optimums.length-1)/2;
        for (int i = 0; i < optimums.length; i++) {
            if (i <= mid) {
                distances[i] = i;
            } else {
                distances[i] = optimums.length - i - 1;
            }
        }

        // sort arrays
        optimums = sort(optimums);
        distances = sort(distances);

        // calculate minimum possible error
        int sum = 0;
        for (int i = 0; i < optimums.length; i++){
            sum += (optimums[i] - distances[i]) * (optimums[i] - distances[i]);
//            System.out.print(distances[i] + " ");

        }

//        System.out.println();
        return sum;
    }

    // bubble sort
    private int[] sort(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - 1 - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
