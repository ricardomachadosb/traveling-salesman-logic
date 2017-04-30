
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Exec {

	static Cidade origin;
	static Cidade destiny;
	static Nodo currentNodo = null;
	static Winner winner = null;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Mapa mapa = new Mapa();
		mapa.carregarMapa();
//		System.out.println(mapa);

		origin = mapa.cidadePorNome("Eforie");
		destiny = mapa.cidadePorNome("Drobeta");

		System.out.println(origin + " " + destiny);

		start();
		System.out.println(winner);
	}

	private static void start() {
		currentNodo = new Nodo();
		loopVizinhos(origin.getVizinhos());
	}

	private static void loopVizinhos(List<Vizinho> vizinhos) {
		for (Vizinho vizinho : vizinhos) {
			if(addToNodo(vizinho)){
				//removeLast();
			}
		}
		removeLast();
	}

	private static boolean addToNodo(Vizinho vizinho) {
		if (!nodoContainsCity(vizinho.getCidade()) && !vizinho.getCidade().equals(origin)) {
			if(winner != null){
				Integer distance = calculateDistance(currentNodo);
				if(distance + vizinho.getDistancia() > winner.km){
					return false;
				}
			}
			System.out.println("Vizinho adicionado: " + vizinho.getCidade().toString());
			addLast(vizinho, currentNodo);
			if(vizinho.getCidade().equals(destiny)){
				win();
				removeLast();
				return true;
			}
			loopVizinhos(vizinho.getCidade().getVizinhos());
			return true;
		}
		return false;
	}
	
	

	private static boolean nodoContainsCity(Cidade cidade) {
		if (currentNodo.vizinho != null) {
			if ((currentNodo.vizinho.getCidade().equals(cidade))) {
				return true;
			}
		}

		Nodo nodo = currentNodo;
		while (nodo.next != null) {
			if (nodo.next.vizinho.getCidade().equals(cidade)) {
				return true;
			}
			nodo = nodo.next;
		}

		return false;
	}

	private static void addLast(Vizinho vizinho, Nodo nodoInstance) {
		Nodo nodo = nodoInstance;

		if (nodoInstance.vizinho == null) {
			nodoInstance.vizinho = vizinho;
			return;
		}

		while (nodo.next != null) {
			nodo = nodo.next;
		}

		Nodo newNodo = new Nodo();
		newNodo.vizinho = vizinho;

		nodo.next = newNodo;
		newNodo.previous = nodo;
	}
	
	private static void removeLast(){
		if(currentNodo.next == null && currentNodo.vizinho != null){
			System.out.println("removed: " + currentNodo.vizinho);
			currentNodo.vizinho = null;
		}
		
		Nodo nodo = currentNodo;
		while(nodo.next != null){
			if(nodo.next.next == null){
				System.out.println("removed: " + nodo.next.vizinho.getCidade());
				nodo.next = null;
				break;
			}else {
				nodo = nodo.next;
			}
		}
	}
	
	private static void win(){
		Integer distance = calculateDistance(currentNodo);
		if(winner == null){
			System.out.println("chegou Com distancia de: " + distance);
			newInner(currentNodo);
		}else {
			distance = calculateDistance(currentNodo);
			if(distance < winner.km){
				newInner(currentNodo);
				System.out.println("Novo record, chegou com distancia de: " + distance);
			}
		}
	}
	
	private static void newInner(Nodo newWinner){
		Nodo nodoClonned = cloneNodo(newWinner);
		winner = new Winner();
		winner.nodo = nodoClonned;
		winner.km = calculateDistance(nodoClonned);
	}
	
	private static Nodo cloneNodo(Nodo nodo){
		Nodo newNodo = new Nodo();
		newNodo.vizinho = nodo.vizinho;
		
		Nodo nodoToLoop = nodo;
		while(nodoToLoop.next != null){
			addLast(nodoToLoop.next.vizinho, newNodo);
			nodoToLoop = nodoToLoop.next;
		}
		
		return newNodo;
	}
	
	private static Integer calculateDistance(Nodo nodo){
		Integer distance = 0;

		Nodo nodoToLoop = nodo;
		while(nodoToLoop != null){
			Vizinho v = nodoToLoop.vizinho;
			if(v != null){
				distance += v.getDistancia();
			}
			nodoToLoop = nodoToLoop.next;
		}
		return distance;
	}
}
