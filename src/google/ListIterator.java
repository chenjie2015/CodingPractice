package google;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListIterator<T> {
	private List<Iterator<T>> list;
	private int index;
	private int size;
	public ListIterator(List<Iterator<T>> list){
		this.list = list;
		this.size = list.size();
		this.index = 0;
	}
	public T next(){
		T res = list.get(index).next();
		int counter = 0;
		index = (index + 1) % size;
		while(counter != size && !list.get(index).hasNext()){
			index = (index + 1) % size;
			counter++;
		}
		if(counter == size)
			index = -1;
		return res;
	}
	public boolean hasNext(){
		return index != -1;
	}
}
