package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class testOne {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		String[] arr = new String[count];
		for (int i = 0; i < count; i++) {
			arr[i] = in.next();
		}

		ArrayList<String> arrList = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String everyarr = arr[i];
			while (everyarr.length() > 8) { // 判断字符串长度
				arrList.add(everyarr.substring(0, 8));// 截取前0-7
				everyarr = everyarr.substring(8, everyarr.length());// 截取后几位
			}
			if (everyarr.length() != 8) {// 判断后几位的长度是否等于8
				String newStr = String.format("%1$0" + (8 - everyarr.length()) + "d", 0);
				String tmp = everyarr + newStr;
				arrList.add(tmp);
			} else {
				arrList.add(arr[i]);
			}
		}

		Collections.sort(arrList);
		for (int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i)+" ");
		}
	}
}