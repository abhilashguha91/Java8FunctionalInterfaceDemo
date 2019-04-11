package java8.prep.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceDemo {

	// The concept of functional Interfaces was introduced in Java 8 to broaden the
	// functionality
	// of Lambda expressions.

	// A functional Interface has only one abstract method
	// may/ maynot be annotated by @FunctionalInterface (in java.lang)
	// if you annotate it with it the compiler immediately knows it's a functional
	// interface and doesn't
	// allow you to create another method inside it

	// If you add another method to your functional Interface it will not be a
	// functional interface anymore

	public static void main(String[] args) {

		// Let's try an example we already saw in the Lambda Demo and see what more Java8
		// has done for it's Functional Interface ease of use
		Condition condition = (s) -> {
			if (s.startsWith("A")) {
				return true;
			}
			return false;
		};

		List<String> list = new ArrayList<String>();
		list = Arrays.asList("Abhilash", "Aloke", "Sanchita", "Swarnali", "Aniket");

		iterateAndApplyCondition(list, condition);

		// In case you do not want to create an Functional interface just to make a type of your
		// lambda variable, Java 8 has a set of ready out of the box interfaces that can be placed
		// in any situation in a package called function i.e java.util.function
		// This package has a set of functional interfaces which comes out of the box in
		// Java 8 with generic return and parameter types and can be used as per your
		// requirement

		// Here we use the Predicate Interface which has a test method that returns a
		// boolean and
		// takes any generic object
		Predicate<String> condition1 = (String s) -> {
			if (s.startsWith("S")) {
				return true;
			}
			return false;
		};
		iterateAndApplyCondition1(list, condition1);
	}

	static void iterateAndApplyCondition(List<String> list, Condition conditionLambda) {
		for (String s : list) {

			if (conditionLambda.test(s)) {
				System.out.println(s);
			}

		}
	}

	static void iterateAndApplyCondition1(List<String> list, Predicate<String> conditionLambda) {
		for (String s : list) {

			if (conditionLambda.test(s)) {
				System.out.println(s);
			}

		}
	}

	@FunctionalInterface
	interface Condition {
		public boolean test(String s);
	}

}
