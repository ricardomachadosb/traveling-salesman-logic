
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ricardo
 */
public class Mapa {

    List<Cidade> cidades = new ArrayList<>();

    public Cidade cidadePorNome(String nome) {
        for (Cidade c : cidades) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

    public void carregarMapa() {
        try {
            //Troque o caminho abaixo, apontando para seu arquivo de mapa.
            FileReader fIn = new FileReader("c:\\temp\\cidades.txt");
            BufferedReader in = new BufferedReader(fIn);
            String linha;
            Cidade cidade = null, cidadeVizinha;
            Vizinho vizinho;
            Boolean vizinhos = false;
            while ((linha = in.readLine()) != null) {
                if(linha.length() == 0){
                    vizinhos = true;
                    continue;
                }
                if (vizinhos) {
                    String dadosVizinho[] = linha.split("(?=\\D)\\s(?=\\d)");
                    if(dadosVizinho.length == 1){
                        cidade = cidadePorNome(dadosVizinho[0]);
                    }else{
                        cidadeVizinha = cidadePorNome(dadosVizinho[0]);
                        vizinho = new Vizinho();
                        vizinho.setCidade(cidadeVizinha);
                        vizinho.setDistancia(Integer.parseInt(dadosVizinho[1]));
                        cidade.addVizinho(vizinho);
                    }
                    
                    
                }else{
                    cidade = new Cidade();
                    cidade.setNome(linha);
                    cidades.add(cidade);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Cidade cidade : cidades) {
            out.append("=>Cidade: ");
            out.append(cidade.getNome());
            out.append("\n");
            for(Vizinho vizinho:cidade.getVizinhos()){
                out.append("Vizinho: ");
                out.append(vizinho.getCidade().getNome());
                out.append(" Distancia: ");
                out.append(vizinho.getDistancia());
                out.append("\n");
            }
        }
        return out.toString();
    }
    
    
}
