package javaknowledge;

public class FinalizeImplementation {
	@Override
	protected void finalize() throws Throwable {
		try {
			System.out.println("Finalize of Sub Class");
			// release resources, perform cleanup;
		} catch (Throwable t) {
			throw t;
		} finally {
			System.out.println("Calling finalize of Super Class");
			super.finalize();
		}
	}
	
	public static void main(String[] args){
		
	}
}
