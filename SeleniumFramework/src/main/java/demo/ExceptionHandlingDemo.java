package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		try {
			System.out.println("Hello World!");
			int i = 1/0;
			System.out.println("Completed");

		}
		catch(Exception exp){
			System.out.println("i am inside catch block");
			System.out.println("Message is: "+exp.getMessage());
			System.out.println("cause is: "+ exp.getCause());
		}
		finally {
			System.out.println("i am inside finally block");
		}

	}

}
