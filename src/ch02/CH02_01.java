package ch02;// =============== Program Description ===============
// �������ƣ� CH02_01.java                               
// ����Ŀ�ģ���ά�����Ӧ��
// ===================================================

import java.util.Arrays;
public class CH02_01{
	public static void main(String[] args){
		//��������
		int intCreate=1000000;           //�������������
		int intRand;                    //���������������
		int[][] intArray=new int[2][42];    //�������������
		
		//����������������������
		while(intCreate-->0){
			intRand=(int)(Math.random()*42);
			intArray[0][intRand]++;
			intArray[1][intRand]++;
		}
		
		//��intArray[0]����������
		Arrays.sort(intArray[0]);
		
		//�ҳ�������������ֺ���
		for(int i=41;i>(41-6);i--){

			//��һ��������ͬ��
			for(int j=41;j>=0;j--){

				//����������ʱ��ӡ
				if(intArray[0][i]==intArray[1][j]){
					System.out.println("��������� "+(j+1)+" ���� "+intArray[0][i]+" ��");
					intArray[1][j]=0;   //���ҵ�����ֵ����������
					break;              //�ж���ѭ����������ѭ��
				}	
			}
		}
	}
}

