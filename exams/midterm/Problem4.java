/**
 * max heap... this is a fun one
 */
public class Problem4 {

    public static int[] kSmallest(int[] array, int k) {

        class MaxHeap {
            private int[] array;
        
            public MaxHeap(int[] array, int k) {
                this.array = new int[k];
                
                // copy first k numbers
                for(int i = 0; i < k; i++) {
                    this.array[i] = array[i];
                }
        
                // initial heapify
                for (int i = k / 2 - 1; i >= 0; i-= 1) {
                    heapify(i);
                }
            }
        
            public int[] getArray() {
                return array;
            }
        
            public int getMax() {
                return array[0];
            }
        
            public void replaceMax(int value) {
                array[0] = value;
                heapify(0);
            }
        
            private void heapify(int i) {
                if (i < array.length) {
                    int left = 2 * i + 1;
                    int right = 2 * i + 2;
                    int j = i;
                    
                    if (left < array.length && -array[left] < -array[j]) {
                        j = left;
                    }
                    
                    if (right < array.length && -array[right] < -array[j]) {
                        j = right;
                    }
        
                    if (j != i) {
                        int tmp = array[i];
                        array[i] = array[j];
                        array[j] = tmp;
                        heapify(j);
                    }
                }
            }
        
        }

        MaxHeap heap = new MaxHeap(array, k);
        for (int i = k; i < array.length; i++) {
            if (array[i] < heap.getMax()) {
                heap.replaceMax(array[i]);
            }
        }

        return heap.getArray();
    }

    public static void main(String[] args) {
        int array[] = { 4, 1, 5, 7, 2, 3, 1, 3};
        System.out.println(java.util.Arrays.toString(kSmallest(array, 4)));

    }

}