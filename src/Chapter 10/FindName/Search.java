package FindName;

public class Search {
    
    /*
     * Retruns the index of numToFind
     * -1 returned if element isn't found
     * pre: none
     * post: index is returned
     */

     public static int linear(int[] array, int numToFind) {
        int index = 0;

        while (array[index] != numToFind && index < array.length) {
            index += 1;
        }

        if (array[index] == numToFind) {
            return(index);
        } else {
            return(-1);
        }
     } 

    public static int linear(String[] array, String stringToFind) {
        int index = 0;

        while (!(array[index].equalsIgnoreCase(stringToFind)) && index < array.length) {
            index += 1;
        }

        if (array[index].equals(stringToFind)) {
            return(index);
        } else {
            return(-1);
        }
    }

}
