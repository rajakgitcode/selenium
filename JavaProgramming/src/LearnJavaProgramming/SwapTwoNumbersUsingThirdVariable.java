package LearnJavaProgramming;

public class SwapTwoNumbersUsingThirdVariable 
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;
		int c;
		
		System.out.println("Before Swap value in A: " + a + " B: "+ b);
		
		c = b;
		b = a;
		a = c;
		
		System.out.println("After Swap value in A: " + a + " B: "+ b);
		
		
		//Second logic to swap 2 numbers
		
		int x = 50;
		int y = 60;

		System.out.println("Before Swap value in X: " + x + " Y: "+ y);
		
		x = x + y;
		y = x - y;
		x = x - y;
		
		System.out.println("After Swap value in X: " + x + " Y: "+ y);
		
	}
}
