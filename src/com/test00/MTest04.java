package com.test00;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MTest04 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("클라이언트 접속 대기중...");

			socket = serverSocket.accept();

			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());

			Object obj = null;
			while ((obj = ois.readObject()) != null) {
				MTest03 data = (MTest03) obj;
				int num1 = data.getNum1();
				int num2 = data.getNum2();
				String operator = data.getOperator();

				if (operator.equals("+")) {
					oos.writeObject(num1 + "+" + num2 + "=" + (num1 + num2));
				} else if ((operator.equals("-"))) {
					oos.writeObject(num1 + "-" + num2 + "=" + (num1 - num2));
				} else if ((operator.equals("*"))) {
					oos.writeObject(num1 + "*" + num2 + "=" + (num1 * num2));
				} else if ((operator.equals("/"))) {
					oos.writeObject(num1 + "/" + num2 + "=" + (num1 / num2));
				}
				oos.flush();
				System.out.println("결과를 전송하였습니다.");
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				if (oos != null)
					oos.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			try {
				if (socket != null)
					socket.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
