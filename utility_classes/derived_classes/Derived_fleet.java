package utility_classes.derived_classes;
import utility_classes.base_classes.*;
import java.util.*;
import java.lang.*;

public class Derived_fleet extends Fleet {
	private ArrayList<Car> carlist = new ArrayList<Car>();
	private int count;

	public Derived_fleet(String colour){
		super(16122,colour);
	}

	@Override
	public void addCar(int speed){
		Car car = new Derived_car(Integer.parseInt("00000"+count),speed);
		carlist.add(car);
		count++;
	}

	//this method finds the nearest car from the start location which the customer requests.
	@Override
	public Car findNearestCar(Location loc){
		int carform; int index = -1; int smallest = Integer.MAX_VALUE;
		for(int i=0; i<carlist.size(); i++){
			carform = carlist.get(i).distSqrd(loc);
				if(carlist.get(i).getStatus()==1){
					if(carform < smallest){
						smallest = carform;
						index = i;
					}
				}
			}
		if(index == -1){
			return null;
		}
		else{
			return carlist.get(index);
		}
	}

	public ArrayList<? extends Car> getCars(){
		return carlist;
	}
}
