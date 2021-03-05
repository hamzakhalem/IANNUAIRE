

public class TestAnnuaire {
    
  
    
    private static void affMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("1 : créer annuaire ");
        System.out.println("2 : ajouter personne ");
        System.out.println("3 : ajouter à une personne un ou plsieurs  numéro en fin de liste ");
        System.out.println("4 : ajouter à une personne ou plsieurs numéro  en debut de liste ");
        System.out.println("5 : afficher tous les numéros d'une personne ");
        System.out.println("6 : afficher le premier numéro d'une personne ");
        System.out.println("7 : supprimer une personne de l'annuaire ");
        System.out.println("8 : supprimer un numéro de la liste  d'une personne ");
        System.out.println("9 : afficher tout le contenu de l'annuaire ");
        System.out.println("0 : quitter l'application ");
        
        System.out.print("\nVotre choix : ");
    }
    
    
    private  static NumTel lireNum() {
        System.out.print("inserer le numero svp \n: ");
        int num = LectureClavier.lireEntier();
        System.out.print("inserer le type svp :\n T : Fixe professionnel\n D : Fixe domicile\n P : Portable\n F : Fax\n ? : inconnu)");
        char type = LectureClavier.lireChar();
        return new NumTel(num,type);
    }
    private static Personne lirepe() {
    	 System.out.println("entrer le nom de la personne");
         System.out.print("Vous étes : \n" + "  0: Mr \n 1 : Mme \n2 : Mlle \n");
        int i = LectureClavier.lireEntier();
        Personne.Typeciv k=Personne.Typeciv.INCONNU;
        switch(i)
        {
        case 0:k= Personne.Typeciv.MR ;break;
        case 1:k= Personne.Typeciv.MME ;break;
        case 2:k= Personne.Typeciv.MLLE ;break;
   
        }
         System.out.print("inserer le nom s'il vous plais \n");
         String n = LectureClavier.lireChaine();
         System.out.print("insererle prenom s'il vous plais \n");
         String p = LectureClavier.lireChaine();
         return new Personne(k,n,p);
      
    }
    
    private static void ajouterPersonne() {
      
        NumTel num = lireNum();
        ImpListeNumTel list = new ImpListeNumTel(num);
        System.out.println("si vous voulez ajouter un autre numero taper 'O'sinon 'N'");
        boolean encore = LectureClavier.lireOuiNon();
        while (encore) {
            num = lireNum();
            list.ajouterFin(num);
            System.out.println("si vous voulez ajouter un autre numero taper 'O'sinon 'N'");
            encore = LectureClavier.lireOuiNon();
        }
       annuaire.ajouterEntree(lirepe(),list);
    }
    
    
    private static void ajouterNumeroDebut() {
   
        annuaire.ajouterNumeroDebut(lirepe(),lireNum());
        System.out.println("numero bien ajouter au debut");
    }
    
    private static void ajouterNumeroFin() {
        annuaire.ajouterNumeroFin(lirepe(),lireNum());   System.out.println("numero bien ajouter a la fin");
    }
    
    private static void numeros() {
   

        System.out.println("ses numéros sont : \n " + annuaire.numeros(lirepe()));
    }
    
    private static void premierNumero() {
Personne pv=lirepe();
        System.out.println("le premier numéro de "+pv.toString()+"est:\n"+ annuaire.premierNumero(pv));
    }
    
    private static void supprimerNumero() {

        System.out.print("numéro à supprimer \n ");
        int n1 = LectureClavier.lireEntier();
        annuaire.supprimer( lirepe(),n1);
    }
    
    private static void supprimerPersonne() {
      annuaire.supprimer(lirepe());
    }
    
   static  Annuaire  annuaire;
    public static void main(String[] args){
        
     annuaire = new Annuaire();
        
        boolean encore = true;
        do {
            affMenu();
            int rep = LectureClavier.lireEntier();
            
            switch (rep) {
                case 0:  System.out.print("Voulez vous vraimment quitter l'application O/N ");
                encore = ! LectureClavier.lireOuiNon();break;
                case 1:  
                	annuaire = new Annuaire();System.out.println("Annuaire créer"); break;
                case 2:  ajouterPersonne(); break;
                case 3:ajouterNumeroFin(); break;
                case 4: ajouterNumeroDebut(); break;
                case 5: numeros();break;
                case 6:  premierNumero(); break;
                case 7:  supprimerPersonne();  break;
                case 8:  supprimerNumero();  break;
              case 9: annuaire.afficher();break;
              default:  System.out.println("Mauvais numéro de commande");
              break;
            } 
        } while (encore);
    }
    
}