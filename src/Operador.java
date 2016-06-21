public class Operador extends Usuario {
	
	public Operador (Biblioteca estaBiblioteca, int id) {
		super(estaBiblioteca, id);
		this.ehOperador = true;
	}
	
	private void CadastrarItem(Item itemNovo) {
		System.out.println("item cadastrado");
	}

}
