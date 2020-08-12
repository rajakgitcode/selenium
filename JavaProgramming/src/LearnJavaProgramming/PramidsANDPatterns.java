package LearnJavaProgramming;

public class PramidsANDPatterns {

	public static void main(String[] arg)
	{
		//print half pyramid using number
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		//print half pyramid using *
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		//Inverted half pyramid using number
		for(int i=5; i>=1; i--)
		{
			for(int j=i; j>=1; j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		
		//Inverted half pyramid using *
		for(int i=5; i>=1; i--)
		{
			for(int j=i; j>=1; j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(" ");
				{
					for(int k=j; k>=1; k--)
					{
						System.out.print(k);
						
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		for(int i=1; i<=5; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print(" ");
				{
					for(int k=j; k>=1; k--)
					{
						System.out.print("*");
						
					}
					//System.out.print();
				}
			}
			System.out.println();
		}
	}
}
