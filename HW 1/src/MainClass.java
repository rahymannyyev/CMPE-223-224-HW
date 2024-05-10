import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Title: My Main Class
 * Author: Rahymberdi Annyyev
 * ID: ***
 * Section: ***
 * Assignment: ***
 * Description: This Class contains all methods that creates bulk of the code itself
 */

public class MainClass {

        public static LinkedList<String> DestinationList = new LinkedList<>();
        public static LinkedList<String> FlowDevicesList = new LinkedList<>();
        public static LinkedList<String> LoadsList = new LinkedList<>();
        public static LinkedList<String> MissionList = new LinkedList<>();
        public static LinkedList<String> FirstList = new LinkedList<>();
        public static LinkedList<String> MiddleList = new LinkedList<>();
        public static LinkedList<String> FinalList = new LinkedList<>();
        public static int FinalInitialSize;
        public static LinkedList<Integer> ArrayOfLastInts = new LinkedList<>();
        public static int SizeofFirstBeforeT;
        public static int SizeofMiddleBeforeT;
        public static int SizeofFinalBeforeT;
        public static File dest;
        public static File flow;
        public static File load;
        public static File miss;

        public static void main(String[] args) throws IOException {

                /*
                 * We read the Default Case if the user does not want to write new adresses for
                 * other txt files
                 */
                if (TestClass.k == 0) {

                        dest = new File("texts\\destinations.txt");
                        flow = new File("texts\\flowdevices.txt");
                        load = new File("texts\\loads.txt");
                        miss = new File("texts\\missions.txt");
                }
                /*
                 * Then we create Scanners that will allow us to access the Files and their
                 * elements
                 */
                Scanner DestKey = new Scanner(dest);
                Scanner FlowKey = new Scanner(flow);
                Scanner LoadKey = new Scanner(load);
                Scanner MissKey = new Scanner(miss);
                /* We Clear the Mission.txt from '-' and ',' characters */
                String MissString = MissKey.nextLine();
                MissString = MissString.replace('-', ' ');
                MissString = MissString.replace(',', ' ');
                Scanner MissStringKey = new Scanner(MissString);
                /* We create the List of Initial Destinations */
                CreateDestList(DestKey);
                System.out.println("Initial List of Destinations: ");
                System.out.println(DestinationList.toString());
                /* We create the List of Initial FlowDevices */
                CreateFlowList(FlowKey);
                System.out.println("Initial List of Flow Devices: ");
                System.out.println(FlowDevicesList.toString());
                /* We create the List of Initial Load Packages */
                CreateLoadList(LoadKey);
                System.out.println("Initial List of Load Packages: ");
                System.out.println(LoadsList.toString());
                /* We create the List of Initial Missions */
                CreateMissList(MissStringKey);
                System.out.println("Mission List: ");
                System.out.println(MissionList.toString());
                System.out.println("");

                /*
                 * We iterate through the MissionList, and we Assign each element either to
                 * FirstCity, Second city and etc.
                 * After we start to assign the amount of the load packages to the "Train" (i.e.
                 * the FlowDevice of The FirstCity)
                 */
                for (int i = 0; i < MissionList.size(); i++) {
                        if (i == 0) {
                                CreateFirst(MissionList.get(i));
                        }
                        if (i == 1) {
                                CreateMiddle(MissionList.get(i));
                        }

                        if (i == 2) {
                                CreateFinal(MissionList.get(i));
                        }

                        if (i == 3) {
                                int k = Integer.parseInt(MissionList.get(i));
                                TakeoutFirst(k);
                        }

                        if (i == 4) {
                                int k = Integer.parseInt(MissionList.get(i));
                                TakeoutMiddle(k);
                        }

                        if (i > 4) {
                                int k = Integer.parseInt(MissionList.get(i));
                                ArrayOfLastInts.add(k);
                        }

                }
                /* We get out the elements from the Train for our SecondCity */
                LastReshuffle(ArrayOfLastInts);
                /*
                 * We fixate the sizes of each of the Lists before pushing the Flowdevices into
                 * each of the Lists
                 */
                SizeofFirstBeforeT = FirstList.size();
                SizeofMiddleBeforeT = MiddleList.size();
                SizeofFinalBeforeT = FinalList.size();
                /* We add FlowDevices into Respective Lists */
                TAdditionFirst(FirstList);
                TAdditionMiddle(MiddleList);
                /* We print each of the Lists at the End */
                FirstToString(FirstList);
                MiddleToString(MiddleList);
                FinalToString(FinalList);
                /* We close each Scanner */
                DestKey.close();
                LoadKey.close();
                FlowKey.close();
                MissKey.close();

                /* The End. */

        }

