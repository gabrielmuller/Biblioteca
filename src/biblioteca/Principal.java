package biblioteca;
public class Principal {

	public static void main(String[] args) {
		Biblioteca principal = new Biblioteca();
		Usuario admin = principal.novoUsuarioVinculado("Joao", true);
		Usuario comum = principal.novoUsuarioVinculado("Jose", false);

		Livro a = new Livro(2, "Hello world", "John", 6);
		Livro b = new Livro(0, "Dom Casmurro", "Machado de Assis", 5);
		Livro c = new Livro(2, "Aaaa Aaa", "Bbbbb", 3);
		Livro d = new Livro(1, "Novembro de 63", "Stephen King", 2);
		Revista e = new Revista(3, "SuperInteressante", "Abril", 192);

		((Operador) admin).pedirParaCadastrarItem(a);
		((Operador) admin).pedirParaCadastrarItem(b);
		((Operador) admin).pedirParaCadastrarItem(c);
		((Operador) admin).pedirParaCadastrarItem(d);
		((Operador) admin).pedirParaCadastrarItem(e);

		System.out.println(comum.pedirParaLocarItem(0));
		System.out.println(comum.pedirParaLocarItem(0));
		System.out.println(comum.pedirParaLocarItem(1));
		System.out.println(comum.pedirParaLocarItem(2));
		System.out.println(comum.pedirParaDevolverItem(2));
		System.out.println(comum.pedirParaLocarItem(3));
		System.out.println(comum.pedirParaLocarItem(4));
		System.out.println("");
		System.out.println(comum.listaDeItensLocados());
		int id_ = 0;
		System.out.printf("id: %d - Prazo de Devolucao: %s %n", id_, comum.dataDeDevolucao(0));
	}

}
