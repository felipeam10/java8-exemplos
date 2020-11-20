import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	public static void main(String[] args) {
		//dada uma lista de strings, eu quero ordena-la
		List<String> palavras = new ArrayList<String>();
		palavras.add("aula on line");
		palavras.add("escola");
		palavras.add("carro"); 
		
		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparador); //antes no java 7
		palavras.sort(comparador); //agora no java 8
		System.out.println(palavras);
		
		for (String p : palavras) { //antes no java 7
			System.out.println(p);
		}
		
		Consumer<String> consumidor = new ImprimeNaLinha(); //agora no java 8 
		palavras.forEach(consumidor);
		
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
		
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return-1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}