/* Victor Zhen
 * 110520245
 * HW #3
 * CSE 214 R06
 * TA: Charles Chen
 * Graduate TA: 
 * @author Sun
 */
import java.util.Arrays;
import java.util.Comparator;

import big.data.*;

public class NeoDatabase {
	public static final String API_KEY = 
			"DgPOEYqawk7TV11b6X0hqJNBlt2v2xLAB8zMuTL7";
	public static final String API_ROOT = 
			"https://api.nasa.gov/neo/rest/v1/neo/browse?";
	private NearEarthObject[] neo;
	private DataSource ds;
	
	/* Default constructor
	 * @postconditions - the database has been constructed and is empty.
	 */
	public NeoDatabase(){
		neo = new NearEarthObject[0];
	}
	
	/* Builds a query URL given a page number.
	 * @pageNumber - integer ranging from 0 to 715, indicating where
	 * what page the user wants to load.
	 * @preconditions - page is between 0 and 715
	 * @throws IllegalArgumentException - if pageNumber is less than 0
	 * or greater than 715
	 */
	public String buildQueryURL(int pageNumber) 
			throws IllegalArgumentException{
		if(pageNumber<0 || pageNumber>715)
			throw new IllegalArgumentException();
		return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
	}
	
	/* Opens a connection to the data source using a given query URL
	 * and adds them all into the data set.
	 * @param1 queryURL - the URL to take the information from.
	 * @preconditions - queryURL is not null and represents a valid api request
	 * to the NASA NeoW service.
	 * @postconditions - all nearearthobjects have been appended to the data
	 * set, or an illegalargumentexception has been thrown
	 * @throws IllegalArgumentException - if queryURL is null or if
	 * the url does not link to the nasa neow service.
	 */
	public void addAll(String queryURL) throws IllegalArgumentException{
		if(queryURL == null)
			throw new IllegalArgumentException();
		//System.out.println(queryURL);
		ds = DataSource.connectJSON(queryURL);
		ds.load();
		//copy old array into new one?
		//neo = neoo;
		NearEarthObject[] newNeo = ds.fetchArray("NearEarthObject", 
				"near_earth_objects/neo_reference_id",
				"near_earth_objects/name",
				"near_earth_objects/absolute_magnitude_h",
				"near_earth_objects/estimated_diameter/"
				+ "kilometers/estimated_diameter_min",
				"near_earth_objects/estimated_diameter/"
				+ "kilometers/estimated_diameter_max",
				"near_earth_objects/is_potentially_hazardous_asteroid",
				"near_earth_objects/"
				+ "close_approach_data/epoch_date_close_approach",
				"near_earth_objects/"
				+ "close_approach_data/miss_distance/kilometers",
				"near_earth_objects/close_approach_data/orbiting_body"
				);
		NearEarthObject[] neoo = new NearEarthObject[neo.length+20];
		for(int i=0; i<neo.length; i++){
			neoo[i] = neo[i];
		}
		for(int i=0; i<newNeo.length; i++){
			neoo[i+neo.length] = newNeo[i];
		}
		neo = neoo;
	}
	
	/* Sorts the database using a certain comparator.
	 * @param1 comp - the comparator to use to compare the nearearthobjects
	 * @preconditions - comp is not null
	 * @postconditions - the database has been sorted based on comp
	 * @throws IllegalArgumentException - if comp is null
	 */
	public void sort(Comparator<NearEarthObject> comp)
			throws IllegalArgumentException{
		if(comp==null)
			throw new IllegalArgumentException();
		Arrays.sort(neo, comp);
	}
	
	/* Prints the database in a neatly manner.
	 * @preconditions - the current database is not null or empty
	 * @postconditions - the values in this database were 
	 * printed but not changed.
	 */
	@SuppressWarnings("deprecation")
	public void printTable(){
		System.out.printf("%-9s|%-14s|%-5s|%-24s|%-7s|%-11s|%-12s|%-7s", 
				"ID", "Name", "Mag.", "Diameter", "Danger", "Close Date", 
				"Miss Dist", "Orbits");
		System.out.println();
		for(int i=0; i<95; i++)
			System.out.print("=");
		System.out.println();
		if(neo.length!=0){
			for(NearEarthObject x: neo){
				System.out.printf("%-10s", x.getReferenceID());
				System.out.printf("%-15s", x.getName());
				System.out.printf("%-6s", x.getAbsoluteMagnitude());
				System.out.printf("%-25s", x.getAverageDiameter());
				System.out.printf("%-8s", x.isDangerous());
				System.out.printf("%-12s", 
						x.getClosestApproachDate().getMonth()+1
						+"-"+x.getClosestApproachDate().getDate()
						+"-"+(x.getClosestApproachDate().getYear()+1900));
				System.out.printf("%-13s", x.getMissDistance());
				System.out.printf("%-8s", x.getOrbitingBody());
				System.out.println();
			}
		}
		else{
			System.out.println("This database has not been instantiated yet");
		}
	}
}