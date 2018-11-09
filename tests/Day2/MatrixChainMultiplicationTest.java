package Day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatrixChainMultiplicationTest {

	@Test
	public void test3Matrices() {
		int expectedAnswer = 18;
		
		int[] matrices = new int[] {1, 2, 3, 4};
		int actualAnswer = MatrixChainMultiplication.solve(matrices.length, matrices);
		
		assertEquals(expectedAnswer, actualAnswer);
	}
	
	@Test
	public void test4Matrices() {
		int expectedAnswer = 26000;
		
		int[] matrices = new int[] {40, 20, 30, 10, 30};
		int actualAnswer = MatrixChainMultiplication.solve(matrices.length, matrices);
		
		assertEquals(expectedAnswer, actualAnswer);
	}
	
	@Test
	public void test4MatricesInOtherOrder() {
		int expectedAnswer = 30000;
		
		int[] matrices = new int[] {10, 20, 30, 40, 30};
		int actualAnswer = MatrixChainMultiplication.solve(matrices.length, matrices);
		
		assertEquals(expectedAnswer, actualAnswer);
	}
	
	@Test
	public void test2Matrices() {
		int expectedAnswer = 6000;
		
		int[] matrices = new int[] {10, 20, 30};
		int actualAnswer = MatrixChainMultiplication.solve(matrices.length, matrices);
		
		assertEquals(expectedAnswer, actualAnswer);
	}

}
