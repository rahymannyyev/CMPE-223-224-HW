import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Step_1 {
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
    System.out.println("Array: ");
    System.out.println(Arrays.toString(arr));
  }

}
