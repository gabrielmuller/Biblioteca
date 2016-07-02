package biblioteca;
public interface InterfBiblioteca {
	public String novoItem(Item i, Usuario u);
	public String locarItem(int id, Usuario u, String nomePedido);
	public String devolverItem(int id, Usuario u);
	public InformacoesDeItem consultarItem(int id);
	public int getItensLength();
	public Usuario novoUsuarioVinculado(String nome, boolean ehOperador);
	public Locacao[] getLocacoes(Usuario u);
}