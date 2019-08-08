# Cab_aggregation_system
This is a simulation of a cab aggregation model written in java, with basic GUI made with java swing. 

You can add different cars to the app with different kinds of speed. You can also create more parameters and test this model (Additional code has to be written)

The app consists of 2 inherited classes (Fleet and Car, derived from respective parent classes), 2 helper classes (Location and Trip) and 6 additional classes (App, Platform, Display, TextDisplay (derived), SwingDisplay(derived) and Demo) for running and testing. The model works on the concept of fleets. Each fleet can have n-number of preset cars. The app contains only 1 fleet class which is derived from the base fleet class. You can add more fleets (Additional code has to be written. New derived class for Car has to be written with different data members) with different parameters, synonymous to different kinds of cars available on cab aggregation platforms like Lyft, Uber, Ola etc.

## Usage 

In order to use the app, **make sure that you have the latest version of JDK (Java Development Kit) installed on your computer.**
you can get it <a href="http://www.oracle.com/technetwork/java/javase/downloads/index.html">here.</a>

* Download and unzip the repo into a folder
* Open a terminal inside the folder
* Run the following command
```
javac ./*.java && javac utility_classes/derived_classes/*.java && java Demo
```
* This will open a Swing GUI window with some cars with IDs and color assigned to them. Click at any 2 points, the first would be the customer pickup location and the second would be the drop location 
* Click on 'new trip'
* This is bring the nearest car to the pickup point, picks up the customer and takes him to the drop point


