package Day2;

public class MatrixChainMultiplication {
	
	public static int solve(int numMatrix, int[] matrixSize) {
		int numOps = 0;
		
		// Array for memorization
		int[][] mem = new int[numMatrix][numMatrix];
		
		for(int i=1; i<numMatrix; i++) {
			mem[i][i] = 0;
		}
		
		for(int l=2; l<numMatrix; l++) {
			
			for(int i=1; i<numMatrix-l+1; i++) {
				
				int j=i+l-1;
				
				if(j == numMatrix)
					continue;
				
				mem[i][j] = Integer.MAX_VALUE;
				
				for(int k=i; k<j; k++) {
					int ops = mem[i][k] + mem[k+1][j] + matrixSize[i-1]*matrixSize[k]*matrixSize[j];
					if(ops < mem[i][j])
						mem[i][j] = ops;
				}
			}
		}
		
		numOps = mem[1][numMatrix-1];
		return numOps;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4}; 
        int size = arr.length; 
  
        System.out.println("Minimum number of multiplications is "+ solve(size, arr)); 
	}

}
