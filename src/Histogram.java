/**
 * Create a Histogram object based on an integer array.
 *
 * Initial design:  Stan Thomas,  February 2021
 *
 * Name: Emily Yang
 * Date: February 23, 2021
 *
 */

public class Histogram {

    // class members
    private int[] data;  // data to be graphed
    private final int PAGEWIDTH = 100;  // maximum row size

    // constructor
    public Histogram(int[] data){
        this.data = data;
    }

    // Find largest int value for scaling row size
    private int findMax(){
        int max = data[0];

        // compare each int value in data to max
        // and replace max if the value is larger
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        return max;
    }

    // print the histogram
    public void print(){
        int unitsPerMark = findMax() / PAGEWIDTH;

        //print the information for data[index]
        for (char index = 'a'; index <= 'z'; index++) {

            // convert char into int to find corresponding elements in data
            int i = Character.getNumericValue(index);
            System.out.printf("%4c (%7d) ", index, data[i]);

            // print the * that represent the number of characters for data[index]
            for (int j = 0; j < data[i]; j = j + unitsPerMark) {
                System.out.print("*");
            }

            System.out.println("");
        }
    }
}