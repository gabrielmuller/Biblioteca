package biblioteca;
public class Principal {

	public static void main(String[] args) {
		Biblioteca principal = new Biblioteca();
		Usuario admin = principal.novoUsuarioVinculado("Ana", true);
		Usuario comum = principal.novoUsuarioVinculado("Bob", false);

		Livro a = new Livro(2, "Hello world", "John", 6);
		Livro b = new Livro(0, "Dom Casmurro", "Machado de Assis", 5);
		Livro c = new Livro(2, "Aaaa Aaa", "Bbbbb", 3);
		Livro d = new Livro(1, "Novembro de 63", "Stephen King", 2);
		Revista e = new Revista(3, "SuperInteressante", "Abril", 192);
		Operador adm = (Operador) admin;
		
		System.out.println(adm.pedirParaCadastrarItem(a));
		System.out.println(adm.pedirParaCadastrarItem(b));
		System.out.println(adm.pedirParaCadastrarItem(c));
		System.out.println(adm.pedirParaCadastrarItem(d));
		System.out.println(adm.pedirParaCadastrarItem(e));
		System.out.println("");
		System.out.println(comum.pedirParaLocarItem(0));
		System.out.println(comum.pedirParaLocarItem("Hello world"));
		System.out.println(comum.pedirParaLocarItem("Dom Casmurro"));
		System.out.println(comum.pedirParaLocarItem("Harry Potter"));
		System.out.println(comum.pedirParaLocarItem(2));
		System.out.println(comum.pedirParaDevolverItem(2));
		System.out.println(comum.pedirParaDevolverItem(4));
		System.out.println(comum.pedirParaLocarItem("Novembro de 63"));
		System.out.println(comum.pedirParaLocarItem(4));
		System.out.println("");
		System.out.println(admin.pedirParaLocarItem(3));
		System.out.println(admin.pedirParaLocarItem(0));
		System.out.println(admin.pedirParaLocarItem(1));
		System.out.println("");
		System.out.println(comum.listaDeItensLocados());
		System.out.println(admin.listaDeItensLocados());

		int id_ = 0;
		System.out.printf("id: %d - Prazo de Devolucao: %s %n", id_, comum.dataDeDevolucao(0));
	}

}
