package LearnJavaProgramming;

/*
 * FibonacciSeries 0 1 1 2 3 5 8 13 21
 */
public class FibonacciSeries 
{
	public static void main(String[] arg)
	{
		int num = 50;
		int a = 0;
		int b = 1;
		int i = 1;
		int sum = 0;
		
		while(i <= num)
		{
			System.out.println(sum);
			
			sum = a + b;
			a = b;
			b = sum;
			i++;
		}
	}
}
