

public class ListeNumTelTest {
    
 
    private static IListeNumTel listNum;
    
   
    private static void affMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("1 : ajouter un num�ro au debut de la liste ");
        System.out.println("2 : ajouter un num�ro � la fin de la liste ");
        System.out.println("3 : ajouter un num�ro � une position donn�e ");
        System.out.println("4 : retirer un num�ro de la liste ");
        System.out.println("5 : afficher la liste ");
        System.out.println("6 : nombre de num�ros de la liste ");
        System.out.println("7 : r�cup�rer le premier de la liste ");
        System.out.println("8 : v�rifier la pr�sence d'un num�ro dans la liste ");
        System.out.println("0 : quitter l'application ");
        
        System.out.print("\nVotre choix : ");
    }
    
    
    private static NumTel creerNumTel() {
        System.out.print("numero : ");
        int num = LectureClavier.lireEntier();
        System.out.print("type (T : Fixe professionnel, D : Fixe domicile, P : Portable, F : Fax, ? inconnu)");
        char type = LectureClavier.lireChar();
        return new NumTel(num,type);
    }
    
    private static void ajouterNumeroDebut() {
        System.out.println("num�ro de t�l�phone � ajouter au d�but de la liste : ");
        NumTel num = creerNumTel();
        listNum.ajouterDebut(num);
    }
    
    private static void ajouterNumeroFin() {
        System.out.println("num�ro de t�l�phone � ajouter en fin de la liste: ");
        NumTel num = creerNumTel();
        listNum.ajouterFin(num);
    }
    
    private static void ajouterNumero() {
        System.out.println("num�ro de t�l�phone � ajouter dans la liste: ");
        NumTel num = creerNumTel();
        System.out.print("Position d'insertion dans la liste : ");
        int pos = LectureClavier.lireEntier();
        listNum.ajouter(pos,num);
    }
    
    private static void retirerNumero() {
        System.out.print("numero � retirer : ");
        int num = LectureClavier.lireEntier();
        if (listNum.retirer(num)) {
            System.out.println("op�ration de retrait a r�ussi");
        }
        else {
            System.out.println("op�ration de retrait a �chou�");
        }
    }
    
    private static void creerListe() {
        System.out.println("Cr�ation du 1er num�ro de la liste : ");
        NumTel num = creerNumTel();
        listNum = new ImpListeNumTel(num);
    }
    
    private static void rechercherNumero() {
        
        System.out.print("num�ro � rechercher : ");
        int num = LectureClavier.lireEntier();
        if (listNum.contientNumero(num)) {
            System.out.println("le num�ro est pr�sent dans la liste");
        }
        else {
            System.out.println("le num�ro n'est pas pr�sent dans la liste");
        }
    }
    
    public static void main(String[] args){
        
        creerListe();
        
        boolean encore = true;
        do {
            affMenu();
            int rep = LectureClavier.lireEntier();
            switch (rep) {
                case 0:  System.out.print("Voulez vous vraimment quitter l'application O/N ");
                encore = ! LectureClavier.lireOuiNon();
                break;
                case 1:  ajouterNumeroDebut();
                break;
                case 2:  ajouterNumeroFin();
                break;
                case 3:  ajouterNumero();
                break;
                case 4:  retirerNumero();
                break;
                case 5:  System.out.println(listNum);
                break;
                case 6:  System.out.println("nombre de num�ros de la liste : " + listNum.nbNumeros());
                break;
                case 7:  System.out.println("premier numero de la liste : " + listNum.premierNumero());
                break;
                case 8:  rechercherNumero();
                break;
                default:  System.out.println("Mauvais num�ro de commande");
                break;
            } // fin du switch
        } while (encore);
    }
    
}// ListeNumTelTest
