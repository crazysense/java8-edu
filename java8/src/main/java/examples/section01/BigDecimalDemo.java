package examples.section01;

import java.math.BigDecimal;

public class BigDecimalDemo {
	public static void main(String[] args) {
		double d1 = 2.0;
		double d2 = 4.64;
		System.out.println("(double) 4.64 - 2.0 ? " + (d2 - d1));

        BigDecimal bd1 = BigDecimal.valueOf(2.0);
        BigDecimal bd2 = BigDecimal.valueOf(4.64);
        System.out.println("(BigDecimal) 4.64 - 2.0 ? " + bd2.subtract(bd1));
	}
}
