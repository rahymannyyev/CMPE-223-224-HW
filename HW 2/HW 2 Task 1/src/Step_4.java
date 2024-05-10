import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Step_4 {

  private static Integer[] aux;

  public static void main(String[] args) throws Exception {
    int temp = 0;
    File IntList = new File(
        "texts\\List.txt");
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

    sort(arr);
    System.out.println("Sorted Array: ");
    System.out.println(Arrays.toString(arr));
  }

  public static void merge(Integer[] a, int lo, int mid, int hi) {

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (less(aux[j], aux[i]))
        /*
         * We reversed the positions of less() variables, so that during the partition,
         * we sort in reverse order
         */
        a[k] = aux[i++];
      else
        a[k] = aux[j++];
    }
  }

  public static void sort(Integer[] a) {
    aux = new Integer[a.length];
    sort(a, 0, a.length - 1);
  }

  private static void sort(Integer[] a, int lo, int hi) {
    if (hi <= lo)
      return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);

    merge(a, lo, mid, hi);
  }

  private static boolean less(Integer v, Integer w) {
    return v.compareTo(w) < 0;
  }

}
