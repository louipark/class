//UIUC CS125 FALL 2012 MP. File: RobotLink.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
/**
 * 
 * @author lzhou8
 */
public class RobotLink {

	private RobotLink next; 	
	private final Robot robot;

	public Robot getRobot() {
		return robot;
	}
	/** Constructs this link.
	 * @param next ; the next item in the chain (null, if there are no more items).
	 * @param robot ; a single robot (never null).
	 */
	public RobotLink(RobotLink next,Robot robot) {
		this.robot = robot;
		this.next = next;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int count() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.count();
	}
	/**
	 * Counts the number of flying robots in the linked list.
	 * Hint: robot.isFlying is useful here.
	 */
	public int countFlyingRobots() {          
		if(next == null){
        if(robot.isFlying()) return 1;
        else return 0;}
        
		else{
        if(robot.isFlying()) return 1+next.countFlyingRobots();
        else return next.countFlyingRobots();}
}

	
	/**
	 * Counts the number of flying robots upto and excluding a sad robot.
	 * (i.e. do not count the sad robot if it is flying).
	 * If there are no sad robots this function will return the same value as countFlyingRobots().
	 * Hint: robot.isHappy() is useful.
	 */
	public int countFlyingRobotsBeforeSadRobot() {
        if (next == null) return (robot.isHappy() && robot.isFlying()) ? 1 : 0; 
        if (!robot.isHappy()) return 0;
        int count = 0;
        if (robot.isFlying()) count++;
       
        count += next.countFlyingRobotsBeforeSadRobot();
        return count;
	}
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param robot - the robot value of the new last link
	 */
	public void append(Robot robot) {
        if(next == null) next=new RobotLink(null,robot);
 
        else next.append(robot);
	}
	/**
	 * Returns the first flying unhappy robot, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getFirstFlyingUnhappyRobot() {
        if(next == null) return null;
        if(robot.isFlying() && !robot.isHappy()) return robot;
        else  return next.getFirstFlyingUnhappyRobot();
	}
	/**
	 * Returns the last flying unhappy robotn the linked list, or null
	 * if there are not robots that are flying and unhappy.
	 * @return
	 */
	public Robot getLastFlyingUnhappyRobot() {
		 if (next == null && (!this.getRobot().isFlying() || this.getRobot().isHappy())) return null;
         if (robot.isFlying() && !robot.isHappy() && next.getLastFlyingUnhappyRobot() == null)
         return this.robot;
   
    return next.getLastFlyingUnhappyRobot();
	}
	/**
	 * Returns a reference to the happy most distant explorer.
	 * Returns null if there are no happy robots
	 * @return reference to the most distant happy robot
	 */
	public Robot findHappyRobotFurthestFromHome() {
        if (next == null && (!this.getRobot().isHappy())) return null;
        if (this.getRobot().isHappy()) {
            if (next.getRobot().getDistanceFromHome() > this.getRobot().getDistanceFromHome())
                        return next.findHappyRobotFurthestFromHome();
        }
        return this.getRobot();
	}
	/**
	 * Returns true if linked list contains the robot.
	 * Hint: Use robot.equals(other).
	 * @param robot
	 * @return
	 */
	public boolean contains(Robot other) {
		if (next == null && !this.getRobot().equals(other)) return false;
        if (this.robot.equals(other))  return true;
        return next.contains(other);

	}

	
}
