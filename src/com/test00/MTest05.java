package com.test00;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MTest05 {
	public static void main(String[] args) {
		System.out.println("����� ������ ip �ּҸ� ��Ȯ�� �Է��ϼ���.");
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		int num1 = 0;
		int num2 = 0;
		String operator = null;

		try {
			socket = new Socket(keyboard.readLine(), 8888);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String message = null;

			while (true) {
				System.out.println("ù��° ���ڸ� �Է��ϼ���.");
				message = reader.readLine();
				num1 = Integer.parseInt(message);
				System.out.println("�ι�° ���ڸ� �Է��ϼ���.");
				message = reader.readLine();
				num2 = Integer.parseInt(message);
				System.out.println("�����ڸ� �Է��ϼ��� (+,-,*,/ �� �ϳ� ����)");
				operator = reader.readLine();

				MTest03 sendObj = new MTest03(num1, num2, operator);
				oos.writeObject(sendObj);
				oos.flush();

				String responseMsg = (String) ois.readObject();
				System.out.println("���� ��� : " + responseMsg);
				System.out.println("��� �Ի��Ͻðڽ��ϱ�? (yes/no �Է�)");
				message = reader.readLine();
				if (message.equals("no"))
					break;
				System.out.println("�ٽ� ����մϴ�.");

			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
