package classes;

import interfaces.IInputter;

public class ResponsibilityInputter implements IInputter<Responsibility>{
	public Responsibility input()
	{
		System.out.print("\nResponsibility: ");
		String tekst = main.keyboard.nextLine();
		
		return new Responsibility(tekst);
	}
}
