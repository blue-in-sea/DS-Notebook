public class ListStack {
    private ListNode head;

    public ListStack() {
        this.head = null;
    }

    public void push(Integer ele) {
        ListNode node = new ListNode(ele);
        node.next = head;
        head = node;
    }

    public Integer pop() {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.next;
        node.next = null;
        return node.value;
    }

    public Integer top() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        ListStack stackLL = new ListStack();

        stackLL.push(1);
        stackLL.push(2);
        stackLL.push(3);

        while (!stackLL.isEmpty()) {
            System.out.println(stackLL.top());
            System.out.println(stackLL.pop());
        }

        System.out.println(stackLL.top());
        System.out.println(stackLL.pop());
    }
}
