package LearnJavaProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString 
{
	// Reverse a string without Array or temp variable using String builder methods
	public void reverseStringMethod1()
	{
		 String str = "ReverseString";
		 StringBuilder sb = new StringBuilder();
		 sb.append(str);
		 sb = sb.reverse();
		 System.out.println(sb);
	}
	
	
	// Reverse a string using Array
	public void reverseStringMethod2()
	{
		String str = "System";
		char[] ch = str.toCharArray();
		
		for(int i = ch.length-1; i >= 0; i--)
		{
			System.out.print(ch[i]);
		}
		
	}
	
	//Reverse a string using temp variable
	public void reverseStringMethod3() throws IOException
	{
		System.out.println("Enter a string to Reverse and Hit ENTER:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String reverse = "";
		
		char[] ch = str.toCharArray();
		
		for(int i = ch.length-1; i>=0; i--)
		{
			reverse = reverse + ch[i];
		}
		
		System.out.println(reverse);
	}

	public static void main(String[] args) throws IOException
	{
		ReverseString rs = new ReverseString();
		rs.reverseStringMethod1();
		rs.reverseStringMethod2();
		rs.reverseStringMethod3();
	}
	
}
