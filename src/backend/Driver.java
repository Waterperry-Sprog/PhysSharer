package backend;

public class Driver {
	
	private static gui.Logic logic;
	
	public static gui.Logic getLogic(){
		return logic;
	}
	
	public static void main(String[] args) {
		gui.ViewController UI = new gui.ViewController();
		logic = new gui.Logic(UI);
		UI.showUI();
	}
}
