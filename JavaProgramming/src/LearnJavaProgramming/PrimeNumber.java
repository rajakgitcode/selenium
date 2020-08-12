package LearnJavaProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Identify number is prime number or not. Divisible by 1 and itself.
 */
public class PrimeNumber 
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Enter a number to check Prime or Not:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Integer num = Integer.valueOf(input);
		
		
		int n = 2;
		while(n <= num)
		{
			int i = 2;
			int flag = 0;
			while(i <= n/2)
			{
				if(n <= 3)
				{
					flag = 0;
				}
				if(n%i == 0)
				{
					flag++;
				}
				i++;
			}
			if(flag == 0)
			{
				System.out.println(n + " is a prime number.");
			}
			else
			{
				System.out.println(n + " is NOT a prime number.");				
			}
	
			n++;
		}
		
	}
	

}
