package facebook;

import java.util.ArrayList;
import java.util.List;

public class ReadLine {
	public int MAX_LEN = 4096;

	public int read4K(char[] buf, int len) {
		//buf = new char[] { 'a', 'b', 'c', 'd' };
		return 4096;
	}

	public List<Character> readLine() {
		boolean EOF = false;
		List<Character> str = new ArrayList<Character>();
		int i = 0;
		int currentPos = MAX_LEN;
		char[] buffer = new char[MAX_LEN];
		while (!EOF || currentPos != MAX_LEN) {
			// buffer is not empty, handle buffer first
			if (currentPos != MAX_LEN) {
				for (i = currentPos; i < MAX_LEN; i++){
					str.add(buffer[i]);
					if (buffer[i] == '\0' || buffer[i] == '\n')
						break;
				}
				currentPos = i + 1;
				if (buffer[i] == '\0' || buffer[i] == '\n')
					return str;
			} else {
				int size = read4K(buffer, MAX_LEN);
				currentPos = 0;
				if (size < MAX_LEN)
					EOF = true;
			}
		}

		return str;
	}
	
	
	public char[] read4(){
		// read to buf
		return new char[4];
	}
	public List<Character> read(int len){
		int pos = 0;
		List<Character> result = new ArrayList<Character>();
		if(len == 0)
			return result;
		char[] buf = null;
		int buf_pos = 0;
		while(pos != len){
			if(buf != null){
				for(int i = buf_pos; i < 4; i++){
					result.add(buf[i]);
					pos++;
					buf_pos = (buf_pos + 1) % 4;
					if(pos == len)
						return result;
				}
			} else {
				int k = (len - pos) / 4;
				for(int i = 0; i < k; i++){
					buf = read4();
					for(int j = 0; j < 4; j++)
						result.add(buf[j]);
					pos += 4;
				}
				k = (len - pos) % 4;
				buf = read4();
				for(int i = 0; i < k; i++){
					result.add(buf[i]);
					buf_pos++;
					pos++;
				}
			}
		}
		return result;
	}
}
