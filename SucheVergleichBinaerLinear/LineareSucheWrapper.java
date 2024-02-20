import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse LineareSuche.
 * 
 * @author (Ihr Boettcher) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LineareSucheWrapper
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    List<Integer> listeZahlen;
    Random randomGenerator;
    int anzZahlen = 0;
    
    /**
     * Konstruktor für Objekte der Klasse LineareSuche
     */
    public LineareSucheWrapper()
    {
        listeZahlen = new List<Integer>();
        randomGenerator = new Random();
        
    }
    
    public void testeLineareSucheIterativ( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            lineareSucheIterativ( randomGenerator.nextInt(10000) );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit lineare Suche iterativ: " + anzZahlen + " Elemente, " + anzahlVersuche + " Versuche, " + (timeEnd - timeStart) + " Millisek.");


    }
            

    public void testeLineareSucheRekursiv( int anzahlVersuche )
    {
        long timeStart;
        long timeEnd;
        
        timeStart = System.currentTimeMillis();
        for( int i=0; i<anzahlVersuche; i++){
            lineareSucheRekursivStart( randomGenerator.nextInt(10000) );    
        }
        timeEnd = System.currentTimeMillis();
        
        System.out.println("Laufzeit rekursiv: Versuche: " + anzahlVersuche + " Zeit: " + (timeEnd - timeStart) + " Millisek.");

    }

    

    public void listeFuellen( int anzElemente )
    {
        anzZahlen = anzElemente;
        listeZahlen.toFirst();
        while( ! listeZahlen.isEmpty() ){
            listeZahlen.remove();
        }
        for( int i = 0; i<anzElemente; i++ ){
            listeZahlen.append( randomGenerator.nextInt(10000)   );
        }
    }

    public void listeDrucken( )
    {
        listeZahlen.toFirst();
        while( listeZahlen.hasAccess() == true ){
            System.out.println(listeZahlen.getContent());
            listeZahlen.next();
        }
    }
    
    public boolean lineareSucheIterativ(int i)
    {
        int listeItem;
        listeZahlen.toFirst();
        while( listeZahlen.hasAccess() == true ){
            listeItem = listeZahlen.getContent();
            if( listeItem == i ){
                return true;
            }
            listeZahlen.next();
        }
        return false;
    }

    
    public boolean lineareSucheRekursivStart(int i)
    {
        listeZahlen.toFirst();
        return lineareSucheRekursivRek(i);
    }
    
    public boolean lineareSucheRekursivRek(int i)
    {
        int listeItem = 0;
        if( listeZahlen.hasAccess() == false ){
            return false;
        }else{
            listeItem = listeZahlen.getContent();
            if( listeItem == i ){
                return true;
            }else
            {
                listeZahlen.next();
                return lineareSucheRekursivRek(i);
            }
        }
    }

    
}
