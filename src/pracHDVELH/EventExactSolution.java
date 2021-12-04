package pracHDVELH;

public class EventExactSolution extends Event {
	private String answer;

	public EventExactSolution()
	{
		this(new GUIManager(), null, null);
		
	}
	
	public EventExactSolution(GUIManager gui, String data, String answer)
	{
		super(gui, data);
		this.answer = answer;
		
	}
	
	public String getAnswer()
	{
		return answer;
	}
	
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	public int interpretAnswer()
	{
		if (answer.equals(super.getReader().next()))
			return 0;
		else
			return 1;
			
	}
}
