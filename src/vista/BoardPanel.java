package vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import controlador.controlador;
import modelo.Conversor;

/*
 * 
 * Clase que genera la matriz de cartas del board
 * 
 * */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel{

	private final int NUMCARTAS = 13;
	private final int NUMPALOS = 4;
	private JToggleButton[][] tablero;
	private String COMMAND;
	private Conversor conversor;
	
	public BoardPanel(String command) {
		conversor = new Conversor();
		COMMAND = command;
		tablero = new JToggleButton[NUMCARTAS][NUMPALOS];
        
        this.setBackground(new java.awt.Color(204, 255, 204));
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 102, 0)));
		//Horizontal
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPanel1Layout);
        javax.swing.GroupLayout.ParallelGroup pg = jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
		for(int f=0; f<NUMCARTAS;f++) {
        	//Horizontal
        	javax.swing.GroupLayout.SequentialGroup sq = jPanel1Layout.createSequentialGroup();
        	pg.addGroup(sq);

        	
        	for(int c=0; c<NUMPALOS;c++) {
        		JToggleButton casilla = new JToggleButton();
        		String nomCasilla = "";
        		nomCasilla += conversor.getValorCarta(NUMCARTAS-(f-1));
        		nomCasilla += conversor.intAPalo(c);
        		casilla.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        		casilla.setAlignmentY(0.0F);
        		casilla.setBorder(null);
        		casilla.setBorderPainted(false);
        		casilla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        		casilla.setFocusPainted(false);
        		casilla.setIconTextGap(0);
        		casilla.setMargin(new java.awt.Insets(0, 0, 0, 0));
        		casilla.setActionCommand(COMMAND);
        		casilla.setBackground(colorCasilla(c));
        		
        		
        		casilla.setText(nomCasilla);
        		tablero[f][c] = casilla;
        		//Horizontal
        		sq.addComponent(casilla, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE);
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
        	for(int c=NUMPALOS-1; c>=0;c--) {//Introduce los elementos en orden inverso
        		gr.addComponent(tablero[f][c], javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE);
        	}
        	sq2.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
        }
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sq2.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
	}
	/*
	 * Colores de las casillas en funcion del palo
	 * */
	private Color colorCasilla(int palo) {
		switch (palo){
		case 0: return new Color(255,204,153);
		case 1: return new Color(255,255,153);
		case 2: return new Color(204,255,204);
		case 3: return new Color(204,255,255);
	}
		return new Color(244, 110, 110);
	}
    
    public boolean isSelected(int fila, int col) {
		return tablero[fila][col].isSelected();
	}
    /*
     * Accion que realizan todos los JToggle
     * */
    public void toggle(JToggleButton boton) {
    	 if(boton.isSelected()) boton.setBackground(Color.red);
         else boton.setBackground(colorCasilla(conversor.paloAInt(boton.getText().charAt(1)))); 
    }
    /*
     * Establece el controlador como ationListener de los botones
     * */
	public void setControlador(controlador control) {
		for(int f=0; f<NUMCARTAS;f++) 
	    	for(int c=0; c<NUMPALOS;c++) tablero[f][c].addActionListener(control);
	}
	/*
	 * Dadas fila y columna, devuelve el nombre de la carta
	 * */
	public String getNombreCarta(int fila, int col) {
		return tablero[fila][col].getText();
	}
}
