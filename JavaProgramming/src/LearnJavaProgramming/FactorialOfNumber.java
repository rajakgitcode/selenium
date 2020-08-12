package LearnJavaProgramming;

public class FactorialOfNumber 
{
	
	public static void main(String[] args)
	{
		int num = 7;
		int fact = 1;
		
		while(num != 0)
		{
			
			fact = fact * num;
			num --;
			
		}
		
		System.out.println("factorial of number : " + fact);
		//using recursion
		System.out.println("factorial of number : " + factorial(5));
		
	}
	
	//using recursion
	public static int factorial(int n)
	{
		if(n >= 1)
			return n * factorial(n - 1);
		else
			return 1;
		 
	}

}
