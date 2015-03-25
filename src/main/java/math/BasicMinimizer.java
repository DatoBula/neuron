package math;

public class BasicMinimizer implements Minimizer {

	private static final double EPS = 0.00001;
	private double STEP = 0.1;
	private static final int[] DIRECTIONS = {-1, 1};

	@Override
	public double findMinimum(Function function, int parametersCount) {

		double[] args = new double[parametersCount];
		for (int i = 0; i < parametersCount; i++) {
			args[i] = 1;
		}

		double minimum = function.apply(args);

		boolean hasImproved;
		do {
			hasImproved = false;
			for (int i = 0; i < parametersCount; i++) {
				for (int DIRECTION : DIRECTIONS) {
					args[i] += STEP * DIRECTION;
					double newMin = function.apply(args);
					if (newMin < minimum) {
						hasImproved = true;
						minimum = newMin;
					} else {
						args[i] -= STEP * DIRECTION;
					}
				}
			}
		} while (hasImproved);

		return minimum < EPS ? 0 : minimum;
	}
}
