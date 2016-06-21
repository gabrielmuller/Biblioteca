
public class Biblioteca {

	private Item[] itens;
	private Usuario[] usuarios;
	
	private int quantidadeUsuarios;
	private int quantidadeItens;
	
	public Biblioteca () {
		quantidadeUsuarios = 0;
		itens = new Item[20];
		usuarios = new Usuario[20];
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
	
	public void printQtd () {
		System.out.println(quantidadeUsuarios);
	}
	
	public Usuario NovoUsuarioVinculado(boolean ehOperador) { //cria um usuario com referencia a esta biblioteca
		Usuario novoUsu = null;
		if (quantidadeUsuarios < 20) {
			if (ehOperador) {
				novoUsu = new Operador(this, 10000 + quantidadeUsuarios);
			} else {
				novoUsu = new Usuario(this, quantidadeUsuarios);
			}
			quantidadeUsuarios++;
		} else if (quantidadeUsuarios == 20) {
			System.err.println("O array de usuarios esta cheio!");
		} else {
			System.err.println("Erro");
		}
		
		return novoUsu;
		
	}
}
