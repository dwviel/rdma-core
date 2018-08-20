package edu.lmu.cs.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;
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


class RunnableServerThread implements Runnable
{
    Thread runner;
    Socket sockref;

    public RunnableServerThread()
    {}

    public RunnableServerThread(String threadName, Socket sock)
    {
        sockref = sock;
        runner = new Thread(this, threadName);
        runner.start();
    }

    public void run()
    {
        while(true)
	    {
		// write to socket                                                                            
            try
                {
		    PrintWriter out =
			new PrintWriter(sockref.getOutputStream(), true);
		    out.println(new Date().toString());
		

		    /*
                        try
                            {
                                Thread.sleep(1000);  // 1000 ms                                         
                            }
                        catch(InterruptedException ex)
                            {
                                Thread.currentThread().interrupt();
                            }
		    */
                }
            catch(IOException ex)
                {

                }


	    }

    }

}



public class DateServerLoopThread {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException 
    {
        ServerSocket listener = new ServerSocket(9090);
        try 
	{
            Socket socket = listener.accept();

	    RunnableServerThread thread1 = new RunnableServerThread("thread1", socket);
	    RunnableServerThread thread2 = new RunnableServerThread("thread2", socket);


	}
        finally 
	{
            listener.close();
	}
    }
}