        public static void CreateDestList(Scanner x) {
                /* Create the List of the Destinations */
                while (x.hasNext())
                        DestinationList.add(x.next());
        }

        public static void CreateFlowList(Scanner x) {
                /* Create the List of the FlowDevices */
                while (x.hasNext())
                        FlowDevicesList.add(x.next());
        }

        public static void CreateLoadList(Scanner x) {
                /* Create the List of the Load Packages */

                while (x.hasNext())
                        LoadsList.add(x.next());
        }

        public static void CreateMissList(Scanner x) {
                /* Create the List of the Missions */

                while (x.hasNext())
                        MissionList.add(x.next());
        }

        public static void CreateFirst(String x) {
                /*
                 * This method created the FirstCity List
                 * In the first for Loop it gets the name of the First City
                 */
                for (int a = 0; a < DestinationList.size(); a++) {
                        if (DestinationList.get(a).equals(x)) {
                                FirstList.add(DestinationList.get(a));
                                break;
                        }
                }
                /*
                 * In the second for loop it adds all the designated package loads to the First
                 * City
                 */
                for (int a = LoadsList.size() - 1; a >= 0; a--) {
                        if (LoadsList.get(a).equals(x)) {
                                FirstList.add(LoadsList.get(a - 1));
                        }
                }
        }

        public static void CreateMiddle(String x) {
                /*
                 * This method created the MiddleCity List
                 * In the first for Loop it gets the name of the Middle City
                 */
                for (int a = 0; a < DestinationList.size(); a++) {
                        if (DestinationList.get(a).equals(x)) {
                                MiddleList.add(DestinationList.get(a));
                                break;
                        }
                }
                /*
                 * In the second for loop it adds all the designated package loads to the Middle
                 * City
                 */
                for (int a = LoadsList.size() - 1; a >= 0; a--) {
                        if (LoadsList.get(a).equals(x)) {
                                MiddleList.add(LoadsList.get(a - 1));
                        }
                }
        }

        public static void CreateFinal(String x) {
                /*
                 * This method created the FinalCity List
                 * In the first for Loop it gets the name of the Final City
                 */
                for (int a = 0; a < DestinationList.size(); a++) {
                        if (DestinationList.get(a).equals(x)) {
                                FinalList.add(DestinationList.get(a));
                                break;
                        }
                }

                for (int a = LoadsList.size() - 1; a >= 0; a--) {
                        /*
                         * In the second for loop it adds all the designated package loads to the Final
                         * City
                         */
                        if (LoadsList.get(a).equals(x)) {
                                FinalList.add(LoadsList.get(a - 1));
                        }
                }
                /*
                 * Initializes the size of the Final List, before dropping load packages from
                 * the FlowDevice. It will come in handy, when we will track it's own packages
                 * and the other ones
                 */
                FinalInitialSize = FinalList.size();
        }

        public static void TakeoutFirst(int k) {
                /* This method deals with load packages which were determined to be taken out */
                /* Copies the load packages from the FirstCity List k times */
                for (int s = 1; s <= k; s++) {
                        String Temp = FirstList.get(s);
                        FinalList.add(Temp);
                }
                /*
                 * Deletes the load packages from the FirstCity List that were copied in the
                 * first loop
                 */
                for (int s = 1; s <= k; s++) {
                        FirstList.remove(1);

                }
        }

        public static void TakeoutMiddle(int k) {
                /* This method deals with load packages which were determined to be taken out */
                /* Copies the load packages from the MiddleCity List k times */
                for (int s = 1; s <= k; s++) {
                        String Temp = MiddleList.get(s);
                        FinalList.add(Temp);
                }
                /*
                 * Deletes the load packages from the MiddleCity List that were copied in the
                 * first loop
                 */
                for (int s = 1; s <= k; s++) {
                        MiddleList.remove(1);

                }
        }

