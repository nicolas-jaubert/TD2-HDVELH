package pracHDVELH;

import java.util.Random;

public class EventRandomSolution extends Event {
	private static final int ERROR_STATUS_BAD_SETTINGS = -1;
	private static final int DEFAULT_RANDOM_SOLUTION = 0;
	private static final String ERROR_MSG_BAD_SETTINGS = "The settings haven't been set properly";
	private int dice;
	private int randomSolution;
	private Random randomGenerator;
	private int[] partition;
	private String waitingMsg;
	private String solutionAnnoucement;
	
	public EventRandomSolution()
	{
		this(new GUIManager(), null, new int[3], null, null);
	}
	
	public EventRandomSolution(GUIManager gui, String data, int[] partition, String waitingMsg, String solutionAnnoucement)
	{
		super(gui, data);
		this.partition = partition;
		this.waitingMsg = waitingMsg;
		this.solutionAnnoucement = solutionAnnoucement;
	}
	
	public void run()
	{
		
	}
	
	public int interpretAnswer()
	{
		
	}

}
