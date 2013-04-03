package cjsmit12;
/**
 * The Machine.java represents an object that is a machine.
 * @author Charles Smith
 *
 */
public class Machine {
	
	//Variables 
	String modelName;
	int memory;
	int cpu;
	String graphics;
	double price;
	
	//Classification Variables
	boolean isCheap;
	boolean isExpensive;
	boolean isHot;
	boolean isLoud;
	boolean isRisky;
	boolean canGame;
	boolean canCrunch;
	
	/**
	 * Constructor creates Machine object
	 * @param modelName
	 * @param memory
	 * @param cpu
	 * @param graphics
	 * @param price
	 */

	public Machine(String modelName, int memory, int cpu, String graphics, double price){
		this.modelName = modelName;
		this.memory = memory;
		this.cpu = cpu;
		this.graphics = graphics;
		this.price = price;
		isCheap = false;
		isHot = false;
		isLoud = false;
		isRisky = false;
	}
	
	/**
	 * Gets String modelName 
	 * @return String
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * Sets String modelName
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * Gets int memory
	 * @return int
	 */
	public int getMemory() {
		return memory;
	}

	/**
	 * Sets int memory
	 * @param memory
	 */
	public void setMemory(int memory) {
		this.memory = memory;
	}
	
	/**
	 * Gets int cpu
	 * @return int
	 */
	public int getCpu() {
		return cpu;
	}

	/**
	 * Sets int cpu
	 * @param cpu
	 */
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	/**
	 * Gets String graphics
	 * @return String
	 */
	public String getGraphics() {
		return graphics;
	}
	
	/**
	 * Sets String graphics
	 * @param graphics
	 */
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}

	/**
	 * Gets double price
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets double price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Gets boolean isCheap
	 * @return
	 */
	public boolean isCheap() {
		return isCheap;
	}

	/**
	 * Sets boolean isCheap
	 * @param isCheap
	 */
	public void setCheap(boolean isCheap) {
		this.isCheap = isCheap;
	}
	
	/**
	 * Gets boolean isHot
	 * @return isHot
	 */
	public boolean isHot() {
		return isHot;
	}
	
	/**
	 * Sets boolean isHot
	 * @param isHot
	 */
	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}
	
	/**
	 * Gets boolean isLoud
	 * @return isLoud
	 */
	public boolean isLoud() {
		return isLoud;
	}

	/**
	 * Sets boolean isLoud
	 * @param isLoud
	 */
	public void setLoud(boolean isLoud) {
		this.isLoud = isLoud;
	}
	
	/**
	 * Gets boolean isExpensive
	 * @return boolean
	 */
	public boolean isExpensive() {
		return isExpensive;
	}

	/**
	 * Sets boolean isExpensive
	 * @param isExpensive
	 */
	public void setExpensive(boolean isExpensive) {
		this.isExpensive = isExpensive;
	}
	
	/**
	 * Gets boolean isRisky
	 * @return boolean
	 */
	public boolean isRisky() {
		return isRisky;
	}
	
	/**
	 * Sets boolean isRisky
	 * @param isRisky
	 */
	public void setRisky(boolean isRisky) {
		this.isRisky = isRisky;
	}
	
	/**
	 * Gets boolean canGame
	 * @return boolean
	 */
	public boolean canGame() {
		return canGame;
	}
	
	/**
	 * Sets boolean canGame
	 * @param isGame
	 */
	public void setGame(boolean isGame) {
		this.canGame = isGame;
	}
	
	/**
	 * Gets boolean canCrunch
	 * @return boolean
	 */
	public boolean canCrunch() {
		return canCrunch;
	}
	
	/**
	 * Sets boolean canCrunch
	 * @param isCrunch
	 */
	public void setCrunch(boolean isCrunch) {
		this.canCrunch = isCrunch;
	}
	
	/**
	 * To String for Machine object
	 */
	@Override
	public String toString(){
		String toString =  " Model Name:     "+modelName+"\n";
		       toString += "     Memory:     "+memory+" GB\n";
		       toString += "        CPU:     "+cpu+" GHz \n";
		       toString += "   Graphics:     "+graphics+"\n";
		       toString += "      Price:     $"+price+"\n";
		       return toString;
		
		
	}
	
	/**
	 * Creates enhanced to string to display drools sorting information
	 * @return String
	 */
	public String enhancedToString() {
		String toString = toString();
		if(isCheap){
			toString += "The machine is cheap.  \n";
		}else{
			toString += "The machine is not cheap.  \n";
		}
		if(isExpensive){
			toString += "The machine is expensive.  \n";
		}else{
			toString += "The machine is not expensive.  \n";
		}
		if(isHot){
			toString += "The machine is hot.  You should not open it up and touch internal parts while it is running.  \n";
		}else{
			toString += "The machine is not hot.  \n";
		}if(isLoud){
			toString += "The machine is loud.  \n";
		}else{
			toString += "The machine is not loud.  \n";
		}if(isRisky){
			toString += "The machine is risky.  Exercise extreme caution things may go wrong.  Don't try shooting laser cannons into any exposed holes.  \n";
		}else{
			toString += "The machine is not risky.  \n";
		}if(canGame){
			toString += "The machine is capable of gaming.  \n";
		}else{
			toString += "The machine is incapable of gaming.  If you install Crysis 3, it is at your own risk.  \n";
		}if(canCrunch){
			toString += "The machine can crunch numbers.  \n";
		}else{
			toString += "The machine is incapable of crunching numbers.  You probably shouldn't feed it Pi.  \n";
		}
		return toString;
	}
}
