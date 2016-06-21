
public class Biblioteca {

	private Item[] itens;
	private Usuario[] usuarios;
	
	private int quantidadeUsuarios;
	
	public Biblioteca () {
		quantidadeUsuarios = 0;
		itens = new Item[0];
		usuarios = new Usuario[0];
	}
	
	public Item getItemByName(String name) {
		return new Livro();
	}
	
	public Item getItemById(int id) {
		return new Livro(); 
	}
	
	public void NovoItem(Item i) {
		
	}
	
	public void LocarItem(Item i, Usuario u) {
		
	}
	
	public void DevolverItem(Item i, Usuario u) {
		
	}
	
	public void ConsultarItem(Item i) {
		
	}
	
	public Usuario NovoUsuarioVinculado(boolean ehOperador) { //cria um usuario com referencia a esta biblioteca
		Usuario novoUsu;
		if (ehOperador) {
			novoUsu = new Operador(this, 10000 + usuarios.length+1);
		} else {
			novoUsu = new Usuario(this, usuarios.length+1);
		}
		return novoUsu;
	}
}
