/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 *
 */
public class Event extends NodeMultiple {
	public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
	public static final String PROMPT_ANSWER = "Answer: ";
	public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";
	private static int lastId = 0;
	private String playerAnswer;
	private Scanner reader;
	private GUIManager gui;
	private int id;
	
	
	public Event()
	{
		this(new GUIManager(), null);
		
	}
	
	public Event(GUIManager gui, String data)
	{
		super(data);
		this.gui = gui;
		this.reader = gui.getInputReader();
		id = ++lastId;
		
	}

	/*
	On affiche la data l'event
	On récupère la réponse de l'utilisateur
	ON interprête la réponse pour lancer le prochain evênement
	*/
	public Event run()
	{
		gui.outputln(super.getData().toString());
		return getDaughter(interpretAnswer());
		
	}
	
	public int interpretAnswer()
	{
		int i = -1;
		while (i == -1)
		{
			gui.outputln("Ecrivez votre choix :");
			setPlayerAnswer(reader.next());
			try 
			{
				 i = Integer.parseInt(playerAnswer);
			}
			catch(Exception e)
			{
				gui.outputln("Ecrivez l'une des valeurs attendues (la valeur entre parenthèse)");
				i = -1;
			}
			if ( i != -1 && (i < 1 || i > super.numberDaughters()))
			{
				gui.outputln("Aucun évènement correspond à votre valeur");
				i = -1;
			}
		}
		return  i - 1;
	}
	
	/**
	 * @return the playerAnswer
	 */
	public String getPlayerAnswer() {
		return playerAnswer;
	}

	/**
	 * @param playerAnswer the playerAnswer to set
	 */
	public void setPlayerAnswer(String playerAnswer) {
		this.playerAnswer = playerAnswer;
	}

	/**
	 * @return the reader
	 */
	public Scanner getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	/**
	 * @return the chosenPath
	 */
	public int getChosenPath() {
		/* TO BE COMPLETED */
	}

	/**
	 * @param chosenPath the chosenPath to set
	 */
	public void setChosenPath(int chosenPath) {
		/* TO BE COMPLETED */
	}

	/* Methods */
	/**
	 * @see pracHDVELH.NodeMultiple#getData()
	 */
	public String getData() {
		return super.getData().toString();
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setData(Object)
	 * @param data
	 */
	public void setData(String content) {
		super.setData(content);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#getDaughter(int)
	 */
	@Override
	public Event getDaughter(int i) {
		return (Event) super.getDaughter(i);
	}

	/**
	 * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
	 * @param daughter
	 * @param i
	 */
	public void setDaughter(Event daughter, int i) {
		super.setDaughter(daughter, i);
	}
	
	/**
	 * @return the gui
	 */
	public GUIManager getGui() {
		return gui;
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUIManager gui) {
		this.gui = gui;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/* Methods */
	/* TO BE COMPLETED */
	
}

// eof