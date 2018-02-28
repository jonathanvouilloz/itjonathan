import java.util.*;
/**
 * Module 633.1-Programmation - TP P04 - Parking
 *
 * Application parking silo
 *
 * Gestion du parking silo : 
 *		 mémorisation des données;
 *		 présentation du rapport;
 *		 retirer un ensemble de véhicules;
 *		 présentation du nouveau rapport.
 *
 * @author VOTRE NOM								
 
 03-03;2;2;Melissa;DELAUNAY;VD3256743
*/
public class GestionParking {

  private static ArrayList lstVehicule = new ArrayList();
  private static ArrayList lstBox = new ArrayList();
  private static ArrayList lstEtage = new ArrayList();
  
		
	/* Liste des délimiteurs */
	private static final String DEL_ETAGE = "\r\n";
	private static final String DEL_CHAMP = ";";
	private static final String DEL_NO_BOX = "-";
		
	/* Le parking */
	private static Parking parking; 
  
	
	/* Méthodes de service */
	private static int str2int (String s) {return Integer.parseInt (s);} 
	
	/* Mémorise les données du parking */
	private static void memoriseParking (String donnesParking) {
		/* Création du parking */	
		parking = new Parking(); 

	  final String SEP = "\n\r";
    final String SEP_LIGNE = ";";
    final String SEP_BOX_ETAGE = "-";
    

		StringTokenizer strT = new StringTokenizer(donnesParking, SEP);//déclaration nouveau tokeniser

    
	
    while (strT.hasMoreTokens()) {
			StringTokenizer strDetailV = new StringTokenizer(strT.nextToken(), SEP_LIGNE);	
			
			String boxEtage = strDetailV.nextToken();
      
      StringTokenizer strBoxEtage = new StringTokenizer(boxEtage,SEP_BOX_ETAGE);

      String noEtage = strBoxEtage.nextToken();
      String idBox = strBoxEtage.nextToken();

      int nEtage = Integer.parseInt(noEtage);
      int idB = Integer.parseInt(idBox);

      
    
    

			int typeV = Integer.parseInt(strDetailV.nextToken());
			int tempsQuart = Integer.parseInt(strDetailV.nextToken());
			String nom = strDetailV.nextToken();
			String prenom = strDetailV.nextToken();
      String numImma = strDetailV.nextToken();

      //System.out.println("No etage: "+noEtage+" Id Box: "+idBox+" Type vehicule: "+typeV+" Temps:: "+tempsQuart
      //  +" Nom: "+nom+" Prenom: "+prenom+" Immatriculation: "+numImma);

   
      Box box;
      if(typeV == 0){
        //velo
         Vehicule velo = new Velo(numImma,nom,prenom);
         lstVehicule.add(velo);
         box = new Box(idB,velo);

      }else if (typeV == 1) { 
        //moto
        Vehicule moto = new Moto(numImma,nom,prenom);
        lstVehicule.add(moto);
        box = new Box(idB,moto);
      }
      else{
        //voiture
        Vehicule voiture = new Voiture(numImma,nom,prenom);
        lstVehicule.add(voiture);     
        box = new Box(idB,voiture);
        }
        //set le nb de quart d'heure
        box.setNbQuartHeures(tempsQuart);
       
       

      //ajout des étages dans le parking
      Etage etage = new Etage(nEtage);
      if(parking.getEtage(nEtage)==null){
        parking.add(etage);
        lstEtage.add(etage);
      }

      
		//ajout des box dans les étage correspondant
		int index = parking.getEtages().indexOf(etage);
		if(index!= -1){
			((Etage)parking.getEtages().get(index)).add(box);
		} 
        
    }

	 /*for(int a2 = 0;a2 < lstEtage.size();a2++){
        
        System.out.println("Etage :"+((Etage)lstEtage.get(a2)).getNo());
        System.out.println(((Etage)lstEtage.get(a2)).getBoxes());
        
       
      }*/
 



		
	

	}
	
	/* Prépare et affiche le rapport */
	private static void afficheRapport () {
		System.out.println("Rapport parking");

		System.out.println("Il y a : "+parking.getNbVehicules()+" véhicule parqués");

		System.out.println("\t\t VELO : "+parking.nbTypeVehicule(Vehicule.TYPE_VELO)+" pour un montant actuel : "+parking.montantParType(Vehicule.TYPE_VELO));
		System.out.println("\t\t MOTO : "+parking.nbTypeVehicule(Vehicule.TYPE_MOTO)+" pour un montant actuel : "+parking.montantParType(Vehicule.TYPE_MOTO));
		System.out.println("\t\t VOITURE : "+parking.nbTypeVehicule(Vehicule.TYPE_VOITURE)+" pour un montant actuel : "+parking.montantParType(Vehicule.TYPE_VOITURE));

		System.out.println("Liste des immatriculations et des conducteurs : ");


		for(int i =0;i<parking.getEtages().size();i++){
			((Etage)parking.getEtages().get(i)).affichage();
		}
		//affiche tous les étages avec leur box
		//for(int i =0;i<parking.getEtages().size();i++){
		//	((Etage)parking.getEtages().get(i)).toString();
		//}

		
	}
	
	/* VOUS NE DEVEZ PAS MODIFIER LE CODE DE CETTE METHODE */
	private static void recuperationVehicules () {
		System.out.println("----------------------------------------------------------");
		parking.removeVehicule("GE657665");
		parking.removeVehicule("NE342078");
		parking.removeVehicule("AG456");
		parking.removeVehicule("BE87350");
		parking.removeVehicule("NE563458");
		parking.removeVehicule("VD15646");
		
		System.out.println("Les véhicules suivants ont été supprimés :");
		System.out.println("	 GE657665, NE342078, AG456, BE87350, NE563458 et VD15646");
		System.out.println("----------------------------------------------------------");
	}
	
	/* LE CODE DE CETTE MÉTHODE NE DOIT PAS ÊTRE MODIFIÉ */
	public static void main (String[] args) {
		if (args.length < 1) { 
			System.out.println("Il faut saisir le fichier de données.");
		} else {
			System.out.println("Mémorisation du parking (fichier : \"" + args[0] + "\")");
			System.out.println("----------------------------------------------------------");
			memoriseParking(FileToStr.read(args[0]));
			afficheRapport();
			recuperationVehicules();
			afficheRapport();
		}
	}
}