
public class Livro extends Item {
	private String autor;
	private int edicao;
	
	public Livro(int numExemplares, String nome, String autor, int edicao) {
		super(numExemplares, nome);
		this.autor = autor;
		this.edicao = edicao;
	}
		
}
