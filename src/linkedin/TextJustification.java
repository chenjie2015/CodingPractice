package linkedin;

import java.util.ArrayList;

public class TextJustification {
	ArrayList<String> fullJustify(ArrayList<String> words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (0 == words.size())
			return result;
		int i = 0;
		while (i < words.size()) {
			int start = i;
			int sum = 0;
			while (i < words.size() && sum + words.get(i).length() <= L) {
				sum += words.get(i).length() + 1;
				i++;
			}
			int end = i - 1;
			int intervalCount = end - start;
			int avgSp = 0, leftSp = 0;
			if (intervalCount > 0) {
				avgSp = (L - sum + intervalCount + 1) / intervalCount;
				leftSp = (L - sum + intervalCount + 1) % intervalCount;
			}
			StringBuilder line = new StringBuilder("");
			for (int j = start; j < end; j++) {
				line.append(words.get(j));
				if (i == words.size()) // the last line
					line.append(' ');
				else {
					for(int k = 0; k < avgSp; k++)
						line.append(' ');
					if (leftSp > 0){
						line.append(' ');
						leftSp--;
					}
				}
			}
			line.append(words.get(end));
			while (line.length() < L)
				line.append(' ');
			result.add(line.toString());
		}
		return result;
	}
}
