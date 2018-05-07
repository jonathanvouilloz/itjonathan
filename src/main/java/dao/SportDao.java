package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Sport;

public class SportDao {
<<<<<<< HEAD

    private final FileReader reader;

    public SportDao(FileReader reader){
        this.reader = reader;
    }

    public  List getListeSports() {
        String[] tabSports = reader.readSports();
        List aLst = new ArrayList();
=======
    
    private final FileReader reader;
    private static final String FICHIER_SPORTS = "Sports.txt";
    
    public SportDao(FileReader reader){
        this.reader = reader;
    }
   
    public ArrayList getListeSports() {
        String[] tabSports = FileStr.read(FICHIER_SPORTS);
        ArrayList aLst = new ArrayList();
>>>>>>> 406918963f9424cbff3482c41d040b71c07312ef
        for (int i=0; i<tabSports.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabSports[i], ";");
            aLst.add(new Sport(Integer.parseInt(strT.nextToken()), strT.nextToken()));
        }
        return aLst;
    }   
}