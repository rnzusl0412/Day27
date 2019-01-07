package com.test00;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MTest01 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(8888);
			System.out.println("클라이언트를 기다립니다...");
			Socket sm = s.accept();
			System.out.println("클라이언트가 연결되었습니다. - " + sm.isConnected());

			System.out.println(sm.getPort());
			System.out.println(sm.getLocalSocketAddress());

			InputStream iis = sm.getInputStream();

			DataInputStream dis = new DataInputStream(iis);
			System.out.println(dis.readUTF());
			dis.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
