import java.util.GregorianCalendar;
public class Locacao {
    protected int id;
    protected GregorianCalendar prazoDeDevolucao;
    
    public Locacao (int id, int periodo) { //id do item e periodo em dias
        this.id = id;
        prazoDeDevolucao = new GregorianCalendar();
        prazoDeDevolucao.add(prazoDeDevolucao.DAY_OF_MONTH, periodo);
        
    }
    
    private Locacao (int id, GregorianCalendar prazoDeDevolucao) {
        this.id = id;
        this.prazoDeDevolucao = prazoDeDevolucao;
    }
    protected Locacao copie () {
        Locacao resultado = new Locacao(id, prazoDeDevolucao);
        return resultado;
    }
    
}
