

public class NumTel {


	public static final char FIXE_PROF = 'T';

	
	public static final char FIXE_DOM = 'D';

	public static final char PORTABLE = 'P';

	public static final char FAX = 'F';

	public static final char INCONNU = '?';

	// ----------------------------------------------
	// attributs (variables de classes)
	// ----------------------------------------------
	private int numero;

	private char type;

	// ----------------------------------------------
	// Constructeurs
	// ----------------------------------------------

	/**
	 * crée un numéro de téléphone d'un type donné.
	 * 
	 * @param num
	 *            le numéro de téléphone
	 * @param type
	 *            son type (si ce type n'est pas 'T','D','P' ou 'F', la valeur
	 *            INCONNU ('?') sera associée à ce numéro).
	 */
	public NumTel(int num, char type) {
		this.numero = num;
		setType(type);
	}

	/**
	 * crée un numéro de téléphone de type inconnu
	 * 
	 * @param num
	 *            le numéro de téléphone
	 */
	public NumTel(int num) {
		this(num, INCONNU);
	}

	// ----------------------------------------------
	// méthodes
	// ----------------------------------------------

	// ---- accesseurs --------------------------------------
	/**
	 * retourne le numéro de téléphone
	 * 
	 * @return le numéro.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * retourne le type de ce numéro de téléphone
	 * 
	 * @return le type.
	 */
	public char getType() {
		return type;
	}

	// ---- modifieurs --------------------------------------
	/**
	 * change le type de ce numéro de téléphone
	 * 
	 * @param type
	 *            le nouveau type pour ce numéro. (si ce type n'est pas
	 *            'T','D','P' ou 'F', la valeur INCONNU ('?') sera associée à ce
	 *            numéro).
	 */
	public void setType(char type) {
		switch (type) {
		case FIXE_PROF:
		case FIXE_DOM:
		case PORTABLE:
		case FAX:
			this.type = type;
			break;
		default:
			this.type = INCONNU;
		}
	}


	public String toString() {
		return numero + " (" + type + ")";
	}


	public boolean equals(Object o) {
		if (!(o instanceof NumTel))
			return false;

		NumTel num = (NumTel) o;

		return this.numero == num.numero;
	}

	public int hashCode() {
		return numero;
	}

}// NumTel
