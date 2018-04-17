package grajava;
/**
 * @author Magdalena Manthey
 */

import java.awt.*;
import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.*;

/**
 * Klasa dodaje do panelu i obsluguje przyciski start, reset i wyjdz,
 * oraz otwiera klawiature pianina, plik tekstowy z nutami i ustawia parametry panelu
 * piosenek, dodajac do niego przyciski piosenek
 */
public class PTrybStandardowy  {

    /**
     * @see #panelPiosenek - panel umozliwiajacy umieszczanie na nim komponentow 
     */ 
    public JPanel panelPiosenek = new JPanel();
    /**
      * @see #bPiosenka1 - obsłużony by po kliknieciu przypisac zmiennej nazwaPiosenki odpowiedni tytul otwieranego pliku i otworzyc klawiature
     */
    private JButton bPiosenka1 = new JButton ();
    /**
     * @see #bPiosenka2 - obsłużony by po kliknieciu przypisac zmiennej nazwaPiosenki odpowiedni tytul otwieranego pliku i otworzyc klawiature
     */
    private JButton bPiosenka2 = new JButton ();
    /**
     * @see #bPiosenka3 - obsłużony by po kliknieciu przypisac zmiennej nazwaPiosenki odpowiedni tytul otwieranego pliku i otworzyc klawiature
     */
    private JButton bPiosenka3 = new JButton ();
    /**
     * @see #bPiosenka4 - obsłużony by po kliknieciu przypisac zmiennej nazwaPiosenki odpowiedni tytul otwieranego pliku i otworzyc klawiature
     */
    private JButton bPiosenka4 = new JButton ();
    /**
     * @see #nazwaPiosenki - umozliwia otworzenie rozniacych sie nazwa plikow
     */
    private String nazwaPiosenki = new String ();
    /**
     * @see #bWyjdz - obsłużony by po kliknieciu wrocic do panelu menu glownego
     */
    private JButton bWyjdz = new JButton("Wyjście");
    /**
     * @see #bStart - obsłużony by po kliknieciu zaczac tryb standardowy
     */
    private JButton bStart = new JButton("Start");
    /**
     * @see #bReset - obsłużony by po kliknieciu wyczyscic klawiature 
     */
    private JButton bReset = new JButton("Reset");

    
   /**
    * Metoda dodaje do panelu przyciski start, reset i wyjdz, obsługuje je
    * oraz otwiera klawiature pianina; Obsluga przycisku Start polega na tworzeniu
    * kolekcji do ktorej losowane sa wartosci od 48 do 72 odpowiadajace numerom
    * dzwięków połączonych z klawiszami; Nastepnie kolejne elementy kolekcji sa
    * porownywane do wartosci przypisanych klawiszom klawiatury pianina;
    * W przypadku znalezienia, klawisz zmienia kolor na rozowy i czeka na wcisniecie;
    * Klikajac w przycisk Wyjdz, wracamy do menu glownego, a Reset, zmieniamy kolor
    * klawiszy na pierwotny.
    */            
   public void otwieranieKlawiatury() {

       panelPiosenek.removeAll();
       panelPiosenek.setLayout(null);
       
       PKlawiaturaPianina klawiaturaPianina = new PKlawiaturaPianina();
       klawiaturaPianina.panelKlawiatura();
       
       panelPiosenek.add(klawiaturaPianina.panelKlawiatura);
       panelPiosenek.add (bStart, FlowLayout.LEFT);
       panelPiosenek.add (bReset, FlowLayout.CENTER);
       panelPiosenek.add(bWyjdz, FlowLayout.RIGHT);
       panelPiosenek.validate();
       
       klawiaturaPianina.panelKlawiatura.setSize(1280,1024);
       panelPiosenek.repaint();
            
       
        //Obsluga przycisku Start
        bStart.setBounds(100, 100, 300, 150);
        bStart.setFont(new Font("Serif", Font.PLAIN, 70));
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {      
                ArrayList <Integer>lista = new ArrayList<Integer>(); //tworzona kolekcja
                Random generator = new Random();
                    for(int i=0; i<=3; i++) // ilosc wylosowanych dzwiekow
                    lista.add(generator.nextInt(24)+48); // dodawanie wylosowanych wartosci do kolekcji
                    System.out.println("lista: "+lista);                   
                    for (int b = 0; b < lista.size(); b++){
                        if(null!=lista.get(b)) //pobierana wartosc kolejnych elementow listy
                          switch (lista.get(b)) { // poczatek porownywania wartosci klawisza i elementow kolekcji
                              case 48:
                                  klawiaturaPianina.biale[0].setBackground(Color.pink);
                                  continue;
                              case 49:
                                  klawiaturaPianina.czarne[0].setBackground(Color.pink);                    
                                  continue;
                              case 50:
                                  klawiaturaPianina.biale[1].setBackground(Color.pink);
                                  continue;
                              case 51:
                                  klawiaturaPianina.czarne[1].setBackground(Color.pink);
                                  continue;
                              case 52:
                                  klawiaturaPianina.biale[2].setBackground(Color.pink);
                                  continue;
                              case 53:
                                  klawiaturaPianina.biale[3].setBackground(Color.pink);
                                  continue;
                              case 54:
                                  klawiaturaPianina.czarne[2].setBackground(Color.pink);
                                  continue;
                              case 55:
                                  klawiaturaPianina.biale[4].setBackground(Color.pink);
                                  continue;
                              case 56:
                                  klawiaturaPianina.czarne[3].setBackground(Color.pink);
                                  continue;
                              case 57:
                                  klawiaturaPianina.biale[5].setBackground(Color.pink);
                                  continue;
                              case 58:
                                  klawiaturaPianina.czarne[4].setBackground(Color.pink);
                                  continue;
                              case 59:
                                  klawiaturaPianina.biale[6].setBackground(Color.pink);
                                  continue;
                              case 60:
                                  klawiaturaPianina.biale[7].setBackground(Color.pink);
                                  continue;
                              case 61:
                                  klawiaturaPianina.czarne[5].setBackground(Color.pink);
                                  continue;
                              case 62:
                                  klawiaturaPianina.biale[8].setBackground(Color.pink);
                                  continue;
                              case 63:
                                  klawiaturaPianina.czarne[6].setBackground(Color.pink);
                                  continue;
                              case 64:
                                  klawiaturaPianina.biale[9].setBackground(Color.pink);
                                  continue;
                              case 65:
                                  klawiaturaPianina.biale[10].setBackground(Color.pink);
                                  continue;
                              case 66:
                                  klawiaturaPianina.czarne[7].setBackground(Color.pink);
                                  continue;
                              case 67:
                                  klawiaturaPianina.biale[11].setBackground(Color.pink);
                                  continue;
                              case 68:
                                  klawiaturaPianina.czarne[8].setBackground(Color.pink);
                                  continue;
                              case 69:
                                  klawiaturaPianina.biale[12].setBackground(Color.pink);
                                  continue;
                              case 70:
                                  klawiaturaPianina.czarne[9].setBackground(Color.pink);
                                  continue;
                              case 71:
                                  klawiaturaPianina.biale[13].setBackground(Color.pink);
                                  continue;
                              case 72:
                                  klawiaturaPianina.biale[14].setBackground(Color.pink);
                                  continue;
                              default:
                                  break;
                           } //koniec switch 
                        b++; // zwiekszany indeks petli az do dlugosci kolekcji
                     } //koniec petli po ilosci zmiennych w kolekcji    
            } //koniec actionPerformed()     
        }); //koniec ActionListener()      
        
      
        //Obsluga przycisku Reset
        bReset.setBounds(500, 100, 300, 150);
        bReset.setFont(new Font("Serif", Font.PLAIN, 70)); 
        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int numerklawisza=0; numerklawisza<klawiaturaPianina.biale.length; numerklawisza++)
                // zmiana kolorow klawiszy na pierwotny w przypadku klikniecia
                {
                    klawiaturaPianina.biale[numerklawisza].setBackground(Color.white);
                    klawiaturaPianina.czarne[numerklawisza].setBackground(Color.black);
                } 
            } //koniec actionPerformed()     
        }); //koniec ActionListener()

        
        //Obsluga przycisku Wyjdz
        bWyjdz.setBounds(900, 100, 300, 150);
        bWyjdz.setFont(new Font("Serif", Font.PLAIN, 70));
        bWyjdz.addActionListener(new ActionListener() {
            /**
            * metoda czekajaca na klikniecie w celu powrotu do menu glownego
            * @param ae 
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                OknoGlowne menu = new OknoGlowne("");  
                try {
                    menu.menuGlowne();
                } catch (IOException ex) {
                    Logger.getLogger(PKlawiaturaPianina.class.getName()).log(Level.SEVERE, null, ex);
                }
            } //koniec actionPerformed()
        }); //koniec ActionListener()
    } //koniec metody otwieranieKlawiatury()
                
   
/**
 * Metoda otwierajaca plik na podstawie zmiennej nazwaPiosenki ustawianej 
 * w metodzie piosenka() i w celu podgladowym wyswietlajaca 1 linie 
 * niewykorzystywana w pelni z powodu niewykonania czesci jednego z trybow;
 * Do odczytu pliku wykorzystywana zostala klasa Scanner.
 * @return zdanie - nieużywany, zmienne bedzie potrzebna przy robieniu dalszej
 * czesci gry do utworzenia kolekcji z danymi z pliku
 * @throws FileNotFoundException związany z nieznalezieniem otwieranego pliku
 */  
    public String otwieraniePliku() throws FileNotFoundException {
          
        File file = new File(nazwaPiosenki);
        Scanner odczyt = new Scanner(file);
        String zdanie = odczyt.nextLine();
        System.out.println(zdanie);
        return zdanie;
    } //koniec metody otwieraniePliku()
   
    
/**
 * Metoda charakteryzujaca wlasciwowosci panelu z wyswietlanymi nazwami piosenek,
 * na ktorym znajduja sie przyciski nasluchujace klikniecia, ktore spowoduje
 * przejscia do kolejnego panelu w trybie gry standardowym.
 */ 
    public void piosenka() {
        
        panelPiosenek.setBorder(
        BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panelPiosenek.setLayout(new GridLayout (2,2));
        panelPiosenek.setBackground(Color.LIGHT_GRAY);
        
        
        //Parametry i obsluga przycisku bPiosenka1
        bPiosenka1=new JButton("Piosenka 1");
        bPiosenka1.setFont(new Font("Serif", Font.PLAIN, 60)); 
        panelPiosenek.add(bPiosenka1);
        bPiosenka1.addActionListener(new ActionListener() {
           /**
            * metoda czekajaca na klikniecie w celu otwarcia klawiatury i pliku z konkretna zmienna
            * @param ae 
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
            otwieranieKlawiatury();   //otwieranie panelu z klawiatura
                try {
                    nazwaPiosenki = "src/Piosenka1.txt"; //przypisywanie zmiennej wartosci wykorzystywanej w metodzie otwieraniePliku()
                    otwieraniePliku();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PTrybStandardowy.class.getName()).log(Level.SEVERE, null, ex);
                }          
            } //koniec actionPerformed()     
        }); //koniec ActionListener()    
           
        
        //Parametry i obsluga przycisku bPiosenka1
        bPiosenka2=new JButton("Piosenka 2");
        bPiosenka2.setFont(new Font("Serif", Font.PLAIN, 60)); 
        panelPiosenek.add(bPiosenka2);
        bPiosenka2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            otwieranieKlawiatury();
                try {
                    nazwaPiosenki = "src/Piosenka2.txt";
                    otwieraniePliku();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PTrybStandardowy.class.getName()).log(Level.SEVERE, null, ex);
                }          
            } //koniec actionPerformed()     
        }); //koniec ActionListener()    

        
        //Parametry i obsluga przycisku bPiosenka1
        bPiosenka3=new JButton("Piosenka 3");
        bPiosenka3.setFont(new Font("Serif", Font.PLAIN, 60)); 
        panelPiosenek.add(bPiosenka3);
        bPiosenka3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            otwieranieKlawiatury();
                try {
                    nazwaPiosenki = "src/Piosenka3.txt"; 
                    otwieraniePliku();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PTrybStandardowy.class.getName()).log(Level.SEVERE, null, ex);
                }          
            } //koniec actionPerformed()     
        }); //koniec ActionListener()    
         
        
        //Parametry i obsluga przycisku bPiosenka1
        bPiosenka4=new JButton("Piosenka 4");
        bPiosenka4.setFont(new Font("Serif", Font.PLAIN, 60)); 
        panelPiosenek.add(bPiosenka4);
        bPiosenka4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            otwieranieKlawiatury();
                try {
                    nazwaPiosenki = "src/Piosenka4.txt";
                    otwieraniePliku();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PTrybStandardowy.class.getName()).log(Level.SEVERE, null, ex);
                }          
            } //koniec actionPerformed()     
        }); //koniec ActionListener()    
    } //koniec metody piosenka()
} // koniec klasy PTrybStandardowy  