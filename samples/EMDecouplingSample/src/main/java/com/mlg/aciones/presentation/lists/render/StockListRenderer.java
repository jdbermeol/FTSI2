/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CandidatoRenderer.java
 *
 * Created on Apr 9, 2011, 8:05:30 PM
 */

package com.mlg.aciones.presentation.lists.render;

import com.mlg.acciones.vo.StockVo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author tuareg
 */
public class StockListRenderer extends javax.swing.JPanel implements ListCellRenderer {

    /** Creates new form CandidatoRenderer */
    public StockListRenderer() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelName = new javax.swing.JLabel();
        labelSymbol = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));

        labelName.setText("nombre");
        add(labelName);

        labelSymbol.setText("nemo");
        add(labelSymbol);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSymbol;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        StockVo company = (StockVo) value;

        labelName.setText(company.getName());
        labelSymbol.setText(company.getSymbol());

        if (isSelected)
            this.setBackground(new Color(232,232,252));
        else
            this.setBackground(new Color(255,255,255));
        return this;
    }

}
