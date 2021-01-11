/**
 * Test the classes Person and Student
 * The class Student extends Person
 *   
 * @author Igor
 *
 */
public class TestPersonStudent
{
	/**
	 * main method 
	 * 
	 */
	public static void main(String[] args) {
		Person Tom = new Person(123, "Tom", "Sawyer", Person.MALE); 
		System.out.println(Tom.getFullName());

		Student Huck = new Student(456, "Huck", "Finn", Person.MALE);
		System.out.println("Print Huck using getFullName::");
		System.out.println(Huck.getFullName());
		System.out.println("Print Huck using toString::");
		System.out.println(Huck + "\n");
	
		Person p = Huck;
		System.out.println(p);
	
		Student p2 = (Student) p; // ok since p is Huck of type Student
		System.out.println(p2);
	
		System.out.println("-----------");

		Student s;
		s = Huck;	// ok since Huck is of type Student
		System.out.println(s.getFullName());

		//	Student s = Tom; !!! Compile Time Exception !!!
		s = (Student) Tom; // ClassCast Exception
	}
	
}


