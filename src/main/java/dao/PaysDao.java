package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Pays;

public class PaysDao {
<<<<<<< HEAD


    private final FileReader reader;

    public PaysDao(FileReader reader){
        this.reader = reader;
    }

    public List getListePays() {
        List aLst = new ArrayList();
        String[] tabPays = reader.readPays();
=======
    
    private FileReader reader;
    private static final String FICHIER_PAYS = "Pays.txt";

    public PaysDao(FileReader reader){
        this.reader = reader;
    } 
    public static ArrayList getListePays() {
        String[] tabPays = FileStr.read(FICHIER_PAYS);
        ArrayList aLst = new ArrayList();
>>>>>>> 406918963f9424cbff3482c41d040b71c07312ef
        for (int i=0; i<tabPays.length; i++) { 
            StringTokenizer strT = new StringTokenizer(tabPays[i], ";");
            aLst.add(new Pays(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken()));
        }
        return aLst;
    }   
}