
public class Usuario {
	protected int id; //de 0 a 20
	protected boolean ehOperador;
	protected Biblioteca estaBiblioteca;
	
	public Usuario (Biblioteca estaBiblioteca, int id) {
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
                Locacao[] meusItens = estaBiblioteca.getLocacoes(this);
		for (int i = 0; i < meusItens.length; i++) {
			if (tenhoItem(i)) {
				InformacoesDeItem info = estaBiblioteca.consultarItem(i);
				resultado = resultado + info.nome + "\n";
			}
		}
		return resultado;
	}
        
        protected boolean tenhoItem(int id) {
            boolean resultado = false;
            Locacao[] meusItens = estaBiblioteca.getLocacoes(this);
            for (int i = 0; i < meusItens.length && !resultado; i++) {
            	if (id == i) {
                    resultado = true;
                }
            }
            return resultado;
        }
        
}
