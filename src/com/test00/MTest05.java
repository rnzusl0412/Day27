package com.test00;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MTest05 {
	public static void main(String[] args) {
		System.out.println("통신할 서버의 ip 주소를 정확히 입력하세요.");
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
				System.out.println("첫번째 숫자를 입력하세요.");
				message = reader.readLine();
				num1 = Integer.parseInt(message);
				System.out.println("두번째 숫자를 입력하세요.");
				message = reader.readLine();
				num2 = Integer.parseInt(message);
				System.out.println("연산자를 입력하세요 (+,-,*,/ 중 하나 선택)");
				operator = reader.readLine();

				MTest03 sendObj = new MTest03(num1, num2, operator);
				oos.writeObject(sendObj);
				oos.flush();

				String responseMsg = (String) ois.readObject();
				System.out.println("연산 결과 : " + responseMsg);
				System.out.println("계속 게산하시겠습니까? (yes/no 입력)");
				message = reader.readLine();
				if (message.equals("no"))
					break;
				System.out.println("다시 계산합니다.");

			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
