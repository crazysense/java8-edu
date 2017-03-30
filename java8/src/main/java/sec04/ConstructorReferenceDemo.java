package sec04;

import sec04.data.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorReferenceDemo {
	public static void main(String[] args) {
		List<String> games = new ArrayList<>();
		games.add("Grand Theft Auto V");
		games.add("Dark Souls III");
		games.add("The Last Of Us");
		games.add("Uncharted IV");

        System.out.println("\n1. <<Array>>");
        Product[] products = games.stream().map(Product::new).toArray(Product[]::new);
		for (Product p : products) {
			System.out.println(p);
		}

        System.out.println("\n1. <<List>>");
		List<Product> productList = games.stream().map(Product::new).collect(Collectors.toList());
		productList.forEach(System.out::println);
	}
}
