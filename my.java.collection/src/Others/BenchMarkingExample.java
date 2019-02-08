package src.Others;

import org.openjdk.jmh.annotations.Benchmark;

//not working on java10, have to try with java8
public class BenchMarkingExample {

	@Benchmark
	public void init() {
		// Do nothing
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}
