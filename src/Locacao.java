import java.util.GregorianCalendar;

public class Locacao {
	protected int id;
	protected GregorianCalendar prazoDeDevolucao;

	public Locacao(int id, int periodo) { // id do item e periodo em dias
		this.id = id;
		prazoDeDevolucao = new GregorianCalendar();
		prazoDeDevolucao.add(GregorianCalendar.DAY_OF_MONTH, periodo);

	}
	
	public Locacao() {
		reset();
	}
	
	private Locacao(int id, GregorianCalendar prazoDeDevolucao) {
		this.id = id;
		this.prazoDeDevolucao = prazoDeDevolucao;
	}

	protected Locacao copie() {
		Locacao resultado = new Locacao(id, prazoDeDevolucao);
		return resultado;
	}
	
	protected void reset() {
		id = -1;
		prazoDeDevolucao = new GregorianCalendar();
	}
}