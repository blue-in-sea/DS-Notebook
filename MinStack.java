// Method 1: Synchronously push two stacks
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}

// Method 2: Asynchronously push two stacks with more space saved, 
//           while worst case space complexity doesn't change
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else if (minStack.peek() >= number) { // 这里考虑的相等的情况也会继续push
            minStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.peek();
    }
}
