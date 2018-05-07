package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Sport;

public class SportDao {

    private final FileReader reader;

    public SportDao(FileReader reader){
        this.reader = reader;
    }

    public  List getListeSports() {
        String[] tabSports = reader.readSports();
        List aLst = new ArrayList();
        for (int i=0; i<tabSports.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabSports[i], ";");
            aLst.add(new Sport(Integer.parseInt(strT.nextToken()), strT.nextToken()));
        }
        return aLst;
    }   
}