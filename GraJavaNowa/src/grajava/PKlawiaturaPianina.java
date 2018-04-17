package grajava;
/**
 * @author Magdalena Manthey
 */
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.*;

/**
 * Klasa generuje przyciski klawiatury i ich wlasciwosci, implementuje interfejs 
 * MouseListener i ustawia w konstruktorze instrument; nadpisuje też metody
 * odpowiedzialne za przycisniecie i zwolnienie klawisza  
 */
public class PKlawiaturaPianina implements MouseListener {
 
    /**
     * @see #biale - tablica bialych klawiszy na klawiaturze pianina 
     */
    public BialeKlawisze[] biale = new BialeKlawisze [15];
    /**
      * @see #czarne - tablica bialych klawiszy na klawiaturze pianina
     */
    public CzarneKlawisze[] czarne = new CzarneKlawisze [10];
    /**
      * @see #panelKlawiatura - panel, do ktorego dodawana jest klawiatura
     */
    public JPanel panelKlawiatura;
    /**
      * @see #channel - zmienna, do ktorej przypisywany jest dzwiek instrumentu
     */
    MidiChannel channel;
    
    
    /**
     * @see #PKlawiaturaPianina - otwiera syntezator, ladowane sa instrumenty z biblioteki
     * i przypisywane sa zmiennej channel konkretny instrument
     */
    PKlawiaturaPianina () {

        try {
            Synthesizer synth = MidiSystem.getSynthesizer ();
            synth.open ();
            synth.loadAllInstruments (synth.getDefaultSoundbank ());
            Instrument [] insts = synth.getLoadedInstruments ();
            MidiChannel channels[] = synth.getChannels ();
            for (int i = 0; i < channels.length; i++) {
                if (channels [i] != null) {
                    channel = channels [i];
                    break;
                }
            }
            // petla for przeszukujaca liste z klasy Instrument i 
            // przypisujaca zmiennej channel z MidiChannel konkretny instrument
            for (int i = 0; i < insts.length; i++) {
                if (insts [i].toString ().startsWith ("Instrument MidiPiano"))
                {
                    channel.programChange (i);
                    break;
                }
            } // koniec petli for 
         } // koniec try
          catch (MidiUnavailableException ex) {
          }
    }//koniec konstruktora
    
    
/**
 * Nadpisana metoda, ktora po nacisnieciu klawisza, wywoluje dzwiek
 * z wybranego wczesniej kanalu z klasy MidiChannel
 * @param e z metody nadpisanej mousePressed()
 */
    @Override
    public void mousePressed (MouseEvent e) {
        Klawisze key = (Klawisze) e.getSource ();
        channel.noteOn (key.getNote (), 127); 
    } //koniec metody mousePressed()

/**
 * Nadpisana metoda, ktora po zwolnieniu klikniętego klawisza, wylacza
 * dzwiek z wybranego wczesniej kanalu z klasy MidiChannel
 * @param e z metody nadpisanej mouseReleased()
 */
    public void mouseReleased (MouseEvent e) {
        Klawisze key = (Klawisze) e.getSource ();
        channel.noteOff (key.getNote ());
    } //koniec metody mouseReleased()

    
//Implementowanane metody abstrakcyjne
    @Override
   public void mouseClicked (MouseEvent e) { }
    @Override
   public void mouseEntered (MouseEvent e) { }
    @Override
   public void mouseExited (MouseEvent e) { }

  
   /**
    * Metoda tworzaca klawiature - generujaca klawisze czarne i biale oraz
    * ustawiajaca nasluch na nie przez addActionListener(); Ustawiana jest
    * tez ich wlasciwowsc poprawnego wyswietlania oraz dodawane sa do panelu.
    */
    public void panelKlawiatura () {

        panelKlawiatura = new JPanel(null){
            
           /**
            * Umozliwia nakladanie sie przyciskow czarnych na biale,
            * gdyby zwracane bylo "true", czarne przyciski bylyby czesciowo
            * zakryte przez biale przed najechaniem
            * @return false
            */ 
           @Override
            public boolean isOptimizedDrawingEnabled()
            {
                return false;
            }    
        };

        //Generowanie przyciskow czarnych, dodawanie ich do panelu
        //i dodawanie nasluchu na klikniecie w celu zmiany koloru
        for (int i=0; i < czarne.length; i++) {
            czarne [i] = new CzarneKlawisze (i);
            panelKlawiatura.add (czarne [i]);
            czarne [i].addMouseListener (this);
            czarne[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 for (int g=0; g < czarne.length; g++) 
                czarne[g].setBackground(Color.black);
            } //koniec actionPerformed()     
        }); //koniec ActionListener()  
        }
        
        
        //Generowanie przyciskow czarnych, dodawanie ich do panelu
        //i dodawanie nasluchu na klikniecie w celu zmiany koloru
        for (int i = 0; i < biale.length; i++) {
            biale [i] = new BialeKlawisze (i);
            panelKlawiatura.add (biale [i]);
            biale [i].addMouseListener (this);
            biale[i].addActionListener(new ActionListener() {
            /**
            * metoda czekajaca na klikniecie w celu zmiany koloru klawiszy na pierwotny bialy
            * @param ae 
            */                
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int g=0; g < biale.length; g++) 
                biale[g].setBackground(Color.white);
            } //koniec actionPerformed()     
        }); //koniec ActionListener()
     
        }
        
        panelKlawiatura.setBackground(Color.LIGHT_GRAY);
            
    } //koniec metody panelKlawiatura()
} // koniec klasy PKlawiaturaPianina


