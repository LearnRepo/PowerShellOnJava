package xyz.powershell.cmdlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cmdlet {

	public String PowerShellExecute(String cmd)
	{

		cmd = "powershell.exe " + cmd;
		String result= null;
		BufferedReader r;
		
		System.out.println(cmd);
	    try {
			Process process = Runtime.getRuntime().exec(cmd);
			InputStream error = process.getErrorStream();
			Thread.sleep(1000);
			if(error.available()<=0)
			{
				r = new BufferedReader(new InputStreamReader(process.getInputStream()));
		        String line = null;
		        while (true)
		        {                        
		            line = r.readLine();
		            if(line == null) {break;}
		            System.out.println(line);
		        }
			}
			else{
				System.err.println("list of error : ");
				for (int i = 0; i < error.available(); i++) {
					   System.err.println(error.read());
					   }
			}
			
			process.getOutputStream().close();
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return result;
	}
	
	public String NonPowerShellExecute(String cmd)
	{


		String result= null;
		ProcessBuilder processbuilder = null; 
		Process process = null;
		
	    try
	    {
	        processbuilder = new ProcessBuilder(cmd);
	        processbuilder.redirectErrorStream(true);           
	        process = processbuilder.start();
	        BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()));
	        String line = null ;
	        while (true)
	        {                        
	            line = r.readLine();
	            if(line == null) {break;}
	            System.out.println(line);
	        }
	        process.getOutputStream().close();

	    }
	    catch(Exception e)
	    {
	        System.out.println("Exception "+e);
	    }
	    finally{
	    	
	    }
	    return result;
	}
	
	
}
