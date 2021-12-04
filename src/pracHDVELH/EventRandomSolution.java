package pracHDVELH;

import java.util.Random;

public class EventRandomSolution extends Event {
	private static final int ERROR_STATUS_BAD_SETTINGS = -1;
	private static final int DEFAULT_RANDOM_SOLUTION = 0;
	private static final String ERROR_MSG_BAD_SETTINGS = "The settings haven't been set properly";
	public static int MAX_PARTITION = 10;
	private int dice;
	private int randomSolution;
	private Random randomGenerator;
	private int[] partition;
	private String waitingMsg;
	private String solutionAnnoucement;
	
	public EventRandomSolution()
	{
		this(new GUIManager(), null, new int[MAX_PARTITION], null, null);
	}
	
	public EventRandomSolution(GUIManager gui, String data, int[] partition, String waitingMsg, String solutionAnnoucement)
	{
		super(gui, data);
		this.partition = partition;
		this.waitingMsg = waitingMsg;
		this.solutionAnnoucement = solutionAnnoucement;
		randomGenerator = new Random();
	}
	
	public Event run()
	{
		getGui().outputln(getData());
		randomSolution = randomGenerator.nextInt(partition[partition.length - 1]) + 1;
		getGui().outputln(waitingMsg + randomSolution);
		getGui().outputln(solutionAnnoucement);
		return getDaughter(interpretAnswer());
	}
	
	public int interpretAnswer()
	{
		int value = 0;
		int i = 1;
		while(i < randomSolution)
		{
			++i;
			if (i > partition[value])
				++value;
		}
		return value;
	}

	public int getDice() {return dice;}
	public int getRandomSolution() {return randomSolution;}
	public Random getRandomGenerator() {return randomGenerator;}
	public int[] getPartition() {return partition;}
	public String getWaitingMsg() {return waitingMsg;}
	public String getSolutionAnnoucement() {return solutionAnnoucement;}
	
	public void setDice(int dice) {this.dice = dice;}
	public void setRandomSolution(int randomSolution) {this.randomSolution = randomSolution;}
	public void setRandomGenerator(Random randomGenerator) {this.randomGenerator = randomGenerator;}
	public void setPartition(int[] partition) {this.partition = partition;}
	public void setWaitingMsg(String waitingMsg) {this.waitingMsg = waitingMsg;}
	public void setSolutionAnnoucement(String solutionAnnoucement) {this.solutionAnnoucement = solutionAnnoucement;}
	
	
}
