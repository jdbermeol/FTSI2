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

import com.mlg.acciones.helper.ApplicationConfig;
import com.mlg.acciones.vo.DateVo;
import com.mlg.acciones.vo.QuoteVo;
import com.mlg.acciones.vo.StockVo;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.xtremeware.testapp.helper.Application;

/**
 *
 * @author tuareg
 */
public class QuoteListRenderer extends javax.swing.JPanel implements ListCellRenderer {

    /** Creates new form CandidatoRenderer */
    public QuoteListRenderer() {
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

        labelDate = new javax.swing.JLabel();
        labelLow = new javax.swing.JLabel();
        labelHigh = new javax.swing.JLabel();
        labelOpen = new javax.swing.JLabel();
        labelClose = new javax.swing.JLabel();
        labelVolume = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));

        labelDate.setText("date");
        add(labelDate);

        labelLow.setText("low");
        add(labelLow);

        labelHigh.setText("high");
        add(labelHigh);

        labelOpen.setText("open");
        add(labelOpen);

        labelClose.setText("close");
        add(labelClose);

        labelVolume.setText("volume");
        add(labelVolume);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelClose;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelHigh;
    private javax.swing.JLabel labelLow;
    private javax.swing.JLabel labelOpen;
    private javax.swing.JLabel labelVolume;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        QuoteVo quote = (QuoteVo) value;
		DateVo date = ApplicationConfig.getInstance().getFacadeFactory().getDateFacade().getDate(quote.getId());
		labelDate.setText(date.getDate() + " / " + date.getMonth() + " / " + date.getYear());
		labelClose.setText(String.valueOf(quote.getClose()));
		labelOpen.setText(String.valueOf(quote.getOpen()));
		labelHigh.setText(String.valueOf(quote.getHigh()));
		labelLow.setText(String.valueOf(quote.getLow()));
		labelVolume.setText(String.valueOf(quote.getVolume()));

        if (isSelected)
            this.setBackground(new Color(232,232,252));
        else
            this.setBackground(new Color(255,255,255));
        return this;
    }

}
