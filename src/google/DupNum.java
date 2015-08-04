package google;

public class DupNum {
	/*
	 * An array. One element has large than 50% occurrence.
	 * Calculate that element.
	 */
	public int find(int[] array){
		int candidate = 0;
		int counter = 0;
		for(int i = 0; i < array.length; i++){
			if(counter == 0){
				candidate = array[i];
				counter++;
			}
			else if(array[i] == candidate)
				counter++;
			else
				counter--;
		}
		return candidate;
	}
	/*
	 *  扩展：
	 *  
	 *  1、ID数组中，有三个水王ID，这三个水王ID重复出现的次数，都超过了数组长度的1/4。要求快速找到这3个水王ID。
	 *  2、ID数组中，有 K个水王ID，这K个水王ID重复出现的次数，都超过了列表长度的1/（k+1）。要求快速找到这K个水王ID。
	 *  扩展1与扩展2的思路是一样的，只不过开辟的数组大小不同而已
	 */
	// 以3个水王ID为例，每个ID的帖子数目超过1/4
	public int[] find3(int[] array){
		int[] candidate = new int[3];
		int[] counter = new int[3];
		for(int i = 0; i < array.length; i++){
			int next = array[i];
			int j = 0;
			for(j = 0; j < 3; j++){
				if(counter[j] == 0 || candidate[j] == next){
					candidate[j] = next;
					counter[j]++;
					break;
				}
			}
			if(j == 3){
				counter[0]--;
				counter[1]--;
				counter[2]--;
			}
		}
		return candidate;
	}
}
