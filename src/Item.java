
public abstract class Item {
	protected int id; //id entre 0 e 20, -1 quando sem id
	protected int numExemplares;
	protected String nome;
	protected int exemplaresDispo;
	
	public Item (int numExemplares, String nome) {
		this.id = -1;
		this.numExemplares = numExemplares;
		this.exemplaresDispo = numExemplares;
		this.nome = nome;
	}
}