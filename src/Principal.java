public class Principal {

	public static void main(String[] args) {
		Biblioteca principal = new Biblioteca();
		Usuario admin = principal.novoUsuarioVinculado("Joao", true);
		Usuario comum = principal.novoUsuarioVinculado("Jose", false);

		Livro a = new Livro(2, "Hello world", "John", 6);
		Livro b = new Livro(0, "Dom Casmurro", "Machado de Assis", 5);
		Livro c = new Livro(2, "Aaaa Aaa", "Bbbbb", 3);

		((Operador) admin).pedirParaCadastrarItem(a);
		((Operador) admin).pedirParaCadastrarItem(b);
		((Operador) admin).pedirParaCadastrarItem(c);

		System.out.println(comum.pedirParaLocarItem(0));
		System.out.println(comum.pedirParaLocarItem(0));
		System.out.println(comum.pedirParaLocarItem(1));
		System.out.println(comum.pedirParaLocarItem(2));
		System.out.println(comum.pedirParaDevolverItem(2));
		System.out.println("");
		System.out.println(comum.listaDeItensLocados());
	}

}
