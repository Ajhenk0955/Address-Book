

import org.junit.Assert;
import org.junit.Test;

public class StackTest {


	@Test
	public void testFillStack(){
		Stack<Integer> stack = new Stack<Integer>();
		int val = 0;
		while(val<Stack.STACK_SIZE){
			stack.push(val++);
		}
		Assert.assertTrue("Stack should be full", stack.full());
	}

	@Test(expected=RuntimeException.class)
	public void testPeakOnEmptyStack(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.peak();
	}

	@Test
	public void testEmptyStack(){
		Stack<Integer> stack = new Stack<Integer>();
		Assert.assertTrue("Stack should be empty", stack.empty());
	}

	@Test
	public void testPopStackToEmpty(){
		Stack<Integer> stack = new Stack<Integer>();
		int val = 0;
		while(!stack.full()){
			stack.push(val++);
		}

		for(int i=0;i<val;i++){
			stack.pop();
		}
		Assert.assertTrue("Stack should be empty", stack.empty());
	}

	@Test
	public void testOrder(){
		Stack<Integer> stack = new Stack<Integer>();
		int[] expected = new int[Stack.STACK_SIZE];
		int[] actual = new int[Stack.STACK_SIZE];
		int val = 0;
		
		while(val<Stack.STACK_SIZE){
			expected[Stack.STACK_SIZE-1 - val] = val;
			stack.push(val++);
		}
		
		int loc = 0;
		while(!stack.empty()){
			actual[loc++] = stack.pop();
		}
		Assert.assertArrayEquals("check that arrays match",expected, actual);
	}

	@Test(expected=RuntimeException.class)
	public void testPushToFullStack(){
		Stack<Integer> stack = new Stack<Integer>();
		int val = 0;
		while(val<Stack.STACK_SIZE){
			stack.push(val++);
		}
		stack.push(1);
	}

	@Test(expected=RuntimeException.class)
	public void testPopOnEmptyStack(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.pop();
	}

	@Test
	public void testPushToEmptyStack(){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		
		Assert.assertEquals("Stack should be 1",1, stack.size(),0);
		Assert.assertEquals("Stack value",1, stack.peak(),0);
	}




}