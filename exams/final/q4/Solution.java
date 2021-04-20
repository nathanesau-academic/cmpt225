import java.util.Arrays;

public class Solution {
    public static Integer partition(int[] arr, int l, int r) {
        int x = arr[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (arr[j] <= x) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i += 1;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }

    // return pivot = kthSmallest, move values less than pivot before pivot
    public static Integer quickselect(int[] arr, int k, int l, int r) {
        if (k > 0 && k <= r - l + 1) {
            int p = partition(arr, l, r);
            if (p - l == k - 1)
                return arr[p];
            else if (p - l > k - 1)
                return quickselect(arr, k, l, p - 1);
            else
                return quickselect(arr, k-p+l-1, p+1, r);
        }
        return -1;
    }

    // sort values between l and r
    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quicksort(arr, l, p - 1);
            quicksort(arr, p + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,2,8,12,4};
        int k = 4;
        int kthSmallest = quickselect(arr, k, 0, arr.length - 1);
        quicksort(arr, 0, k);
        System.out.println(kthSmallest);
        System.out.println(Arrays.toString(arr));
    }
}
