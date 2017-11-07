import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Timer;

// sound system by https://stackoverflow.com/questions/2258066/java-run-a-function-after-a-specific-number-of-seconds
// Program written by Joel Schooler
//Thanks to standard library


public class googlemain {

	private static String hint = "DESKTOP/DOWNLOADS/M1/FileName.txt";
	/** The text currently being entered by the user. */
	private static   String textBeingEntered;

	/**
	 * text that is used to display the current information the user must
	 * interact with
	 */
	private static   String label;
	/** Displays information at the top of the screen, giving state of the game **/
	private String[] statementList = shuffler.getShuffledStatements();
	/**
	 * user entered statements
	 */
	public String[] enteredStatements= new String[30];{

		for (int i = 0; i< enteredStatements.length; i++){
			enteredStatements[i]= "";
		}}
	public String[] enteredLocations = new String[30];{
		for (int i = 0; i< enteredLocations.length; i++){
			enteredLocations[i]= "";
		}}
	public String[] enteredRecall = new String[30];{
		for (int i = 0; i< enteredRecall.length; i++){
			enteredRecall[i]= "";
		}}
	public String[] savedLocations = new String[30];{
		for(int i = 0; i < savedLocations.length; i++){
			savedLocations[i]= "";
		}}
	public double[] timeLocation = new double[30];{
		for(int i = 0; i < timeLocation.length; i++){
			timeLocation[i]= 0;
		}}
	public double[] timeFact = new double[30];{
		for(int i = 0; i < timeFact.length; i++){
			timeFact[i]= 0;
		}}

	public static void main(String args[]) {
		StdDraw.setCanvasSize(1000, 700);
		// citation
		// http://en.wikipedia.org/wiki/Lewis_and_Clark_Expedition#/media/File:Carte_Lewis_and_Clark_Expedition.png
		new googlemain().run();
	}
	private studyModel model;
	/** constructor **/
	public  googlemain(){
		model = new studyModel();
		textBeingEntered = "";
	}

