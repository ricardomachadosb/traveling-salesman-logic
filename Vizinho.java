
/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Vizinho {
    private Cidade cidade;
    private Integer distancia;

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the distancia
     */
    public Integer getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
    
    @Override
    public String toString() {
    	if(this.cidade != null){
    		return this.cidade.toString();
    	}
    	return null;
    }
}
