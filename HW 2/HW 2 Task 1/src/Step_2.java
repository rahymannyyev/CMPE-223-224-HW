import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Integer;

public class Step_2 {
    public static void main(String[] args) throws Exception {
        int temp = 0;
        File IntList = new File("texts\\List.txt");
        Scanner reader = new Scanner(IntList);
        Stack<Integer> stack = new Stack<>();

        while (reader.hasNextInt()) {
            stack.push(reader.nextInt());
        }
        reader.close();
        int N = stack.size();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = stack.pop();
        }
        for (int k = 0; k < N; k++) {
            temp = arr[k];
            int s = (int) (Math.random() * N);
            arr[k] = arr[s];
            arr[s] = temp;
        }
        System.out.println("Initial Array: ");
        System.out.println(Arrays.toString(arr));

        InsertionSortReversed(arr);
        System.out.println("Sorted Array": );
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertionSortReversed(Integer[] a) {
        int L = a.length;
        /*
         * In the for loop, we changed the way comparisons are executed. For example,
         * instead of starting at the beginning, we start at the end, and we insert in
         * reverse order.
         */
        for (int i = L - 2; i >= 0; i--) {
            for (int j = i; j < L - 1 && less(a[j], a[j + 1]); j++)
                exch(a, j, j + 1);
        }
    }

    private static boolean less(Integer v, Integer w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Integer[] a, int i, int j) {
        Integer t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
