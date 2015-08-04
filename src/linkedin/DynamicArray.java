package linkedin;

import java.util.Arrays;

/*
 * Personally implementation of ArrayList
 */
public class DynamicArray<T> {
	private Object[] elements;
	private int size;
	public DynamicArray(){
		this.elements = new Object[10];
		this.size = 0;
	}
	public DynamicArray(int capacity){
		this.elements = new Object[capacity];
		this.size = 0;
	}
	public void ensureCapacity(int minCapacity){
		int oldCapacity = elements.length;
		if(minCapacity > oldCapacity){
			int newCapacity = (oldCapacity * 2);
			if(newCapacity < minCapacity)
				newCapacity = minCapacity;
			elements = Arrays.copyOf(elements, newCapacity);
		}
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	private void rangeCheck(int index){
		if(index >= size || size < 0)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	public T get(int index){
		rangeCheck(index);
		return (T)elements[index];
	}
	public boolean add(T element){
		ensureCapacity(size + 1);
		elements[size++] = element;
		return true;
	}
	public void clear(){
		size = 0;
	}
	public T set(int index, T element){
		rangeCheck(index);
		T oldValue = (T)elements[index];
		elements[index] = element;
		return oldValue;
	}
	public int capacity(){
		return elements.length;
	}
	public T remove(int index){
		rangeCheck(index);
		T oldValue = (T)elements[index];
		int numMoved = size - index - 1;
		if(numMoved > 0)
			System.arraycopy(elements, index + 1, elements, index, numMoved);
		elements[--size] = null; // leave for gc
		return oldValue;
	}
	public void trimToSize(){
		int oldCapacity = elements.length;
		if(size < oldCapacity)
			elements = Arrays.copyOf(elements, size);
	}
}
