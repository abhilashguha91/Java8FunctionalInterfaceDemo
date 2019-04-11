package java8.prep.demo;

@FunctionalInterface
public interface Greet {
	
	public String perform();
	
	//public String anotherMethod();
	// If you add another method the annotation will throw an compilation error
	// Without the annotation this will not be a compilation issue, but this
	// will lose it's property as a functional Interface, and cannot be used
	// as a Type to a lambda variable.

}
