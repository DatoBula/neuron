package neurons;

import org.junit.Test;

public class NeuronTester {

	@Test
	public void test() {
		int signalCount = 5;
		int lessons = 100;
		LightCheckerNeuron lightCheckerNeuron = new LightCheckerNeuron(signalCount);
		Teacher.teach(lightCheckerNeuron, 2);
		for (int i = 0; i < lessons; i++) {
			System.out.println(lightCheckerNeuron.makeDecision(SignalGenerator.generateSignals(signalCount)));
		}
	}
}
