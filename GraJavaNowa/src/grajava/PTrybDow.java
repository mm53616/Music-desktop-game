package grajava;
/**
 * @author Magdalena Manthey
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

    /**
     * Klasa implementujaca klawiature z klasy PKlawiaturaPianina i wyswietlajaca ja
     * wraz z przyciskiem cofnij i labelem na panelu
     */
    public class PTrybDow {

        /**
         * @see #panelTrybDow - umozliwiajacy umieszczanie komponentow 
         */ 
        public JPanel panelTrybDow = new JPanel ();  
        /**
          * @see #bPowrot - obsłużony by po kliknieciu wrocic do panelu menu glownego
         */
        private JButton bPowrot = new JButton();
        /**
          * @see #wynik - odnoszacy sie do wyswietlanego tekstu w panelu
         */
        private JLabel wynik = new JLabel();


        /**
         * Metoda ustawia odpowiedni layout i dodaje do panelu klawiature pianina z
         * klasy PKlawiaturaPianina, label z napisem oraz przycisk cofnij,
         * czekajacy na klikniecie w celu powrotu do menu glownego.
        */  
        public void graDowolna(){

            panelTrybDow.setLayout(new BorderLayout());
            PKlawiaturaPianina klawiaturaPianina = new PKlawiaturaPianina();
            klawiaturaPianina.panelKlawiatura();
            panelTrybDow.add(klawiaturaPianina.panelKlawiatura);
            klawiaturaPianina.panelKlawiatura.add(wynik);
            klawiaturaPianina.panelKlawiatura.add(bPowrot);
            panelTrybDow.validate();


            wynik.setBounds(100, 125, 700, 100);  
            wynik.setText("Graj to, na co masz ochotę");
            wynik.setFont(new Font("Serif", Font.PLAIN,60));


            //Parametry i obsluga przycisku Wyjdz
            bPowrot.setBounds(800, 100, 300, 150);
            bPowrot.setText("Cofnij");
            bPowrot.setFont(new Font("Serif", Font.PLAIN, 70));  
            bPowrot.addActionListener(new ActionListener() {
                /**
                   * metoda czekajaca na klikniecie w celu powrotu do menu glownego
                   * @param ae 
                */
                @Override
                public void actionPerformed(ActionEvent ae) {
                     OknoGlowne menu = new OknoGlowne("");  
                     menu.getContentPane().removeAll();
                     try {
                        menu.menuGlowne();
                     } catch (IOException ex) {
                        Logger.getLogger(PKlawiaturaPianina.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    } //koniec actionPerformed()     
                }); //koniec ActionListener() 
    } // koniec metody graDowolna()     
}// koniec klasy PTrybDow
