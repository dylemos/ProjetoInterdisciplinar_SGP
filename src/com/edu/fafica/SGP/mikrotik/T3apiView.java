package com.edu.fafica.SGP.mikrotik;

import java.util.logging.Level;
import java.util.logging.Logger;

public class T3apiView {

	public void outputHere(String s) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		ApiConn ret = new ApiConn("172.16.50.1", 8728);

		if (!ret.isConnected()) {

		ret.start();
		try {
		ret.join();
		if (ret.isConnected()) {

		ret.login("sgp", new char[0]);

		}
		} 
		catch (InterruptedException ex) {
		//Logger.getLogger(T3apiView.class.getName()).log(Level.SEVERE, null, ex);
		//return null;
		System.out.println(ex);
		}
		}
		String ip;
		ip = ret.sendCommand("/log/print");
		System.out.println(ip);

		}
}
