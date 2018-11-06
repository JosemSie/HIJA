package TheRango;

import vista.vistaRangos;

public class Main {

	public static void main(String[] args) {
		
		new Tablero(new Rang(new String[]{}));
	}
	
	
	
}

/*Tablero table = new Tablero(new Rang(new String[]{"JJ+", "ATs-A2s"}));
System.out.print(table.toString());
table.selectCord(8, 8);
table.selectCord(12, 9);
System.out.print(table.toString());
table.selectCord(11, 12);
table.selectCord(10, 12);
table.selectCord(9, 12);
table.selectCord(8, 12);
table.selectCord(0, 11);
table.selectCord(0, 12);
System.out.print(table.toString());
Tablero table2 = new Tablero(new Rang(new String[] {"TT+", "AJs-A2s", "K2o", "ATo+", "A2o"}));
System.out.print(table2.toString());		
}*/