package Day1;

import java.util.LinkedList;

public class TowerOfHonoi {
	
	private void moveDisk(int disk, String fromRod, String toRod, LinkedList<Movement> sol) {
		Movement m = new Movement(disk, fromRod, toRod);
		sol.add(m);
		System.out.println(String.format("Disk %d moved from rod %s to rod %s", disk, fromRod, toRod));
	}
	
	private void applySolution(int disk, String fromRod, String toRod, String auxRod, LinkedList<Movement> sol) {
		
		if(disk == 1) {
			moveDisk(disk, fromRod, toRod, sol);
			return;
		}
		
		applySolution(disk-1, fromRod, auxRod, toRod, sol);
		moveDisk(disk, fromRod, toRod, sol);
		applySolution(disk-1, auxRod, toRod, fromRod, sol);
	}
	
	public LinkedList<Movement> solve(int noDisks, String fromRod, String toRod, String auxRod) {
		LinkedList<Movement> sol = new LinkedList<>();
		applySolution(noDisks, fromRod, toRod, auxRod, sol);
		return sol;
	}
	
	class Movement{
		int disk;
		String fromRod;
		String toRod;
		
		public Movement(int disk, String fromRod, String toRod) {
			super();
			this.disk = disk;
			this.fromRod = fromRod;
			this.toRod = toRod;
		}

		public int getDisk() {
			return disk;
		}

		public String getFromRod() {
			return fromRod;
		}

		public String getToRod() {
			return toRod;
		}
		
	}
	
	public static void main(String[] args) {
		TowerOfHonoi p = new TowerOfHonoi();
		p.solve(4, "A", "C", "B");
	}

}
