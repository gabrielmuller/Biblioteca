
public class Usuario {
	protected int id; //de 0 a 20
	protected boolean ehOperador;
	protected boolean[] meusItens;
	protected Biblioteca estaBiblioteca;
	
	public Usuario (Biblioteca estaBiblioteca, int id) {
		this.estaBiblioteca = estaBiblioteca;
		this.id = id;
		ehOperador = false;
		
		meusItens = new boolean[estaBiblioteca.getItensLength()];
		for (boolean b : meusItens) {
			b = false;
		}
	}
	
	public String pedirParaLocarItem(int id) {
		return estaBiblioteca.LocarItem(id, this);
	}
	
	public String pedirParaDevolverItem(int id) {
		return estaBiblioteca.DevolverItem(id, this);
	}
	
	
	public String listaDeItensLocados() {
		String resultado = "";
		for (int i = 0; i < meusItens.length; i++) {
			if (meusItens[i]) {
				InformacoesDeItem info = estaBiblioteca.ConsultarItem(i);
				resultado = resultado + info.nome + "\n";
			}
		}
		return resultado;
	}
}
