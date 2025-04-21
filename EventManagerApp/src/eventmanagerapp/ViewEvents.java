/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eventmanagerapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/**
 *
 * @author nayju
 */
public class ViewEvents extends javax.swing.JFrame {

    /**
     * Creates new form ViewEvents
     */
    public ViewEvents() {
        initComponents();
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) jSpinner1.getEditor();
        editor.getTextField().setEditable(true);

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "yyyy-MM-dd"));
        
        String[] categories = {"WorkShops", "Seminars", "Social Events", "Tests"};
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(categories));
        loadEventsToTextArea(); // load the events after UI initializes

        // Add action listeners
        jButton1.addActionListener(e -> filterEventsByDate());
        jButton2.addActionListener(e -> filterEventsByCategory());
    }

    public void loadEventsToTextArea() {
        File file = new File("Events.txt");
        if (!file.exists()) {
            jTextArea1.setText("No events found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String name = parts[0];
                    String date = parts[1];
                    int time = Integer.parseInt(parts[2]);
                    String description = parts[3];
                    String venue = parts[4];

                    int hours = time / 100;
                    int minutes = time % 100;

                    String formattedTime = String.format("%02d:%02d", hours, minutes);

                    builder.append("Event: ").append(name)
                            .append("\nDate: ").append(date)
                            .append("\nTime: ").append(formattedTime)
                            .append("\nDescription: ").append(description)
                            .append("\nVenue: ").append(venue)
                            .append("\n-----------------------------\n");
                }
            }

            jTextArea1.setText(builder.toString());

        } catch (IOException e) {
            jTextArea1.setText("Error loading events: " + e.getMessage());
        }
    }

    public void filterEventsByDate() {
        File file = new File("Events.txt");
        if (!file.exists()) {
            jTextArea1.setText("No events found.");
            return;
        }

        // Get selected date
        java.util.Date selectedDate = (java.util.Date) jSpinner1.getValue();

        if (selectedDate == null) {
            jTextArea1.setText("Please select a valid date.");
            JOptionPane.showMessageDialog(null, "Enter the date in this format: yyyy-MM-dd \ne.g 2025-06-30");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder builder = new StringBuilder();

            //format the date
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String selectedDateStr = sdf.format(selectedDate);

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 6);
                if (parts.length == 6 && parts[1].equals(selectedDateStr)) {
                    appendFormattedEvent(builder, parts);
                }
            }

            jTextArea1.setText(builder.length() > 0 ? builder.toString() : "No events found for that date.");

        } catch (IOException e) {
            jTextArea1.setText("Error filtering events: " + e.getMessage());
        }
    }

    public void filterEventsByCategory() {
        File file = new File("Events.txt");
        if (!file.exists()) {
            jTextArea1.setText("No events found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder builder = new StringBuilder();
            String selectedCategory = (String) jComboBox1.getSelectedItem();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 6);
                if (parts.length == 6 && parts[5].equalsIgnoreCase(selectedCategory)) {
                    appendFormattedEvent(builder, parts);
                }
            }

            jTextArea1.setText(builder.length() > 0 ? builder.toString() : "No events found for that category.");

        } catch (IOException e) {
            jTextArea1.setText("Error filtering events: " + e.getMessage());
        }
    }

    private void appendFormattedEvent(StringBuilder builder, String[] parts) {
        String name = parts[0];
        String date = parts[1];
        int time = Integer.parseInt(parts[2]);
        String description = parts[3];
        String venue = parts[4];
        String category = parts[5];

        int hours = time / 100;
        int minutes = time % 100;
        String formattedTime = String.format("%02d:%02d", hours, minutes);

        builder.append("Event: ").append(name)
                .append("\nDate: ").append(date)
                .append("\nTime: ").append(formattedTime)
                .append("\nDescription: ").append(description)
                .append("\nVenue: ").append(venue)
                .append("\nCategory: ").append(category)
                .append("\n-----------------------------\n");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("View Events:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Search by date:");

        jLabel3.setText("Search by Category:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner1)
                            .addComponent(jComboBox1, 0, 273, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

    }                                        

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEvents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
