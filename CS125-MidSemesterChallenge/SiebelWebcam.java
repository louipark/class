//UIUC CS125 FALL 2012 MP. File: SiebelWebcam.java, CS125 Project: CS125-MidSemesterChallenge, Version: 2012-10-29T13:46:09-0500.344693000

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

/**
 * This class is a complete webcam server that serves a webcam page and a 'live'
 * picture of the Siebel Center. Note there's no error handling or proper
 * support for the http protocol. The original image URL :
 * http://www.engr.uiuc.edu/shared/images/news/image786.jpg
 * 
 * @author angrave
 * 
 */
public class SiebelWebcam {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(0);
		serverSocket.setReuseAddress(true);
		String serverAddress = InetAddress.getLocalHost().getHostAddress();
		System.out.println("Copy-paste the following URL into a webcam browser");
		System.out.println("http://" + serverAddress + ":" + serverSocket.getLocalPort() + "/");

		while (true) {
			handleClientRequest(serverSocket.accept());
		}
	}

	private static void handleClientRequest(Socket socket) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String request = in.readLine(); // e.g. GET /siebel.jpg HTTP/1.1
		if (request.contains("siebel"))
			siebeljpg(socket.getOutputStream());
		else
			webpagehtml(request, socket.getOutputStream());
		socket.close();
	}

	private static void webpagehtml(String request, OutputStream stream) {
		PrintStream out = new PrintStream(stream);
		out.println("HTTP/1.1 200 OK");
		out.println("Connection: close");
		out.println("");
		out.println("<html><head><title>Siebel Webcam Viewer</title></head>");
		out.println("<body><a href=siebel.jpg>Siebel Webcam!</a></body></html>");
		out.flush();
	}

	private static void siebeljpg(OutputStream stream) throws IOException {
		PrintStream out = new PrintStream(stream);
		out.println("HTTP/1.1 200 OK");
		out.println("Connection: close");
		out.println("Content-Type: image/jpeg\n");
		out.flush();

		BufferedImage image = ImageIO.read(SiebelWebcam.class.getResourceAsStream("siebel.jpg"));

		int x = (int) (Math.random() * image.getWidth());
		int y = (int) (Math.random() * image.getHeight() / 4);

		String[] quotes = { "'Coffee'", "'Tea'", "'Iced Latte'" };
		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x, y + 14, 100, 6);
		g.fillOval(x + 35, y, 30, 20);

		char[] mesg = quotes[(int) (quotes.length * Math.random())].toCharArray();
		g.drawChars(mesg, 0, mesg.length, x, y);

		g.dispose();

		ImageIO.write(image, "jpeg", stream);
	}
}
