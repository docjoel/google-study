
import java.util.Arrays;


public class shuffler {

	public static  String[] statements = new String[30];{
		for (int i = 0; i < statements.length; i++) {
			statements[i] = "";
		}
	}
	public static String[] topFile = new String[6];{
		for (int i = 0; i< topFile.length; i++){
			topFile[i]= "";
		}
	}
	public static String[] lowFile= new String[5];{
		for (int i = 0; i< lowFile.length; i++){
			lowFile[i]= "";
		}
	}
	public static String[] key = new String [30];{
		for (int i = 0; i < key.length; i++){
			key[i]="";
		}
	}
	


	/** sets orginal order of statements **/
	public static void setStatements(){
		statements[0] = "Saddam Hussein has been executed";
		statements[1] ="Greenland is the world's largest island by area.";
		statements[3] ="The Tsunami disaster in Asia occurred in December 2004.";
		statements[4]="A cow produces nearly 200,000 glasses of milk in her lifetime.";
		statements[5] ="Bluebirds cannot see the color blue.";
		statements[6] =	"Michael Jackson was acquitted of molestation charges.";
		statements[7]= "Only two countries border three oceans, the United States and Canada.";
		statements[8]="There was a terrorist bombing in the subways of London in July 2005.";
		statements[9]="There have been 44 presidents of the United States.";
		statements[10]="Ingrown toenails are hereditary.";
		statements[11]="ABC news anchor Peter Jennings was a high school dropout from Canada.";
		statements[12]="Pope Benedict XVI deserted the German Army during World War II.";
		statements[13]="The highest point in Pennsylvania is lower than the lowest point in Colorado.";
		statements[14]="Europe is the only continent without a desert.";
		statements[15]="The collapse of the Larsen B ice shelf in Antarctica began in January 2002.";
		statements[16]="The space shuttle Columbia disintegrated during re-entry over Texas in Feb 2003.";
		statements[17]=	"The international telephone dialing code for Antarctica is 672.";
		statements[18]="A quarter has 119 grooves around the edge.";
		statements[19]="Rubber bands last longer when refrigerated.";
		statements[20]="French Fries are originally from Belgium, not France.";
		statements[21]="Al Capone's business card said he was a used furniture dealer.";
		statements[22]=	"Without glasses, John Lennon was legally blind all of his life.";
		statements[23]="The Atlantic Ocean is saltier than the Pacific Ocean.";
		statements[24]="The Dominican Republic has the only national flag with a bible in it.";
		statements[25]="The Live 8 concerts took place in the G8 nations and South Africa in July 2005.";
		statements[26]="The NATO bombing of Yugoslavia began in March 1999.";
		statements[27]="There are an average of 178 sesame seeds on a McDonald's Big Mac bun.";
		statements[28]="In Chinese script, there are more than 40,000 characters.";
		statements[29]="An ostrich's eye is bigger than its brain.";
		statements[2]="A person burns more calories when sleeping than when watching television.";
	}
	public static void setKey(){
		key[0] = "Saddam Hussein";
		key[1] ="Greenland";
		key[3] ="Tsunami disaster";
		key[4] = "A Cow";
		key[5] ="Bluebirds";
		key[6] = "Michael Jackson";
		key[7] = "United States and Canada";
		key[8] ="Terrorist Bombing";
		key[9] ="Presidents";
		key[10]="Ingrown Toenails";
		key[11]="Peter Jennings";
		key[12]="Pope Benedict XVI";
		key[13]="Pennsylvania";
		key[14]="Europe";
		key[15]="Larsen B";
		key[16]="Columbia";
		key[17]="Antarctica 672";
		key[18]="Quarter";
		key[19]="Rubber bands";
		key[20]="French Fries";
		key[21]="Al Capone’s business card";
		key[22]="John Lennon";
		key[23]="Atlantic Ocean";
		key[24]="Dominican Republic";
		key[25]="Live 8 concerts";
		key[26]="NATO bombing";
		key[27]="Big Mac bun";
		key[28]="Chinese script";
		key[29]="Ostrich";
		key[2]="Calories";	
	}
	
	public static String[] shuffledKey = new String[30];{
		for (int i = 0; i< shuffledKey.length; i++){
			shuffledKey[i]="";
		}
	}
	
