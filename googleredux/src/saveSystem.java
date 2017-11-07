
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



//THANKS TO CRUNCHIFY FOR THE BASE CODE AND THE LINK TO THE JASON
// SIMPLE JAR

public class saveSystem {

	static studyModel model;
	static String[] entered;
	static String[] responcesLocation;
	static String[] responcesRecall;
	static String[] correctKeys;
	static String[] correctLoc;
	static double[] timeLoc;
	static double[] timeFact;
	/**
	 * 
	 * @return current time stamp
	 */
	public static String getCurrentTimeStamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

	}

	/**
	 * Save the State of the game by saving all team names, team steps and
	 * player names
	 * 
	 * @param game
	 *            game to be saved, and statement to save, input location string, and input recall string
	 * @throws IOException
	 */
	public static void save(studyModel game, String[] inputEntered, String[] inputLocation, String[] inputRecall, String[] savedLocations, double[] timeLocation, double[] timeFact2) throws IOException {
		model = game;
		entered = inputEntered;
		responcesLocation = inputLocation;
		responcesRecall = inputRecall;
		correctLoc = savedLocations;
		saveSystem.timeLoc = timeLocation;
		saveSystem.timeFact = timeFact2;
		saveOut();
	}

	

	
	
	@SuppressWarnings("unchecked")
	/**
	 * Outputs the save file to an actual file
	 * @throws IOException
	 */
	public static void saveOut() throws IOException {
		JSONObject obj = new JSONObject();
		// saves the day

		JSONArray cStatements = new JSONArray();
		JSONArray eStatements = new JSONArray();
		JSONArray whereReply = new JSONArray();
		JSONArray recallReply = new JSONArray();
		JSONArray cKeys = new JSONArray();
		JSONArray cLocation = new JSONArray();
		JSONArray timeLocation = new JSONArray();
		JSONArray timeFactRecall = new JSONArray();
		JSONArray pairedFact  = new JSONArray();
		JSONArray pairLoc = new JSONArray();
		JSONArray codedFact = new JSONArray();
		JSONArray codedLoc = new JSONArray();
		// save coded facts
		
		
		
		// save correct statements
		for (int i = 0; i < model.getStatements().length; i++) {
			cStatements.add(model.getStatement(i));
		}
		// saves entered statements
		for (int i = 0; i < entered.length; i++) {
			eStatements.add(entered[i]);
		}
		// saves where statements
		for (int i = 0; i< responcesLocation.length; i++){
			whereReply.add(i +"# " + responcesLocation[i]);
		}
		// saves recall statement
		for (int i = 0; i< responcesRecall.length; i++){
			recallReply.add(i + "# "+ responcesRecall[i]);
		}
		for (int i=0;i < model.getKeys().length;i++){
			cKeys.add(model.getKey(i));
			
		}
		for (int i=0; i < correctLoc.length;i++){
			cLocation.add(" # " + correctLoc[i] + " " + model.getKey(i));
		}
		for (int i=0; i < timeLoc.length;i++){
			timeLocation.add( timeLoc[i]);
		}
		for (int i=0; i < timeFact.length;i++){
			timeFactRecall.add(  timeFact[i]);
		}
		for (int i=0; i < correctLoc.length; i++){
			pairedFact.add( responcesRecall[i] +" : " + model.getStatement(i) );
		}
		for (int i=0; i < correctLoc.length; i++){
			pairLoc.add(responcesLocation[i] +" : " +  correctLoc[i] );
		}
	


		// puts the objects with a title;
		obj.put("CORRECT STATEMENTS ", cStatements);
		//obj.put("ENTERED STATEMENTS", eStatements);
		//obj.put("CORRECT KEYS",cKeys);
		obj.put("ENTERED LOCATIONS ", whereReply);
		obj.put("CORRECT LOCATIONS ", cLocation);
		obj.put("ENTERED RECALL ", recallReply);
		obj.put("Recall Time for Facts ", timeFactRecall);
		obj.put("Recall Time for Locations ", timeLocation);
		obj.put("PAIRED STATEMENTS(Recall,Correct) ", pairedFact);
		obj.put("PAIRED LOCATIONS(Recall,Correct) ", pairLoc);
	
		
		
		// writes the file to file1.txt
		FileWriter file = new FileWriter(getCurrentTimeStamp()+".txt");
		try {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			file.flush();
			file.close();
		}
	}

	/**
	 * prints a save file
	 */
	/**
	public static void printSave() {
		@SuppressWarnings("unchecked")
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader(
					"/Users/joelnathaniel/Documents/file1.txt"));
			String name = "";
			String author = "";
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray teamList = (JSONArray) jsonObject.get("Team List");
			JSONArray stepList = (JSONArray) jsonObject.get("Team Steps");
			JSONArray playerList = (JSONArray) jsonObject.get("Player Names");
			System.out.println("Name: " + name);
			System.out.println("Author: " + author);
			System.out.println("\nCompany List:");
			Iterator<String> iterator = teamList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			Iterator<String> iterator2 = stepList.iterator();
			while (iterator2.hasNext()) {
				System.out.println(iterator2.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 **/


}

