/**
 * File: ScenarioDG.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

/**
 * @author prost
 *
 */
public class Scenario {
	private static final String MSG_EMPTY_SCENARIO = "Sorry, no scenario was found.";
	private static final String MSG_FINALE = "That's all folks!";
	private GUIManager gui;
	private Event head;

	/* TO BE COMPLETED */
	

	
	public Scenario(Event beginEvent)
	{
		this.head = beginEvent;
	}
	
	public String run()
	{
		Event next_event = head;
		while (next_event.hasDaughters())
			next_event = next_event.run();
		System.out.println(next_event.toString());
	
		return "Fin de l'éxécution";
	}
	

	/* MAIN */
	public static void main(String[] args) {
		Scenario scenario;
		GUIManager gui = new GUIManager(System.in, System.out, System.err);
				
		// S
		// *1:event1
		// **1.1
		// ***S
		// **1.2
		// ***E
		// *2:event2
		// **2.1
		// ***1
		// **2.2
		// ***S

		Event startEvent = new Event(gui, "Go!\n" + "(1)1 (2)2");
		Event event1 = new Event(gui, "event:\n" + "(1)1.1 (2)1.2");
		Event event2 = new Event(gui, "event2:\n" + "(1)2.1 (2)2.2");
		Event endEvent = new Event(gui, "End event: that's it :-)");
		startEvent.addDaughter(event1);
		startEvent.setDaughter(event2, 1);
		event1.addDaughter(startEvent);
		event1.addDaughter(endEvent);
		event2.addDaughter(event1);
		event2.addDaughter(startEvent);
		scenario = new Scenario(startEvent);
	
		
		// *2
		// ...
		// **2.3:event3
		// ***E
		// ***event3

		Event event3 = new EventExactSolution(gui, "Wizard: how much is worth pi? (the first 6 values)", "3.14159");
		event2.setData(event2.getData() + " (3)2.3");
		event2.addDaughter(event3);
		event3.addDaughter(endEvent);
		event3.addDaughter(event3);

		
		// **2.3
		// ***event4
		// ****event2
		// ****E
		// ****event3
		// ...

		int[] mask = { 3, 6, 7 };
		Event event4 = new EventRandomSolution(gui, "Random choice of the next event...", mask, "Dice rolling... Roll=",
				"\nNext event is ");
		event3.setDaughter(event4, 0);
		event4.addDaughter(event2);
		event4.addDaughter(endEvent);
		event4.addDaughter(event3);
		

		gui.outputln(scenario.run());
	}
}

// eof