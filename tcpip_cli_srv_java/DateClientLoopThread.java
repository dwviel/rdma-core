package edu.lmu.cs.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.InetSocketAddress;

import javax.swing.JOptionPane;



class RunnableThread implements Runnable
{
    Thread runner;
    Socket sockref;

    public RunnableThread()
    {}
    
    public RunnableThread(String threadName, Socket sock)
    {
	sockref = sock;
	runner = new Thread(this, threadName);
	runner.start();
    }

    public void run()
    {
	while(true)
	{
	    // read from socket

	    try
		{
		    BufferedReader input = 
			new BufferedReader(new InputStreamReader(sockref.getInputStream()));
		    String answer = input.readLine();

		    String recvStr = "Thread: " + runner.getName() + ", Received Str: " + answer;
		    System.out.println(recvStr);
		}
	    catch(IOException ex)
		{

		}


	}

    }

}


public class DateClientLoopThread 
{

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     * See: cs.lmu.edu/~ray/notes/javanetexamples/
     */
    public static void main(String[] args) throws IOException {
        //String serverAddress = JOptionPane.showInputDialog(
         
	System.out.println("Enter IP Address of a machine that is\n" +
            "running the date service on port 9090:");
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	String serverAddress = reader.readLine();
	String addrStr = "Server addr: " + serverAddress;
	System.out.println(addrStr);

	// create socket
        Socket sock = new Socket(serverAddress, 9090);

	InetAddress inetAddr = sock.getLocalAddress();
	String inetAddrStr = inetAddr.getHostAddress();
	String inetAddrStrOut = "InetAddr: " + inetAddrStr;
	System.out.println(inetAddrStrOut);

	InetSocketAddress remInetSockAddr = (InetSocketAddress)sock.getRemoteSocketAddress();
	String remInetAddr = remInetSockAddr.getHostString();
	String remInetAddrStr = "Remote InetAddr: " + remInetAddr;
	System.out.println(remInetAddrStr);


	RunnableThread thread1 = new RunnableThread("thread1", sock);
	RunnableThread thread2 = new RunnableThread("thread2", sock);
	RunnableThread thread3 = new RunnableThread("thread3", sock);





        //JOptionPane.showMessageDialog(null, answer);
        //System.exit(0);
    }
}
