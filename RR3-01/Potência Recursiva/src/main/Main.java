package main;

public class Main {

	public static void main(String[] args) {
		int expoente = 10;
		int valor = 2;
		System.out.println(potencia(valor, expoente));
		
}
	
	public static long potencia(int valor, int expoente) {
		int result = 1;
		int i = 1;

		return potencia(valor, expoente, i, result);
	}
	private static long potencia(int valor, int expoente, int i, int result) {
		if (i <= expoente) {
			result = (int) (valor * potencia(valor, expoente, i + 1, result));
		}
		return result;
	}
}
