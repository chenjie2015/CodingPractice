package javaknowledge;

public class ChildClass extends ParentClass {
	//public int b = 2;
	public void abstract_print(){
		
	}
	public void print(){
		System.out.println("From child class.");
		System.out.println(a);
	}
	public static void main(String[] args){
		ChildClass test = new ChildClass();
		test.print();
		// cannot initiate an abstract class
		// ParentClass test2 = new ParentClass();
		//ChildClass test3 = new ParentClass();
		ParentClass test4 = new ChildClass();
		test4.print();
	}
}
