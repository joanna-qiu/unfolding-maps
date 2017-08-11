package module4;

public class Student extends Person{

	public Student()
	{
		this ("Student");
		System.out.println("#2");
	}
	public Student(String n)
	{
		super(n);
		System.out.println("#3");
	}


public static void main (String [] args)
{
	Student s = new Student();
}
}