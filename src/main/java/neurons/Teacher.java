package neurons;

public class Teacher {

	public static void teach(final LightCheckerNeuron neuron, int lessons) {

		for (int i = 0; i < lessons; i++) {
			boolean answer = i > (lessons / 2);
			neuron.learn(SignalGenerator.generateSignals(neuron.incomingSignalCount), answer);
		}
	}
}
