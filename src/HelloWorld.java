import java.util.ArrayList;
import java.util.Iterator;
import com.senac.SimpleJava.Console;

public class HelloWorld {
	public void run() {

		Console.println(ShowExtenso(Console.readInt("informe um numero: ")));
	}

	public static String Dezena(char[] digitos) {
		String texto = "";

		if (digitos[0] == 1) {
			char d = digitos[1];
			for (int i = 0; i < GetTipoDezena(2).length; i++) {
				if (i == Character.getNumericValue(d)) {
					texto = GetTipoDezena(2)[i];
				}
			}
		} else {
			char d = digitos[0];

			for (int i = 0; i < GetTipoDezena(3).length; i++) {
				if (i == Character.getNumericValue(d) - 2) {
					texto = GetTipoDezena(3)[i];
				}
			}

			if (digitos[1] != 0) {
				char d2 = digitos[1];
				for (int i = 0; i < GetTipoDezena(1).length; i++) {
					if (i == Character.getNumericValue(d2)) {
						texto = texto + " e " + GetTipoDezena(1)[i];
					}
				}
			}
		}

		return texto;

	}

	public static String Centena(char[] digitos) {
		String texto = "";
		char d = digitos[0];
		for (int i = 0; i < GetTipoDezena(4).length; i++) {
			if (i == Character.getNumericValue(d) - 1) {
				texto = GetTipoDezena(4)[i];
			}
		}

		if ((digitos[1] != '0') && (digitos[1] == '1')) {
			char d1 = digitos[2];
			for (int i = 0; i < GetTipoDezena(2).length; i++) {
				if (i == Character.getNumericValue(d1)) {
					texto = texto + " e " + GetTipoDezena(2)[i];
				}
			}
		}
		if ((digitos[1] != '0') && (digitos[1] > '1')) {
			char d2 = digitos[1];
			for (int i = 0; i < GetTipoDezena(3).length; i++) {
				if (i == Character.getNumericValue(d2) - 2) {
					texto = texto + " e " + GetTipoDezena(3)[i];
				}
			}
		}
		if ((digitos[2] != '0')) {
			char d3 = digitos[2];
			for (int i = 0; i < GetTipoDezena(1).length; i++) {
				if (i == Character.getNumericValue(d3)) {
					texto = texto + " e " + GetTipoDezena(1)[i];
				}
			}
		}
		
		return texto;

	}
	
	public static String Unidade(int numero){
		String texto = "";
		
		for (int i = 0; i < GetTipoDezena(1).length; i++) {
			if (i == numero)
				texto = GetTipoDezena(1)[i];
		}
		
		return texto;
	}
	
	
	public static int GetQuatidadeCasasDecimais(int numero) {
		int contator = 1;
		int testeCasas = numero;

		while ((testeCasas = testeCasas / 10) > 0) {
			contator++;
		}

		return contator;
	}

	public static String[] GetTipoDezena(int tipo) {
		String[] unidade = { "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", };
		String[] dezena1 = { "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezesete", "dezoito",
				"desenove", };
		String[] dezena2 = { "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa", };
		String[] centena = { "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos",
				"oitocentos", "novecentos" };

		String[] uni = unidade;

		switch (tipo) {
		case 1:
			uni = unidade;
			break;
		case 2:
			uni = dezena1;
			break;
		case 3:
			uni = dezena2;
			break;
		case 4:
			uni = centena;
			break;

		default:
			break;
		}
		return uni;

	}

	public static String ShowExtenso(int numero) {

		String texto = "";
		int contador = 0;

		char[] digitos = String.valueOf(numero).toCharArray();
		contador= GetQuatidadeCasasDecimais(numero);
		
		switch (contador) {
		case 1:
			texto= Unidade(numero);
			break;
		case 2:
			texto= Dezena(digitos);
			break;
		case 3:
			texto= Centena(digitos);

			break;
		default:
			break;
		}
		return texto;
	}
}
