package vetor;

public class VetorTeste {
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno("Jo�o");
		Aluno a2 = new Aluno("Jos�");
		Aluno a3 = new Aluno("Danilo");
		
		Vetor lista = new Vetor();
		
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		System.out.println(lista);
		
	}

}
