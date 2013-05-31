package oop;

public class Elevator {

	/**
	 * http://kargs.net/elevator.html
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/*The scheduling will be like:

if available pick a standing elevator for this floor.
else pick an elevator moving to this floor.
else pick a standing elevator on an other floor.
else pick the elevator with the lowest load(directions).
 * 
 * */

class ElevatorEntry{
	//key track of current floor position, current direction, and state of operation.
	//list of destination.
	public enum directions{
		up, down, idle, maintainance;
	}
	
	public enum status{
		dooropen, doorclose;
	}
	
	public int curFloor;
	public directions curdirect;
	public int elevatorid;
	
	public int maxfloor, minfloor;
	
	public void load_passengers(){
		
	}
	
	public void unload_passengers(){
		
	}
}

class passenger{
	//Keep track of the destination floor.
	public int curFloor;
	public int targetFloor;
	
}