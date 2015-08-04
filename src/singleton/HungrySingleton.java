package singleton;

public class HungrySingleton {
	private static HungrySingleton instance = new HungrySingleton();
	private HungrySingleton(){
		
	}
	public HungrySingleton getInstance(){
		return instance;
	}
}
