package ch07.CH07_07.src;// =============== Program Description ===============
// �������ƣ� CH07_07.java                               
// ����Ŀ�ģ� Dijkstra�㷨(�����ȫ����������·��) 
// ===================================================

// ͼ�ε����ھ���������
class Adjacency { 
   final int INFINITE = 99999;        
   public int[][] Graph_Matrix;         
   // ���캯��
   public Adjacency(int[][] Weight_Path,int number) {
      int i, j;      
      int Start_Point, End_Point;            
      Graph_Matrix = new int[number][number]; 
      for ( i = 1; i < number; i++ )
         for ( j = 1; j < number; j++ )
            if ( i != j )
               Graph_Matrix[i][j] = INFINITE;     
            else
               Graph_Matrix[i][j] = 0;            
         for ( i = 0; i < Weight_Path.length; i++ ) { 
            Start_Point = Weight_Path[i][0];           
            End_Point = Weight_Path[i][1];             
            Graph_Matrix[Start_Point][End_Point] = Weight_Path[i][2];
         }
   }
   // ��ʾͼ�εķ���
   public void printGraph_Matrix() {
      for ( int i = 1; i < Graph_Matrix.length; i++ ) {
         for ( int j = 1; j < Graph_Matrix[i].length; j++ )
            if ( Graph_Matrix[i][j] == INFINITE )
               System.out.print(" x ");
            else {  
                 if ( Graph_Matrix[i][j] == 0 ) System.out.print(" ");
                 System.out.print(Graph_Matrix[i][j] + " ");
            } 
            System.out.println();
      }
   }
}

// Dijkstra�㷨��
class Dijkstra extends Adjacency {
   private int[] cost;       
   private int[] selected;  
   //���캯��
   public Dijkstra(int[][] Weight_Path,int number) {
      super(Weight_Path,number);
      cost = new int[number];          
      selected = new int[number];
      for ( int i = 1; i < number; i++ )  selected[i] = 0;
   }
   /// �����ȫ��������̾���
   public void shortestPath(int source) {
      int shortest_distance;                   
      int shortest_vertex= 1;                 
      int i,j;
      for ( i = 1; i < Graph_Matrix.length; i++ )
         cost[i] = Graph_Matrix[source][i]; 
      selected[source] = 1;          
      cost[source] = 0;              
      for ( i = 1; i < Graph_Matrix.length-1; i++ ) {
         shortest_distance = INFINITE;            
         for ( j = 1; j < Graph_Matrix.length; j++ )
            if ( shortest_distance>cost[j] && selected[j]==0 ) {
               shortest_vertex= j;            
               shortest_distance = cost[j];    
            }
         selected[shortest_vertex] = 1;        
         for ( j = 1; j < Graph_Matrix.length; j++ ) {
           if ( selected[j] == 0 &&  
               cost[shortest_vertex]+Graph_Matrix[shortest_vertex][j] < cost[j]) {
             cost[j] = cost[shortest_vertex] + Graph_Matrix[shortest_vertex][j];
           }
         }
      }
      System.out.println("==================================");
      System.out.println("����1����������̾�������ս��");
      System.out.println("==================================");
      for (j=1;j<Graph_Matrix.length;j++) 
         System.out.println("����1������"+j+"����̾���= "+cost[j]);
   }
   
}
// ����
public class CH07_07 {
	// ������
   public static void main(String[] args) {
      int Weight_Path[][] = { {1, 2, 10},{2, 3, 20}, 
                       {2, 4, 25},{3, 5, 18},
                       {4, 5, 22},{4, 6, 95},{5, 6, 77} };
      Dijkstra object=new Dijkstra(Weight_Path,7);  
      System.out.println("==========================");
      System.out.println("�˷���ͼ�ε����ھ�������: ");
      System.out.println("==========================");
      object.printGraph_Matrix();  
      object.shortestPath(1);     
   }
}
