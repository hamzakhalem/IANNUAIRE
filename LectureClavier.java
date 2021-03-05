
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LectureClavier {

	private static BufferedReader stdin = new BufferedReader(
			new InputStreamReader(System.in));

	public static int lireEntier(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireEntier();
	}
	
	public static int lireEntier() {
		try {
			return (Integer.parseInt(stdin.readLine()));
		} catch (IOException e) {
			erreurEntree(e, "entier");
			return 0; // même si on passe jamais ici il faut un return !!
		}
	}


	public static String lireChaine(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireChaine();
	}


	public static String lireChaine() {
		try {
			return (stdin.readLine());
		} catch (IOException e) {
			erreurEntree(e, "chaine de caractères");

			return null;
		}
	}

	public static float lireFloat(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireFloat();
	}

	public static float lireFloat() {

		try {
			return (Float.valueOf(stdin.readLine()).floatValue());
		} catch (IOException e) {
			erreurEntree(e, "réel (float)");

			return (float) 0.0;
		}
	}

	public static double lireDouble(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireDouble();
	}


	public static double lireDouble() {
		try {
			return (Double.valueOf(stdin.readLine()).doubleValue());
		} catch (IOException e) {
			erreurEntree(e, "réel (double)");
			return 0.0;
		}
	}


	public static boolean lireOuiNon(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireOuiNon();
	}


	public static boolean lireOuiNon() {
		String ch;
		ch = lireChaine();
		return (ch.equals("o") || ch.equals("O"));
	}

	public static char lireChar(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return lireChar();
	}

 static char lireChar() {
		String ch;
		ch = lireChaine();
		return ch.charAt(0);
	}
	
	private static void erreurEntree(Exception e, String message) {
		System.out.println("Erreur lecture " + message);
		System.out.println(e);
		e.printStackTrace();
		System.exit(1);
	}

} // LectureClavier
