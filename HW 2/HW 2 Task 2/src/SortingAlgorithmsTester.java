public class SortingAlgorithmsTester extends SortingAlgorithms {
    /*
     * Title: My Sorting Algorithms tester class
     * Author: Rahymberdi/Annyyev
     * ID: ***
     * Section: ***
     * Assignment: ***
     * Description: This Class contains main method that tests the sorting methods
     */
    public static void main(String[] args) throws Exception {
        /*
         * Methods that can be used:
         * sort1()
         * sort2()
         * sort3()
         * sort4()
         * sort5()
         */
        for (int p = 1000; p < 100000000; p = p + 1000) {
            /*
             * This for loop iterates throgh each 2^k number and sets sizes for array
             * accordingly
             */
            long starting, ending;
            int size = p; // Convinient manipulations of sizes
            int barrier = size - 1;
            int ascending = 0;

            System.out.println("Size of the array is " + size);

            int[] arr = new int[size];

            /* i) Ascending order */

            for (int i = ascending; i < size; i++)
                arr[i] = i;

            starting = System.currentTimeMillis();
            sort5(arr, 1); /* Can be changed */
            ending = System.currentTimeMillis();

            System.out.println("Total time for ascending array: " + (ending - starting));

            /***************************************************************************/

            /* ii) Descending order */

            for (int i = barrier; i > 0; i--)
                arr[i] = i;

            starting = System.currentTimeMillis();
            sort5(arr, 1); /* Can be changed */
            ending = System.currentTimeMillis();

            System.out.println("Total time for descending array: " + (ending - starting));

            /***************************************************************************/

            /* iii) Random order */

            for (int i = ascending; i < size; i++)
                arr[i] = i;

            for (int i = barrier; i > 0; i--) {
                int k = (int) (Math.random() * size); // Randomize the content in the array
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
            starting = System.currentTimeMillis();
            sort5(arr, 1); /* Can be changed */
            ending = System.currentTimeMillis();

            System.out.println("Total time for random array: " + (ending - starting));

        }
    }
}
