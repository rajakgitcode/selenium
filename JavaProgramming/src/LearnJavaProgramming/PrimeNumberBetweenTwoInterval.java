package LearnJavaProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumberBetweenTwoInterval 
{
	public static void main(String[] arg) throws IOException
	{
		System.out.println("Enter Two Intervals of Number: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();
		Integer lower = Integer.valueOf(str);
		Integer higher = Integer.valueOf(str2);
		
		for(int low=lower; low<=higher;low++)
		{
		int flag = 0;
		for(int i = 2; i <= low/2; i++)
		{
			if(low%i == 0)
			{
				flag++;
			}
		}
		if(flag == 0)
		{
			System.out.println(low + "is a prime number");
		}
		else
		{
			System.out.println(low + "is NOT a prime number");
		}
		}
	}
}