        public static void LastReshuffle(LinkedList<Integer> x) {

                /*
                 * This Method at the end takes out the load packages from the FinalCity List
                 * and assigns them to the MiddleCity List according to last integers at the
                 * mission.txt
                 */
                /* The first loop copies these packages to MiddleCity List */
                int z = 0;
                LinkedList<String> TemporaryList = new LinkedList<>();
                for (int i = 0; i < x.size(); i++) {
                        MiddleList.add(FinalList.get(x.get(z) + FinalInitialSize));
                        TemporaryList.add(FinalList.get(x.get(z) + FinalInitialSize));
                        z++;
                }
                /* The second loop deletes these packages from FinalCityList */
                for (int p = 0; p < FinalList.size(); p++) {
                        for (int y = 0; y < TemporaryList.size(); y++) {
                                if (TemporaryList.get(y).equals(FinalList.get(p))) {
                                        FinalList.remove(p);
                                }
                        }
                }
        }

        public static void TAdditionFirst(LinkedList<String> x) {
                /*
                 * This method adds FlowDevices to the FirstCity, but checks the first
                 * flowdevice that should be assigned to the FinalCityList
                 */
                int check = 0;
                for (int q = 1; q < FlowDevicesList.size(); q++) {

                        if ((x.get(0).equals(FlowDevicesList.get(q))) && check > 0) {
                                FirstList.add(FlowDevicesList.get(q - 1));
                        }

                        else if (x.get(0).equals(FlowDevicesList.get(q))) {
                                FinalList.add(FlowDevicesList.get(q - 1));
                                check++;
                        }

                }
        }

        public static void TAdditionMiddle(LinkedList<String> x) {
                /*
                 * This method adds FlowDevices to the MiddleCity
                 */
                for (int q = 1; q < FlowDevicesList.size(); q++) {
                        if (x.get(0).equals(FlowDevicesList.get(q))) {
                                MiddleList.add(FlowDevicesList.get(q - 1));
                        }

                }
        }

        /*
         * Next 3 Methods prints the results of the Mission by Listing:
         * 1. First City
         * 2. Middle City
         * 3. Final City
         */

        public static void FirstToString(LinkedList<String> x) {
                for (int i = 0; i < x.size(); i++) {
                        if (i == 0) {
                                System.out.println("City: ");
                                System.out.println(x.get(i));
                                System.out.println("Loads: ");
                        }
                        if (i > 0 && i < SizeofFirstBeforeT) {
                                System.out.println(x.get(i));
                        }

                        if (i >= SizeofFirstBeforeT) {
                                System.out.println("FlowDevices: ");
                                System.out.println(x.get(i));
                        }
                }
                System.out.println("---------------------------------");
        }

        public static void MiddleToString(LinkedList<String> x) {
                for (int i = 0; i < x.size(); i++) {
                        if (i == 0) {
                                System.out.println("City: ");
                                System.out.println(x.get(i));
                                System.out.println("Loads: ");
                        }
                        if (i > 0 && i < SizeofMiddleBeforeT) {
                                System.out.println(x.get(i));
                        }
                        if (i == SizeofMiddleBeforeT) {
                                System.out.println("FlowDevices: ");
                        }
                        if (i >= SizeofMiddleBeforeT) {

                                System.out.println(x.get(i));
                        }
                }
                System.out.println("---------------------------------");
        }

        public static void FinalToString(LinkedList<String> x) {
                for (int i = 0; i < x.size(); i++) {
                        if (i == 0) {
                                System.out.println("City: ");
                                System.out.println(x.get(i));
                                System.out.println("Loads: ");
                        }
                        if (i > 0 && i < SizeofFinalBeforeT) {
                                System.out.println(x.get(i));
                        }
                        if (i == SizeofFinalBeforeT) {
                                System.out.println("FlowDevices: ");
                        }
                        if (i >= SizeofFinalBeforeT) {

                                System.out.println(x.get(i));
                        }
                }

                System.out.println("---------------------------------");
        }

        static void MainRunner() {
                /* This method allows for the TestClass to run main() method of MainClass */
                try {
                        MainClass.main(null);
                } catch (IOException e) {

                        e.printStackTrace();
                }
        }

}
