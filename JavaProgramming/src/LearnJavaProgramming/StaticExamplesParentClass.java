package LearnJavaProgramming;

public class StaticExamplesParentClass extends AccessModifierExample
{
	private int a = 10;
	protected int b = 20;
	public int c = 30;
	int d = 50;
		
		public static void main(String[] args)
		{
			AccessModifierExample obj1 = new AccessModifierExample();
			StaticExamplesParentClass obj2 = new StaticExamplesParentClass();
			
			
			System.out.println("a: " + obj1 + "b: " + obj1.b + "c: " + obj1.c + "d: " + obj1.d );
			
			//obj1.a = 100;
			obj1.b = 200;
			obj1.c = 300;
			obj1.d = 400;
			
			System.out.println("a: " + obj1 + "b: " + obj1.b + "c: " + obj1.c + "d: " + obj1.d );
			System.out.println("a: " + obj2 + "b: " + obj2.b + "c: " + obj2.c + "d: " + obj2.d );
			
		}

	
}
