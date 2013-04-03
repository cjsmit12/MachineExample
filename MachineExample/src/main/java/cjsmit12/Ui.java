package cjsmit12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

/**
 * @author Charles Smith
 *The Ui class is responsible for prompting the user and responding 
 *to user input with the appropriate information.
 */
public class Ui {
		//list is a global variable for the machines available in the system.
		List<Machine> list = new ArrayList<Machine>();
		
		/**
		 * Ui constructor creates the Ui object and populates the machine list (list) with machines.
		 */
		public Ui (){
			list.add(new Machine("GLADOS", 2, 5, "NO", 800.00));
			list.add(new Machine("K9", 8, 3, "AVERAGE", 1500.00));
			list.add(new Machine("Cybermen", 1, 1,"NO", 400.00));
			list.add(new Machine("Marvin", 16, 4, "PREMIUM", 3000.00));
			list.add(new Machine("Deep Thought", 32, 5, "NO", 8000.00));
			list.add(new Machine("Borg", 2, 2, "PREMIUM", 5500.00));
			KnowledgeBase kb = kBase("generalRules.drl");
			StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
			session.execute(list);
			System.out.println("Don't Panic!");
			System.out.println("Welcome To The Crazy Train Machine Advisor\n");
		}
		
		/**
		 * mainUi is the first Ui element presented to the user
		 * @return
		 */
		public boolean mainUi(){
			String choice = "";
			Scanner lineScan;
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the number of an option listed below \nthat you would like to execute.\n");
			System.out.println("1.  View all available machines");
			System.out.println("2.  View all safe gaming machine options");
			System.out.println("3.  View risky number cruncher options");
			System.out.println("4.  View hot gaming machines");
			System.out.println("5.  View all available information on a specific machine");
			System.out.println("6.  Exit\n");
			System.out.println("Please enter the number of an option listed above: ");
			choice = in.nextLine();
			lineScan = new Scanner(choice);
			if(lineScan.hasNextInt()){
				switch(lineScan.nextInt()){
					//prints all machines
					case 1:		printMachines();
								return true;
					//prints machines which are safe gaming machines		
					case 2:		safeGaming();
								return true;
					//prints machines which are risky number crunchers
					case 3:		riskyCrunch();
								return true;
					//prints machines which are hot and capable of gaming
					case 4:		hotGaming();
								return true;
					//prompts user for the number of a machine in the list and prints detailed information		
					case 5:		pickMachine();
								return true;
					//exits the program		
					case 6:		return false;
					//invalid input
					default:	System.out.println("\nI'm sorry but your input was not understood\nPlease try again.");
								return true;
				}
			}else{
			//invalid input again
			System.out.println("\nI'm sorry but your input was not understood\nPlease try again.");
			return false;
			}
			
		}
		
		/**
		 * pickMachine allows the user to pick a machine by its number in the list
		 * and prints its detailed information
		 */
		private void pickMachine() {
			String choice = "";
			Scanner lineScan;
			Scanner in = new Scanner(System.in);
			boolean loop = true;
			int machineNumber;
			System.out.println("View Enhanced Information For A Machine\n");
			while(loop){
				System.out.println("Please enter a number between 1 and "+list.size()+" to view that machine's information.\nYou may enter '''Q '''to quit");
				choice = in.nextLine();
				lineScan = new Scanner(choice);
				if(choice.trim().equalsIgnoreCase("Q")){
					loop = false;
				}else if(lineScan.hasNextInt()){
					machineNumber = lineScan.nextInt();
					if(machineNumber>=1 && machineNumber<=list.size()){
						System.out.println("\nMachine "+machineNumber);
						System.out.println(list.get(machineNumber-1).enhancedToString());
					}else{
						System.out.println("\nI'm sorry but your input was not understood\nPlease try again.\n");
					}
				}else{
				System.out.println("\nI'm sorry but your input was not understood\nPlease try again.\n");
				}
			}
			
		}

		/**
		 * hotGaming prints machines which are classified as hot and gaming
		 */
		private void hotGaming() {
			System.out.println("The following machines are hot gaming computers\n");
			KnowledgeBase kb = kBase("hotGaming.drl");
			StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
			for(int i = 0; i<list.size();i++){
				try{
					session.execute(list.get(i));
					System.out.println("Machine " + (i+1));
					System.out.println(list.get(i).toString());
				}catch (Exception e){
					//Catches exception for a machine that is Risky or not for Gaming (Basically, the cake is a lie)
				}
			}
			
		}
		/**
		 * riskCrunch prints all machines which are classified as risky and capable of crunching numbers
		 */
		private void riskyCrunch() {
			System.out.println("The following machines are risky number crunchers\n");
			KnowledgeBase kb = kBase("riskyNumberCrunchers.drl");
			StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
			for(int i = 0; i < list.size();i++){
				try{
					session.execute(list.get(i));
					System.out.println("Machine " + (i+1));
					System.out.println(list.get(i).toString());
				}catch (Exception e){
					//Catches exception for a machine that is Risky or not for Gaming (Basically, the cake is a lie)
				}
			}
			
		}

		/**
		 * safeGaming prints the machines which are classified as safe and capable of gaming
		 */
		private void safeGaming() {
			System.out.println("The following machines are safe gaming computers\n");
			KnowledgeBase kb = kBase("safeAndGaming.drl");
			StatelessKnowledgeSession session = kb.newStatelessKnowledgeSession();
			for(int i = 0; i<list.size();i++){
				try{
					session.execute(list.get(i));
					System.out.println("Machine " + (i+1));
					System.out.println(list.get(i).toString());
				}catch (Exception e){
					//Catches exception for a machine that is Risky or not for Gaming (Basically, the cake is a lie)
				}
			}
			
		}

		/**
		 * printMachines prints all machines available in the list
		 */
		private void printMachines() {
			System.out.println("\nThe following machines are available:\n");
			for(int i = 0; i<list.size();i++){
				System.out.println("Machine "+ (i+1));
				System.out.println(list.get(i).toString());
				
			}
		}

		/**
		 * kBase creates a new knowledge base using the provided rulePath
		 * @param rulePath
		 * @return KnowledgeBase
		 */
		private static KnowledgeBase kBase (String rulePath) {
			KnowledgeBuilder build = KnowledgeBuilderFactory.newKnowledgeBuilder();
			build.add(ResourceFactory.newClassPathResource(rulePath), ResourceType.DRL);
			if(build.hasErrors()){
				throw new RuntimeException(build.getErrors().toString());
			}
			KnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
			kBase.addKnowledgePackages(build.getKnowledgePackages());
			return kBase;
		}
}
