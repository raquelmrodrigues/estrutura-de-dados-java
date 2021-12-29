package conjunto;

public class TesteConjunto {

	public static void main(String[] args) {
		
	Conjunto conjunto = new Conjunto();
	conjunto.adiciona("Mauricio");
	System.out.println(conjunto);
	
	conjunto.adiciona("Marcelo");
	System.out.println(conjunto);
	
	conjunto.adiciona("Cristina");
	System.out.println(conjunto);
	
	conjunto.remove("Cristina");
	System.out.println(conjunto);
		
	}
}
