package utility_classes.derived_classes;
import java.lang.*;
import utility_classes.base_classes.*;

class Derived_car extends Car{
	//when we create a new car, we automatically set the status as idle(1).
	private int status=1;
	private Location lxy;
	private Trip currenttrip;

	//we are gonna have int fid as a parameter here for passing the car id. this will be provided in the fleet class.
	public Derived_car(int fid, int speed){
		super(fid,speed);
		//we set the default location of the car to (0,0) when we create a new car.
		lxy = new Location(0,0);
	}

	@Override
	public void setLocation(Location l){
		lxy = l;
	}

	@Override
	public Trip getTrip(){
		return currenttrip;
	}

	@Override
	public int distSqrd(Location loc){
		int dist = 1; dist*=Math.pow(loc.getX()-lxy.getX(),2) + Math.pow(loc.getY()-lxy.getY(),2);
		return dist;
	}

	@Override
	public Location getLocation(){
		return lxy;
	}

	//getter and setter functions for status.
	@Override
	public void setStatus(int s){
		this.status = s;
	}

	@Override
	public int getStatus(){
		return status;
	}

	@Override
	public void assignTrip(Trip trip){
		currenttrip = trip;
		//when we assign a trip, we change the car status automatically to 2.
		status=2;
	}

	//getter functions for the start point and end point of a trip.
	@Override
	public Location getStart(){
		return currenttrip.getStart();
	}

	@Override
	public Location getDest(){
		return currenttrip.getDest();
	}

	//update location function updates the location of the car constantly after every deltaT seconds. This is necessary to see movement of the car in the GUI and for further calculations. 
	@Override
	public void updateLocation(double deltaT){
		int xdist = lxy.getX(); int ydist = lxy.getY();
		// if the car is idle (status=1), just come out of the loop with return (no need to update the location)
		if(getStatus()==1){
			return;
		}
		//if status is 2, it has been booked, so it has to go to the pickup point which is the current location to the startpoint of the trip.
		else if(getStatus()==2){
			// this is to make sure that the hop made by the car (the distance it travels in deltaT time is less than the actual distance left)
			if(maxSpeed*deltaT<Math.sqrt(distSqrd(currenttrip.getStart()))){
				xdist+=(currenttrip.getStart().getX()-lxy.getX())*maxSpeed*(deltaT)/Math.sqrt(distSqrd(currenttrip.getStart()));
				ydist+=(currenttrip.getStart().getY()-lxy.getY())*maxSpeed*(deltaT)/Math.sqrt(distSqrd(currenttrip.getStart()));
				lxy.set(xdist,ydist);
			}
			else{
				//this is when the hop is greater than the actual distance. we blindly set the location to the start location.
				lxy.set(currenttrip.getStart().getX(), currenttrip.getStart().getY());
				// as the car has reached the pickup point, the trip will start, so the status is changed to 3.
				status=3;
			}

		}
		//if status is 3, it is on trip,  so it has to go from the startpoint of the trip to the destination.
		else if(getStatus()==3){
				// this is to make sure that the hop made by the car (the distance it travels in deltaT time is less than the actual distance left)
			if(maxSpeed*(deltaT)<Math.sqrt(distSqrd(currenttrip.getDest()))){
				xdist+=(currenttrip.getDest().getX()-lxy.getX())*maxSpeed*(deltaT)/Math.sqrt(distSqrd(currenttrip.getDest()));
				ydist+=(currenttrip.getDest().getY()-lxy.getY())*maxSpeed*(deltaT)/Math.sqrt(distSqrd(currenttrip.getDest()));
				lxy.set(xdist,ydist);
			}
			else{
				//this is when the hop is greater than the actual distance. we blindly set the location to the destination location.
				lxy.set(currenttrip.getDest().getX(), currenttrip.getDest().getY());
				// as the car has finished the trip, we set the status to idle.
				status=1;
			}
		}
	}
}
