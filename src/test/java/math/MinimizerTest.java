package math;

import org.junit.Test;

public class MinimizerTest {

	@Test
	public void test() {
		double minimum = new BasicMinimizer().findMinimum(args -> {
			double ans = 1.052;
			for (double arg : args) {
				ans += arg * arg;
			}
			return ans;
		}, 5);

		System.out.println(minimum);
	}

}