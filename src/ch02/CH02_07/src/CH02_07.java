package ch02.CH02_07.src;// =============== Program Description ===============
// �������ƣ� CH02_07.java                               
// ����Ŀ�ģ������Ӧ��-�����Ǿ���
// ===================================================

class CH02_07 
{
	    private int[] arr;    
	    private int array_size;        
	    public CH02_07(int[][] array) {
		        array_size = array.length;        
		        arr = new int[array_size*(1+array_size)/2];                
		        int index = 0;        
		        for(int i = 0; i < array_size; i++) {             
		        for(int j = 0; j < array_size; j++) {                 
		        if(array[i][j] != 0)                     
		        arr[index++] = array[i][j];             
		        }         
		        }    
		        }        
		public int getValue(int i, int j) 
		{        
		int index = array_size*i - i*(i+1)/2 + j;        
		return arr[index];    
		}    
		public static void main(String[] args) 
		{        
		int[][] array = {
			                 {76,  0,  0,  0,  0},                 
			                 {54, 51,  0,  0,  0},                 
			                 {23, 8, 26,  0,  0},                 
			                 { 43,  35,  28, 18,  0},                 
			                 { 12,  9,  14, 35, 46}};                
		CH02_07 Array_object = new CH02_07(array);
		int i=0, j=0 ;
		System.out.println("==========================================") ;
		System.out.println("�������ξ���");
		for ( i = 0 ; i < Array_object.array_size ; i++ ) 
		{
			for ( j = 0 ; j < Array_object.array_size ; j++ ) 
		        System.out.print("\t"+ array[i][j]);
		    System.out.println();    
		}
				System.out.println("==========================================") ;
		System.out.println("��һά�ķ�ʽ��ʾ��");
		System.out.print("\t"+"[");
		for ( i = 0 ; i < Array_object.array_size ; i++ ) 
		{
			for ( j = i ; j < Array_object.array_size ; j++ ) 
		        System.out.print(" "+Array_object.getValue(i, j));
		}
		System.out.print(" ]");
		System.out.println();    
    }
}
