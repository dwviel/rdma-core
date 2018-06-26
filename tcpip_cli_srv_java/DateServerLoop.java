package edu.lmu.cs.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class DateServerLoop {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException 
    {
        ServerSocket listener = new ServerSocket(9090);
        try 
	{
	    Socket socket = listener.accept();
            while (true) 
	    {
		PrintWriter out =
		    new PrintWriter(socket.getOutputStream(), true);
		out.println(new Date().toString());

		if(args.length > 0)
		    {

			try        
			    {
				Thread.sleep(1000);  // 1000 ms
			    } 
			catch(InterruptedException ex) 
			    {
				Thread.currentThread().interrupt();
			    }
		    }
		
	    }
	}
        finally 
	{
            listener.close();
	}
    }
}
