/**
 * Assume we have three colors denoted as -1, 0, 1
 * and all elements in the input are valid
 */
public class RainbowSort {
  public int[] rainbowSort(int[] A) {
    if (A == null || A.length <= 1) {
      return A;
    }
    // three pointers to divide four intervals
    // 1. the left side of neg is -1 (exclusive of neg)
    // 2. the right side of one is 1 (exclusive one)
    // 3. between neg and zero is 0 (exclusive of zero)
    // 4. between zero and one will be to dicovered (inclusive of both)
    int neg = 0;
    int zero = 0;
    int array.length - 1;
    while (zero <= one) {
      if (array[zero] == -1) {
        swap(A, neg++, zero++);
      } else if (array[zero] == 0) {
        zero++;  
      } else {
        swap(A, zero, one--);
      }
      return array;
    }
  }
  
  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
