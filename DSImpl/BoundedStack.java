public class BoundedStack {
    private int head;
    private int[] array;

    public BoundedStack(int cap) {
        array = new int[cap];
        head = -1;
    }

    public boolean push(int ele) {
        if (head == array.length -1) {
            return false;
        }
        array[++head] = ele;
        return true;
    }

    public Integer pop() {
        return head == -1 ? 0 : array[head--];
    }

    public Integer top() {
        return head == -1 ? 0 : array[head];
    }

    public boolean isEmpty() {
        return head == -1;
    }


    public static void main(String[] args) {
        BoundedStack MyArrStack = new BoundedStack(100);

        MyArrStack.push(4);
        MyArrStack.push(5);
        MyArrStack.push(6);

        while (!MyArrStack.isEmpty()) {
            System.out.println(MyArrStack.top());
            System.out.println(MyArrStack.pop());
        }

        System.out.println(MyArrStack.top());
        System.out.println(MyArrStack.pop());
    }
}
