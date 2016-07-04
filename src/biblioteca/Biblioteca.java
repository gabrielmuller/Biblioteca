package biblioteca;

public class Biblioteca implements InterfBiblioteca {

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

	public int getItem(String nome) {
		Item item = null;
		for (int i = 0; i < itens.length && item == null; i++) {
			if (itens[i] != null) {
				if (itens[i].nome == nome) {
					item = itens[i];
				}
			}
		}
		int resultado = -1;
		if (item != null) {
			resultado = item.id;
		}
		return resultado;
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
		String resultado = "Item " + i.nome + " nao cadastrado: voce nao eh operador!";
		if (u.ehOperador) {
			itens[quantidadeItens] = i;
			i.id = quantidadeItens;

			quantidadeItens++;
			resultado = "Item " + i.nome + " cadastrado.";
		}
		return resultado;
	}

	public String locarItem(int id, Usuario u, String nomePedido) {
		String resultado;
		String nomeDoItem = "N/A";
		if (nomePedido != "") {
			nomeDoItem = nomePedido;
		}
		
		if (id < 0 || id >= itens.length) {
			resultado = "Item nao existe!";
		} else if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else {
			nomeDoItem = itens[id].nome;
			if (itens[id].exemplaresDispo <= 0) {
				resultado = "Item esgotado!";
			} else if (u.getLocacaoDoItem(id) != null) {
				resultado = "Voce ja tem este item!";
			} else {
				Locacao l = new Locacao(id, periodoDeEmprestimo);
				boolean sucesso = addLocacao(locacoes[u.id], l);
				if (sucesso) {
					resultado = "Item locado com sucesso.";
					itens[id].exemplaresDispo--;
				} else {
					resultado = "Voce tem itens demais.";
				}
			}
		}

		return "Pedido de locacao do item " + nomeDoItem + " por " + u.nome + ": " + resultado;
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

	public String devolverItem(int id, Usuario u, String nomePedido) {
		String resultado;
		String nomeDoItem = "N/A";
		if (nomePedido != "") {
			nomeDoItem = nomePedido;
		}
		
		Locacao estaLoc = getLocacaoDoItem(id, u);
		if (id < 0 || id >= itens.length) {
			resultado = "Item nao existe!";
		} else if (itens[id] == null) {
			resultado = "Item nao existe!";
		} else {
			nomeDoItem = itens[id].nome;
			if (estaLoc == null) {
				resultado = "Voce nao tem este item!";
			} else {
				itens[id].exemplaresDispo++;

				// reseta a locacao do item escolhido
				estaLoc.reset();
				resultado = "Item devolvido.";
			}
		}

		return "Pedido de devolucao do item " + nomeDoItem + " por " + u.nome + ": " + resultado;
	}

	private Locacao getLocacaoDoItem(int id, Usuario u) {
		// se o usuario tiver item, retorna a locacao deste item.
		// se nao tiver, retorna null
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
		// cria um usuario com referencia a esta biblioteca
		Usuario novoUsu = null;
		if (quantidadeUsuarios < 20) {
			if (ehOperador) {
				novoUsu = new Operador(this, quantidadeUsuarios, nome);
			} else {
				novoUsu = new Usuario(this, quantidadeUsuarios, nome);
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
