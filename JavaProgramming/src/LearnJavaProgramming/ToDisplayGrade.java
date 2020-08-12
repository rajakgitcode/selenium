package LearnJavaProgramming;

public class ToDisplayGrade {

	public static void main(String[] args) {
		int mark = 75;
		char grade;
		
		if(mark > 90)
		{
			grade = 'A';
		}
		else if(mark > 80 && mark < 90)
		{
			grade = 'B';
		}
		else if(mark >70 && mark < 80)
		{
			grade = 'C';
		}
		else if(mark >60 && mark < 70)
		{
			grade = 'D';
		}
		else
		{
			grade = 'E';
		}
		System.out.println(grade);
	}

}
