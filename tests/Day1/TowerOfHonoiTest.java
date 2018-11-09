package Day1;

import static org.junit.Assert.assertFalse;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Day1.TowerOfHonoi.Movement;

public class TowerOfHonoiTest {
	
	TowerOfHonoi p;
	
	@Before
	public void setupBeforeClass() {
		p = new TowerOfHonoi();
	}
	
	@Test
	public void test3Disks() {
		LinkedList<Movement> sol = p.solve(3, "A", "C", "B");
		assertFalse(testDiskMovesAcrossRods(3, "A", "C", "B", sol));
	}
	
	@Test
	public void test4Disks() {
		LinkedList<Movement> sol = p.solve(4, "A", "C", "B");
		assertFalse(testDiskMovesAcrossRods(4, "A", "C", "B", sol));
	}
	
	private boolean testDiskMovesAcrossRods(int noDisks, String fromRod, String toRod, String auxRod, List<Movement> sol) {
		
		boolean isBreakingConstraints = false;
		int fromRodWeight = noDisks;
		int toRodWeight = noDisks+1;
		int auxRodWeigth = noDisks+1;
		
		int fromRodDisks = noDisks;
		int toRodDisks = 0;
		int auxRodDisks = 0;
		
		for(Movement move: sol) {
			if(move.getFromRod().equals(fromRod)) {
				if(fromRodDisks > 0)
					fromRodDisks--;
				else
					return true;
			}
			
			if(move.getFromRod().equals(toRod)) {
				if(toRodDisks > 0)
					toRodDisks--;
				else
					return true;
			}
			
			if(move.getFromRod().equals(auxRod)) {
				if(auxRodDisks > 0)
					auxRodDisks--;
				else
					return true;
			}
			
			if(move.getToRod().equals(fromRod) && ((fromRodDisks==0) || (fromRodDisks>0 && fromRodWeight>move.getDisk()))) {
				fromRodWeight = move.getDisk();
				
				if(fromRodDisks < noDisks)
					fromRodDisks++;
				else
					return true;
				
				continue;
			}
			
			if(move.getToRod().equals(toRod) && ((toRodDisks==0) || (toRodDisks>0 && toRodWeight>move.getDisk()))) {
				toRodWeight = move.getDisk();
				
				if(toRodDisks < noDisks)
					toRodDisks++;
				else
					return true;
				
				continue;
			}
			
			if(move.getToRod().equals(auxRod) && ((auxRodDisks==0) || (auxRodDisks>0 && auxRodWeigth>move.getDisk()))) {
				auxRodWeigth = move.getDisk();
				
				if(auxRodDisks < noDisks)
					auxRodDisks++;
				else
					return true;
				
				continue;
			}
			
			return true;
			
		}
		
		return isBreakingConstraints;
		
	}

}
