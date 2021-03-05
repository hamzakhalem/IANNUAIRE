import java.util.Iterator;

/**
 * Annuaire téléphonique permettant d'associer à une Personne une liste de numéros de téléphones.
 *
 * <br>Created: Tue Dec 04 21:25:14 2001
 *
 * @see NumTel
 * @see Personne
 * @see ImpListeNumTel
 * @author <a href="mailto:Philippe.Genoud@imag.fr">Philippe Genoud</a>
 * @version
 */

public interface IAnnuaire {
    

    public boolean ajouterEntree(Personne p, IListeNumTel nums) ;
    

    public void ajouterNumeroFin(Personne p, NumTel n) ;
    

    
    public void ajouterNumeroDebut(Personne p, NumTel n) ;

    public NumTel premierNumero(Personne p) ;
    
  

    public IListeNumTel numeros(Personne p) ;
    
  

    public Iterator<?> personnes();
    
  
    public void afficher();
  
    public void supprimer(Personne p);
    
    
   
    public void supprimer(Personne p, int n) ;
    
    
}// Annuaire
