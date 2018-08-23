package yu;

import java.util.Stack;

public class MyQueue {
	  
	Stack<Integer> my;
	// Implement the following operations of a queue using stacks.

    /** Initialize your data structure here. */
    public MyQueue() {
    	 my=new Stack<Integer>();
    	
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!my.empty()){
            temp.push(my.pop());
        }
        my.push(x);
        while(!temp.empty()){
            my.push(temp.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	//my.pop();
		return my.pop();
    }
    
    /** Get the front element. */
    public int peek() {
		return my.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	if(max==0)
    		return true;
    	else return false;
        
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

/**
 * Your MyQueue object will be instantiated and called as such:


push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top,
 size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */