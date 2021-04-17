import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    static int op1;
    static int op2;
    static int op3;

    public static void barRec1(List<Integer> array, int start, int end) {
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                op1 += 1;
                array.set(i, array.get(i) + 1);
            }

            barRec1(array, start+1, end-1);
        }
    }

    public static void barRec2(List<Integer> array) {
        for (int start = 0; start <= array.size() / 2; start++) {
            int end = (array.size() - 1) - start;
            for (int i = start; i <= end; i++) {
                op2 += 1;
                array.set(i, array.get(i) + 1);
            }
        }
    }

    public static void barRec3(List<Integer> array) {
        int start = 0;
        int end = array.size() - 1;
        int mid = (start + end) / 2;
        for (int i = 0; i < array.size(); i++ ) {
            op3 += 1;
            int incr = (i <= mid) ? i + 1 : (end - start - i + 1);
            array.set(i, array.get(i) + incr);
        }
    }

    public static void main(String[] args) {
        int N = 10;

        /*List<Integer> arr1 = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            arr1.add(i+1);
        }

        List<Integer> arr2 = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            arr2.add(i+1);
        }

        List<Integer> arr3 = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            arr3.add(i+1);
        }*/

        var arr1 = Arrays.asList(5,4,7,1,3);
        var arr2 = Arrays.asList(5,4,7,1,3);
        var arr3 = Arrays.asList(5,4,7,1,3);
        
        op1 = 0;
        barRec1(arr1, 0, arr1.size()-1);
        System.out.println(op1);
        //System.out.println(N*N/op1);
        //System.out.println(N*Math.log(N)/op1);
        System.out.println(Arrays.toString(arr1.toArray()));

        op2 = 0;
        barRec2(arr2);
        System.out.println(op2);
        System.out.println(Arrays.toString(arr2.toArray()));

        op3 = 0;
        barRec3(arr3);
        System.out.println(op3);
        System.out.println(Arrays.toString(arr3.toArray()));
    }
}