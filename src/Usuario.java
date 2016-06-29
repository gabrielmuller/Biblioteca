
public class Usuario {
	protected int id; // de 0 a 20
	protected boolean ehOperador;
	protected Biblioteca estaBiblioteca;

	public Usuario(Biblioteca estaBiblioteca, int id) {
		this.estaBiblioteca = estaBiblioteca;
		this.id = id;
		ehOperador = false;

	}

	public String pedirParaLocarItem(int id) {
		return estaBiblioteca.locarItem(id, this);
	}

	public String pedirParaDevolverItem(int id) {
		return estaBiblioteca.devolverItem(id, this);
	}

	public String listaDeItensLocados() {
		String resultado = "";
		Locacao[] minhasLoc = estaBiblioteca.getLocacoes(this);
		for (int i = 0; i < minhasLoc.length; i++) {
			int idDestaLoc = minhasLoc[i].id;
			if (idDestaLoc != -1) {
				InformacoesDeItem info = estaBiblioteca.consultarItem(idDestaLoc);
				resultado = resultado + info.nome + "\n";
			}
		}
		return resultado;
	}

	protected Locacao getLocacaoDoItem(int id) {
		//se o usuario tiver item, retorna a locacao deste item.
		//se nao tiver, retorna null
		Locacao resultado = null;
		Locacao[] minhasLoc = estaBiblioteca.getLocacoes(this);
		for (int i = 0; i < minhasLoc.length && resultado == null; i++) {
			if (id == minhasLoc[i].id) {
				resultado = minhasLoc[i];
			}
		}
		return resultado;
	}

}
