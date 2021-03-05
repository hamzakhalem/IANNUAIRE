

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
	 * cr�e un num�ro de t�l�phone d'un type donn�.
	 * 
	 * @param num
	 *            le num�ro de t�l�phone
	 * @param type
	 *            son type (si ce type n'est pas 'T','D','P' ou 'F', la valeur
	 *            INCONNU ('?') sera associ�e � ce num�ro).
	 */
	public NumTel(int num, char type) {
		this.numero = num;
		setType(type);
	}

	/**
	 * cr�e un num�ro de t�l�phone de type inconnu
	 * 
	 * @param num
	 *            le num�ro de t�l�phone
	 */
	public NumTel(int num) {
		this(num, INCONNU);
	}

	// ----------------------------------------------
	// m�thodes
	// ----------------------------------------------

	// ---- accesseurs --------------------------------------
	/**
	 * retourne le num�ro de t�l�phone
	 * 
	 * @return le num�ro.
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * retourne le type de ce num�ro de t�l�phone
	 * 
	 * @return le type.
	 */
	public char getType() {
		return type;
	}

	// ---- modifieurs --------------------------------------
	/**
	 * change le type de ce num�ro de t�l�phone
	 * 
	 * @param type
	 *            le nouveau type pour ce num�ro. (si ce type n'est pas
	 *            'T','D','P' ou 'F', la valeur INCONNU ('?') sera associ�e � ce
	 *            num�ro).
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
