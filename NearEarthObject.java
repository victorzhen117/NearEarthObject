/* Victor Zhen
 * 110520245
 * HW #3
 * CSE 214 R06
 * TA: Charles Chen
 * Graduate TA: 
 * @author Sun
 */
import java.util.Date;

public class NearEarthObject {
	
	//instance variables
	private int referenceID;
	private String name;
	private double absoluteMagnitude;
	private double averageDiameter;
	private boolean isDangerous;
	private Date closestApproachDate;
	private double missDistance;
	private String orbitingBody;
	
	/* Default constructor
	 * @param1 referenceID - the id of the neo
	 * @param2 name - the name of the neo
	 * @param3 absoluteMagnitude - the brightness of the neo
	 * @param4 minDiameter - the min diameter of the neo
	 * @param5 maxDiameter - the max diameter of the neo
	 * @param6 isDangerous - boolean value determining whether or not
	 * the neo is a potential impact threat
	 * @param7 closestDateTimestamp - unix value representing the
	 * date of closest approach
	 * @param8 missDistance - distance of neo on closest date
	 * @param9 orbitingBody - the planet or orbiting body in which
	 * this neo orbits.
	 */
	public NearEarthObject(int referenceID, String name, 
			double absoluteMagnitude, double minDiameter, 
			double maxDiameter, boolean isDangerous, 
			long closestDateTimestamp, double missDistance, 
			String orbitingBody){
		this.referenceID = referenceID;
		this.name = name;
		this.absoluteMagnitude = absoluteMagnitude;
		this.averageDiameter = (minDiameter + maxDiameter)/2;
		this.isDangerous = isDangerous;
		this.closestApproachDate = new Date(closestDateTimestamp);
		this.missDistance = missDistance;
		this.orbitingBody = orbitingBody;
	}
	
	/* Getter for reference ID
	 * @returns - value of referenceid
	 */
	public int getReferenceID() {
		return referenceID;
	}

	/* setter for refernece ID
	 * @param1 referenceID - the value to replace the instance variable's
	 */
	public void setReferenceID(int referenceID) {
		this.referenceID = referenceID;
	}

	/* Getter for name
	 * @returns - value of name
	 */
	public String getName() {
		return name;
	}

	/* Setter for name
	 * @param1 name - the value to replace the instance variables.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* Getter for absolute magnitude
	 * @returns - value of aboslutemagnitude
	 */
	public double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	/* Setter for absolute magnitude
	 * @param1 absolutemagnitude - the value to replace absolutemagnitude
	 */
	public void setAbsoluteMagnitude(double absoluteMagnitude) {
		this.absoluteMagnitude = absoluteMagnitude;
	}

	/* Getter for averagediameter
	 * @returns - the value of average diameter
	 */
	public double getAverageDiameter() {
		return averageDiameter;
	}

	/* Setter for averagediameter
	 * @param1 averageDiameter - the value to replace averagediameter
	 */
	public void setAverageDiameter(double averageDiameter) {
		this.averageDiameter = averageDiameter;
	}

	/* Getter for isdangerous
	 * @returns - value of boolean variable isdangerous
	 */
	public boolean isDangerous() {
		return isDangerous;
	}

	/* setter for isdangerous
	 * @param1 isdangerous - value to replace isDangerous
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}

	/* Getter for closest approach date
	 * @returns - value of closestapproachdate
	 */
	public Date getClosestApproachDate() {
		return closestApproachDate;
	}

	/* Setter for closestapproachdate
	 * @param1 closestApproachDate - the value to replace the instance variable
	 */
	public void setClosestApproachDate(Date closestApproachDate) {
		this.closestApproachDate = closestApproachDate;
	}

	/* Getter for missdistance
	 * @returns - the value of missDistance
	 */
	public double getMissDistance() {
		return missDistance;
	}

	/* Setter for missdistance
	 * @param1 missdistance - the value to replace missdistance
	 */
	public void setMissDistance(double missDistance) {
		this.missDistance = missDistance;
	}

	/* Getter for orbitingbody
	 * @returns - the value of orbitingBody
	 */
	public String getOrbitingBody() {
		return orbitingBody;
	}

	/* Setter for orbitingBody
	 * @param1 orbitingBody - the value to rpelace orbitingBody
	 */
	public void setOrbitingBody(String orbitingBody) {
		this.orbitingBody = orbitingBody;
	}
}