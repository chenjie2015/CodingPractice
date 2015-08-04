package google;

public class Read4096 {
	public static char[] buffer = new char[4096];
	public static int pos = 0;
	public static int capacity = 0;
	public int read4096(char[] buffer){
		return 4096;// or actual read size
	}
	public char[] read(int size){
		char[] result = new char[size];
		int counter = 0;
		while(counter < size){
			if(pos == capacity){
				capacity = read4096(buffer);
				pos = 0;
				if(capacity == 0)
					break;
			}
			result[counter] = buffer[pos];
			counter++;
			pos++;
		}
		return result;
	}
}
