/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wesley Ricardo
 */
public class TestePilha {
    
	/** 
	 * Vetor de String que armazenará os elementos. 
	 * Se uma posição estiver nula, esta posição será encarada como uma posição 
	 * vazia na pilha. Sendo assim, nunca poderá existir uma posição vazia  
	 * seguida de uma posição não-vazia(diferente de null), pois isso indicaria  
	 * que, de alguma forma, removemos algum elemento da pilha que não o do topo. 
	 */  
	private String[] elements;  
	/** 
	 * inteiro que indicará quantos elementos NÃO NULOS existem dentro de  
	 * elements. Note por exemplo que: 
	 * -Se size for igual a 26, o topo da pilha está na posição 25 de elements 
	 * -Se size for igual a 10, o topo da pilha está na posição 9 de elements 
	 * -Se size for igual a n, o topo da pilha está na posição (n - 1) de elements 
	 * Resumindo, podemos assumir QUASE sempre que o topo da pilha é a posição  
	 * (size - 1) de elements. 
	 * O "quase" se deve ao caso de quando nossa pilha é vazia. Nesse caso,  
	 * size é igual a 0. Se fossemos seguir a regra acima indistintamente,  
	 * acabaríamos assumindo que neste caso o topo da pilha está na posição -1  
	 * de elements, o que é um erro... Trata-se então de uma exceção, a qual  
	 * deveremos estar atentos para fazer bobagem! 
	 * Para fins didáticos, criaremos um método privado que retorna a posição  
	 * exata do topo da pilha, e sempre utilizaremos este método para termos tal 
	 * informação. 
	 */  
	private int size;  
	/** 
	 * Construtor que recebe um int como parâmetro, indicando qual será a  
	 * capacidade da pilha recém-instanciada 
	 */  
	public TestePilha(int capacity) {  
		/* 
		* Utilizamos o método abs da classe Math só pra evitar que se tente  
		* criar uma pilha "devedora"... 
		*/  
		elements = new String[Math.abs(capacity)];  
		size = 0;  
	}  
	/** 
	 * Método utilizado para adicionar elementos à nossa pilha. Este elemento  
	 * sempre será inserido no topo deta pilha. 
	 * -Se o elemento for null, vamos lançar uma exceção, informando que nossa  
	 * pilha não aceita null como elemento válido. 
	 * -Se a pilha estiver cheia, retornamos null para indicar que não foi  
	 * possível insirir elemento. 
	 * -Se o elemento for inserido com sucesso, retornamos o próprio elemento,  
	 * indicando assim o sucesso da operação 
	 */  
	public String push(String element) {  
		if(element == null)  
			throw new IllegalArgumentException("O elemento não pode ser nulo!");  
		if(size == elements.length)  
			return null;  
		size++;  
		elements[getTopPosition()] = element;  
		return element;  
	}  
	/** 
	 * Método utilizado para se obter o elemento que está no topo desta pilha,  
	 * porém, sem removê-lo da mesma. 
	 * -Se a pilha estiver vazia, retornamos null para indicar que a pilha  
	 * está vazia. 
	 * -Se houver ao menos um elemento na pilha, o elemento que está no topo  
	 * será retornado, indicando o sucesso da operação 
	 */  
	public String peek() {  
		if(isEmpty())  
			return null;  
		return elements[getTopPosition()];  
	}  
	/** 
	 * Método utilizado para retirar("destacar") um elemento desta pilha. Este  
	 * elemento sempre será aquele que se encontra no topo desta pilha. 
	 * -Se a pilha estiver vazia, retornamos null para indicar que a pilha  
	 * está vazia. 
	 * -Se houver ao menos um elemento na pilha, o elemento que está no topo  
	 * será retornado, indicando o sucesso da operação 
	 */  
	public String pop() {
		String result = peek();  
		/*Se havia um elemento no topo da pilha...*/  
		if(result != null) {  
			elements[getTopPosition()] = null;  
			size--;  
		}  
		return result;  
	}  
	/** 
	 * Método utilizado para limpar todo o conteúdo da pilha. 
	 */  
	public void clear() {  
		for(int i = 0; i < size; i++)  
			elements[i] = null;  
		size = 0;  
	}  
	/**
	 * Método utilizado para se obter o tamanho (número de elementos) da pilha 
	 */  
	public int getSize() {  
		return size;  
	}  
	/** 
	 * Método utilizado para se obter a capacidade da pilha 
	 */  
	public int getCapacity() {  
		return elements.length;  
	}
	/**
	 * Método utilizado para verificar se a pilha está vazia. Se for o caso, 
	 * será retornado true, caso contrário, será retornado false.
	 */
	public boolean isEmpty() {
		return size <= 0;
	}
	/** 
	 * Este método tem uma finalidade estritamente didática, visando facilitar o  
	 * entendimento do código desta classe. 
	 * Este método retorna um inteiro que representa a posição de elements onde  
	 * se encontra o último elemento inserido nesta pilha (O topo da pilha) 
	 */  
	private int getTopPosition() {
		if (isEmpty())
			return 0;
		return size - 1;  
	}
	/** 
	 * Este método serve para representar textualmente esta pilha 
	 * @see java.lang.Object#toString() 
	 */  
	public String toString() {  
		StringBuilder sb = new StringBuilder("[");  
		for(int i = 0; i < size; i++) {  
			sb.append(elements[i]);  
			if(i < size - 1)  
			  sb.append(" | ");  
		}  
		sb.append(">");  
		return sb.toString();  
	}  
}
    

