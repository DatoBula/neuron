package addon;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class NetworkTest {

	@Test
	public void testSubnet() throws IOException, InterruptedException {

		String subnet = "192.168.0";
		ExecutorService executorService = new ScheduledThreadPoolExecutor(100);
		List<Future<Map.Entry<String, Boolean>>> answers = new ArrayList<>();
		for (int i = 1; i < 254; i++) {
			String host = subnet + "." + i;
			answers.add(executorService.submit(new Checker(host)));
		}

		executorService.awaitTermination(100, TimeUnit.SECONDS);
		answers.stream().filter(Future::isDone).map(future -> {
			try {
				return future.get();
			} catch (Exception ex) {
				return null;
			}
		}).filter(answer -> answer != null && answer.getValue()).forEach(answer -> System.out.println(answer.getKey()));
	}
}

class Checker implements Callable<Map.Entry<String, Boolean>> {

	private String host;
	private static final Integer TIMEOUT = 1000;

	public Checker(String host) {
		this.host = host;
	}

	@Override
	public Map.Entry<String, Boolean> call() throws Exception {

		Boolean answer = false;
		System.out.println("Checking host " + host + "...");
		if (InetAddress.getByName(host).isReachable(TIMEOUT)) {
			System.out.println(host + " is reachable");
			answer = true;
		} else {
			System.out.println("Timeout!");
		}
		return new AbstractMap.SimpleEntry<>(host, answer);
	}
}