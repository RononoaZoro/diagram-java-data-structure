package ch07.CH07_05.src;// =============== Program Description ===============
// �������ƣ� CH07_05.java                               
// ����Ŀ�ģ��ȹ����������(BFS) 
// ===================================================

class Node {
   int x;
   Node next;
   public Node(int x) {
      this.x=x;
      this.next=null;
   }
}
class GraphLink {
   public Node first;
   public Node last;
   public boolean isEmpty() {
      return first==null;
   }
   public void print() {
      Node current=first;
      while(current!=null) {
         System.out.print("["+current.x+"]");
	 current=current.next;
      }
      System.out.println();
   }
   public void insert(int x) {
      Node newNode=new Node(x);
      if(this.isEmpty()) {
         first=newNode;
	 last=newNode;
      }
      else {
	 last.next=newNode;
	 last=newNode;
      }
   }
}

public class CH07_05 {	
   public static int run[]=new int[9];//������¼�������Ƿ������
   public static GraphLink Head[]=new GraphLink[9];	
   public final static int MAXSIZE=10; //������е��������	
   static int[] queue= new int[MAXSIZE];//�������������
   static int front=-1; //ָ����е�ǰ��
   static int rear=-1; //ָ����еĺ��
   //�������ݵĴ���
   public static void enqueue(int value) {
      if(rear>=MAXSIZE) return;
      rear++;
      queue[rear]=value;
   }
   //�������ݵ�ȡ�����X
   public static int dequeue() {
      if(front==rear) return -1;
      front++;
      return queue[front];
   }
   //�������������
   public static void bfs(int current) {
      Node tempnode; //��ʱ�Ľڵ�ָ��
      enqueue(current); //����һ������������
      run[current]=1; //���������Ķ����趨Ϊ1
      System.out.print("["+current+"]"); //��ӡ�ñ������Ķ���
      while(front!=rear) { //�ж�Ŀǰ�Ƿ�Ϊ�ն���
         current=dequeue(); //������Ӷ�����ȡ��
         tempnode=Head[current].first; //�ȼ�¼Ŀǰ�����λ��
         while(tempnode!=null) {
            if(run[tempnode.x]==0) {
               enqueue(tempnode.x);
               run[tempnode.x]=1; //��¼�ѱ�����
               System.out.print("["+tempnode.x+"]");
            }
	    tempnode=tempnode.next;
         }
      }
   }

   public static void main (String args[]) {
      int Data[][] =  //ͼ�α������������C�ŧi
      { {1,2},{2,1},{1,3},{3,1},{2,4},{4,2},{2,5},{5,2},{3,6},{6,3},
      {3,7},{7,3},{4,5},{5,4},{6,7},{7,6},{5,8},{8,5},{6,8},{8,6} };
      int DataNum;			
      int i,j;				
      System.out.println("ͼ�ε��ڽӱ����ݣ�"); //��ӡͼ�ε��ڽӱ�����
      for( i=1 ; i<9 ; i++ ) { //���а˸�����
    	  run[i]=0; //�趨���ж������δ������
		 Head[i]=new GraphLink();	
		 System.out.print("����"+i+"=>");
		 for( j=0 ; j<20 ;j++) {
		    if(Data[j][0]==i) { //������ͱ�ͷ��ȣ���Ѷ�������
		       DataNum = Data[j][1];
		       Head[i].insert(DataNum);
		    }
		 }
		 Head[i].print();  //��ӡͼ�ε��ڽӱ�����
      }		
      System.out.println("������ȱ������㣺");   //��ӡ������ȱ����Ķ���
      bfs(1);
      System.out.println("");
   }
}
