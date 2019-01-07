package com.test00;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MTest02 {
	public static void main(String[] args) {
		Socket m_client;
		try {
			m_client = new Socket("127.0.0.1", 8888);
			if (m_client.isConnected()) {
				System.out.println("서버와 연결되었습니다.");

				System.out.println("서버 주소 " + m_client.getInetAddress());
				System.out.println("서버 포트 " + m_client.getPort());
				System.out.println("나의 포트 " + m_client.getLocalPort());
				System.out.println("나의 주소 " + m_client.getLocalAddress());

				OutputStream oos = m_client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(oos);
				dos.writeUTF("나 클라이언트야...");
				dos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
