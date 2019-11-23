public class BoundedQueue {
  private int head; 
  private int tail;
  private int size;
  private Integer[] array;
  
  public BoundedQueue(int cap) {
    array = new Integer[cap];
    head = tail = 0;
    size = 0;
  }
  
  public boolean offer(Integer ele) {
    if (size == array.length) {
      return false;
    }
    array[tail] = ele;
    tail = tail + 1 == array.length ? 0 : tail + 1;
    size++;
    return true;
  }
  
  public Integer peek() {
    if(size == 0) {
      return null;
    }
    return array[head];
  }
  
  public Integer poll() {
    if (size == 0) {
      return null;
    }
    Integer res = array[head];
    head = head + 1 == array.length ? 0 : head + 1;
    // head = (head + 1) % array.length;
    size--;
    return res;
  }
  
  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }
  
  public boolean isFull() {
    return size == array.length;
  }
  
  public static void main(String[] args) {
    BoundedQueue MyArrQueue = new BoundedQueue(100);
    
    MyArrQueue.offer(7);
    MyArrQueue.offer(8);
    MyArrQueue.offer(9);
    
    while (!MyArrQueue.isEmpty()) {
      System.out.println(MyArrQueue.peek());
      System.out.println(MyArrQueue.poll());
    }
    
    System.out.println(MyArrQueue.peek());
    System.out.println(MyArrQueue.poll());
  }
}
