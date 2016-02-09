
public class Stack<T> {
	protected static int STACK_SIZE = 10;
	private T [] data;
	private int top;
	public Stack(){
		data = (T[])new Object[STACK_SIZE];
		top = -1;
	}

	public boolean full(){
		return top == STACK_SIZE - 1;
	}

	public boolean empty(){
		return top == -1;
	}

	public void push(T obj){
		if(full()){
			throw new RuntimeException("Stack Overflow");
		}
		data[++top] = obj;
	}

	public T pop(){
		if(empty()){
			throw new RuntimeException("Stack Underflow");
		}
		return data[top--];
	}

	public T peak(){
		if(empty()){
			throw new RuntimeException("Stack Underflow");
		}
		return data[top];
	}

	public int size(){
		return top+1;
	}
}