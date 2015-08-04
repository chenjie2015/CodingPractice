package google;

import java.util.LinkedList;

public class RunningAverage {
	private LinkedList<Double> list = null;
	// get the window size
	private int winSize = 0;
	private double sum = 0;

	public RunningAverage(int winSize) throws Exception {
		if (winSize <= 0) {
			throw new Exception("The input window size illegal");
		}
		this.list = new LinkedList<Double>();
		this.winSize = winSize;
	}

	// get the next
	public double next(double input) {
		if (list.size() < this.winSize) {
			sum += input;
			list.add(input);
			return this.sum / list.size();
		} else {
			double output = list.remove();
			list.add(input);
			this.sum = this.sum - output + input;
			return this.sum / this.winSize;
		}
	}

}
