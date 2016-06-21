
public class Usuario {
	protected int id; //de 00000 a 99999
	protected boolean ehOperador;
	private Biblioteca estaBiblioteca;
	
	public Usuario (Biblioteca estaBiblioteca, int id) {
		this.estaBiblioteca = estaBiblioteca;
		this.id = id;
		ehOperador = false;
	}
}
