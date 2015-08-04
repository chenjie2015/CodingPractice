package singleton;

public class DoubleCheckSingleton {
	private static DoubleCheckSingleton instance = null;
	private DoubleCheckSingleton(){
		
	}
	public DoubleCheckSingleton getInstance(){
		if(instance == null){
			synchronized(instance){
				DoubleCheckSingleton temp = instance;
				if(temp == null){
					temp = new DoubleCheckSingleton();
				}
				instance = temp;
			}
		}
		return instance;
	}
}
