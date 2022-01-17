package ch05.CH05_02.src;// =============== Program Description ===============
// �������ƣ� CH05_02.java                               
// ����Ŀ�ģ�ʵ��������������
// ===================================================

import java.io.IOException;
class QueueNode                 // ���нڵ���
{
	int data;                    // �ڵ�����
	QueueNode next;              // ָ����һ���ڵ�
   //���캯��
   public QueueNode(int data) {
       this.data=data;
       next=null;
   }
};

class Linked_List_Queue { //������
   public QueueNode front; //���е�ǰ��ָ��
   public QueueNode rear;  //���е�β��ָ��

//���캯��
   public Linked_List_Queue() { front=null; rear=null; }

//����enqueue:�������ݵĴ���
public boolean enqueue(int value) {
	QueueNode node= new QueueNode(value); //�����ڵ�
  //����Ƿ�Ϊ�ն���
   if (rear==null)
      front=node; //�½����Ľڵ��Ϊ��һ���ڵ�
   else
	   rear.next=node; //���ڵ���뵽���е�β��
   rear=node; //�����е�β��ָ��ָ���¼���Ľڵ�
   return true;
}

//����dequeue:�������ݵ�ȡ��
public int dequeue() {
	int value;
	//�������Ƿ�Ϊ�ն���
   if (!(front==null)) {
     if(front==rear) rear=null;
     value=front.data; //����������ȡ��
     front=front.next; //�����е�ǰ��ָ��ָ����һ��
     return value;
   }
   else return -1;
}
} //��������������

public class CH05_02 {
// ������
   public static void main(String args[]) throws IOException {
	   Linked_List_Queue queue =new Linked_List_Queue(); //�������ж���
	   int temp;
	   System.out.println("��������ʵ�ֶ���");
	   System.out.println("====================================");
	   System.out.println("�ڶ���ǰ�˼����1�����ݣ�������ֵΪ1");
	   queue.enqueue(1);
	   System.out.println("�ڶ���ǰ�˼����2�����ݣ�������ֵΪ3");
	   queue.enqueue(3);
	   System.out.println("�ڶ���ǰ�˼����3�����ݣ�������ֵΪ5");
	   queue.enqueue(5);
	   System.out.println("�ڶ���ǰ�˼����4�����ݣ�������ֵΪ7");
	   queue.enqueue(7);
	   System.out.println("�ڶ���ǰ�˼����5�����ݣ�������ֵΪ9");
	   queue.enqueue(9);
	   System.out.println("====================================");
	   while (true) {
		   if (!(queue.front==null)) {
			   temp=queue.dequeue();
			   System.out.println("�Ӷ���ǰ������ȡ����Ԫ������ֵΪ��"+temp);
		   }
		   else
			   break;
	   }
	   System.out.println();
  }
}
