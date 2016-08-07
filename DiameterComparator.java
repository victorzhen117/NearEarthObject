/* Victor Zhen
 * 110520245
 * HW #3
 * CSE 214 R06
 * TA: Charles Chen
 * Graduate TA: 
 * @author Sun
 */
public class DiameterComparator implements 
java.util.Comparator<NearEarthObject>{

	/* compares two nearearth objects based on diameter
	 * @param o1 - the first object to compare to the second
	 * @param o2 - the second object to compare to the first
	 * @preconditions - o1 and o2 are declared
	 * @postconditions - 0, 1, or -1 is returned.
	 */
	@Override
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		// TODO Auto-generated method stub
		if(o1.getAverageDiameter()>o2.getAverageDiameter())
			return 1;
		else if(o1.getAverageDiameter()<o2.getAverageDiameter())
			return -1;
		return 0;
	}

}
