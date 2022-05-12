/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package guicalculator;

import main.ICalculator;

/**
 *
 * @author lucas
 */
public class GUICalculator extends javax.swing.JFrame {
    private ICalculator Calculator;

    /**
     * Creates new form GUICalculator
     */
    public GUICalculator(ICalculator Calculator) {
        initComponents();
        this.jPanel1.setAlignmentX(CENTER_ALIGNMENT);
        this.jPanel1.setAlignmentY(CENTER_ALIGNMENT);
        this.Calculator = Calculator;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Digit7 = new javax.swing.JButton();
        Digit8 = new javax.swing.JButton();
        Digit9 = new javax.swing.JButton();
        Digit4 = new javax.swing.JButton();
        Digit5 = new javax.swing.JButton();
        Digit6 = new javax.swing.JButton();
        Digit1 = new javax.swing.JButton();
        Digit2 = new javax.swing.JButton();
        Digit3 = new javax.swing.JButton();
        Digit0 = new javax.swing.JButton();
        DigitX = new javax.swing.JButton();
        DigitSub = new javax.swing.JButton();
        DigitPlus = new javax.swing.JButton();
        DigitopenPar = new javax.swing.JButton();
        DigitDivision = new javax.swing.JButton();
        DigitClear = new javax.swing.JButton();
        DigitEqual = new javax.swing.JButton();
        DigitclosePar = new javax.swing.JButton();
        DigitComma = new javax.swing.JButton();
        DigitEqual1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Digit7.setText("7");
        Digit7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit7ActionPerformed(evt);
            }
        });

        Digit8.setText("8");
        Digit8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit8ActionPerformed(evt);
            }
        });

        Digit9.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        Digit9.setText("9");
        Digit9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit9ActionPerformed(evt);
            }
        });

        Digit4.setText("4");
        Digit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit4ActionPerformed(evt);
            }
        });

        Digit5.setText("5");
        Digit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit5ActionPerformed(evt);
            }
        });

        Digit6.setText("6");
        Digit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit6ActionPerformed(evt);
            }
        });

        Digit1.setText("1");
        Digit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit1ActionPerformed(evt);
            }
        });

        Digit2.setText("2");
        Digit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit2ActionPerformed(evt);
            }
        });

        Digit3.setText("3");
        Digit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit3ActionPerformed(evt);
            }
        });

        Digit0.setText("0");
        Digit0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Digit0ActionPerformed(evt);
            }
        });

        DigitX.setText("X");
        DigitX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitXActionPerformed(evt);
            }
        });

        DigitSub.setText("-");
        DigitSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitSubActionPerformed(evt);
            }
        });

        DigitPlus.setText("+");
        DigitPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitPlusActionPerformed(evt);
            }
        });

        DigitopenPar.setText("(");
        DigitopenPar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitopenParActionPerformed(evt);
            }
        });

        DigitDivision.setText("/");
        DigitDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitDivisionActionPerformed(evt);
            }
        });

        DigitClear.setText("C");
        DigitClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitClearActionPerformed(evt);
            }
        });

        DigitEqual.setText("=");
        DigitEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitEqualActionPerformed(evt);
            }
        });

        DigitclosePar.setText(")");
        DigitclosePar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitcloseParActionPerformed(evt);
            }
        });

        DigitComma.setText(",");
        DigitComma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitCommaActionPerformed(evt);
            }
        });

        DigitEqual1.setFont(new java.awt.Font("sansserif", 0, 7)); // NOI18N
        DigitEqual1.setText("+/-");
        DigitEqual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DigitEqual1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(33, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Digit1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit4, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit7, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitClear, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitEqual1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Digit5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Digit6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DigitSub, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Digit2,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Digit3,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Digit0,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(DigitComma,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(DigitPlus, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(DigitEqual,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Digit8,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Digit9,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(DigitopenPar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(DigitclosePar,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(DigitDivision,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(DigitX, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(32, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DigitClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitDivision, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitopenPar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitclosePar, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Digit7, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit8, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit9, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitX, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Digit4, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit5, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitSub, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Digit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit2, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Digit3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Digit0, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitComma, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DigitEqual1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)));

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(43, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(79, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Digit1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 1);
    }

    private void Digit2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 2);
    }

    private void Digit3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 3);
    }

    private void Digit4ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 4);
    }

    private void Digit5ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 5);
    }

    private void Digit7ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 7);
    }

    private void Digit6ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 6);
    }

    private void Digit8ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 8);
    }

    private void Digit9ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 9);
    }

    private void Digit0ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + 0);
    }

    private void DigitopenParActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '(');
    }

    private void DigitPlusActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '+');
    }

    private void DigitSubActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '-');
    }

    private void DigitXActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '*');
    }

    private void DigitDivisionActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '/');
    }

    private void DigitClearActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText("");
    }

    private void DigitEqualActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            this.jTextPane1.setText(this.Calculator.eval(this.jTextPane1.getText().toString()));
        } catch (Exception e) {
        }
    }

    private void DigitcloseParActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + ')');
    }

    private void DigitCommaActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + '.');
    }

    private void DigitEqual1ActionPerformed(java.awt.event.ActionEvent evt) {
        this.jTextPane1.setText(this.jTextPane1.getText() + "(-");
    }

    public void run(ICalculator Calculator) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUICalculator.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICalculator.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICalculator.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICalculator.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICalculator(Calculator).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Digit0;
    private javax.swing.JButton Digit1;
    private javax.swing.JButton Digit2;
    private javax.swing.JButton Digit3;
    private javax.swing.JButton Digit4;
    private javax.swing.JButton Digit5;
    private javax.swing.JButton Digit6;
    private javax.swing.JButton Digit7;
    private javax.swing.JButton Digit8;
    private javax.swing.JButton Digit9;
    private javax.swing.JButton DigitClear;
    private javax.swing.JButton DigitComma;
    private javax.swing.JButton DigitDivision;
    private javax.swing.JButton DigitEqual;
    private javax.swing.JButton DigitEqual1;
    private javax.swing.JButton DigitPlus;
    private javax.swing.JButton DigitSub;
    private javax.swing.JButton DigitX;
    private javax.swing.JButton DigitclosePar;
    private javax.swing.JButton DigitopenPar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
