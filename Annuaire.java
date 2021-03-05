
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Annuaire implements IAnnuaire{
  private Map<Object, Object> annmap ;
	
	public Annuaire ()
	{
		annmap=new TreeMap<>();
	}
	@Override
	public boolean ajouterEntree(Personne p, IListeNumTel nums) {
		 if (! annmap.containsKey(p))
		 {       annmap.put(p,nums);  
	            return true; }return false;
	}

	@Override
	public void ajouterNumeroFin(Personne p, NumTel n) {
		// TODO Auto-generated method stub
		  if (annmap.containsKey(p)==false) 
	    		 annmap.put(p,new ImpListeNumTel(n));
	    	     ((IListeNumTel) annmap.get(p)).ajouterFin(n);
	}

	@Override
	public void ajouterNumeroDebut(Personne p, NumTel n) {
		// TODO Auto-generated method stub
	     if (annmap.containsKey(p)==false) 
	    		 annmap.put(p,new ImpListeNumTel(n));
	    	     ((IListeNumTel) annmap.get(p)).ajouterDebut(n);
	}

	@Override
	public NumTel premierNumero(Personne p) {
		   IListeNumTel np = (IListeNumTel) annmap.get(p);
		   if(np!=null) return np.premierNumero();
	        return null;

	}

	@Override
	public IListeNumTel numeros(Personne p) {
		// TODO Auto-generated method stub
		return (IListeNumTel) annmap.get(p);
	}

	@Override
	public Iterator<?> personnes() {
		// TODO Auto-generated method stub
		return annmap.keySet().iterator();
	}

	@Override
	public void afficher() {
		Iterator<?> i=personnes();
		while(i.hasNext())
		{
			Personne pr=(Personne) i.next();
			System.out.println(pr +":"+ annmap.get(pr));
		}
		
	}

	@Override
	public void supprimer(Personne p) {
		// TODO Auto-generated method stu
	            annmap.remove(p);
	}

	@Override
	public void supprimer(Personne p, int n) {
		// TODO Auto-generated method stub

		
		IListeNumTel np = (IListeNumTel)annmap.get(p);
	            if (np.nbNumeros() == 1)
	            annmap.remove(p);  
	            np.retirer(n);
	             
	}
	  public Set<?> entreesPourChaine(String s1) {
	        char[] carac = s1.toCharArray();
	        carac[carac.length-1] += 1;
	        String s2 = new String(carac);
	        Personne fromPers = new Personne(s1,"");
	        Personne toPers = new Personne(s2,"");
	        SortedMap s = ((TreeMap)annmap).subMap(fromPers, toPers);
	        
	        return s.keySet();
	    }
	public static void main(String[] args) {
		 
		 IAnnuaire an = new Annuaire();
		 Personne p1 = new Personne(Personne.Typeciv.MLLE,"DURAND","Sophie");
		 an.ajouterEntree(p1,new ImpListeNumTel(new NumTel(151171,'D')));
		 an.ajouterEntree(new Personne(Personne.Typeciv.MR,"DUPONT","Jean"),
		 new ImpListeNumTel(new NumTel(151170,'P')));
		 an.ajouterEntree(new Personne(Personne.Typeciv.MR,"DUSCHMOL", "Louis"),
		 new ImpListeNumTel(new NumTel(146761,'P')));

		 an.ajouterEntree(new Personne(Personne.Typeciv.MR,"AARGHH", "Robert"),
		 new ImpListeNumTel(new NumTel(140361,'P')));
		 System.out.println("------------------------------");
		 System.out.println(an);
		 System.out.println("------------------------------");
		 System.out.println("numeros de " + p1);
		 System.out.println(an.numeros(p1));
		 Personne p2 = new Personne(Personne.Typeciv.MR,"DUPONT","Jean");
		 System.out.println("numeros de " + p2);
		 System.out.println(an.numeros(p2));
		 } 
}
