import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImpListeNumTel implements IListeNumTel {
   private List<Object> numlist;
	 public ImpListeNumTel(NumTel num) {
		// TODO Auto-generated constructor stub
		 numlist=new ArrayList<>();
		this.ajouterDebut(num);
	}
	@Override
	public boolean ajouterFin(NumTel num) {
		// TODO Auto-generated method stub
		if(numlist.contains(num)==false)
		{	this.ajouter(this.nbNumeros(),num); return true;
		}
		return false;
	}

	@Override
	public boolean ajouterDebut(NumTel num) {
		// TODO Auto-generated method stub
		if(numlist.contains(num)==false)
		{	this.ajouter(0,num); return true;
		}
		return false;
	}

	@Override
	public boolean ajouter(int index, NumTel num) {
		// TODO Auto-generated method stub
		if(numlist.contains(num)==false)
		{	numlist.add(index,num); return true;
		}
		return false;
	}

	@Override
	public NumTel premierNumero() {
		// TODO Auto-generated method stub
		return (NumTel)numlist.get(0);
	}

	@Override
	public NumTel numero(int index) {
		// TODO Auto-generated method stub
		
		return (NumTel)numlist.get(index);
	}

	@Override
	public boolean contientNumero(int num) {
		// TODO Auto-generated method stub
		
		return numlist.contains(new NumTel(num));
	}

	@Override
	public int nbNumeros() {
		// TODO Auto-generated method stub
		return numlist.size();
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return numlist.iterator();
	}

	@Override
	public boolean retirer(int num) {
		// TODO Auto-generated method stub
		if (this.nbNumeros()>1)
            return numlist.remove(new NumTel(num));
            return false;
	}

}
