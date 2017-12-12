import java.util.ArrayList;
import utility_classes.base_classes.*;
public class Platform{
	ArrayList<Fleet> fleetlist = new ArrayList<Fleet>();
	public Platform(){}

	public void addFleet(Fleet f){
		fleetlist.add(f);
	}

	// for a request defined as a Trip, find the best car by checking each of its fleets and assigns the car. to this trip
	public Car assignCar(Trip trip){
		int carform; int index = 0; int smallest = Integer.MAX_VALUE;
		ArrayList<Car> bestcarlist = new ArrayList<Car>();
		for(int i=0; i<fleetlist.size(); i++){
			bestcarlist.add(fleetlist.get(i).findNearestCar(trip.getStart()));
		}
		for(int i=0; i<bestcarlist.size(); i++){
			carform = bestcarlist.get(i).distSqrd(trip.getStart());
				if(bestcarlist.get(i).getStatus()==1){
					if(carform < smallest){
						smallest = carform;
						index = i;
					}
				}
			}
		bestcarlist.get(index).assignTrip(trip);
		return bestcarlist.get(index);
	}

	// returns list of all cars (in all the fleets) managed by this platform
	public ArrayList<Car> findCars() {
		ArrayList<Car> carlistfinal = new ArrayList<Car>();
		for(int i=0; i<fleetlist.size(); i++){
			carlistfinal.addAll(fleetlist.get(i).getCars());
		}
		return carlistfinal;
	}
}
