/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.practica2;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import controlador.Controlador2;

/**
 *
 * @author Jose Manuel
 */
@SuppressWarnings("serial")
public class VistaRangos extends JFrame implements InterfazVistaRangos{
	private javax.swing.JButton botonLimpiar;
	private javax.swing.JTextField entradaTexto;
	private RangosPanel rangosPanel;
	private javax.swing.JTextField porcentajeManos;
	private javax.swing.JSlider slideAzar;
	private BoardPanel boardPanel;
	private JTextArea estadisticasPanel;
	private javax.swing.JTextField tituloBoard;
    private javax.swing.JButton Resultado;
    private javax.swing.JTextField tituloEstadisticas;
    private javax.swing.JTextField tituloRangos;
	
    /**
     * Creates new form vistaRangos
     */
    public VistaRangos() {
    	 try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(VistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(VistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(VistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(VistaRangos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rangosPanel = new RangosPanel(RANGO);
        entradaTexto = new javax.swing.JTextField();
        botonLimpiar = new javax.swing.JButton();
        slideAzar = new javax.swing.JSlider();
        porcentajeManos = new javax.swing.JTextField();
        boardPanel = new BoardPanel(CARTABOARD);
        tituloBoard = new javax.swing.JTextField();
        estadisticasPanel = new javax.swing.JTextArea();
        tituloEstadisticas = new javax.swing.JTextField();
        tituloRangos = new javax.swing.JTextField();
        Resultado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        entradaTexto.setActionCommand(SELECCIONAR);
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setActionCommand(LIMPIAR);

        tituloBoard.setBackground(new java.awt.Color(238, 238, 238));
        tituloBoard.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tituloBoard.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tituloBoard.setText("Board");
        tituloBoard.setToolTipText("");
        tituloBoard.setBorder(null);
        tituloBoard.setEditable(false);
        
        porcentajeManos.setEditable(false);
        porcentajeManos.setFocusable(false);
        slideAzar.setValue(0);
        slideAzar.setDoubleBuffered(true);
        slideAzar.setFocusable(false);
        estadisticasPanel.setToolTipText("");
        

        estadisticasPanel.setEditable(false);
        estadisticasPanel.setColumns(20);
        estadisticasPanel.setRows(5);
        estadisticasPanel.setBorder(null);

        tituloEstadisticas.setBackground(new java.awt.Color(238, 238, 238));
        tituloEstadisticas.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tituloEstadisticas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tituloEstadisticas.setText("Estadisticas");
        tituloEstadisticas.setToolTipText("");
        tituloEstadisticas.setBorder(null);
        tituloEstadisticas.setEditable(false);

        tituloRangos.setBackground(new java.awt.Color(238, 238, 238));
        tituloRangos.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        tituloRangos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tituloRangos.setText("Rangos");
        tituloRangos.setToolTipText("");
        tituloRangos.setBorder(null);
        tituloRangos.setEditable(false);
       

        Resultado.setText("Resultado");
        Resultado.setActionCommand(RESULTADO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(porcentajeManos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slideAzar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(entradaTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonLimpiar))
                            .addComponent(rangosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(tituloRangos, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tituloBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(tituloEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estadisticasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Resultado)
                        .addGap(193, 193, 193))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloRangos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rangosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(slideAzar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porcentajeManos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(estadisticasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entradaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLimpiar)
                    .addComponent(Resultado))
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void clean() {
    	rangosPanel.clean();
    	entradaTexto.setText("");
    	slideAzar.setValue(0);
    }
    /*
     * Accion que realizan todos los JToggle
     * */
    public void toggleRango(JToggleButton boton) {
    	rangosPanel.toggle(boton);
    }
    /*
     * Toggle de rango por coordenadas
     * */
	public void toggleBoard(int fila, int col) {
		rangosPanel.toggle(fila, col);		
	}
	/*
	 * Toggle de las cartas de la mesa
	 * */
	public void toggleBoard(JToggleButton boton) {
		this.boardPanel.toggle(boton);		
	}
    
    public void setControlador(Controlador2 control) {
    	boardPanel.setControlador(control);
    	rangosPanel.setControlador(control);
    	botonLimpiar.addActionListener(control);
        Resultado.addActionListener(control);
        entradaTexto.addActionListener(control);
        slideAzar.addChangeListener(control);
	}

	public void arranca() {
		pack();// coloca los componentes
		setLocationRelativeTo(null);//centra la ventana en la pantalla
		setVisible(true);//visualiza la ventana
	}

	public boolean isSelectedRango(int fila, int col) {
		return rangosPanel.isSelected(fila, col);
	}
	
	public boolean isSelectedBoard(int fila, int col) {
		return boardPanel.isSelected(fila, col);
	}

	public void muestraResultado(String s) {
		estadisticasPanel.setText("");;
		estadisticasPanel.setText(s);
	}
	
	public void muestraRango(String s) {
		entradaTexto.setText(s);
	}

	public String getRangoTexto() {
		return entradaTexto.getText();
	}

	public void mostrarPorcentajeRangos() {
    	int porcentaje = this.slideAzar.getValue();
    	this.porcentajeManos.setText(String.valueOf(porcentaje) + "%");
    	rangosPanel.mostrarPorcentajeRangos(porcentaje);
	}

	public void generarPorcentajeRangos() {
		this.porcentajeManos.setText(String.valueOf(rangosPanel.getPorcentajeRangos()) + "%");
	}
	
	public String getNombreCartaBoard(int fila, int col) {
		return boardPanel.getNombreCarta(fila, col);
	}
	public String getNombreCartaRango(int fila, int col) {
		return rangosPanel.getNombreCarta(fila, col);
	}
}
