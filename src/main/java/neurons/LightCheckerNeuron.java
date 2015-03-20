package neurons;

public class LightCheckerNeuron {

	private static int[] memory;
	private static int learnedCount = 0;

	public LightCheckerNeuron(int incomingSignalCount) {
		memory = new int[incomingSignalCount];
	}

	public void learn(boolean[] incoming, boolean answer) {
		for (int i = 0; i < incoming.length; i++) {
			if (incoming[i] && answer) {
				memory[i]++;
			}
		}
		learnedCount++;
	}

	public boolean makeDecision(boolean[] incoming) {
		return false;
	}
}
