/*
 * Copyright 2015 Panagiotis Eustratiadis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gr.peustr.openhawking.gui;

import gr.peustr.openhawking.core.guicomponents.ActionPanel;
import gr.peustr.openhawking.core.guicomponents.ActionButton;
import gr.peustr.openhawking.core.guicomponents.ResourceFrame;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peustr
 */
public abstract class SimpleActionPanel extends ActionPanel {

    private ResourceFrame parent;

    private String labelText;
    private String[] buttonTexts;

    private List<ActionButton> buttons;

    /**
     * Creates new form ButtonActionPanel
     *
     * @param parent
     * @param labelText
     * @param buttonTexts
     */
    public SimpleActionPanel(Menu parent, String labelText, String[] buttonTexts) {
        this.parent = parent;
        this.labelText = labelText;
        this.buttonTexts = buttonTexts;
        buttons = new ArrayList<>();
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

        textLabel = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 241, 238));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray));

        textLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        textLabel.setText("jLabel1");

        contentPane.setBackground(new java.awt.Color(240, 241, 238));
        contentPane.setLayout(new java.awt.GridLayout(2, 3, 5, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLabel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initCustomComponents() {
        textLabel.setText(labelText);
        for (String str : buttonTexts) {
            final String curText = str;
            ActionButton jb = new ActionButton(curText) {
                @Override
                public void act() {
                    parent.setTextResource((parent.getTextResource() + curText));
                    GUIDefaultSwitchingPolicy.getInstance().apply(parent.getActionPanels());
                }

            };
            jb.setBackgroundColor(Color.decode("#F0F1EE"));
            jb.setForegroundColor(Color.decode("#4C4C4C"));
            jb.setFont(jb.getFont().deriveFont(jb.getFont().getStyle() & ~java.awt.Font.BOLD, 30));
            buttons.add(jb);
            contentPane.add(jb);
        }
    }

    public List<ActionButton> getActionButtons() {
        return buttons;
    }

    @Override
    public void setBackgroundColor(Color c) {
        setBackground(c);
        contentPane.setBackground(c);
    }

    @Override
    public void setForegroundColor(Color c) {
        textLabel.setForeground(c);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}
