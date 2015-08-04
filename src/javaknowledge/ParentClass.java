package javaknowledge;

public abstract class ParentClass {
	public int a = 10;
	abstract void abstract_print();
	protected void print(){
		System.out.println("From parent class.");
	}
}
