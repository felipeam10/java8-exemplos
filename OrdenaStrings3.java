import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

//AULA 2: LAMBDAS

public class OrdenaStrings3 {
	public static void main(String[] args) {
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

//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length)); //essas duas sintaxes sao equivalentes :: tbm é um lambda
		
//		Function<String, Integer> funcao = s -> s.length(); //das linhas 28 a 35 sao equivalentes a linha 26
/*		Function<String, Integer> funcao = new Function<String, Integer>() {

			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
*/
		Function<String, Integer> funcao = String::length;
		Function<String, Integer> funcao2 = s -> s.length(); //equiv a linha 38
		
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador);		
		
		System.out.println(palavras);
		
		Consumer<String> impressor = s -> System.out.println(s);
		Consumer<String> impressor2 = System.out::println; //equiv a linha 46
		palavras.forEach(impressor);
				
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
		
	}
}

class ComparadorPorTamanho3 implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return-1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}