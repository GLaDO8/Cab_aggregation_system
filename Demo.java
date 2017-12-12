import java.util.ArrayList;
import utility_classes.base_classes.*;
// import each of the fleets to be considered in the simulation
import utility_classes.derived_classes.Derived_fleet;

public class Demo {
	public static void main(String[] args) {
		Platform pf = new Platform();
		//Display disp = new TextDisplay();
		Display disp = new SwingDisplay();
		App app = new App(pf, disp);
		ArrayList<Fleet> fleets = new ArrayList<Fleet>(); //can be used if you want multiple fleets.

		Fleet f1 = new Derived_fleet("blue"); // note: colour currently not used by Display
		pf.addFleet(f1);
		fleets.add(f1);

		// instantiate cars for the fleets
		int j = 1;
		for(Fleet fleet: fleets) {
			for (int i = 0; i < 5; i++) {
				fleet.addCar(20 + i); // add cars, assigning max speed to each car
			}

			ArrayList<? extends Car> cars = fleet.getCars();
			for (int i = 0; i < cars.size(); i++) {
				cars.get(i).setLocation(new Location(j * 40, i * 50 + 10*j));
			}
			j++;
		}

		// start the app - populate the display and run the simulation
		app.init();
	}
}
