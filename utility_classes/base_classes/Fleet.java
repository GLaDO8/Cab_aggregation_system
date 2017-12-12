package utility_classes.base_classes;
//base_classes folder contains abstract classes for car and fleet class. It also contains helper classes like Location and Trip.
import java.util.ArrayList;

public abstract class Fleet {
	private int id;
	private String colour;

	protected Fleet(int fid, String col){
		id = fid;
		colour = col;
	}

	public int getId() {
		return id;
	}

	public String getColour() {
		return colour;
	}

	// creates a new car (consistent with its derived type) and adds it to its list of cars
	public abstract void addCar(int speed);
	public abstract Car findNearestCar(Location loc);
	public abstract ArrayList<? extends Car> getCars();
}
