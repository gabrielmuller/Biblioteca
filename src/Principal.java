public class Principal {

	public static void main(String[] args) {
		Biblioteca principal = new Biblioteca();
		Usuario joao = principal.NovoUsuarioVinculado(true);
		Usuario jose = principal.NovoUsuarioVinculado(false);
		
		System.out.println(joao.id);
		System.out.println(jose.id);
		principal.printQtd();
	}

}
