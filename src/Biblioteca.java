
public class Biblioteca {

	private Item[] itens;
	private Usuario[] usuarios;

	private Locacao[][] locacoes = new Locacao[20][5];
	private int quantidadeUsuarios;
	private int quantidadeItens;
	private int periodoDeEmprestimo;

	public Biblioteca() {
		quantidadeUsuarios = 0;
		itens = new Item[20];
		usuarios = new Usuario[20];
		periodoDeEmprestimo = 15;
		for (Locacao[] i : locacoes) {
			for (int k = 0; k < i.length; k++) {
				i[k] = new Locacao();
			}
		}
	}

	public Item getItem(String nome) {
		Item resultado = null;
		for (int i = 0; i < itens.length && resultado == null; i++) {
			if (itens[i].nome == nome) {
				resultado = itens[i];
			}
		}
		return resultado;
	}

	public Item getItem(int id) {
		return itens[id];
	}

	public Locacao[] getLocacoes(Usuario u) { // envia suas locacoes para
												// leitura apenas.
		Locacao[] minhasLoc = locacoes[u.id];
		Locacao[] resultado = new Locacao[minhasLoc.length];
		for (int i = 0; i < minhasLoc.length; i++) {
			resultado[i] = minhasLoc[i].copie();
		}
		return resultado;
	}

	public String novoItem(Item i, Usuario u) {
		String resultado = "Item nao cadastrado.";
		if (u.ehOperador) {
			itens[quantidadeItens] = i;
			quantidadeItens++;
			resultado = "Item cadastrado";
		}
		return resultado;
	}

	public String locarItem(int id, Usuario u) {
		String resultado;
		if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else if (itens[id].exemplaresDispo <= 0) {
			resultado = "Item esgotado!";
		} else if (u.getLocacaoDoItem(id) != null) {
			resultado = "Voce ja tem este item!";
		} else {
			Locacao l = new Locacao(id, periodoDeEmprestimo);
			boolean sucesso = addLocacao(locacoes[u.id], l);
			if (sucesso) {
				resultado = "Item locado com sucesso.";
			} else {
				resultado = "Voce tem itens demais.";
			}
		}
		return resultado;
	}

	private boolean addLocacao(Locacao[] ll, Locacao l) {
		boolean resultado = false;
		for (int i = 0; i < ll.length && !resultado; i++) {
			if (ll[i].id == -1) {
				resultado = true;
				ll[i] = l;
			}
		}
		return resultado;
	}

	public String devolverItem(int id, Usuario u) {
		String resultado;
		Locacao estaLoc = getLocacaoDoItem(id, u);
		if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else if (estaLoc == null) {
			resultado = "Voce nao tem este item!";
		} else {
			itens[id].exemplaresDispo++;
			
			//reseta a locacao do item escolhido
			estaLoc.reset();
			resultado = "Item devolvido.";
		}
		return resultado;
	}

	private Locacao getLocacaoDoItem(int id, Usuario u) {
		//se o usuario tiver item, retorna a locacao deste item.
		//se nao tiver, retorna null
		Locacao resultado = null;
		for (int i = 0; i < locacoes[u.id].length && resultado == null; i++) {
			if (id == locacoes[u.id][i].id) {
				resultado = locacoes[u.id][i];
			}
		}
		return resultado;
	}

	public InformacoesDeItem consultarItem(int id) {
		Item esteItem = itens[id];
		InformacoesDeItem resultado = new InformacoesDeItem(esteItem.numExemplares, esteItem.nome);
		resultado.exemplaresDispo = esteItem.exemplaresDispo;
		resultado.id = id;
		return resultado;
	}

	public Usuario novoUsuarioVinculado(String nome, boolean ehOperador) { 
		//cria um usuario com referencia a esta biblioteca
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

	public int getItensLength() {
		return itens.length;
	}
}
