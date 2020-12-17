import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Curso {

	private String name;
	private int alunos;
	
	public Curso(String name, int alunos) {
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

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso1> cursos = new ArrayList<Curso1>();
		cursos.add(new Curso1("Python", 45));
		cursos.add(new Curso1("JavaScript", 150));
		cursos.add(new Curso1("Java 8", 300));
		cursos.add(new Curso1("C", 2));
		cursos.add(new Curso1("SQL", 20));
		
		cursos.sort(Comparator.comparing(Curso1::getAlunos));
//		cursos.forEach(c -> System.out.println(c.getName()));
		
	/*	cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			//.forEach(c -> System.out.println(c.getName()))
			.map(c -> c.getAlunos())
			.forEach(System.out::println); */
		
		int sum = cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.mapToInt(Curso1::getAlunos)
		.sum();
		
		System.out.println(sum);
	}
}
