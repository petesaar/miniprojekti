package miniprojekti.JSON;

import java.io.File;
import miniprojekti.Viite.Artikkeliviite;
import miniprojekti.Viite.Inproceedings;
import miniprojekti.Viite.Kirjaviite;
import miniprojekti.Viite.Viite;
import miniprojekti.Viite.ViiteJoukko;
import miniprojekti.Viite.ViitejoukkoImpl;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JsonIOTest {
    
    public JsonIOTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void tallennaLuoTiedostonJosSitäEiOle() {
        
        JsonIO io = new JsonIO("test.json");
        io.tallenna(new ViitejoukkoImpl());
        File file = new File("test.json");
        if(file.exists()){
            file.delete();
        } else fail();       
    }
    
    @Test
    public void latausToimiiKirjaviittellä(){
        tallennaJaLataaViite(new Kirjaviite("key","auth","title","2013","pub","as","ds","asd","dd","aet","sdfd"));       
    }
    
    @Test
    public void latausToimiiArtikkeliviitteellä(){
        tallennaJaLataaViite(new Artikkeliviite("ref","auth","title","jour","1234","vol","aet","tea","etq","asd","reee"));
    }
    
    @Test
    public void latausToimiiInproceedingsViitteellä(){
        tallennaJaLataaViite(new Inproceedings("key","auth","title","1234","booktitle","aef","as","egage","req","asd","gea","geg","aegasd","eaae","gegegeg"));
    }
    
    private void tallennaJaLataaViite(Viite viite){
        ViitejoukkoImpl joukko = new ViitejoukkoImpl();
        joukko.save(viite);
        
        JsonIO io = new JsonIO("test.json");
        io.tallenna(joukko);
        
        ViiteJoukko ladatut = io.lataa();
        Viite v  = ladatut.getViitteet().get(0);
        
        if(v.getClass().equals(viite.getClass())){
            if(v.getBibtexkey().equals(viite.getBibtexkey())){
                for(String key : viite.getFields().keySet()){
                    String a = viite.getFields().get(key);
                    String b = v.getFields().get(key);
                    if(!a.equals(b)) fail("Kentän "+key+" tulee olla "+a+" mutta olikin "+b);
                }
            } else fail();
        } else fail();
        File file = new File("test.json");
        System.out.println(file.delete());
    }
}
