package singleton;

public class InnerClassSingleton {
	private static class InstanceHolder{
		private static final InnerClassSingleton instance = new InnerClassSingleton();
	}
	private InnerClassSingleton(){
		
	}
	public InnerClassSingleton getInstance(){
		return InnerClassSingleton.InstanceHolder.instance;
	}
}
