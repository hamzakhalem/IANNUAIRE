import java.util.Arrays;

public class Personne implements Comparable<Object> {

  // des constantes definissant les valeurs possiblses pour
  // la civilité
	
	public static enum Typeciv{
		INCONNU,MR,MME,MLLE;
	}



 // private static final String[] civil_ = { "", "Mr", "Mme", "Mlle"}; 

  //------------------------------------------------------
  // les attributs d'un objet personne
  //------------------------------------------------------
  private String nom_;
  private String prenom_;
  private Typeciv civilite_ = Typeciv.INCONNU;

  //------------------------------------------------------
  // les constructeurs
  //------------------------------------------------------

  /**
   * crée un personne en indiquant son nom et son prenom, sa civilité n'est pas
   * specifiée et est initialisée à INCONNU
   * @param nom le nom de la personne
   * @param prenom le prenom de la personne
   */
  public Personne (String nom, String prenom) {
    this(Typeciv.INCONNU,nom,prenom);
  }


  /**
   * crée un personne en indiquant sa civilité, son nom et son prenom.
   * @param civilite la civilité de la personne. Seules quatre valeurs sont
   *        admises pour la civilité définies par les constantes INCONNU, 
   *        MR, MME et MLLE. Si une valeur de civilité incorrecte est fournie
   *        en paramètre, la personne est alors créée avec une civilité fixée
   *        à INCONNU.
   * @param nom le nom de la personne
   * @param prenom le prenom de la personne
   */
  public Personne (Typeciv civilite, String nom, String prenom) {
    nom_ = nom;
    prenom_ = prenom;
    if (civiliteCorrecte(civilite)) 
        civilite_ = civilite;
    else
        civilite_ =Typeciv.INCONNU ;
  }

  //------------------------------------------------------
  // les méthodes
  //------------------------------------------------------  

  //---- accesseurs --------------------------------------
  /**
   * retourne le nom de la personne
   * @return le nom de la personne
   */
  public String getNom() {
    return nom_;
  }

  /**
   * retourne le prenom de la personne
   * @return le prenom de la personne
   */
  public String getPrenom() {
    return prenom_;
  }

  /**
   * retourne la civilite de la personne
   * @return la civilite de la personne
   */
  public Typeciv getCivilite() {
    return civilite_;
  }

  //---- modifieurs ---------------------------------------
  
  /**
   * modifie la civilite de la personne. Seules les modification suivantes
   * sont autorisées :<BR>
   * <UL>
   *   <LI>INCONNU --> MR, MME ou MLLE</LI>
   *   <LI>MLLE --> MME</LI>
   * </UL>
   * Toute autre modification est sans effet sur la personne 
   */
  public void setCivilite(Typeciv civilite) {
      if (civiliteCorrecte(civilite)) {
          switch (civilite_) {
              case INCONNU:   civilite_ = civilite;
                              break;
              case MLLE:      if (civilite == Typeciv.MME)
                                 civilite_ = Typeciv.MME;
                              break;
              default:        // on ne fait rien
                              break;
          }
      }
  }
  //-------------------------------------------------------
  // méthodes héritées de la classe Object et redéfinies
  //-------------------------------------------------------

  public String toString() {
    return civilite_+ " " + prenom_ + " " + nom_;
  }

  //--------------------------------------------------------
  // méthodes privées utilitaires
  //--------------------------------------------------------
  
  /**
   * Teste si une valeur de civilité est correcte.
   * @param civilite la valeur de civilité à tester
   * @return true si <code>civilite</code> définit une
   *         valeur correcte, false sinon
   */
  private boolean civiliteCorrecte(Typeciv civilite) {
	return  Arrays.stream(Typeciv.values()).anyMatch((t) -> t.name().equals(civilite));
  }

  public boolean equals(Object ob) {
	    if (ob instanceof Personne== false ) 
	      return false;
      Personne pr = (Personne) ob;
	    return nom_.equals(pr.nom_) && prenom_.equals(pr.prenom_) && civilite_ == pr.civilite_;

	  }

  public int hashCode() {
    return (nom_ +""+ prenom_+""+civilite_).hashCode(); }


@Override
public int compareTo(Object o) {
	if (o instanceof Personne==false )
        return -1; 
     Personne p = (Personne) o;
     return (nom_ +prenom_ +civilite_).compareTo(p.nom_ + p.prenom_ + p.civilite_);
}
  
}// Personne





