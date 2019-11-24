public class MyLinkedList {
  private ListNode head;
  private int length;
  
  public ListNode() {
    this.head = null;
    this.length = 0;
  }
  
  public int size() {
    if (head == null) {
      return 0;
    }
    ListNode cur = head;
    while (cur != null) {
      length++;
      cur = cur.next;
    }
    return length;
  }
  
  public ListNode get(int idx) {
    if (head == null) {
      return null;
    }
    
    ListNode cur = head;
    while (idx >0 && cur != null) {
      cur = cur.next;
      idx--;
    }
      
    return cur;
  }

  public ListNode appendTail(int value) {
    if (head == null) {
      head = new ListNode(value);
    }
    
    ListNode prev = head;
    while (prev.next != null) {
      prev = prev.next;
    }
    
    prev.next = new ListNode(value);
    return head;
  }
  
  public ListNode appendHead(int value) {
    ListNode newHead = new ListNode(value);
    newHead.next = head;
    return newHead;
  }
  
  public void print() {
    if (head == null) {
      System.out.print("Linked List is null");
    }
    
    ListNode prev = head;
    while (prev.next != null) {
      System.out.print(prev.value);
      System.out.print(" -> ");
      prev = prev.next;
    }
    System.out.print(prev.value);
    System.out.print(" -> NULL");
  }
}

