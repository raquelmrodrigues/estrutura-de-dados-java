package listaDuplamenteLigada;

import listaligada.Celula;

public class ListaDuplamenteLigada {

	private Celula primeira = null;
	private Celula ultima = null;
	private int totalDeElementos = 0;

	public void adicionaNoComeco(Object elemento) {

		if(this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		
		this.totalDeElementos++;
	}
	
	@Override
	public String toString() {
		if(this.totalDeElementos == 0) {
			return "[]";
		}
		
		Celula atual = primeira;
		
		StringBuilder builder = new StringBuilder("[");
		
		for(int i = 0; i < totalDeElementos; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			
			atual = atual.getProximo();
		}
		
		builder.append("]");
		
		return builder.toString();
	}
	
	public void adicionaNoFinal(int posicao, Object elemento) {
		
		if(this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProximo(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inexistente");
		}
		
		Celula atual = primeira;
		
		for(int i = 0; i <posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}
	
	public void adicionaNoMeio(int posicao, Object elemento) {
		
		if(posicao == 0) {
			adicionaNoComeco(elemento);
		} else if(posicao == this.totalDeElementos) {
			adicionaNoComeco(elemento);
		} else {
		 Celula anterior = this.pegaCelula(posicao - 1);
		 Celula anterior = anterior.getProximo();
		 Celula nova = new Celula(elemento, anterior.getProximo());
		 nova.setAnterior(anterior);
		 anterior.setProximo(nova);
		 proxima.setAnterior(nova);
		 this.totalDeElementos++;
		}
	}
	
	public Object pega(int posicao ) {
		return this.pegaCelula(posicao).getElemento();
	}
	
	public void removeDoComeco() {
		if(this.totalDeElementos == 0) {
			throw new IllegalArgumentException("Lista vazia")
		}
		this.primeira = this.primeira.getProximo();
		this.totalDeElementos--;
		
		if(this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}
	
	public void removeDoFim() {
		if(this.totalDeElementos == 1) {
			removeDoComeco();
		} else {
			Celula penultima = this.ultima.getAnterior();
			penultima.setProximo(null);
			this.ultima = penultima;
			this.totalDeElementos--;
		}
	}
	
	public void remove(int posicao) {
		if(possicao == 0) {
			this.removeDoComeco();
		} else if(posicao == this.totalDeElementos) {
			this.removeDoFim();
		} else {
			Celula anterior =this.pegaCelula(posicao -1);
			Celula atual = anterior.getProximo();
			Celula proxima = atual.getProximo();
			
			anterior.setProximo(proxima);
			proxima.setAnterior(anterior);
			
			this.totalDeElementos--;
		}
	}
	
	public int tamanho() {
		return this.totalDeElementos;
	}
	
	public boolean contem(Object o ) {
		Celula atual = this.primeira;
		
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}
}
