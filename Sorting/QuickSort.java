class QuickSort {
    // Ave Time: O(nlogn), Worst Case Time: O(n^2), Space: O(n)
    public int[] sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // define a pivot and use the pivot to partition the array
        int pivotIndex = partition(array, left, right);
        // pivot is already at its position, when we do the recursive call
        // the two partitions, pivot should not be inlcude in any them
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(array, left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] <= pivot) {
                i++;
            } else if (array[j] >= pivot) {
                j--;
            } else {
                swap(array, i, j);
            }
        }
        // swap back the pivot to the correct position
        swap(array, i, right);
        return i;
    }
    // pick a random number in range 
    private int pivotIndex(int[] array, int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