/**
 * Interfejs Klawisze definijacy podstawowe wartosci dotyczacy 
 * klawiszy, ktore sa modyfikowane przez metody implementujace interfejs:
 * szerokosc, wysokosc, dzwiek pierwszego klawisza
 */
interface Klawisze {
 
    /**
     * Zmienne z przypisana szerokoscia i wysokoscia klawiszy 
     * @see #szerCzarna - szerokosc czarnych klawiszy
     * @see #wysCzarna - wysokosc czarnych klawiszy
     */
    int szerCzarna = 55; //Szerokosc czarnego przycisku
    int wysCzarna = (szerCzarna * 9) / 2; //Wysokosc czarnego przycisku
    int baseNote = 48; // Dzwiek podstawowy
    int getNote ();
} // koniec interfejsu Klawisze


/**
 * Klasa dziedziczaca po klasie JButton i implementujaca interfejs Klawisze
 * zawierajaca konstruktor i metode getNote:
 * @see #CzarneKlawisze () - wyliczajaca dzwiek konkretnego klawisza i polozenie
 * pierwszego czarnego na panelu
 * @see #getNote() - zwracajaca wyliczony dzwiek
 */
class CzarneKlawisze extends JButton implements Klawisze {

    final int note;
 
 /**
  * Konstruktor, ktory zgodnie z algorytmem wylicza dzwiek dla kolejnych czarnych 
  * klawiszy, w zaleznosci od pozycji klawisza, przyjmujac za 
  * I dzwiek podstawowy 48 i ustawia ich polozenie oraz wielkosc
  * w zaleznosci od ustalonych wartosci oraz ustawia ich kolor
  * @param pos - pozycja, numer w kolejnosci klawisza
  */  
    CzarneKlawisze (int pos) {
        note = baseNote + 1 + 2 * pos + (pos + 3) / 5 + pos / 5;
        int left = 10 + szerCzarna
                + ((szerCzarna * 3) / 2) * (pos + (pos / 5)
                + ((pos + 3) / 5));
        setBackground (Color.BLACK);
        setBounds (left, 350, szerCzarna, wysCzarna);    
    } //koniec metody CzarneKlawisze()

    
    /**
     * metoda zwracajaca wyliczony w metodzie CzarneKlawisze() note:
     * @return note - dzwiek konkretnego klawisza
     */    
    public int getNote () {
        return note;
    } //koniec klasy getNote()
} // koniec klasy CzarneKlawisze implementujacej interfejs Klawisze


/**
 * Klasa dziedziczaca po klasie JButton i implementujaca interfejs Klawisze
 * zawierajaca konstruktor i metode getNote:
 * @see #BialeKlawisze () - wyliczajaca dzwiek konkretnego klawisza i polozenie
 * pierwszego bialego na panelu
 * @see #getNote() - zwracajaca wyliczony dzwiek
 */
class BialeKlawisze  extends JButton implements Klawisze {

    /**
     * Zmienne z przypisana szerokoscia i wysokoscia klawiszy w zaleznosci od
     * wartosci klawiszy czarnych: 
     * @see #szerBiala - szerokosc bialych klawiszy
     * @see #wysBiala - wysokosc bialych klawiszy
     */
    static int szerBiala = (szerCzarna * 3) / 2;
    static int wysBiala = (wysCzarna * 3) / 2;
    final int note;

    
 /**
  * Konstruktor, ktory zgodnie z algorytmem wylicza dzwiek dla kolejnych bialych 
  * klawiszy, w zaleznosci od pozycji klawisza, przyjmujac za 
  * I dzwiek podstawowy 48 i ustawia ich polozenie oraz wielkosc
  * w zaleznosci od ustalonych wartosci oraz ustawia ich kolor
  * @param pos - pozycja, numer w kolejnosci klawisza
  */  
    public BialeKlawisze (int pos) {

        note = baseNote + 2 * pos
                - (pos + 4) / 7
                - pos / 7;
        int left = 10 + szerBiala * pos;
        setBounds (left, 350, szerBiala, wysBiala);
        setBackground(Color.white);
    } //koniec metody BialeKlawisze()
    
    
    /**
     * metoda zwracajaca wyliczony w metodzie BialeKlawisze() note:
     * @return #note - dzwiek konkretnego klawisza
     */
    public int getNote () {
        return note;
    }
    
} // koniec klasy BialeKlawisze implementujacej interfejs Klawisze