
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Cidade {
    private String nome;
    private List<Vizinho> vizinhos = new ArrayList<>();

    public void addVizinho(Vizinho v){
        vizinhos.add(v);
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the vizinhos
     */
    public List<Vizinho> getVizinhos() {
        return vizinhos;
    }
    
    @Override
    public String toString() {
    	return getNome();
    }
    
    public boolean equals(Cidade cidade) {
    	return cidade.getNome().equals(this.getNome());
    }
}
