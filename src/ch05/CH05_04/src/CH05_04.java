package ch05.CH05_04.src;// =============== Program Description ===============
// �������ƣ� ch05_04.java                               
// ����Ŀ�ģ�����������˫�����
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
public int dequeue(int action) {
	int value;
	QueueNode tempNode,startNode;
   //��ǰ��ȡ������
   if (!(front==null) && action==1) {
     if(front==rear) rear=null;
     value=front.data; //���������ݴ�ǰ��ȡ��
     front=front.next; //�����е�ǰ��ָ��ָ����һ��
     return value; }
   //��β��ȡ������
   else if(!(rear==null) && action==2) {
	startNode=front;  //�ȼ���ǰ�˵�ָ��ֵ
    value=rear.data;  //ȡ��Ŀǰβ�˵�����
     //��Ѱ��β�˽ڵ��ǰһ���ڵ�
    tempNode=front;
     while (front.next!=rear && front.next!=null) { front=front.next;tempNode=front;}
	   front=startNode;  //��¼��β��ȡ�����ݺ�Ķ���ǰ��ָ��
	   rear=tempNode;    //��¼��β��ȡ�����ݺ�Ķ���β��ָ��
     //��һ�г�����ָ�������н�ʣ�����ڵ�ʱ,ȡ�����ݺ�㽫front��rearָ��null
     if ((front.next==null) || (rear.next==null)) { front=null;rear=null; }
     return value; }
   else return -1;
 }
} //��������������

public class CH05_04 {
// ������
   public static void main(String args[]) throws IOException {
	   Linked_List_Queue queue =new Linked_List_Queue(); //�������ж���
	   int temp;
	   System.out.println("��������ʵ��˫�����");
	   System.out.println("====================================");
	   System.out.println("��˫�����ǰ�˼����1�����ݣ�������ֵΪ1");
	   queue.enqueue(1);
	   System.out.println("��˫�����ǰ�˼����2�����ݣ�������ֵΪ3");
	   queue.enqueue(3);
	   System.out.println("��˫�����ǰ�˼����3�����ݣ�������ֵΪ5");
	   queue.enqueue(5);
	   System.out.println("��˫�����ǰ�˼����4�����ݣ�������ֵΪ7");
	   queue.enqueue(7);
	   System.out.println("��˫�����ǰ�˼����5�����ݣ�������ֵΪ9");
	   queue.enqueue(9);
	   System.out.println("====================================");
	   temp=queue.dequeue(1);
	   System.out.println("��˫�����ǰ������ȡ����Ԫ������ֵΪ��"+temp);
	   temp=queue.dequeue(2);
	   System.out.println("��˫�����β������ȡ����Ԫ������ֵΪ��"+temp);
	   temp=queue.dequeue(1);
	   System.out.println("��˫�����ǰ������ȡ����Ԫ������ֵΪ��"+temp);
	   temp=queue.dequeue(2);
	   System.out.println("��˫�����β������ȡ����Ԫ������ֵΪ��"+temp);
	   temp=queue.dequeue(1);
	   System.out.println("��˫�����ǰ������ȡ����Ԫ������ֵΪ��"+temp);
   System.out.println();
  }
}
