
public class SortWithThreeStacks {
  public void sort(LinkedList<Integer> s1) {
    if(s1 == null || s1.size() <= 1) {                   // input
      return;
    }

    LinkedList<Integer> s2 = new LinkedList<Integer>();  // buffer 
    LinkedList<Integer> s3 = new LinkedList<Integer>();  // reverse of the input order
    sort(s1, s2, s3);
  }

  private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3) {
    while (!s1.isEmpty()) {
      int min = Integer.MAX_VALUE;
      int cnt = 0;  // duplicates
      // step 1: input supply to buffer 
      while (!s1.isEmpty()) {
        int cur = s1.pollFirst();
        if (cur < min) {
          min = cur;
          cnt = 1;
        } else if (cur == min) {
          cnt++;
        }
        s2.offerFirst(cur);
      }
      
      // step 2: buffer to s3
      while (cnt-- > 0) {
        s3.offerFirst(min);
      }
      
      // step 3: buffer return to input
      while (!s2.isEmpty() && s2.peekFirst() >= min) {
        int tmp = s2.pollFirst();
        if (tmp != min) {
         s1.offerFirst(tmp);
        }
      }
    }
    // s3 contains integers and from top to bottom that are 
    // sorted in descending order (max in the top), when it
    // returns all element to s1, s1 contains reverse order 
    while (!s3.isEmpty()) {
      s1.offerFirst(s3.pollFirst());
    }
  }
}
