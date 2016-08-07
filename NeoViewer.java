/* Victor Zhen
 * 110520245
 * HW #3
 * CSE 214 R06
 * TA: Charles Chen
 * Graduate TA: 
 * @author Sun
 */
import java.util.Comparator;
import java.util.Scanner;

public class NeoViewer {
	/* main method
	 * @param1 args - ???
	 */
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		NeoDatabase neoDatabase = new NeoDatabase();
		boolean isRunning = true;
		Comparator<NearEarthObject> comp;
		while(isRunning){
			System.out.println("\nOption Menu:\n" +
					"A) Add a page to the database\n" +
					"S) Sort the database\n" +
					"P) Print the database as a table.\n" +
					"Q) Quit");
			System.out.println("Select a menu option: ");
			String input = scan.nextLine();
			if(input.toLowerCase().equals("a")){
				System.out.println("Enter the page to load: ");
				int pageToLoad = scan.nextInt();
				scan.nextLine();
				try{
					neoDatabase.addAll(neoDatabase.buildQueryURL(pageToLoad));
					System.out.println("Page loaded successfully!");
				}
				catch(IllegalArgumentException e){
					System.out.println("Page not found :v");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(input.toLowerCase().equals("s")){
				System.out.println("R) Sort by referenceID\n" +
					 "D) Sort by diameter\n" +
					 "A) Sort by approach date\n" +
					 "M) Sort by miss distance");
				String resultOfS = scan.nextLine();
				if(resultOfS.toLowerCase().equals("r")){
					comp = new ReferenceIDComparator();
					neoDatabase.sort(comp);
					System.out.println("Table sorted by reference ID");
				}
				if(resultOfS.toLowerCase().equals("d")){
					comp = new DiameterComparator();	
					neoDatabase.sort(comp);
					System.out.println("Table sorted by diamaeter");
				}
				if(resultOfS.toLowerCase().equals("a")){
					comp = new ApproachDateComparator();
					neoDatabase.sort(comp);
					System.out.println("Table sorted by approach date");
				}
				if(resultOfS.toLowerCase().equals("m")){
					comp = new MissDistanceComparator();
					neoDatabase.sort(comp);
					System.out.println("Table sorted by missed distance");
				}
			}
			if(input.toLowerCase().equals("p")){
				neoDatabase.printTable();
			}
			if(input.toLowerCase().equals("q")){
				isRunning = false;
			}
		}
	}
}