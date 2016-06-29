public class Operador extends Usuario {

	public Operador(Biblioteca estaBiblioteca, int id) {
		super(estaBiblioteca, id);
		this.ehOperador = true;
	}

	public String pedirParaCadastrarItem(Item itemNovo) {
		return estaBiblioteca.novoItem(itemNovo, this);
	}

}
