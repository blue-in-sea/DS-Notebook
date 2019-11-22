public class MyDeque {
  Deque<Integer> left;
  Deque<Integer> right;
  Deque<Integer> buffer;

  public Solution() {
    left = new ArrayDeque<>();
    right = new ArrayDeque<>();
    buffer = new ArrayDeque<>();
  }
  
  public void offerFirst(int element) {
    left.offerFirst(element);
  }
  
  public void offerLast(int element) {
    right.offerFirst(element);
  }
  
  public Integer pollFirst() {
    move(right, left);
    return left.isEmpty() ? null : left.pollFirst();
  }
  
  public Integer pollLast() {
    move(left, right);
    return right.isEmpty() ? null : right.pollFirst();
  }
  
  public Integer peekFirst() {
    move(right, left);
    return left.isEmpty() ? null : left.peekFirst();
  }
  
  public Integer peekLast() {
    move(left, right);
    return right.isEmpty() ? null : right.peekFirst();
  }
  
  public int size() {
    return left.size() + right.size();
  }
  
  public boolean isEmpty() {
    return left.isEmpty() && right.isEmpty();
  }

  private void move(Deque<Integer> src, Deque<Integer> dest) {
    if (!dest.isEmpty()) {
      return;
    }
    int half = src.size() / 2;
    // src (top half) --> buffer 
    for (int i = 0; i < half; i++) {
      buffer.offerFirst(src.poll());
    }
    // src (bot half) --> dest
    while (!src.isEmpty()) {
      dest.offerFirst(src.poll());
    }
    // buffer (half) --> src (reverse step1)
    while (!buffer.isEmpty()) {
      src.offerFirst(buffer.poll());
    }
    // test case       ][ 1 2 3 4
  }
}
