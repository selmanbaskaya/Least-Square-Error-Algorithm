package lse_exp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;




public class lse extends javax.swing.JFrame {
    /*    LSE Algoritmasını Uygulayabilmek İçin Verileri Tutmamız Gereken Değişkenler    */
    static double x_sum, y_sum, xy_sum, x_squared_sum, number_of_data;
    double slope, equation;
    static double intercept;
    static double value_estimate, result_estimate;
    static int[] y_data, x_data, end_y_data, end_x_data;
    static ArrayList <String> array, independent, dependent = new ArrayList <String>();
    static Thread t1;
    /*    LSE Algoritmasını Uygulayabilmek İçin Verileri Tutmamız Gereken Değişkenler    */

    public lse() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        btn_calculate = new javax.swing.JButton();
        lbl_independent = new javax.swing.JLabel();
        lbl_dependent = new javax.swing.JLabel();
        tf_independent = new javax.swing.JTextField();
        tf_dependent = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_sum = new javax.swing.JTable();
        lbl_estimate = new javax.swing.JLabel();
        tf_estimate = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_x_y_values = new javax.swing.JTable();
        btn_draw_chart = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_result = new javax.swing.JTable();
        pnl_title = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        pnl_footer = new javax.swing.JPanel();
        lbl_footer = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_main.setBackground(new java.awt.Color(51, 51, 51));
        pnl_main.setForeground(new java.awt.Color(255, 255, 255));

