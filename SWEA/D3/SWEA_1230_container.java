package D3;
/*
SWEA 1230 암호문
Linked List
날짜 2023.02.08
*/

import java.util.*;
import java.io.*;

public class SWEA_1230_container {

	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N;// 원본 암호문 길이
			int M;// 명령어 갯수
			String a;// 명령어
			int x;// 바꿀 위치
			int y;// s의 갯수
			int s;// 바꿀 숫자
			int num;
			N = sc.nextInt();
			// 연결리스트 생성. 끝나고 삭제 꼭 해주기
			LinkedList<Integer> list = new LinkedList<Integer>();// 인티저를 담는 연결리스트 생성
			// for문 N번 돌면서 암호문 받아와서 연결리스트에 넣어주기
			for (int i = 0; i < N; i++) {
				num = sc.nextInt();
				list.add(num);
			}
			// M=sc.nextInt(); 명령어 갯수 받아오기
			M = sc.nextInt();
			// switch case문 이용해서 명령어에 따른 처리 해주기.
			for (int i = 0; i < M; i++) {
				a = sc.next();
				switch (a) {
				case "I":
					// System.out.println("I");
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						s = sc.nextInt();
						list.add(x + j, s);
					}
					/*
					 * for(int j=0;j<list.size();j++){ System.out.printf("%d ",list.get(j)); }
					 * System.out.println();
					 */
					break;
				case "D":
					// System.out.println("D");
					x = sc.nextInt();
					y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
					/*
					 * for(int j=0;j<list.size();j++){ System.out.printf("%d ",list.get(j)); }
					 * System.out.println();
					 */
					break;
				case "A":
					// System.out.println("A");
					y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						s = sc.nextInt();
						list.add(s);
					}
					/*
					 * for(int j=0;j<list.size();j++){ System.out.printf("%d ",list.get(j)); }
					 * System.out.println();
					 */
					break;
				}
			}
			System.out.printf("#%d ", test_case);
			int list_length = list.size();
			// System.out.printf("%d\n",list_length);
			int length = 10;
			if (list_length < 10) {
				length = list_length;
			}
			for (int i = 0; i < length; i++) {
				System.out.printf("%d ", list.get(i));
			}
			System.out.println();
		}
	}
}
