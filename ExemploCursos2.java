import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Curso1 {

	private String name;
	private int alunos;
	
	public Curso1(String name, int alunos) {
		this.name = name;
		this.alunos = alunos;
	}

	public String getName() {
		return name;
	}

	public int getAlunos() {
		return alunos;
	}
	
	
}

public class ExemploCursos2 {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 300));
		cursos.add(new Curso("C", 2));
		cursos.add(new Curso("SQL", 20));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getName()));
		
	/*	cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			//.forEach(c -> System.out.println(c.getName()))
			.map(c -> c.getAlunos())
			.forEach(System.out::println); */
		
		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();
//		System.out.println(sum);

		OptionalDouble media = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.average(); // ao inves de sum se chamar o metodo average, ele devolve um OptionalDouble 
		
		
		// aula 05
		// o stram eh um fluxo de objetos
		Optional<Curso> optionalCurso = cursos.stream() // qdo atribuimos uma variavel é lançado um Optional (ele nao devolve um Curso), que eh uma classe nova do java8
			.filter(c -> c.getAlunos() >= 100)	// Optional ajuda a gente a trabalhar com null, sem ter q ficar verificando se isso eh igual a null
			.findAny(); // pega qquer um que tem mais de 100
		
		//optionalCurso.get(); te devolve o curso, porem se nao encontrar, ele vai te devolver um noSuchElement
//		Curso curso1 = optionalCurso.get();
//		System.out.println(curso1.getName());

		// o metodo orElse faz null getName e lança o NPE
//		Curso curso = optionalCurso.orElse(null);
//		System.out.println(curso.getName());
		
//		optionalCurso.ifPresent(c -> System.out.println(c.getName())); //se estiver com c -> c.getAlunos() >= 1000 nao devolve nada
//		optionalCurso.ifPresent(c -> System.out.println(c.getName())); //getAlunos() >= 100 devolve o JavaScript  
		
/*		cursos.stream() //podemos tbm fazer o stream direto equivalendo das linhas 54 a 67
			.filter(c -> c.getAlunos() >= 100)
			.findAny()
			.ifPresent(c -> System.out.println(c.getName()));
*/	
		cursos.parallelStream() 
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toMap( //Collectors.toMap devolvem uma map
					c -> c.getName(),
					c -> c.getAlunos()))
			.forEach((name, alunos) -> System.out.println(name + " tem " + alunos +" alunos "));
		
	}
}
