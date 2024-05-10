import java.io.File;
import java.util.Scanner;

/*This Class acts as a user-interface through which you can assign texts files and run the missions*/

public class TestClass {

  public static int k;

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the Load Package Managment System!");
    System.out.println("Rules of usage: ");
    System.out.println("1. When the program asks for the path to the File, write down the Absolute Path.");
    System.out.println("2. Files should not be null.");
    System.out.println(
        "3. In Mission File, last values of integers should not go out of boundry of the FlowDevice Train (i.e. the Package Loader List)");

    System.out.println("Would you like to write your own paths or want to use defaults one?");
    System.out.println("Write 0 for default, 1 for your own paths");
    k = keyboard.nextInt();

    if (k == 1) {
      System.out.println("Write down the path to Destination.txt");
      String destinationpath = keyboard.next();
      System.out.println("Write down the path to Loads.txt");
      String loadspath = keyboard.next();
      System.out.println("Write down the path to FlowDevices.txt");
      String flowdevicespath = keyboard.next();
      System.out.println("Write down the path to Mission.txt");
      String missionpath = keyboard.next();

      MainClass.dest = new File(destinationpath);
      MainClass.load = new File(loadspath);
      MainClass.flow = new File(flowdevicespath);
      MainClass.miss = new File(missionpath);
    }

    keyboard.close();

    MainClass.MainRunner();
  }
}