	public static int counter;
	/** runs the program **/
	public   void run(){
		counter = 0;
		// create base files

		new File("ITEMS").mkdirs();
		new File("ITEMS/F1").mkdirs();
		new File("ITEMS/F2").mkdirs();
		new File("ITEMS/F3").mkdirs();
		new File("ITEMS/F4").mkdirs();
		new File("ITEMS/F5").mkdirs();
		new File("FACTS").mkdirs();
		new File("FACTS/F1").mkdirs();
		new File("FACTS/F2").mkdirs();
		new File("FACTS/F3").mkdirs();
		new File("FACTS/F4").mkdirs();
		new File("FACTS/F5").mkdirs();
		new File("POINTS").mkdirs();
		new File("POINTS/F1").mkdirs();
		new File("POINTS/F2").mkdirs();
		new File("POINTS/F3").mkdirs();
		new File("POINTS/F4").mkdirs();
		new File("POINTS/F5").mkdirs();
		new File("DATA").mkdirs();
		new File("DATA/F1").mkdirs();
		new File("DATA/F2").mkdirs();
		new File("DATA/F3").mkdirs();
		new File("DATA/F4").mkdirs();
		new File("DATA/F5").mkdirs();
		new File("NAMES").mkdirs();
		new File("NAMES/F1").mkdirs();
		new File("NAMES/F2").mkdirs();
		new File("NAMES/F3").mkdirs();
		new File("NAMES/F4").mkdirs();
		new File("NAMES/F5").mkdirs();
		new File("INFO").mkdirs();
		new File("INFO/F1").mkdirs();
		new File("INFO/F2").mkdirs();
		new File("INFO/F3").mkdirs();
		new File("INFO/F4").mkdirs();
		new File("INFO/F5").mkdirs();
		hint ="";
		label="Welcome to the HCI experiemt on the effect of saving files on memory, if you have signed the informed consent press enter";
		String pressed = readString();	
		draw();
		label ="";
		// runs set up
		setUPText();
		// makes WW2 file
		try {
			new FileWriter("WW2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hint = "path Notation Format: DESKTOP/DOWNLOADS/F1/FILENAME.txt";
		label = "Please put WW2.txt located on the DESKTOP, into the POINTS folder and then put it into folder F1, when done hit enter";
		pressed = readString();
		label = "Where is  WW2.txt located in path notation? You may go look for it.";
		pressed = readString();	
		draw();
		// checks to make sure they entered the right file name
		Boolean correct = false;
		while (correct == false){
			if (pressed.equalsIgnoreCase("DESKTOP/POINTS/F1/WW2.txt")){
				correct = true;
			}
			else {
				label = "incorrect, the correct answer is Desktop/POINTS/F1/WW2.txt";
				pressed = readString();
				label = "Where is WW2.txt located in path notation?";
				pressed = readString();
				draw();
			}

		}


		correct = false;
		label =  "correct";
		pressed = readString();
		try {
			new FileWriter("problemset2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		label = "Please put problemset2.txt located on the DESKTOP, into the ITEMS folder, and then into folder F2, when done hit enter"; 
		pressed = readString();
		label ="Where is problemset2.txt located in file root notation? You may go look for it.";
		pressed = readString();
		// checks for file name
		while (correct == false){
			if (pressed.equalsIgnoreCase("DESKTOP/ITEMS/F2/problemset2.txt")){
				correct = true;
			}
			else {
				label = "incorrect, the correct answer is Desktop/ITEMS/F2/problemset2.txt";
				pressed = readString();
				label ="Where is problemset2.txt located in path notation?";
				pressed = readString();
				draw();
			}
		}
		label = "correct";
		
		correct = false;
		pressed = readString();
			
		draw();
		try {
			new FileWriter("NFLTeams.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label = "Please put NFLTeams.txt into data, and then F1";
		pressed = readString();
		label ="Now please look for the NFLTeams.txt, when found say found and click enter";
		pressed = readString();
		
		try {
			new FileWriter("DraftForFinal.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label = "please put DraftforFinal.txt into facts, and then put it in F3";
		pressed = readString();
		label = "Now please look for DraftForFinal.txt, when found say found and click enter";
		pressed = readString();
		
		label = "In this study we will show you 30 statements, you will be asked to type and save them, you will not have acsess to them later";
		pressed = readString();
		draw();
		label = "Type the statement as you see it and hit enter to save, then follow the instructions on the screen";
		pressed = readString();
		// primary learning loop
		hint ="Type the statement as you see it and hit enter to save";
		for(int i =0; i < 30; i++ ){
			// prints statement
			label= model.getStatement();
			draw();
			// gets input
			pressed = readString();
			enteredStatements[i]=pressed;
			draw();
			//check input and record
			//tells the particant to put file in appropreate file
			int topNumber= StdRandom.uniform(5);
			int lowNumber = StdRandom.uniform(4);
			label = model.getLocation(topNumber, lowNumber);
			savedLocations[i]=model.LocationShortHand(topNumber, lowNumber);
			draw();
			pressed = readString();;
			//save file to desktop			
			// advances to next statment
			counter++;
			model.advStatement();
		}
		// run the recall loop
		hint ="path notation format: desktop/TopFileName/F#/name of file.txt";
		// change this
		label = "You will now be asked to recall both the location and the fact, when done or if you don't know, hit enter";
		pressed = readString();
		draw();
		for(int i = 0; i<30;i++){
			int ranDecison; 
			// generates random number 
			ranDecison = StdRandom.uniform(100);
			// checks random number to see if number is less than 50, then Where first?
			if (ranDecison<50){
				if(ranDecison < 25){
					label = "where is "+ model.getKey(i) + " located in path notation? do not look for it, when done hit enter.";
					draw();
					// start timer
					long start = System.currentTimeMillis();
					Timer timer1 = new Timer(60000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Toolkit.getDefaultToolkit().beep();
						}
					});
					timer1.setRepeats(false); // Only execute once
					timer1.start();
					pressed = readString();
					timer1.stop();
					//end timer, they entered statement
					long now = System.currentTimeMillis();
					enteredLocations[i] = pressed;
					timeLocation[i]= ((now - start) / 1000.0);
					draw();
				}
				// runs the tell them to find it section
				if (ranDecison >= 25){
					label = "where is "+ model.getKey(i) + " located, go find it, when found, or you hear the beep, click on the program and press enter.";
					draw();
					// start timer
					long start = System.currentTimeMillis();
					// runs timer for find
					Timer timer2 = new Timer(60000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Toolkit.getDefaultToolkit().beep();
						}
					});
					timer2.setRepeats(false); // Only execute once
					timer2.start();
					pressed = readString();
					timer2.stop();
					//end timer, they entered statement
					long now = System.currentTimeMillis();
					enteredLocations[i] = "Go and Find";
					timeLocation[i]= ((now - start) / 1000.0);
					draw();
				}
				label = "what was the statement about "+ model.getKey(i) + " ?";
				//start timer, statement preesented
				long start = System.currentTimeMillis();
				Timer timer3 = new Timer(60000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Toolkit.getDefaultToolkit().beep();
					}
				});
				timer3.setRepeats(false); // Only execute once
				timer3.start();
				pressed = readString();
				timer3.stop();
				// end timer statment recorded. 
				long now = System.currentTimeMillis();
				enteredRecall[i]=pressed;
				timeFact[i]= ((now - start) / 1000.0);
				draw();
				counter++;
			}
			// checks random number to see if greater 50, then go What First
			if (ranDecison>=50){
				label = "what was the statement about "+ model.getKey(i) + " ?";
				draw();
				// start timer
				long start = System.currentTimeMillis();
				Timer timer4 = new Timer(60000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Toolkit.getDefaultToolkit().beep();
					}
				});
				timer4.setRepeats(false); // Only execute once
				timer4.start();
				pressed = readString();
				timer4.stop();
				// end timer
				long now = System.currentTimeMillis();
				enteredRecall[i]=pressed;
				timeFact[i]= ((now - start) / 1000.0);
				draw();
				if (ranDecison >75){
					label = "where is "+ model.getKey(i) + " located in path notation? do not look for it, when done hit enter.";
					//start timer string presented
					start = System.currentTimeMillis();
					Timer timer5 = new Timer(60000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Toolkit.getDefaultToolkit().beep();
						}
					});
					timer5.setRepeats(false); // Only execute once
					timer5.start();
					pressed = readString();
					timer5.stop();
					// end timer, answer entered.
					now = System.currentTimeMillis();
					timeLocation[i]= ((now - start) / 1000.0);
					enteredLocations[i]=pressed;
					draw();
				}
				if (ranDecison <= 75){
					label = "where is "+ model.getKey(i) + "  located, go find it, when found, or you hear the beep, click on the program and press enter.";
					draw();
					// start timer
					start = System.currentTimeMillis();
					// runs timer for find
					Timer timer6 = new Timer(60000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							Toolkit.getDefaultToolkit().beep();
						}
					});
					timer6.setRepeats(false); // Only execute once
					timer6.start();
					pressed = readString();
					timer6.stop();
					//end timer, they entered statement
					now = System.currentTimeMillis();
					enteredLocations[i] = "Go and Find";
					timeLocation[i]= ((now - start) / 1000.0);
					draw();
				}
				counter++;
			}
			draw();
		}

		// save system
		try {
			saveSystem.save(model,enteredStatements,enteredLocations,enteredRecall, savedLocations,timeLocation,timeFact );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label = "Thank you!, if you would like to provide demographics let your experimentor know";
		pressed = readString();
		draw();


	}



	/**
	 * draws the state of the program
	 */
	public static void draw() {
		StdDraw.clear();
		StdDraw.text(.5, .90, hint);
		StdDraw.text(.5, .5, label);
		StdDraw.text(0.5, 0.3, textBeingEntered);
		StdDraw.show(0);

	}

	public static String line1 = "Many computers use a path root notation like this: DESKTOP/ITEMs/F1/FILENAME.txt";
	public static String line2 = "DESKTOP/ITEMS/F1/FILENAME.txt means that a file is stored in folder F1 located in the ITEMS folder located on the desktop.";
	public static String line3 = " This means to get the file you must then first go to DESKTOP, then ITEMS, Then F1, then you have the file.";

	public static void setUPText(){
		StdDraw.clear();
		StdDraw.text(.5,.8,line1);
		StdDraw.text(.5,.7,line2);
		StdDraw.text(.5, .6,line3);
		StdDraw.text(.5, .4,"Lets try an example");
		StdDraw.text(.5, .4, label);
		StdDraw.text(.5,0.3,textBeingEntered);
		StdDraw.show(0);
		waitForKey();
	}
	/**
	 * Reads a String from the user, displaying it as they type and allowing
	 * backspaces.
	 */
	public static String readString() {
		while (true) {
			draw();
			char pressed = waitForKey();
			if (pressed == '\n') {
				String result = textBeingEntered;
				textBeingEntered = "";
				return result;
			} else if ((pressed == '\b') && (textBeingEntered.length() != 0) ) {
				textBeingEntered = textBeingEntered.substring(0,
						textBeingEntered.length() - 1);
			} else {
				textBeingEntered += pressed;
			}
		}
	}

	/**
	 * waits for key
	 * 
	 * @return
	 */
	public static char waitForKey() {
		while (!StdDraw.hasNextKeyTyped()) {
			// Wait for keypress
		}
		return StdDraw.nextKeyTyped();
	}
	
	
	
	
}
