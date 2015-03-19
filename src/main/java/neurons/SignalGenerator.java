package neurons;

import java.util.Random;

public class SignalGenerator {

	public static boolean[] generateSignals(int signalCount) {

		Random random = new Random();
		boolean[] signals = new boolean[signalCount];
		for (int j = 0; j < signals.length; j++) {
			signals[j] = random.nextBoolean();
		}
		return signals;
	}

	public static boolean[] generateSignals(int signalCount, int reliability){
		Random random = new Random();
		boolean[] signals = new boolean[signalCount];
		for (int j = 0; j < signals.length; j++) {
			signals[j] = random.nextInt(100) < reliability;
		}
		return signals;
	}

	public static boolean[] generateSignals(int signalCount, int[] reliability){
		Random random = new Random();
		boolean[] signals = new boolean[signalCount];
		for (int j = 0; j < signals.length; j++) {
			signals[j] = random.nextInt(100) < reliability[j];
		}
		return signals;
	}
}
