package xyz.powershell.interactive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Commandline {
	public void interfaceLine()
	{
		BufferedReader r;
		Scanner s;
		String cmd = "echo 'welcome to Java powershell'";
	    try {
	    	Process process;
			InputStream error;
	    	do{
	    		process = Runtime.getRuntime().exec("powershell " +cmd);
	    		error = process.getErrorStream();
				Thread.sleep(1000);
				
				if(error.available()<=0)
				{
					r = new BufferedReader(new InputStreamReader(process.getInputStream()));
			        String line = null ;
			        while (true)
			        {                        
			            line = r.readLine();
			            if(line == null) {break;}
			            System.out.println(line);
			        }
				}
				else{
					
					/*
					for (int i = 0; i < error.available(); i++) {
						   //System.err.println(error.read());
						   }
					*/
					
					r = new BufferedReader(new InputStreamReader(error));
			        String line = null ;
			        while (true)
			        {                        
			            line = r.readLine();
			            if(line == null) {break;}
			            System.err.println(line);
			        }
					
				}
				s = new Scanner(System.in);
				while(true)
				{
					cmd = s.nextLine();
					if(!cmd.equals(""))
						break;
				}
					
	    	}
			while(!cmd.equals("exit"));
			
			process.getOutputStream().close();
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CachedInterfaceLine()
	{
		BufferedReader r;
		Scanner s;
		String cmd = "echo 'welcome to Java powershell'";
		String cmdCache = "";
	    try {
		    	Process process;
				InputStream error;
		    	do{
		    		if(!cmd.toLowerCase().contains("for") && !cmd.toLowerCase().contains("while"))
		    		{
		    			process = Runtime.getRuntime().exec("powershell " + cmdCache + cmd);
			    		error = process.getErrorStream();
						Thread.sleep(1000);
						
						if(error.available()<=0)
						{
							r = new BufferedReader(new InputStreamReader(process.getInputStream()));
					        String line = null ;
					        while (true)
					        {                        
					            line = r.readLine();
					            if(line == null) {break;}
					            System.out.println(line);
					        }
					       String[] temp = cmd.split(";");
					       for(int i = 0;i<temp.length;i++)
					       {
					    	   if(temp[i].indexOf('=') > -1)
					    	   {
					    		   cmdCache += (temp[i] + ";");
					    	   }
					       }
		    		
						}
						else{
							r = new BufferedReader(new InputStreamReader(error));
					        String line = null ;
					        while (true)
					        {                        
					            line = r.readLine();
					            if(line == null) {break;}
					            System.err.println(line);
					        }
						}
						process.getOutputStream().close();
		    		}
		    		else
		    		{
		    			System.err.println("Error! loop is forbidden");
		    		}
						s = new Scanner(System.in);
						while(true)
						{
							cmd = s.nextLine();
							if(!cmd.equals(""))
								break;
						}
		    	}
				while(!cmd.equals("exit"));
			}		    
		    catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
