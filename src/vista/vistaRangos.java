/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JToggleButton;

import TheRango.Rang;
import TheRango.Tablero;

/**
 *
 * @author Jose Manuel
 */
@SuppressWarnings("serial")
public class vistaRangos extends javax.swing.JFrame {
	
	private ArrayList<String> listaCartas;
    /**
     * Creates new form vistaRangos
     */
    public vistaRangos() {
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(vistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(vistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(vistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(vistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
    	listaCartas = new ArrayList<String>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	cutre = new Tablero(new Rang(new String[] {}));
        jPanel1 = new javax.swing.JPanel();
        entradaTexto = new javax.swing.JTextField();
        botonSeleccionar = new javax.swing.JButton();
        salidaMarcados = new javax.swing.JTextField();
        Generar = new javax.swing.JButton();
        colorDiagonal = new java.awt.Color(255,255,153);
        colorSuited = new java.awt.Color(255,204,153);
        colorOffsuited = new java.awt.Color(204,255,255);
        tablero = new JToggleButton[NUMCARTAS][NUMCARTAS];
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 102, 0)));

        //Horizontal
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        javax.swing.GroupLayout.ParallelGroup pg = jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
              
        for(int f=0; f<NUMCARTAS;f++) {
        	//Horizontal
        	javax.swing.GroupLayout.SequentialGroup sq = jPanel1Layout.createSequentialGroup();
        	pg.addGroup(sq);

        	
        	for(int c=0; c<NUMCARTAS;c++) {
        		JToggleButton casilla = new JToggleButton();
        		String nomCasilla = nombreCarta(13-Math.min(f, c)+1);
        		nomCasilla += nombreCarta(13-Math.max(f, c)+1);
        		casilla.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        		casilla.setAlignmentY(0.0F);
        		casilla.setBorder(null);
        		casilla.setBorderPainted(false);
        		casilla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        		casilla.setFocusPainted(false);
        		casilla.setIconTextGap(0);
        		casilla.setMargin(new java.awt.Insets(0, 0, 0, 0));
        		casilla.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                    	toggle((JToggleButton) evt.getSource());
                    }
                });
        		
        		if(f<c) {
        			casilla.setBackground(colorSuited);
        			nomCasilla += "s";
        		}
        		else if(f>c) {
        			casilla.setBackground(colorOffsuited);
        			nomCasilla += "o";
        		}
        		else casilla.setBackground(colorDiagonal);
        		
        		casilla.setText(nomCasilla);
        		tablero[f][c] = casilla;
        		//Horizontal
        		sq.addComponent(casilla, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE);
                sq.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
                
        	}//columnas
        }//filas
        
        //Horizontal
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                	.addGroup(pg)
	                		.addContainerGap())
        );
        //Vertical
        javax.swing.GroupLayout.SequentialGroup sq2 = jPanel1Layout.createSequentialGroup().addContainerGap();
        for(int f=0; f<NUMCARTAS;f++) {
        	javax.swing.GroupLayout.ParallelGroup gr = jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        	sq2.addGroup(gr);
        	for(int c=NUMCARTAS-1; c>=0;c--) {//Introduce los elementos en orden inverso
        		gr.addComponent(tablero[f][c], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE);
        	}
        	sq2.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        }
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sq2.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSeleccionarActionPerformed(evt);
            }
        });
        
        salidaMarcados.setEditable(false);
        salidaMarcados.setFocusable(false);

        Generar.setText("Generar");
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(salidaMarcados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(entradaTexto, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonSeleccionar)
                            .addComponent(Generar))))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entradaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salidaMarcados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Generar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*
     * Dado un entero con el valor de una carta
     * devuelve su identificación en String 
     * */
    private String nombreCarta(int c) {
    	if(c==14)return "A";
    	if(c==13)return "K";
    	if(c==12)return "Q";
    	if(c==11)return "J";
    	if(c==10)return "T";
    	else return Integer.toString(c);
    }
    
    /*
     * Guarda en salidaMarcados la lista de todos los rangos pulsados
     * */
    public void leerMarcados() {
    	String aux = "";
    	 for(int i = 0; i<listaCartas.size();i++) {
    		 aux+=listaCartas.get(i);
       }
    	 this.salidaMarcados.setText(aux);
    }
    
    public void clean() {
    	for(int f=0; f<NUMCARTAS;f++) 
        	for(int c=0; c<NUMCARTAS;c++) {
        		tablero[f][c].setSelected(false);
	      	   	//Devuelve al color original
	            if(tablero[f][c].getText().length()==2) tablero[f][c].setBackground(colorDiagonal);
	            else if(tablero[f][c].getText().charAt(2)=='s') tablero[f][c].setBackground(colorSuited);
	            else tablero[f][c].setBackground(colorOffsuited);
        	}
    }
    
    public void pulsaCoord(int fila, int col) {
    	if(!tablero[fila][col].isSelected()) {
    		tablero[fila][col].setBackground(Color.red);
       	   this.listaCartas.add(tablero[fila][col].getText());
       	   tablero[fila][col].setSelected(true);
          }
          else {
       	   	this.listaCartas.remove(tablero[fila][col].getText());
       	   	tablero[fila][col].setSelected(false);
       	   	//Devuelve al color original
             if(tablero[fila][col].getText().length()==2) tablero[fila][col].setBackground(colorDiagonal);
             else if(tablero[fila][col].getText().charAt(2)=='s') tablero[fila][col].setBackground(colorSuited);
             else tablero[fila][col].setBackground(colorOffsuited);
          }  
    }
    /*
     * Accion que realizan todos los JToggle
     * */
    private void toggle(javax.swing.JToggleButton boton) {
    	 if(boton.isSelected()) {
      	   boton.setBackground(Color.red);
      	   this.listaCartas.add(boton.getText());
         }
         else {
      	   	this.listaCartas.remove(boton.getText());
      	   	//Devuelve al color original
            if(boton.getText().length()==2) boton.setBackground(colorDiagonal);
            else if(boton.getText().charAt(2)=='s') boton.setBackground(colorSuited);
            else boton.setBackground(colorOffsuited);
         }   
    }
  
    
    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        //leerMarcados();
    	this.cutre.clean();
    	for(int i=0;i<13;i++)
    		for(int j=0;j<13;j++) {
    			if(this.tablero[i][j].isSelected()) 
    				this.cutre.selectCord(12-i, 12-j);
    		}
        this.cutre.tabToRang();
        //rescribir
        salidaMarcados.setText(this.cutre.getRang().toString());
    }//GEN-LAST:event_GenerarActionPerformed

    private void BotonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
    	clean();
    	if(!entradaTexto.getText().isEmpty()) {
	    	cutre.setRango(entradaTexto.getText().split(", "));
	    	int[][] tableroCutreAux = cutre.getTablerocutre();
	    	for(int i=0;i<13;i++)
	    		for(int j=0;j<13;j++) {
	    			if(tableroCutreAux[i][j]==2) 
	    				pulsaCoord(12-i,12-j);
	    		}
    	}
    }//GEN-LAST:event_GenerarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generar;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JTextField entradaTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField salidaMarcados;
    private Color colorDiagonal;
    private Color colorSuited;
    private Color colorOffsuited;
    private final int NUMCARTAS = 13;
    private JToggleButton[][] tablero;
    private Tablero cutre;
    // End of variables declaration//GEN-END:variables
}
