package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

public class AthleteDao {
<<<<<<< HEAD

    private final FileReader reader;

    public AthleteDao(FileReader reader){
        this.reader = reader;
    }

    public List getListeAthletes(Pays pays, Sport sport) {
        String[] tabAthletes = reader.readAthletes();
        List aLst = new ArrayList();
=======
    
    private final FileReader reader;
    private static final String FICHIER_ATHLETES = "Athletes.txt";

    public AthleteDao(FileReader reader){
        this.reader = reader;
    }
    
    public static ArrayList getListeAthletes(Pays pays, Sport sport) {
        String[] tabAthletes = FileStr.read(FICHIER_ATHLETES);
        ArrayList aLst = new ArrayList();
>>>>>>> 406918963f9424cbff3482c41d040b71c07312ef
        for (int i=0; i<tabAthletes.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabAthletes[i], ";");
            Pays p = new Pays(Integer.parseInt(strT.nextToken()));
            Sport s = new Sport(Integer.parseInt(strT.nextToken()));
            if (p.equals(pays) && s.equals(sport)) { aLst.add(new Athlete(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken(), pays, sport)); }
        }
        return aLst;
    }   
}