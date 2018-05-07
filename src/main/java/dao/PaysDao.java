package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Pays;

public class PaysDao {


    private final FileReader reader;

    public PaysDao(FileReader reader){
        this.reader = reader;
    }

    public List getListePays() {
        List aLst = new ArrayList();
        String[] tabPays = reader.readPays();
        for (int i=0; i<tabPays.length; i++) { 
            StringTokenizer strT = new StringTokenizer(tabPays[i], ";");
            aLst.add(new Pays(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken()));
        }
        return aLst;
    }   
}