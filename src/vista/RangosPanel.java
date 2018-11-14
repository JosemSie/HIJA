package vista;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import controlador.controlador;
import modelo.Conversor;
import modelo.SlanskyTable;


/*
 * Clase que genera el panel de rangos y todos los botones
 * 
 * 
 * */
@SuppressWarnings("serial")
public class RangosPanel extends JPanel{

	private final int NUMCARTAS = 13;
	private JToggleButton[][] tablero;
	private Color colorDiagonal;
    private Color colorSuited;
    private Color colorOffsuited;
    private Color colorPorcentajes;
	private ArrayList<String> listaCartas;
	private SlanskyTable slanskyTable;
	private String COMMAND;
	private Conversor conversor;
	
	public RangosPanel(String command) {
		conversor = new Conversor();
		COMMAND = command;
		listaCartas = new ArrayList<String>();
		tablero = new JToggleButton[NUMCARTAS][NUMCARTAS];
		colorDiagonal = new java.awt.Color(255,255,153);
        colorSuited = new java.awt.Color(255,204,153);
        colorOffsuited = new java.awt.Color(204,255,255);
        colorPorcentajes = new java.awt.Color(204,0,255);
        slanskyTable = new SlanskyTable();
		
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

        	
        	for(int c=0; c<NUMCARTAS;c++) {
        		JToggleButton casilla = new JToggleButton();
        		String nomCasilla = "";
        		nomCasilla += conversor.getValorCarta(13-Math.min(f, c)+1);
        		nomCasilla += conversor.getValorCarta(13-Math.max(f, c)+1);
        		casilla.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        		casilla.setAlignmentY(0.0F);
        		casilla.setBorder(null);
        		casilla.setBorderPainted(false);
        		casilla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        		casilla.setFocusPainted(false);
        		casilla.setIconTextGap(0);
        		casilla.setMargin(new java.awt.Insets(0, 0, 0, 0));
        		casilla.setActionCommand("RANGO");
        		casilla.setActionCommand(COMMAND);
        		
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
	}
	/*
	 * Limpia el tablero
	 * */
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
    /*
     * Dadas las coordenadas devuelve
     * true si la casilla esa seleccionada
     * */
    public boolean isSelected(int fila, int col) {
		return tablero[fila][col].isSelected();
	}
    
    /*
     * Pinta las casillas de morado en funcion del porcentaje
     * segun la slankyTable
     * */
    public void mostrarPorcentajeRangos(int porcentaje) {
    	//Las parejas a colorear seran todas las cartas
    	int numParejas = ((NUMCARTAS*NUMCARTAS) * porcentaje)/100;
    	ArrayList <String> parejasOrdenadas = new ArrayList<String>();
    	for (int i = 0; i < numParejas; i++)
    		parejasOrdenadas.add(slanskyTable.devuelveCarta(i));
 
    	for (int i = 0; i < NUMCARTAS; i++) 
    		for (int j = 0; j < NUMCARTAS; j++) {
    			if(tablero[i][j].isSelected()) toggle(i,j);
    			if (parejasOrdenadas.contains(tablero[i][j].getText())) {
    				toggle(i,j);
    				tablero[i][j].setBackground(colorPorcentajes);
    			}
    		}	
    }
    
    private static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
    
    public float getPorcentajeRangos() {
    	float porcentaje=0;
    	for (int i = 0; i < NUMCARTAS; i++) 
    		for (int j = 0; j < NUMCARTAS; j++)
    			if(tablero[i][j].isSelected()) {
    				if(i==j)porcentaje += 0.5;//Parejas
    				else if(i<j)porcentaje += 0.3;//suited
    				else porcentaje += 0.9;//offsuited
    			}
    	return Math.min(100,round(porcentaje, 2));
    }
    
    /*
     * Accion que realizan todos los JToggle
     * */
    public void toggle(JToggleButton boton) {
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
    /*
     * Toggle por coordenada
     * */
    public void toggle(int fila, int col) {
    	tablero[fila][col].setSelected(!tablero[fila][col].isSelected());
		toggle(tablero[fila][col]);
	}
    /*
     * Establece el controlador como ationListener de los botones
     * */
	public void setControlador(controlador control) {
		for(int f=0; f<NUMCARTAS;f++) 
	    	for(int c=0; c<NUMCARTAS;c++) tablero[f][c].addActionListener(control);
	}

	public String getNombreCarta(int fila, int col) {
		// TODO Auto-generated method stub
		return tablero[fila][col].getText();
	}

}
