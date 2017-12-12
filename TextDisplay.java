import utility_classes.base_classes.*;
//this class can be used if you want to troubleshoot the program via CLI.
public class TextDisplay extends Display {
	public TextDisplay(){}
	public void init(){
		System.out.println("Starting new simulation");

	}
	public void draw(Car car) {
		System.out.println("Car"+car.getId() + " at " + car.getLocation());
	}

	public void drawLine(Location a, Location b) {
		System.out.println("Line from " + a + " to " + b);
	}
}
