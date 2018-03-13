/**
 * This class provides a convenient way to test shuffling methods.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuffler 
{
    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static int[] perfectShuffle(int[] values) 
    {
        int[] shuffled = new int[values.length];
        int e = 0;
        int o = values.length/2;
        for(int k = 0; e < values.length / 2; k = k + 2){
            shuffled[k] = values[e];
            e++;
        }
        for(int k = 1; o < values.length; k = k + 2){
            shuffled[k] = values[o];
            o++;
        }
        return shuffled;
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm begins by exchanging the last element
     * in the array with randomly selected element preceeding it, and then 
     * exchanging the second-to-the-last element with another randomly 
     * selected element preceeding it.  The selection thus continues from 
     * the back to the front with random elements selected from those 
     * preceeding it.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) 
    {
        for(int k = values.length - 1; k > 0; k--){
            int r = (int)(Math.random() * k);
            int temp = values[k];
            values[k] = values[r];
            values[r] = temp;
        } 
    }
}
