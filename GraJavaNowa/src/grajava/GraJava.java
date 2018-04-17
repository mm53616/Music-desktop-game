package grajava;
/**
 * @author Magdalena Manthey
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa OknoGlowne dziedziczy po JFrame i zawiera konstruktor klasy oraz
 * metode menuGlowne() nadajaca wlasciwowsci panelom, przyciskom
 * i labelom oraz obslugujaca dzialanie przyciskow i odpowiadajaca za dzialanie
 * muzyki w tle z biblioteki .midi dzieki sekwencerowi
*/
class OknoGlowne extends JFrame {

    /**
     * @see #panelMenu - panel na ktorym umieszcza sie pozostale komponenty 
     */   
   private  JPanel panelMenu = new JPanel();
    /**
     * @see #bSamouczek - obsłużony by po kliknieciu przejsc do panelu samouczka
     */
   private  JButton bSamouczek = new JButton("Samouczek");
    /**
     * @see #bTrybStand - obsłużony by po kliknieciu przejsc do panelu trybu standardowego
     */
   private JButton bTrybStand = new JButton("Tryb standardowy");
    /**
     * @see #bTrybDow - obsłużony by po kliknieciu przejsc do panelu trybu dowolnego
     */
   private JButton bTrybDow = new JButton("Tryb dowolny");
    /**
     * @see #bmuzyka - obsłużony by po kliknieciu wylaczyc muzyke
     */
   private JButton bMuzyka = new JButton(); 
    /**
     * @see #sequencer - odpowiedzialny za dzialanie muzyki w tle z biblioteki .midi
     */   
   public Sequencer sequencer = new Sequencer() {

 /**
 * Automatyczna implementacja wszystkich metod abstarakcyjnych klasy Sequencer 
 * z wyjatkami; jednak ze wzgledu na brak wykorzystywania wiekszosci metod, ich
 * wyjatki i parametry nie zostaly dodane do dokumentacji
 * @throws InvalidMidiDataException
 * @throws IOException
 */
       @Override
       public void setSequence(Sequence sqnc) throws InvalidMidiDataException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setSequence(InputStream in) throws IOException, InvalidMidiDataException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Sequence getSequence() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
       
       @Override
       public void start() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void stop() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean isRunning() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void startRecording() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void stopRecording() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean isRecording() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void recordEnable(Track track, int i) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void recordDisable(Track track) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public float getTempoInBPM() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTempoInBPM(float f) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public float getTempoInMPQ() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTempoInMPQ(float f) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTempoFactor(float f) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public float getTempoFactor() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getTickLength() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getTickPosition() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTickPosition(long l) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getMicrosecondLength() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getMicrosecondPosition() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setMicrosecondPosition(long l) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setMasterSyncMode(Sequencer.SyncMode sm) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Sequencer.SyncMode getMasterSyncMode() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Sequencer.SyncMode[] getMasterSyncModes() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setSlaveSyncMode(Sequencer.SyncMode sm) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Sequencer.SyncMode getSlaveSyncMode() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Sequencer.SyncMode[] getSlaveSyncModes() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTrackMute(int i, boolean bln) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean getTrackMute(int i) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setTrackSolo(int i, boolean bln) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean getTrackSolo(int i) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean addMetaEventListener(MetaEventListener ml) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void removeMetaEventListener(MetaEventListener ml) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public int[] addControllerEventListener(ControllerEventListener cl, int[] ints) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public int[] removeControllerEventListener(ControllerEventListener cl, int[] ints) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setLoopStartPoint(long l) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getLoopStartPoint() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setLoopEndPoint(long l) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public long getLoopEndPoint() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void setLoopCount(int i) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public int getLoopCount() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public MidiDevice.Info getDeviceInfo() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void open() throws MidiUnavailableException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public void close() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public boolean isOpen() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public int getMaxReceivers() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public int getMaxTransmitters() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Receiver getReceiver() throws MidiUnavailableException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public java.util.List<Receiver> getReceivers() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public Transmitter getTransmitter() throws MidiUnavailableException {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }

       @Override
       public java.util.List<Transmitter> getTransmitters() {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       }
   } ;
     
