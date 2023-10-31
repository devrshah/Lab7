import java.util.List;
import java.util.Random;

public interface IShuffleList<T> extends List<T> {
    
    /**
     * Swaps random positions in the list specified number of times.
     * @param swaps the number of times positions should be swapped.
     * @pre swaps > 0
     * @post list elements have been shuffled swaps times.
     */
    default void shuffle(int swaps) {
        Random rand = new Random();
        for (int i = 0; i < swaps; i++) {
            int pos1 = rand.nextInt(size());
            int pos2 = rand.nextInt(size());
            while (pos1 == pos2) {
                pos2 = rand.nextInt(size());
            }
            swap(pos1, pos2);
        }
    }

    /**
     * Exchanges the values at positions i and j in the list.
     * @param i the index of the first element to be swapped.
     * @param j the index of the second element to be swapped.
     * @pre 0 <= i, j < size() and i != j
     * @post The elements at positions i and j have been swapped.
     */
    default void swap(int i, int j) {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
}


