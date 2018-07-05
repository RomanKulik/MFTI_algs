import java.util.*;

public class Sorts_O_ot_N {
    /**
     * This class contains sorts O(N) and its tests
     * <p>
     * count_sort - сортировка подсчетом - однопроходный алгоритм
     */

    public static void main(String[] args) {
        sort_test();
    }

    public static void sort_test() {
        int[] arr = new int[]{0, 1000, 1, 4, 7, 0, 2, 5, 9, 8, 6, 3, 2, 5, 0, 6, 6, 4, 3, 100, 555, 1000, 554, 8, 20, 6, 7, 4, 50, 2, 11, 0, 3, 1, 9, 8, 11, 20};
        int[] arr_test = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr_test);

        int[] test_insert_sort = count_sort(arr);
        System.out.println(Arrays.equals(arr_test, test_insert_sort) ? "count_sort - ok" : "count_sort - fail");
        System.out.println("arr_test:\t\t\t" + Arrays.toString(arr_test));
        System.out.println("test_count_sort:\t" + Arrays.toString(test_insert_sort));
        System.out.println();
    }

    public static int[] count_sort(int[] array) {
        int biggestNumberAtArray = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > biggestNumberAtArray) {
                biggestNumberAtArray = array[i];
            }
        }

        int[] arr = Arrays.copyOf(array, array.length);
        int[] indexes = new int[++biggestNumberAtArray];

        for (int i = 0; i < array.length; i++) {
            indexes[arr[i]]++;
        }
        System.out.println(Arrays.toString(indexes));

        for (int i = 0, count = 0; i < indexes.length; i++) {
            int elements = indexes[i];
            if (elements == 0)
                continue;
            for (int j = 0; j < elements; j++) {
                arr[count] = i;
                count++;
            }
        }

        return arr;
    }
}
