package neurons;

import org.junit.Test;

public class NeuronTester {

	@Test
	public void test() {
		int signalCount = 5;
		int lessons = 1000;
		LightCheckerNeuron lightCheckerNeuron = new LightCheckerNeuron(signalCount);
		Teacher.teach(lightCheckerNeuron, lessons);
		for (int i = 0; i < lessons; i++) {
			System.out.println("Neuron answer is: " + lightCheckerNeuron.makeDecision(SignalGenerator.generateSignals
					(signalCount)));
		}
	}
}

