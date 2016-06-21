
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
	
	public Item getItemByName(String n) {
		Item resultado = null;
		for (int i = 0; i < itens.length && resultado == null; i++) {
			if (itens[i].nome == n) {
				resultado = itens[i];
			}
		}
		return resultado;
	}
	
	public String NovoItem(Item i, Usuario u) {
		String resultado = "Item nao cadastrado.";
		if (u.ehOperador) {
			itens[quantidadeItens] = i;
			quantidadeItens++;
			resultado = "Item cadastrado";
		}
		return resultado;
	}
	
	public String LocarItem(int id, Usuario u) {
		String resultado;
		if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else if (itens[id].exemplaresDispo <= 0) {
			resultado = "Item esgotado!";
		} else if (u.meusItens[id]) {
			resultado = "Voce ja tem este item!";
		} else {
			itens[id].exemplaresDispo--;
			u.meusItens[id] = true;
			resultado = "Item locado.";
		}
		return resultado;
	}
	
	public String DevolverItem(int id, Usuario u) {
		String resultado;
		if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else if (!u.meusItens[id]) {
			resultado = "Voce nao tem este item!";
		} else {
			itens[id].exemplaresDispo++;
			u.meusItens[id] = false;
			resultado = "Item devolvido.";
		}
		return resultado;
	}
	
	public InformacoesDeItem ConsultarItem(int id) {
		Item esteItem = itens[id];
		InformacoesDeItem resultado = new InformacoesDeItem(esteItem.numExemplares, esteItem.nome);
		resultado.exemplaresDispo = esteItem.exemplaresDispo;
		resultado.id = id;
		return resultado;
	}
	
	public Usuario NovoUsuarioVinculado(String nome, boolean ehOperador) { //cria um usuario com referencia a esta biblioteca
		Usuario novoUsu = null;
		if (quantidadeUsuarios < 20) {
			if (ehOperador) {
				novoUsu = new Operador(this, quantidadeUsuarios);
			} else {
				novoUsu = new Usuario(this, quantidadeUsuarios);
			}
			usuarios[quantidadeUsuarios] = novoUsu;
			quantidadeUsuarios++;
		} else if (quantidadeUsuarios == 20) {
			System.err.println("O array de usuarios esta cheio!");
		} else {
			System.err.println("Erro");
		}
		
		return novoUsu;
		
	}
	
	public int getItensLength () {
		return itens.length;
	}
}
