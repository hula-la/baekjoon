package bj;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2527 {
	static int[] rec;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int i=0;i<4;i++) {
			rec = new int[8];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			
			// 안겹침:0, 내부겹칩:1, 바깥 겹칩:2, 안쪽 겹침:3
			int isfoldedX;
			int isfoldedY;
			

			// 사각형 정보 입력
			for(int j=0;j<8;j++) {
				rec[j] = Integer.parseInt(st.nextToken());
			}
			
			// 겹침 여부 가로기준
			int foldCriteriaX = rec[0]<=rec[4]?rec[2]-rec[0]:rec[6]-rec[4];
			int foldCriteriaY = rec[1]<=rec[5]?rec[3]-rec[1]:rec[7]-rec[5];
			isfoldedX=foldCal(0,foldCriteriaX);
			isfoldedY=foldCal(1,foldCriteriaY);
			
//			System.out.print("isfoldedX:"+isfoldedX+"isfoldedY:"+isfoldedY);
			
			if ((isfoldedX==2)&&(isfoldedY==2)) {
				System.out.println("c");
			}
			else if(((isfoldedX==2)&&(isfoldedY!=0))||((isfoldedX!=0)&&(isfoldedY==2))) {
				System.out.println("b");
			}
			else if((isfoldedX==0)||(isfoldedY==0)) {
				System.out.println("d");
			}
			else{
				System.out.println("a");
			}

		}
	}
	
	static int foldCal(int idx ,int criteria) {
		int diff = Math.abs(rec[idx]-rec[idx+4]);
		
		if (diff>criteria) {
			return 0;
		}
		else if (diff==criteria) {
			return 2;
		}
		else if (diff==0) {
			return 3;
		}
		else {
			return 1;
		}
	}
	
}
