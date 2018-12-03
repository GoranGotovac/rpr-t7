package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static void main(String[] args) {


        }
    public static ArrayList<Grad> ucitajGradove(){
    ArrayList<Grad> gradovi = new ArrayList<>();
    Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ulaz.txt ne postoji ili se ne može otvoriti");
        }
        try{
            while(ulaz.hasNext()) {
                String[] mjerenja = ulaz.nextLine().split(",");
                Grad grad = new Grad();
                grad.setNaziv(mjerenja[0]);
                double[] niz;
                niz = new double[mjerenja.length-1];
                for(int i = 0; i<mjerenja.length; i++) {
                    if(i==1000) break;
                    niz[i] = Double.valueOf(mjerenja[i+1]);
                }
                grad.setTemperature(niz);
                gradovi.add(grad);
            }
         }
         catch(Exception e) {
             System.out.println(e.getMessage());
         }
         finally {
            try{
                ulaz.close();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return gradovi;
    }
    public static UN ucitajXml(ArrayList<Grad> gradovi) {
        UN un = new UN();
        Document xmldoc = null;
        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }
    return un;
    }
}
