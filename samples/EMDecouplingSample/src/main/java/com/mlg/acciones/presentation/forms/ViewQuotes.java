/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlg.acciones.presentation.forms;

import com.mlg.acciones.facade.FacadeFactory;
import com.mlg.acciones.vo.CompanyVo;
import com.mlg.acciones.vo.MarketVo;
import com.mlg.acciones.vo.StockVo;
import com.mlg.aciones.presentation.lists.model.ModeloLista;
import com.mlg.aciones.presentation.lists.render.CompanyListRenderer;
import com.mlg.aciones.presentation.lists.render.StockListRenderer;

/**
 *
 * @author Owner
 */
public class ViewQuotes extends javax.swing.JPanel {

    /**
     * Creates new form ViewQuotes
     */
    public ViewQuotes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        marketList = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        companyList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        marketDeleteButton = new javax.swing.JButton();
        marketCreateButton = new javax.swing.JButton();
        marketEditButton = new javax.swing.JButton();
        companyDeleteButton = new javax.swing.JButton();
        companyEditButton = new javax.swing.JButton();
        companyCreateButton = new javax.swing.JButton();
        stockCreateButton = new javax.swing.JButton();
        stockEditButton = new javax.swing.JButton();
        stockDeleteButton = new javax.swing.JButton();

        marketList.setModel(new ModeloLista<MarketVo>(FacadeFactory.getInstance().getMarketFacade().getAll()));
        marketList.setCellRenderer(new CompanyListRenderer());
        jScrollPane1.setViewportView(marketList);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        companyList.setModel(new ModeloLista<CompanyVo>(FacadeFactory.getInstance().getCompanyFacade().getAll(((MarketVo)marketList.getSelectedValue()).getId())));
        companyList.setCellRenderer(new CompanyListRenderer());
        jScrollPane2.setViewportView(companyList);

        jLabel1.setText("Select a market");

        jLabel2.setText("Select a company");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        stockList.setModel(new ModeloLista<StockVo>(FacadeFactory.getInstance().getStockFacade().getAll(((CompanyVo)companyList.getSelectedValue()).getId())));
        stockList.setCellRenderer(new StockListRenderer());
        jScrollPane3.setViewportView(stockList);

        jLabel3.setText("Select a stock");

        marketDeleteButton.setText("Delete market");
        marketDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketDeleteButtonActionPerformed(evt);
            }
        });

        marketCreateButton.setText("Create market");
        marketCreateButton.setActionCommand("Create market");
        marketCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketCreateButtonActionPerformed(evt);
            }
        });

        marketEditButton.setLabel("Edit market");
        marketEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketEditButtonActionPerformed(evt);
            }
        });

        companyDeleteButton.setText("Delete company");
        companyDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyDeleteButtonActionPerformed(evt);
            }
        });

        companyEditButton.setText("Edit company");
        companyEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyEditButtonActionPerformed(evt);
            }
        });

        companyCreateButton.setText("Create company");
        companyCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyCreateButtonActionPerformed(evt);
            }
        });

        stockCreateButton.setText("Create stock");
        stockCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockCreateButtonActionPerformed(evt);
            }
        });

        stockEditButton.setText("Edit stock");
        stockEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockEditButtonActionPerformed(evt);
            }
        });

        stockDeleteButton.setText("Delete stock");
        stockDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockDeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(marketDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(marketCreateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(marketEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(companyDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(companyCreateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(companyEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stockDeleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(stockCreateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stockEditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(marketCreateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marketEditButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(marketDeleteButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(companyCreateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(companyEditButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(companyDeleteButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(stockCreateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockEditButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockDeleteButton)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void marketDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketDeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marketDeleteButtonActionPerformed

    private void marketCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketCreateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marketCreateButtonActionPerformed

    private void marketEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marketEditButtonActionPerformed

    private void companyDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyDeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyDeleteButtonActionPerformed

    private void companyEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyEditButtonActionPerformed

    private void companyCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyCreateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_companyCreateButtonActionPerformed

    private void stockCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockCreateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockCreateButtonActionPerformed

    private void stockEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockEditButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockEditButtonActionPerformed

    private void stockDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockDeleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockDeleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton companyCreateButton;
    private javax.swing.JButton companyDeleteButton;
    private javax.swing.JButton companyEditButton;
    private javax.swing.JList companyList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton marketCreateButton;
    private javax.swing.JButton marketDeleteButton;
    private javax.swing.JButton marketEditButton;
    private javax.swing.JList marketList;
    private javax.swing.JButton stockCreateButton;
    private javax.swing.JButton stockDeleteButton;
    private javax.swing.JButton stockEditButton;
    private javax.swing.JList stockList;
    // End of variables declaration//GEN-END:variables
}