package neurons;

public class LightCheckerNeuron {

	private int[] memory;
	private int learnedCount = 0;

	public int incomingSignalCount;

	public LightCheckerNeuron(int incomingSignalCount) {
		this.incomingSignalCount = incomingSignalCount;
		memory = new int[incomingSignalCount];
	}

	public void learn(boolean[] incoming, boolean answer) {
		for (int i = 0; i < incoming.length; i++) {
			if (incoming[i] == answer) {
				memory[i]++;
			}
		}
		learnedCount++;
	}

	public boolean makeDecision(boolean[] incoming) {
		int balance = 0;
		for (int i = 0; i < incomingSignalCount; i++) {
			int reliability = memory[i] * 100 / learnedCount;
			balance += incoming[i] ? reliability - 50 : 50 - reliability;
			System.out.println("Signal " + i + " answer is " + incoming[i] + ", reliability: " + reliability + " " +
					"balance: " + balance);
			/*if (memory[i] * 100 / learnedCount > 50) {
				balance += incoming[i] ? 1 : -1;
			} else {
				balance += incoming[i] ? -1 : 1;
			}*/

		}

		boolean answer = balance > 0;
		learn(incoming, answer);
		return answer;
	}
}
