import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate myBithday = LocalDate.of(2020, 12, 31);
		System.out.println(myBithday);
		
		int dias = myBithday.getDayOfMonth() - hoje.getDayOfMonth();
		System.out.println(dias);
		
		Period periodo = Period.between(hoje, myBithday);
		System.out.println(periodo.getDays());
		
		LocalDate proximos4Anos = myBithday.plusYears(4);
		System.out.println(proximos4Anos);
		
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = myBithday.format(dataFormatada);
		System.out.println(valorFormatado);
		
		DateTimeFormatter dataFormatadaComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(dataFormatadaComHoras));
		
		LocalTime intervalo = LocalTime.of(15, 35);
		System.out.println(intervalo);
		
	}
}