	public static  void setShuffledKey() {
		String temp;
		setKey();
		shuffledKey = key;
		int ran ;
		for (int i = 29; i > 0; i--) {
			temp = shuffledKey[i];
			ran = StdRandom.uniform(i + 1);
			shuffledKey[i] = shuffledKey[ran];
			shuffledKey[ran] = temp;
		}
	}
	
	public static String[] getShuffledKeys(){
		setShuffledKey();
		return shuffledKey;
	}
	
	public static String getShuffledKey(int i){
		setShuffledKey();
		return shuffledKey[i];
	}
	public static String getFileKey(int i){
		setKey();
		setStatements();
		setShuffledStatements();
		return shuffledKey[i];
	}
	public static String[] getFileKeys(){
		setKey();
		setStatements();
		setShuffledStatements();
		return shuffledKey;
	}
	
	
	
	/**
	 *  establishes the shuffled statements
	 */
	private static String[] shuffledStatements= new String[30];{
		for (int i = 0; i < shuffledStatements.length; i++) {
			shuffledStatements[i] = "";
		}
	}
	/** returns statements in shuffled order **/
	public static String[] getShuffledStatements() {
		setStatements();
		setShuffledStatements();
		return shuffledStatements;
	}
	/** shuffles statements **/
	public static  void setShuffledStatements() {
		String temp;
		String tempKey;
		setStatements();
		setKey();
		shuffledStatements = statements;
		shuffledKey = key;
		int ran ;
		for (int i = 29; i > 0; i--) {
			temp = shuffledStatements[i];
			tempKey = shuffledKey[i];
			ran = StdRandom.uniform(i + 1);
			shuffledStatements[i] = shuffledStatements[ran];
			shuffledKey[i]=shuffledKey[ran];
			shuffledStatements[ran] = temp;
			shuffledKey[ran]=tempKey;
		}
	}
	/**
	 * sets the top file with names
	 */
	public static void setTopFile(){
		topFile[0]="DATA";
		topFile[1]="INFO";
		topFile[2]="NAMES";
		topFile[3]="ITEMS";
		topFile[4]="POINTS";
		topFile[5]="FACTS";

	}
	/**
	 * establishes the shuffledTopFile order
	 */


	public static String[] shuffledTopFile = new String[6];{
		for(int i = 0; i < shuffledTopFile.length; i++  ){
			shuffledTopFile[i]="";
		}
	}

	/**
	 * shuffles the TopFile
	 */
	public static void setShuffledTopFile(){
		String temp;
		setTopFile();
		shuffledTopFile = topFile;
		int ran ;
		for (int i = 5; i > 0; i--) {
			temp = shuffledTopFile[i];
			ran = StdRandom.uniform(i + 1);
			shuffledTopFile[i] = shuffledTopFile[ran];
			shuffledTopFile[ran] = temp;
		}
	}

	/**
	 * 
	 * @return shuffled top file
	 */
	public static String[] getShuffledTopFile() {
		setTopFile();
		setShuffledTopFile();
		return shuffledTopFile;
	}
/**
 * sets Low File with initial values
 */

	public static void setLowFile(){
		lowFile[0]="F1";
		lowFile[1]="F2";
		lowFile[2]="F3";
		lowFile[3]="F4";
		lowFile[4]="F5";		
	}
	
	
	
	
	
	
/**
 * inizalizes shuffledLowFile	
 */
	public static String[] shuffledLowFile = new String[5];{
		for(int i = 0; i < shuffledLowFile.length; i++  ){
			shuffledLowFile[i]="";
		}
	}
	/**
	 * sets shuffled Low File
	 */
	public static void setShuffledLowFile(){
		String temp;
		setLowFile();
		shuffledLowFile = lowFile;
		int ran ;
		for (int i = 4; i > 0; i--) {
			temp = shuffledLowFile[i];
			ran = StdRandom.uniform(i + 1);
			shuffledLowFile[i] = shuffledLowFile[ran];
			shuffledLowFile[ran] = temp;
		}
		
	}
	/**
	 * 
	 * @return shuffledLowFile array
	 */
	public static String[] getShuffledLowFile(){
		setLowFile();
		setShuffledLowFile();
		return shuffledLowFile;
	}
	
	public static void main(String[] args) {

		System.out.println(Arrays.toString(getShuffledStatements()));
		System.out.println(Arrays.toString(getShuffledTopFile()));
		System.out.println(Arrays.toString(getShuffledLowFile()));
		

	}




}




