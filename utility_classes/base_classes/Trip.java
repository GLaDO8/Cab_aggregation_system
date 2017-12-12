package utility_classes.base_classes;
//base_classes folder contains abstract classes for car and fleet class. It also contains helper classes like Location and Trip. 
public class Trip {
	private Location startLoc;
	private Location destLoc;

	public Trip(Location start, Location dest) {
		startLoc = start;
		destLoc = dest;
	}

	public Location getStart() {
		return startLoc;
	}

	public Location getDest() {
		return destLoc;
	}
}
