package listaligada;

public class TesteListaLigada {
	
	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		
		lista.adicionaNoComeco("Mauricio");
		lista.adicionaNoComeco("Paulo");
		lista.adicionaNoComeco("Ricardo");
		
		System.out.println(lista);
		
		lista.removeDoComeco();
		
		System.out.println(lista);
	}
}
