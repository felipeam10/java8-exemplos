import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

//AULA 2: LAMBDAS

public class OrdenaStrings2 {
	public static void main(String[] args) {
		//dada uma lista de strings, eu quero ordena-la
		List<String> palavras = new ArrayList<String>();
		palavras.add("aula on line");
		palavras.add("escola");
		palavras.add("carro"); 
		
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length())); // equivale ao fonte da linha 15 a 21 que tbm equivale da linha 47 a 58
		System.out.println(palavras);
		
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor);
				
/*		palavras.forEach(new Consumer<String>() { //sem o lambda
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
*/
/*		palavras.forEach((String s) -> { //com o lambda
				System.out.println(s);	 //esse lambda ainda possui alguns itens opcionais
			}
		);
*/
		palavras.forEach(s -> System.out.println(s)); //lambda formal //essa linha eh equivalente as linhas 27 e 28
		
	}
}

class ComparadorPorTamanho2 implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return-1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}