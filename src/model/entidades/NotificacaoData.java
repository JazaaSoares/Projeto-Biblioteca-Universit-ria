package model.entidades;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotificacaoData {
	public void validaDataEntrega(LocalDate  data) {

		LocalDate dataAtual = LocalDate.now();

		long diferencaDias = ChronoUnit.DAYS.between(dataAtual, data);

		if (Math.abs(diferencaDias) == 1) {
			System.out.println("\u001B[31m" + "Atenção: A data de devolução está próxima!" + "\u001B[0m");
		
		
	     }
     }
}