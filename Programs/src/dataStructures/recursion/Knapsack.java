package dataStructures.recursion;

public class Knapsack {
	static int matrix[][] = new int[100][100];
	static int picks[][] = new int[100][100];
	static int subset[] = new int[100];
	static int knapsack(int nItems, int size, int weights[], int values[]){
	    int i,j;
	 
	    for (i=1;i<=nItems;i++){
	        for (j=0;j<=size;j++){
	            if (weights[i-1]<=j){
	                matrix[i][j] = Math.max(matrix[i-1][j],values[i-1]+matrix[i-1][j-weights[i-1]]);
	                if (values[i-1]+matrix[i-1][j-weights[i-1]]>matrix[i-1][j])
	                    picks[i][j]=1;
	                else
	                    picks[i][j]=-1;
	            }
	            else{
	                picks[i][j] = -1;
	                matrix[i][j] = matrix[i-1][j];
	            }
	        }
	    }
	 
	    return matrix[nItems][size];
	 
	}
	
	public static void printPicks(int item, int size, int weights[]){
		int k=0;
	    while (item>0){
	        if (picks[item][size]==1){
	            subset[k++]=item;
	            item--;
	            size -= weights[item];
	        }
	        else{
	            item--;
	        }
	    }
	    //Your subset here
	    for(int i=k-1;i>=0;--i)
			System.out.print(subset[i]+" ");
	 
	 
	return;
	}
	
	public static void main(String args[]){
		int nItems = 5;
	    int knapsackSize = 8;
	    int weights[] = {0,2,3,4,5};
	    int values[] = {0,1,2,5,6};
	    
	    System.out.println(knapsack(nItems,knapsackSize,weights,values));
	    
	    printPicks(nItems,knapsackSize, weights);
        
        
    }
}
