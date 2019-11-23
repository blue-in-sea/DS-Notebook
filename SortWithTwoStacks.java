public class SortWithTwoStacks {
  public void sort(LinkedList<Integer> s1) {
    if(s1 == null || s1.size() <= 1) {
      return;
    }
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    sort(s1, s2);  // s1: input, s2: buffer
  }

  private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2) {
    while (!s1.isEmpty()) {
      int cur = s1.pollFirst();
      // s2 contains integers and from top to bottom that are 
      // sorted in descending order (max in the top)
      while (!s2.isEmpty() && cur < s2.peekFirst()) { // key!!
        s1.offerFirst(s2.pollFirst());
      }
      s2.offerFirst(cur);
    }
    
    // while elements from s2 return back s1, they are 
    // sorted in ascending order (min in the top)
    while (!s2.isEmpty()) {
      s1.offerFirst(s2.pollFirst());
    }
  }
}
