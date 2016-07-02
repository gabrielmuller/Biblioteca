package biblioteca;
public class Operador extends Usuario {

	public Operador(Biblioteca estaBiblioteca, int id, String nome) {
		super(estaBiblioteca, id, nome);
		this.ehOperador = true;
	}

	public String pedirParaCadastrarItem(Item itemNovo) {
		return estaBiblioteca.novoItem(itemNovo, this);
	}

}
