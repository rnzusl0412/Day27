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
				System.out.println("������ ����Ǿ����ϴ�.");

				System.out.println("���� �ּ� " + m_client.getInetAddress());
				System.out.println("���� ��Ʈ " + m_client.getPort());
				System.out.println("���� ��Ʈ " + m_client.getLocalPort());
				System.out.println("���� �ּ� " + m_client.getLocalAddress());

				OutputStream oos = m_client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(oos);
				dos.writeUTF("�� Ŭ���̾�Ʈ��...");
				dos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