    /**
     * @see #OknoGlowne - konstruktor
     * @param nazwa wykorzystywany jest w metodzie super wywołujący konstruktor nadklasy,
     * w którym definiowane sa podstawowe parametry otwieranego okna JFrame
     */
    OknoGlowne(String nazwa){ 
        super(nazwa);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("src/nutka.png"));
        setSize(1280,1024);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } //koniec konstruktora

    /**
     * Metoda usawiajaca komponenty panelu glownego i obslugujaca ich dzialanie,
     * laczenie z ustawianiem tytulu i wlaczaniem muzyki z biblioteki MIDI
     * @see #bSamouczek - nasluchujacy na klikniecie i przechodzacy do panelu samouczka
     * @see #bTrybStand - nasluchujacy na klikniecie i przechodzacy do panelu trybu standardowgo
     * @see #bTrybDow - nasluchujacy na klikniecie i przechodzacy do panelu trybu dowolnego
     * @see #bmuzyka - nasluchujacy na klikniecie i wylaczajacy muzyke w tle
     * @see #tytul - ustawiony tytul gry na panelu menu
     * @see #grafika - ustawiony gif w panelu
     * @throws FileNotFoundException 
     * @throws IOException 
     */    
    public void menuGlowne() throws FileNotFoundException, IOException{
      
         panelMenu.setBackground(Color.LIGHT_GRAY);
         panelMenu.setLayout(null);
         add(panelMenu);         
         
         //Parametry naglowka z tytulem gry
         JLabel tytul = new JLabel("Notes to remember");
         tytul.setBounds(350, 25, 700, 100);
         tytul.setFont(new Font("Serif", Font.PLAIN, 84));
         panelMenu.add(tytul);       
         
         //Parametry przycisku samouczka i jego obsluga
         bMuzyka.setBounds(1200, 30, 50, 50);
         bMuzyka.setFont(new Font("Serif", Font.PLAIN, 60)); 
         bMuzyka.setIcon(new ImageIcon("src/muzyka.png"));
         bMuzyka.addActionListener(new ActionListener() {  
             /**
             * Nadpisana metoda nasluchujaca na klikniecie 
             * @param ae actionPerformed()
             */ 
             @Override
             public void actionPerformed(ActionEvent ae) {
                 sequencer.stop(); //wylaczenie muzyki
                 sequencer.close();
             } //koniec actionPerformed()
        }); //koniec ActionListener()
         panelMenu.add(bMuzyka);
         
         //Parametry przycisku samouczka i jego obsluga
         bSamouczek.setBounds(100, 200, 500, 100);
         bSamouczek.setFont(new Font("Serif", Font.PLAIN, 60));  
         bSamouczek.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                getContentPane().removeAll(); //usuniecie komponentow
                PSamouczek samouczek = new PSamouczek(); //otworzenie panelu samouczka
                samouczek.instrukcja();
                add(samouczek.panelSamouczek);
                validate(); //odswiezenie
                sequencer.stop(); //wylaczenie muzyki
                sequencer.close();
                repaint(); //odswiezenie widoku panelu
             } //koniec actionPerformed()
        }); //koniec ActionListener()
         panelMenu.add(bSamouczek);
                 
         //Parametry przycisku trybu standardowego i jego obsluga
         bTrybStand.setBounds(100, 350, 500, 100);
         bTrybStand.setFont(new Font("Serif", Font.PLAIN, 60));  
         bTrybStand.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent ae) {
                getContentPane().removeAll();
                PTrybStandardowy trybStandardowy = new PTrybStandardowy(); //otworzenie panelu trybu dowolnego
                trybStandardowy.piosenka();
                add(trybStandardowy.panelPiosenek);
                validate(); 
                sequencer.stop();
                sequencer.close();
                repaint(); 
             } //koniec actionPerformed()
        }); //koniec ActionListener()
         panelMenu.add(bTrybStand);
         
         //Parametry przycisku trybu dowolnego i jego obsluga
         bTrybDow.setBounds(100, 500, 500, 100);
         bTrybDow.setFont(new Font("Serif", Font.PLAIN, 60));  
         bTrybDow.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                getContentPane().removeAll();
                PTrybDow dowolny = new PTrybDow(); //otworzenie panelu trybu dowolnego
                dowolny.graDowolna(); 
                add(dowolny.panelTrybDow);
                validate();  
                sequencer.stop();
                sequencer.close();
                repaint(); 
             } //koniec actionPerformed()
        }); //koniec ActionListener()
        panelMenu.add(bTrybDow);
    
        //Parametry labala z grafika
        JLabel lGrafika=new JLabel();
        lGrafika.setIcon(new ImageIcon("src/GIF.gif"));
        lGrafika.setBounds(700,200,500,400);
        panelMenu.add(lGrafika);
        
        setVisible(true); // ustawianie widzialnosci panelu glownego menu
        
/**
 * Obsluga muzyki (pliku .mid) za pomoca sekwencera z biblioteki Sequencer
 * z otwarciem pliku i obsluga wyjatku MidiUnavailableException
 */        
  try {          
        if (true){
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            InputStream strumien = new BufferedInputStream(new FileInputStream(new File("src/Chopin.mid"))); //nowy strumien potrzebny do otwarcia pliku
            sequencer.setSequence(strumien);
            sequencer.start();
        } //koniec warunku if odpowiedzialnego za otwieranie pliku .mid i wlaczanie muzyki
       } //koniec try
         catch(MidiUnavailableException mue) {;}  
         catch (IOException | InvalidMidiDataException ex) {
                    Logger.getLogger(PKlawiaturaPianina.class.getName()).log(Level.SEVERE, null, ex);
         } // koniec catch
    } //koniec metody menuGlowne()
 } //koniec klasy OknoGlowne

/**
 * Klasa GraJava jest klasą glowna, otwierajaca okno klasy OknoGlowne - okno menu
 */
public class GraJava {

/**
 * Instancja klasy OknoGlowne i wygenerowanie menu metoda menuGlowne()
 * @param args parametr metody statycznej main()
 * @throws IOException związany z nieudana próba odczytu pliku
 * @throws FileNotFoundException związany z nieznalezieniem otwieranego pliku
 */    
        public static void main(String[] args) throws IOException, FileNotFoundException {       
        OknoGlowne frame = new OknoGlowne("Notes to remember");
        frame.menuGlowne();     
        }  // koniec metody main(String[] args) 
} //koniec klasy GraJava