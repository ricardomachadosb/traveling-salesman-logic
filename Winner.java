
public class Winner {
	Nodo nodo;
	Integer km;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Distancia: " + km + "\n");
		sb.append(nodo.vizinho + "\n");
		
		while(nodo.next != null){
			sb.append(nodo.next.vizinho + "\n");
			nodo = nodo.next;
		}
		return sb.toString();
	}
}
