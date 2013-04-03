package cjsmit12;

public class MachineExample {
	
	
	/**
	 * Main method of program, calls ui.mainUi in a loop until ui returns false and exits
	 * @param args
	 */
	public static void main(String[] args) {
		Ui ui = new Ui();
		while(ui.mainUi());
		System.exit(1);
	}

}
