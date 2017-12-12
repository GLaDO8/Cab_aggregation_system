package utility_classes.base_classes;
//base_classes folder contains abstract classes for car and fleet class. It also contains helper classes like Location and Trip. 
public class Location {

	private int x;
	private int y;

	public Location(int a, int b) {
		x=a;
		y=b;
	}

	public void set(int a, int b) {
		x = a;
		y = b;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ")";

	}
}
