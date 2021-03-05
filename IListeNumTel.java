import java.util.Iterator;



public interface IListeNumTel {

boolean ajouterFin(NumTel num) ;

 
  public boolean ajouterDebut(NumTel num) ;
  
  

  public boolean ajouter(int index, NumTel num) ;

  public NumTel premierNumero() ;
  

  public NumTel numero(int index ) ;
 

  public boolean contientNumero(int num) ;

  public int nbNumeros() ;

  public String toString() ;

 
   public Iterator<?> iterator() ;
   
 
  public boolean retirer(int num);
  
  
}// ListeNumTel

