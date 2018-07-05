import java.util.Arrays;

/**
 * This class contains N(O^2) or (N*(N-1))/2 sorts and its tests:
 * https://www.youtube.com/watch?v=NLq7nB9bV0M&list=PLRDzFCPr95fK7tr47883DFUbm4GeOjjc0&index=11
 * <p>
 * insert_sort(сортировка вставками) - the first position is sorted yet.
 * Iterator goes from right to left
 * If NEXT element is greater than PREVIOUS element, elements are replaced.
 * <p>
 * choice_sort (сортировка выбора) - the first position is for min number in unsorted array
 * Iterator goes from left to right
 * If the FIRST element is greater than every next element, elements are replaced.
 * When iteraror will come to the last element (N-1), the first element will be sorted.
 * Next iteration begin from the second element to (N-1)
 * <p>
 * bubble_sort (сортировка методом пузырька) - the biggest number became in the rightist position
 * Iterator goes from left to right
 * Every iterartion starts from 0 to ((N-1) - iterator)
 * If PREVIOUS element is greater than the NEXT element, elements are replaced
 */
public class Sorts_O2 {

    public static void main(String[] args) {
        sort_test();
    }

    public static void sort_test() {
        int[] arr = new int[]{1, 4, 7, 2, 7, 5, 9, 8, 6, 3};
        int[] arr_test = new int[]{1, 2, 3, 4, 5, 6, 7, 7, 8, 9};

        int[] test_insert_sort = insert_sort(arr);
        System.out.println(Arrays.equals(arr_test, test_insert_sort) ? "insert_sort - ok" : "insert_sort - fail");
        System.out.println("arr_test:\t\t\t" + Arrays.toString(arr_test));
        System.out.println("test_insert_sort:\t" + Arrays.toString(test_insert_sort));
        System.out.println();

        int[] test_choice_sort = choice_sort(arr);
        System.out.println(Arrays.equals(arr_test, test_choice_sort) ? "choice_sort - ok" : "choice_sort - fail");
        System.out.println("arr_test:\t\t\t" + Arrays.toString(arr_test));
        System.out.println("test_choice_sort:\t" + Arrays.toString(test_choice_sort));
        System.out.println();

        int[] test_bubble_sort = bubble_sort(arr);
        System.out.println(Arrays.equals(arr_test, test_bubble_sort) ? "bubble_sort - ok" : "bubble_sort - fail");
        System.out.println("arr_test:\t\t\t" + Arrays.toString(arr_test));
        System.out.println("test_bubble_sort:\t" + Arrays.toString(test_bubble_sort));
    }

    /**
     * insert_sort(сортировка вставками)
     * The first position is sorted yet.
     * Iterator goes from right to left
     * If PREVIOUS element is greater than NEXT element, elements are replaced.
     *
     * @param array - an array for sort
     * @return - new sorted array
     */
    public static int[] insert_sort(int[] array) {
        //int[] arr = new int[array.length];
        //System.arraycopy(array, 0, arr, 0, arr.length); // System.out.println("arr: " + Arrays.toString(arr));
        int[] arr = Arrays.copyOf(array, array.length);
        int iterations = 0;

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
                iterations++;
            }
            iterations++; // 25
            /*for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                iterations++; // 45
            }*/
        }

        System.out.println("Iterations = " + iterations);
        return arr;
    }

    /**
     * choice_sort (сортировка выбора) - the first position is for min number in unsorted array
     * Iterator goes from left to right
     * If the FIRST element is greater than every next element, elements are replaced.
     * When iteraror will come to the last element (N-1), the first element will be sorted.
     * Next iteration begin from the second element to (N-1)
     *
     * @param array - an array for sort
     * @return - new sorted array
     */
    public static int[] choice_sort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        int iterations = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                iterations++;
            }
        }
        System.out.println("Iterations = " + iterations);
        return arr;
    }

    /**
     * bubble_sort (сортировка методом пузырька) - the biggest number became in the rightist position
     * Iterator goes from left to right
     * Отсчитывается количество проходов, а не позиция, как в choice_sort
     * Every iterartion starts from 0 to ((N-1) - iterator)
     * If PREVIOUS element is greater than the NEXT element, elements are replaced
     *
     * @param array - an array for sort
     * @return - new sorted array
     */
    public static int[] bubble_sort(int[] array) {
        int[] arr = Arrays.copyOf(array, array.length);
        int iterations = 0;
        for (int i = 1; i < arr.length; i++) { // чтобы не доходить до конца
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                iterations++;
            }
        }
        System.out.println("Iterations = " + iterations);
        return arr;
    }
}
