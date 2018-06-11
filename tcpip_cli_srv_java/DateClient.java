package edu.lmu.cs.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.InetSocketAddress;

import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class DateClient {

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
        Socket s = new Socket(serverAddress, 9090);

	InetAddress inetAddr = s.getLocalAddress();
	String inetAddrStr = inetAddr.getHostAddress();
	String inetAddrStrOut = "InetAddr: " + inetAddrStr;
	System.out.println(inetAddrStrOut);

	InetSocketAddress remInetSockAddr = (InetSocketAddress)s.getRemoteSocketAddress();
	String remInetAddr = remInetSockAddr.getHostString();
	String remInetAddrStr = "Remote InetAddr: " + remInetAddr;
	System.out.println(remInetAddrStr);


        BufferedReader input =
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
	String recvStr = "Received Str: " + answer;
	System.out.println(recvStr);
        //JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}
