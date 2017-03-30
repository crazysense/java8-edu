package sec07;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ParallelStreamDemo2 {
	public static void main(String[] args) throws Exception {

        /***
         * Reference by
         * http://www.popit.kr/java8-stream%EC%9D%98-parallel-%EC%B2%98%EB%A6%AC/
         */

		// 1. General Thread Processing
        System.out.println("\n2. <<General Thread Processing>>");

		ExecutorService executor = Executors.newFixedThreadPool(5);
		List<Future<String>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			final int index = i;
			futures.add(executor.submit(() -> {
				Thread.sleep(2000);
				return Thread.currentThread().getName() + ", index=" + index + ", ended at " + new Date();
			}));
		}

		for (Future<String> eachFuture : futures) {
			String result = eachFuture.get();
			System.out.println("Thread result : " + result);
		}

		executor.shutdown();

		// 2. Java 8 Parallel Processing
        // ForkJoinPool Size = CPU Core Size
        System.out.println("\n2. <<Java 8 Parallel Processing>>");
        Thread.sleep(2000);

		IntStream.range(0, 10).parallel().forEach(index -> {
			System.out.println("Starting " + Thread.currentThread().getName() + ", index=" + index + ", ended at " + new Date());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});


		// 3. Java 8 Paralle Processing
        // Changes pool size
        System.out.println("\n2. <<Java 8 Parallel Processing - Changes pool size>>");
        Thread.sleep(2000);

        ForkJoinPool myPool = new ForkJoinPool(5);
        myPool.submit(() -> {
            IntStream.range(0, 10).parallel().forEach(index -> {
                System.out.println("Starting " + Thread.currentThread().getName() + ", index=" + index + ", ended at " + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }).get();
	}
}
