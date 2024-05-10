import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Step_3 {
  public static void main(String[] args) throws Exception {
    float temp = 0;
    File IntList = new File(
        "texts\\ListFloat.txt");
    Scanner reader = new Scanner(IntList);
    Stack<Float> stack = new Stack<>();

    while (reader.hasNextFloat()) {
      stack.push(reader.nextFloat());
    }
    reader.close();
    int N = stack.size();
    Float[] arr = new Float[N];
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
    System.out.println("Sorted Array: ");
    System.out.println(Arrays.toString(arr));
  }

  public static void InsertionSortReversed(Float[] a) {
    int L = a.length;
    for (int i = L - 2; i >= 0; i--) {
      for (int j = i; j < L - 1 && less(a[j], a[j + 1]); j++)
        exch(a, j, j + 1);
    }
  }

  private static boolean less(Float v, Float w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Float[] a, int i, int j) {
    Float t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

}
