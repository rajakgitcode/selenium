package LearnJavaProgramming;

public class AccessModifierExample 
{
	private static int a = 10;
	protected  static int b = 20;
	public static int c = 30;
	static int d = 40;
	
	public static void main(String[] args)
	{
		AccessModifierExample obj1 = new AccessModifierExample();
		System.out.println("a: " + obj1.a + "b: " + obj1.b + "c: " + obj1.c + "d: " + obj1.d );
		
		obj1.a = 100;
		obj1.b = 200;
		obj1.c = 300;
		obj1.d = 400;
		
		System.out.println("a: " + obj1.a + "b: " + obj1.b + "c: " + obj1.c + "d: " + obj1.d );
		
	}

}
