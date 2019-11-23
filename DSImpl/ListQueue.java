/**
 * public class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     this.next = null;
 *   }
 * }
 */
public class ListQueue {
  private ListNode head;
  private ListNode tail;
  
  public ListQueue() {
    head = tail = null;
  }
  
  public void offer(Integer ele) {
    if (head == null) {
      head = new ListNode(ele);
      tail = head;
    } else {
      tail.next = new ListNode(ele);
      tail = tail.next;
    }
  }
  
  public Integer peek() {
    if (head == null) {
      return null;
    }
    return head.value;
  }
  
  public Integer poll() {
    if (head == null) {
      return null;
    }
    ListNode node = new ListNode(head.value);
    if (head.next == null) {
      tail = null;
    }
    return head.value;
  }
  
  public boolean isEmpty() {
    return head == null && tail == null;
  }
  
  public static void main(String[] args) {
    BoundedQueue queueLL = new BoundedQueue(100);
    
    queueLL.offer(4);
    queueLL.offer(5);
    queueLL.offer(6);

    while (!queueLL.isEmpty()) {
      System.out.println(queueLL.peek());
      System.out.println(queueLL.poll());
    }

      System.out.println(queueLL.peek());
      System.out.println(queueLL.poll());
  }
}
