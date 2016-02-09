package exceptions;

public class test {

	public static int oddOrPos(int[] x)
	{ 
	//Effects: If x==null throw NullPointerException

	//Effects: if x==null throw NullPointerException
	// else return the number of elements in x that
	// are either odd or positive (or both)

	int count = 0; 
	for (int i = 0; i < x.length; i++)
	{ 
	        if (x[i]%2 == 1 || x[i] > 0)
	        {
	                   count++; 
	        }

	}
	return count; 
	}
}
