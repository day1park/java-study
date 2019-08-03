package lectureExamples;

/*
 * Single-level
 * Multi-level
 * Multiple Inheritance - not allowed
 * Hierarchical Inheritance - one class is extended by multiple classes
 *     e.g. B extends A, C extends A & D extends A.
 * Hybrid Inheritance - if an inheritance hierarchy contains more than one type of inheritance
 *     e.g. B extends A, C extends A & C extends B.
 */

class GrandParent {
	
}

class Parent extends GrandParent {
	
}

class Uncle extends GrandParent {
	
}

class GrandChild extends Parent {
	
}

public class Inheritance {

}
