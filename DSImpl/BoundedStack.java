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
        return true
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
        BoundedStack stackArr = new BoundedStack(100);

        stackArr.push(4);
        stackArr.push(5);
        stackArr.push(6);

        while (!stackArr.isEmpty()) {
            System.out.println(stackArr.top());
            System.out.println(stackArr.pop());
        }

        System.out.println(stackArr.top());
        System.out.println(stackArr.pop());
    }
}
