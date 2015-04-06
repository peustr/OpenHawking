/*
 Copyright (C) 2015 Panagiotis Eustratiadis
 This program is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package gr.peustr.openhawking.gui;

import com.gtranslate.Audio;
import com.gtranslate.Language;
import gr.peustr.openhawking.core.DefaultSwitchingPolicy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javazoom.jl.decoder.JavaLayerException;

/**
 *
 * @author peustr
 */
public class MenuScreen extends JFrame {

    private Audio audio;
    private List<ActionPanel> actionPanels;

    /**
     * Creates new form MenuScreen
     */
    public MenuScreen() {
        initComponents();
        initCustomComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputText = new javax.swing.JTextField();
        contentPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenHawking");
        setBackground(new java.awt.Color(255, 255, 255));

        inputText.setFont(inputText.getFont().deriveFont(inputText.getFont().getStyle() & ~java.awt.Font.BOLD, 30));

        contentPane.setBackground(new java.awt.Color(255, 255, 255));
        contentPane.setLayout(new java.awt.GridLayout(3, 4));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addComponent(inputText))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initCustomComponents() {
        audio = Audio.getInstance();
        actionPanels = new ArrayList<>();
        SimpleActionPanel p1 = new SimpleActionPanel(this, "Α - Ζ", new String[]{"α", "β", "γ", "δ", "ε", "ζ"}) {

            @Override
            public void act() {
                DefaultSwitchingPolicy.getInstance().apply(getActionButtons());
            }
        };
        SimpleActionPanel p2 = new SimpleActionPanel(this, "Η - Μ", new String[]{"η", "θ", "ι", "κ", "λ", "μ"}) {

            @Override
            public void act() {
                DefaultSwitchingPolicy.getInstance().apply(getActionButtons());
            }
        };
        SimpleActionPanel p3 = new SimpleActionPanel(this, "Ν - Σ", new String[]{"ν", "ξ", "ο", "π", "ρ", "σ"}) {

            @Override
            public void act() {
                DefaultSwitchingPolicy.getInstance().apply(getActionButtons());
            }
        };
        SimpleActionPanel p4 = new SimpleActionPanel(this, "Τ - Ω", new String[]{"τ", "υ", "φ", "χ", "ψ", "ω"}) {

            @Override
            public void act() {
                DefaultSwitchingPolicy.getInstance().apply(getActionButtons());
            }
        };
        SimpleActionPanel p5 = new SimpleActionPanel(this, "ΝΑΙ", new String[]{"ΝΑΙ"}) {

            @Override
            public void act() {
                InputStream sound = null;
                try {
                    sound = audio.getAudio("ναι", Language.GREEK);
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
                try {
                    audio.play(sound);
                } catch (JavaLayerException ex) {
                    ex.printStackTrace(System.err);
                }
            }

        };
        SimpleActionPanel p6 = new SimpleActionPanel(this, "ΟΧΙ", new String[]{"ΟΧΙ"}) {

            @Override
            public void act() {
                InputStream sound = null;
                try {
                    sound = audio.getAudio("όχι", Language.GREEK);
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
                try {
                    audio.play(sound);
                } catch (JavaLayerException ex) {
                    ex.printStackTrace(System.err);
                }
            }

        };
        SimpleActionPanel p7 = new SimpleActionPanel(this, "ΚΕΝΟ", new String[]{"ΚΕΝΟ"}) {

            @Override
            public void act() {
                inputText.setText(inputText.getText() + " ");
            }

        };
        SimpleActionPanel p8 = new SimpleActionPanel(this, "ΚΑΘΑΡΙΣΜΑ", new String[]{"ΚΑΘΑΡΙΣΜΑ"}) {

            @Override
            public void act() {
                inputText.setText("");
            }

        };
        SimpleActionPanel p9 = new SimpleActionPanel(this, "ΦΩΝΗ", new String[]{"ΦΩΝΗ"}) {

            @Override
            public void act() {
                InputStream sound = null;
                try {
                    sound = audio.getAudio(inputText.getText(), Language.GREEK);
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
                try {
                    audio.play(sound);
                } catch (JavaLayerException ex) {
                    ex.printStackTrace(System.err);
                }
            }

        };
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        contentPane.add(p7);
        contentPane.add(p8);
        contentPane.add(p9);
        actionPanels.add(p1);
        actionPanels.add(p2);
        actionPanels.add(p3);
        actionPanels.add(p4);
        actionPanels.add(p5);
        actionPanels.add(p6);
        actionPanels.add(p7);
        actionPanels.add(p8);
        actionPanels.add(p9);
        DefaultSwitchingPolicy.getInstance().apply(actionPanels);
        pack();
    }

    public JTextField getInputText() {
        return inputText;
    }

    public List<ActionPanel> getActionPanels() {
        return actionPanels;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JTextField inputText;
    // End of variables declaration//GEN-END:variables

}
