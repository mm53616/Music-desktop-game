package grajava;
/**
 * @author Magdalena Manthey
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa tworzy panel samouczka z ustawionymi
 * komponentami w layout BorderLayout
 */
public class PSamouczek {

    /**
      * @see #tekst - tekstbox do umiejszczenia wewnatrz instrukcji 
    */     
    private JTextArea tekst = new JTextArea();
    /**
      * @see #suwak - suwak umozliwiajacy przesuwanie tekstu z tekstboxu
    */  
    private JScrollPane suwak=new JScrollPane(tekst);
    /**
      * @see #panelSamouczek - panel umozliwiajacy umieszczanie na nim komponentow 
    */ 
    public JPanel panelSamouczek = new JPanel (); 
    /**
      * @see #panelSamouczek - panel umozliwiajacy umieszczanie na nim komponentow 
    */ 
    private JButton bCofnij = new JButton ();  


    /**
     * Metoda, w ktorej do panelu dodawany jest przycisk umozliwiajacy powrot do menu
     * glownego oraz pole tekstowe wraz z przesuwajacym tekst suwakiem, dziedziczace po JScrollPane
     */
     public void instrukcja() {

        JLabel naglowek = new JLabel("Instrukcja");
        naglowek.setFont(new Font("Serif", Font.PLAIN, 80));


        //Parametry, wlasciwosci i zawartosc tekstowa pola tekstowego
        tekst.setText("Gra Notes to remember jest grą muzyczną, rozwijającą"
                + " koordynację i pamięć. Gracz może w trybie dowolnym grać"
                + " dowolną melodię. Jednak jego głównym zadaniem jest"
                + " powtarzanie dźwięków: wylosowaną kombinację lub"
                + " konkretny utwór wybrany z menu. Po naciśnięciu przycisku"
                + " START, musi powtórzyć wylosowaną kombinację,"
                + " naciskając na odpowiednie klawisze, które się zaświeciły."
                + " Powodzenia! ");
        tekst.setEditable(false); //brak mozliwosci edycji zawartosci pola
        tekst.setCaretPosition(0); //widziany poczatek tesktu; nie jest on przewiniety
        tekst.setSize(500, 700);
        tekst.setBackground(Color.gray);
        tekst.setAutoscrolls(true);
        tekst.setLineWrap(true); //zawijanie tekstu
        tekst.setWrapStyleWord(true); 
        tekst.setFont(new Font("Serif", Font.PLAIN,60));


        //Dziedziczacy po klasie JScrollPane suwak i jego ustawienia
        suwak.setViewportView(tekst);
        suwak.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        //Parametry i obsluga przycisku cofnij
        bCofnij.setText("Cofnij");
        bCofnij.setFont(new Font("Serif", Font.PLAIN, 70)); 
        bCofnij.addActionListener(new ActionListener() {
            /**
              * metoda czekajaca na klikniecie w celu powrotu do menu glownego
              * @param ae 
            */
            @Override
            public void actionPerformed(ActionEvent ae) {
                OknoGlowne menu = new OknoGlowne("");  
                try {
                    menu.menuGlowne();  
                }catch (IOException ex) {
                        Logger.getLogger(PKlawiaturaPianina.class.getName()).log(Level.SEVERE, null, ex);
                }
                } //koniec actionPerformed()
            }); //koniec ActionListener()  


        panelSamouczek.setBorder(BorderFactory.createEmptyBorder(20, 50, 50, 50));
        panelSamouczek.setLayout(new BorderLayout());
        panelSamouczek.setBackground(Color.LIGHT_GRAY);
        panelSamouczek.add(naglowek, BorderLayout.NORTH);
        panelSamouczek.add(suwak, BorderLayout.CENTER);
        panelSamouczek.add(bCofnij, BorderLayout.PAGE_END);

       } //koniec metody instrukcja();
} //koniec klasy PSamouczek