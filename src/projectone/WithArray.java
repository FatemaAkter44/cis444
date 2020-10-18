package projectone;

public class WithArray {


    public static void main(String[] args) {
            int[] array={3, 25, 33, 21, 55, 43, 78, 31, 33, 75, 43, 11, 36, 4, 10, 99};
            System.out.println("median is : "+findMedian(array,array.length));
            System.out.println("mode is : "+mode(array,array.length));
            System.out.println("array after sort is : ");
            for(int i=0; i < array.length; i++){
                System.out.print(array[i] + " ");
            }
    }

    static double findMedian(int[] a, int n) {
// First we sort the array
            bubbleSort(a);

// check for even case
            if (n % 2 != 0)
                return (double)a[n / 2];

            return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }


    static int mode(int[] a,int n) {
            int maxValue = 0, maxCount = 0, i, j;

            for (i = 0; i < n; ++i) {
                int count = 0;
                for (j = 0; j < n; ++j) {
                    if (a[j] == a[i])
                        ++count;
                }

                if (count > maxCount) {
                    maxCount = count;
                    maxValue = a[i];
                }
            }
            return maxValue;
    }

    static void bubbleSort(int[] arr) {
            int n = arr.length;
            int temp = 0;
            for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                    if(arr[j-1] > arr[j]){
//swap elements
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }

                }
            }
    }
}

