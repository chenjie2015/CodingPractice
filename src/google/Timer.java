package google;

public class Timer {

	private volatile Long startTime;
	private volatile Long endTime;

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		endTime = System.currentTimeMillis();
	}

	public Long duration() {
		if (startTime == null || endTime == null)
			return null;
		return (endTime - startTime);
	}

	public Long durationInSec() {
		Long d = duration();
		if (d == null)
			return null;
		return (d / 1000);
	}

	public Long durationInMins() {
		Long d = durationInSec();
		if (d == null)
			return null;
		return (d / 60);
	}

}