        btn_calculate.setBackground(new java.awt.Color(255, 204, 51));
        btn_calculate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_calculate.setForeground(new java.awt.Color(255, 255, 255));
        btn_calculate.setText("Calculate");
        btn_calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculateActionPerformed(evt);
            }
        });

        lbl_independent.setBackground(new java.awt.Color(153, 153, 153));
        lbl_independent.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_independent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_independent.setText("Independent Variable Values (X):");

        lbl_dependent.setBackground(new java.awt.Color(153, 153, 153));
        lbl_dependent.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_dependent.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dependent.setText("Dependent Variable Values (Y):");

        tbl_sum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                " The sum of X", " The sum of Y", " The sum of X*Y", " The sum of X^2"
            }
        ));
        jScrollPane2.setViewportView(tbl_sum);

        lbl_estimate.setBackground(new java.awt.Color(153, 153, 153));
        lbl_estimate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_estimate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_estimate.setText(" Value to be Estimated:");

        tbl_x_y_values.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "X", "Y"
            }
        ));
        jScrollPane3.setViewportView(tbl_x_y_values);

        btn_draw_chart.setBackground(new java.awt.Color(255, 204, 51));
        btn_draw_chart.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_draw_chart.setForeground(new java.awt.Color(255, 255, 255));
        btn_draw_chart.setText(" Draw a Chart");
        btn_draw_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_draw_chartActionPerformed(evt);
            }
        });

        tbl_result.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Slope - m", "Intercapt - b", "Value to be Estimated", "Predicted Result "
            }
        ));
        jScrollPane4.setViewportView(tbl_result);

        pnl_title.setBackground(new java.awt.Color(255, 204, 51));
        pnl_title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_title.setText("Least Squares Error");

        javax.swing.GroupLayout pnl_titleLayout = new javax.swing.GroupLayout(pnl_title);
        pnl_title.setLayout(pnl_titleLayout);
        pnl_titleLayout.setHorizontalGroup(
            pnl_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_titleLayout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addGap(82, 82, 82))
        );
        pnl_titleLayout.setVerticalGroup(
            pnl_titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_titleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title)
                .addContainerGap())
        );

        pnl_footer.setBackground(new java.awt.Color(255, 204, 51));
        pnl_footer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_footer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_footer.setForeground(new java.awt.Color(255, 255, 255));
        lbl_footer.setText("Design by Selman Başkaya");

        javax.swing.GroupLayout pnl_footerLayout = new javax.swing.GroupLayout(pnl_footer);
        pnl_footer.setLayout(pnl_footerLayout);
        pnl_footerLayout.setHorizontalGroup(
            pnl_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_footerLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lbl_footer)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        pnl_footerLayout.setVerticalGroup(
            pnl_footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_footerLayout.createSequentialGroup()
                .addComponent(lbl_footer)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        btn_reset.setBackground(new java.awt.Color(255, 204, 51));
        btn_reset.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_mainLayout = new javax.swing.GroupLayout(pnl_main);
        pnl_main.setLayout(pnl_mainLayout);
        pnl_mainLayout.setHorizontalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_draw_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_mainLayout.createSequentialGroup()
                        .addComponent(pnl_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_mainLayout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_mainLayout.createSequentialGroup()
                            .addComponent(lbl_independent)
                            .addGap(27, 27, 27)
                            .addComponent(tf_independent, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_mainLayout.createSequentialGroup()
                            .addComponent(lbl_dependent)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_dependent, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_mainLayout.createSequentialGroup()
                            .addComponent(lbl_estimate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_estimate, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_mainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        pnl_mainLayout.setVerticalGroup(
            pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mainLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnl_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_independent)
                    .addComponent(tf_independent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_dependent)
                    .addComponent(tf_dependent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_estimate)
                    .addComponent(tf_estimate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_draw_chart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculateActionPerformed
        /*   Bağımlı ve Bağımsız Değişkenleri Değişkende Tutabilmek İçin   */
        String tmp_independent = String.valueOf(tf_independent.getText());
        String independent[] = tmp_independent.split(",");
        
        String tmp_dependent = String.valueOf(tf_dependent.getText());
        String dependent[] = tmp_dependent.split(",");
        /*   Bağımlı ve Bağımsız Değişkenleri Değişkende Tutabilmek İçin   */
        
        /*   Veri Sayısını ve x, y, x*y, x^2 İfadelerinin Toplam Değerlerini Bulmak İçin   */
        number_of_data = dependent.length;
        value_estimate = Integer.valueOf(tf_estimate.getText());
        
        for(int i = 0; i < dependent.length; i++) {
            x_sum = x_sum + Integer.valueOf(independent[i]);
            y_sum = y_sum + Integer.valueOf(dependent[i]);
            xy_sum = xy_sum + (Integer.valueOf(independent[i]) * Integer.valueOf(dependent[i]));
            x_squared_sum = x_squared_sum + (Integer.valueOf(independent[i]) * Integer.valueOf(independent[i]));
        }
        /*   Veri Sayısını ve x, y, x*y, x^2 İfadelerinin Toplam Değerlerini Bulmak İçin   */
        
        /* Verileri Ekrana Yazdırmak İçin */
        System.out.println("Independent Variables: " + tmp_independent);
        
        System.out.println("Dependent Variables: " + tmp_dependent);
        /* Verileri Ekrana Yazdırmak İçin */     
        
        /*   Slope (m) Değerini Bulmak İçin   */
        slope = ((number_of_data * xy_sum) - (x_sum * y_sum)) / ((number_of_data * x_squared_sum) - (x_sum * x_sum));
        System.out.println("Slope: " + slope);
        /*   Slope (m) Değerini Bulmak İçin   */
        
        /*   Intercept (b) Değerini Bulmak İçin   */
        intercept = ((y_sum - (slope * x_sum)) / number_of_data);
        System.out.println("Intercept: " + intercept);
        /*   Intercept (b) Değerini Bulmak İçin   */
        
        /*   Doğru Denklemi İçin   */
        System.out.println("Right Equation => y = " + slope + "x + " + intercept);
        /*   Doğru Denklemi İçin   */
        
        /*   Denkleme Göre Tahmini Değer ve Sonucu   */
        System.out.println("Value to be Estimated: " + value_estimate);
        result_estimate = slope * value_estimate + intercept;
        System.out.println("Result of Estimated Value: " + result_estimate);
        /*   Denkleme Göre Tahmini Değerin Sonucu   */
        
        /*   Tabloya Değerleri Yazdırmak İçin Gerekli ArrayList Tanımlamaları ve Değer Atama İşlemleri   */
        ArrayList x_y_values = new ArrayList();
        ArrayList total_values = new ArrayList();
        ArrayList results = new ArrayList();
        
        for(int i = 0; i < independent.length; i++) {
            x_y_values.add(independent[i]);
            x_y_values.add(dependent[i]);
        }
        
        total_values.add(x_sum);
        total_values.add(y_sum);
        total_values.add(xy_sum);
        total_values.add(x_squared_sum);
        
        results.add(slope);
        results.add(intercept);
        results.add(value_estimate);
        results.add(result_estimate);
        /*   Tabloya Değerleri Yazdırmak İçin Gerekli ArrayList Tanımlamaları ve Değer Atama İşlemleri   */
        
        /*   Tabloya Değerleri Yazdırmak İçin   */
        DefaultTableModel model_x_y_values = (DefaultTableModel) tbl_x_y_values.getModel();
        
        for (int i = 0; i < model_x_y_values.getRowCount();) {
            model_x_y_values.removeRow(0);
        }
        
        Object[] array_x_y_values = new Object[300];
        int column_x_y_values = 0;
        
        for (int i = 0; i < x_y_values.size(); i+=2) {
            column_x_y_values = 0;
            
            for (int j = i; j < i+2; j++) {
                array_x_y_values[column_x_y_values] = x_y_values.get(j);
                column_x_y_values++;
            }
            model_x_y_values.insertRow(model_x_y_values.getRowCount(), array_x_y_values);
        }
        
        DefaultTableModel model_sum = (DefaultTableModel) tbl_sum.getModel();
        
        for (int i = 0; i < model_sum.getRowCount();) {
            model_sum.removeRow(0);
        }
        
        Object[] array_sum = new Object[300];
        int column_sum = 0;
        
        for (int i = 0; i < total_values.size(); i+=4) {
            column_sum = 0;
            
            for (int j = i; j < i+4; j++) {
                array_sum[column_sum] = total_values.get(j);
                column_sum++;
            }
            model_sum.insertRow(model_sum.getRowCount(), array_sum);
        }
        
        DefaultTableModel model_results = (DefaultTableModel) tbl_result.getModel();
        
        for (int i = 0; i < model_results.getRowCount();) {
            model_results.removeRow(0);
        }
        
        Object[] array_results = new Object[300];
        int column_results = 0;
        
        for (int i = 0; i < results.size(); i+=4) {
            column_results = 0;
            
            for (int j = i; j < i+4; j++) {
                array_results[column_results] = results.get(j);
                column_results++;
            }
            model_results.insertRow(model_results.getRowCount(), array_results);
        }
        /*   Tabloya Değerleri Yazdırmak İçin   */
               
    }//GEN-LAST:event_btn_calculateActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        /*   TextField'ların Text Alanını Boşaltmak İçin   */
        tf_independent.setText("");
        tf_dependent.setText("");
        tf_estimate.setText("");
        /*   TextField'ların Text Alanını Boşaltmak İçin   */
        
        /*   Tabloları Sıfırlamak İçin   */
        DefaultTableModel model_x_y_values = (DefaultTableModel) tbl_x_y_values.getModel();
        
        for (int i = 0; i < model_x_y_values.getRowCount();) {
            model_x_y_values.removeRow(0);
        }
        
        DefaultTableModel model_sum = (DefaultTableModel) tbl_sum.getModel();
        
        for (int i = 0; i < model_sum.getRowCount();) {
            model_sum.removeRow(0);
        }
        
        DefaultTableModel model_results = (DefaultTableModel) tbl_result.getModel();
        
        for (int i = 0; i < model_results.getRowCount();) {
            model_results.removeRow(0);
        }
        /*   Tabloları Sıfırlamak İçin   */
        
        /*   Değişkenleri Sıfırlamak İçin   */
        x_sum = 0;
        y_sum = 0;
        xy_sum = 0;
        x_squared_sum = 0;
        number_of_data = 0;
        slope = 0;
        intercept = 0;
        value_estimate = 0;
        result_estimate = 0;
        independent.clear();
        dependent.clear();
        /*   Değişkenleri Sıfırlamak İçin   */
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_draw_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_draw_chartActionPerformed
        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };
 
        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();
    }//GEN-LAST:event_btn_draw_chartActionPerformed

    public static void main(String args[]) {
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calculate;
    private javax.swing.JButton btn_draw_chart;
    private javax.swing.JButton btn_reset;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_dependent;
    private javax.swing.JLabel lbl_estimate;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_independent;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JPanel pnl_footer;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_title;
    private javax.swing.JTable tbl_result;
    private javax.swing.JTable tbl_sum;
    private javax.swing.JTable tbl_x_y_values;
    private javax.swing.JTextField tf_dependent;
    private javax.swing.JTextField tf_estimate;
    private javax.swing.JTextField tf_independent;
    // End of variables declaration//GEN-END:variables
}
