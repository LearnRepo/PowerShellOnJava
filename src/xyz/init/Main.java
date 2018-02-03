package xyz.init;

import java.util.Scanner;

import xyz.powershell.cmdlet.Cmdlet;
import xyz.powershell.interactive.Commandline;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Enter command :");
		Scanner s = new Scanner(System.in);
		String cmd = s.nextLine();
		
		
		Cmdlet cmdlet = new Cmdlet();
		//cmdlet.PowerShellExecute(cmd);
		cmdlet.PowerShellExecute(cmd);
		*/
		
		Commandline commandLine = new Commandline();
		commandLine.CachedInterfaceLine();
	}

}
