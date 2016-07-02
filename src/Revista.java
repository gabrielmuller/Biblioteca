
public class Revista extends Item {
	private String editora;
	private int edicao;
	
	public Revista(int numExemplares, String nome, String editora, int edicao) {
		super(numExemplares, nome);
		this.editora = editora;
		this.edicao = edicao;
	}
		
}