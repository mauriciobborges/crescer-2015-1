package filmator;
import java.util.ArrayList;

public class Filme {
	private ArrayList<Ator> elenco = new ArrayList<>();
	private String titulo;
	private Genero genero;
	
	public Filme(String titulo){
		this.titulo=titulo;
	}
	public Filme(String titulo, Genero genero){
		this.titulo=titulo;
		this.genero=genero;
	}
	
	public String toString(){
		String aux = "Titulo: " + this.titulo + "\nElenco:";
		for(Ator ator: this.elenco){
			aux = aux + " " + ator.toString();
		}
		return aux;
	}
	public void inserirAtor(Ator ator){
		this.elenco.add(ator);
	}
	public ArrayList<Ator> temIssoNoNome(String isso){
		ArrayList<Ator> aux = new ArrayList<>();
		for(Ator ator: elenco){
			if(ator.toString().contains(isso)){
				aux.add(ator);
			}
		}
		return aux;
	}

	public String getTitulo() {
		return titulo;
	}
	public Genero getGenero() {
		return genero;
	}
	

}