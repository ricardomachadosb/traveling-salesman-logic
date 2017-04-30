
public class Winner {
	Cidade origin;
	Nodo nodo;
	Integer km;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Distancia: " + km + "\n");
		sb.append(origin + " 0" + "\n");
		sb.append(nodo.vizinho + " "+ String.valueOf(nodo.vizinho.getDistancia()) + "\n");
		
		while(nodo.next != null){
			sb.append(nodo.next.vizinho + " " + String.valueOf(nodo.next.vizinho.getDistancia()) + "\n");
			nodo = nodo.next;
		}
		return sb.toString();
	}
}
