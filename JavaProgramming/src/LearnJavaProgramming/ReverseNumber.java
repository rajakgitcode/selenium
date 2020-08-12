package LearnJavaProgramming;

public class ReverseNumber 
{
	public static void main(String[] args)
	{
		int num = 12345;
		int reverse = 0;
		int digit = 0;
		while(num != 0)
		{
			digit = num % 10;
			reverse = reverse * 10 + digit;
			num = num / 10;
		}
		System.out.println("Reverse of Number: " + reverse);
	}
}
