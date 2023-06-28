/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interrogados;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * FXML Controller class
 *
 * @author nombre_usuario
 */
public class IniciarJuegoController implements Initializable {

    private int numero_pregunta = -1;
    private int numero_rapuesta_correcta;
    private boolean juego_terminado = false;
    private boolean pantallaInicio = true;
    private boolean gano = false;
    
    // Salto de linea \n
    private final String[][] preguntas = {
        {
            "¿Cuántas veces puede restarse el número 1 del número 1.111?",  // Pregunta
            "1,111",    // Respuesta 0
            "1,110",    // Respuesta 1
            "0",        // Respuesta 2
            "1",        // Respuesta 3
            "3",        // Numero respuesta correcta inicia desde 0
        },
        {
            "¿quien escribio la obra Hamlet?",
            "Bram Stoker",
            "William Shakespeare",
            "Dante Alighieri",
            "Ninguna de las anteriores",
            "1",
        },
        {
            "¿Quién es el máximo goleador de la historia del fútbol?",
            "Messi",
            "Falcao",
            "James",
            "Cristiano",
            "3",
        },
        {
            "¿En qué año murió Freddie Mercury?",
            "1991",
            "1989",
            "1899",
            "1992",
            "0",
        },
	{
            "¿Cuántos huesos hay en el cuerpo humano?",
            "365",
            "202",
            "206",
            "ninguna de las anteriores",
            "2",
         },
	{
            "¿Cuánto vale el número pi?",
            "3.15",
            "3.1416",
            "3",
            "ninguna de las anteriores",
            "1",
         },
        {
            "Color primario",
            "blanco",
            "negro",
            "azul",
            "ninguna de las anteriores",
            "2",
         },
	{
            "¿En qué lugar se da primero el día jueves que el miércoles?",
            "Monte carlo",
            "Bogota",
            "España",
            "En el diccionario.",
            "3",
         },
        {
            "Si 5 máquinas hacen 5 artículos en 5 minutos, "
            +"\n¿cuánto tiempo dedicarán 100 máquinas en hacer 100 artículos??",
            "5 minutos",
            "5 articulos",
            "5 maquinas",
            "ninguna de las anteriores",
            "0",
         },
        {
            "¿Cómo se llama la cordillera costera más alta del mundo"
            + "\nubicada en Colombia?",
            "Nevado Cocuy",
            "Sierra Nevada de Santa Marta",
            "Nevado del Ruiz",
            "Volcan Purace",
            "1",
         },
        
    };


    @FXML
    private Label idLabelPregunta;
    @FXML
    private RadioButton radioButtonPregunta1;
    @FXML
    private RadioButton radioButtonPregunta2;
    @FXML
    private RadioButton radioButtonPregunta3;
    @FXML
    private RadioButton radioButtonPregunta4;
    ToggleGroup toggleGroup = new ToggleGroup();
    List<RadioButton> radioButtons = new ArrayList<>();
    @FXML
    private Button btnMeLaJuego;
    @FXML
    private Label labelInicioArriba;
    @FXML
    private Label labelInicioCentro;
    @FXML
    private Label labelInicioAbajo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.pantallaInicio();

        // Agregamos los radioButtons a un ToggleGroup
        // para que al seleccionar un radioButton se
        // desselecciones los demas
        radioButtonPregunta1.setToggleGroup(this.toggleGroup);
        radioButtonPregunta2.setToggleGroup(this.toggleGroup);
        radioButtonPregunta3.setToggleGroup(this.toggleGroup);
        radioButtonPregunta4.setToggleGroup(this.toggleGroup);

        // Agregamos los radioButtons a una lista
        // para saber la posicion del radioButton seleccionado
        this.radioButtons.add(radioButtonPregunta1);
        this.radioButtons.add(radioButtonPregunta2);
        this.radioButtons.add(radioButtonPregunta3);
        this.radioButtons.add(radioButtonPregunta4);
    }


    @FXML
    private void clck(ActionEvent event) {
        if (pantallaInicio) {
            this.mostrarPregunta();
            pantallaInicio = false;
            this.mostrarSiguientePregunta();
        } else if (!this.juego_terminado) {
            RadioButton radioButtonSeleccionado = (RadioButton) this.toggleGroup.getSelectedToggle();
            if (radioButtonSeleccionado != null) {
                int posicion_seleccionado = radioButtons.indexOf(radioButtonSeleccionado);
                boolean respuesta_correcta = posicion_seleccionado == this.numero_rapuesta_correcta;

                if (respuesta_correcta) {
                    if (this.gano) {
                        this.reiniciarJuego();
                    } else {
                        this.mostrarSiguientePregunta();
                    }
                } else {
                    this.finDelJuego();
                }
            } else {
                System.out.println("Ningún RadioButton seleccionado.");
            }
        } else {
            this.reiniciarJuego();
        }
    }


    @FXML
    private void hola(ActionEvent event) {
        // asdf
    }
    
    @FXML
    private void pantallaInicio() {
        idLabelPregunta.setVisible(false);
        radioButtonPregunta1.setVisible(false);
        radioButtonPregunta2.setVisible(false);
        radioButtonPregunta3.setVisible(false);
        radioButtonPregunta4.setVisible(false);
        
         labelInicioArriba.setVisible(true);
        labelInicioCentro.setVisible(true);
        labelInicioAbajo.setVisible(true);
    }
    
    @FXML
    private void mostrarPregunta() {
        idLabelPregunta.setVisible(true);
        radioButtonPregunta1.setVisible(true);
        radioButtonPregunta2.setVisible(true);
        radioButtonPregunta3.setVisible(true);
        radioButtonPregunta4.setVisible(true);

        labelInicioArriba.setVisible(false);
        labelInicioCentro.setVisible(false);
        labelInicioAbajo.setVisible(false);
    }

    @FXML
    private void mostrarSiguientePregunta() {
        this.numero_pregunta++;
        if (this.numero_pregunta < preguntas.length) {
            String pregunta_actual[] = preguntas[this.numero_pregunta];

            idLabelPregunta.setText(pregunta_actual[0]);       // Pregunta
            radioButtonPregunta1.setText(pregunta_actual[1]);  // Respuesta 1
            radioButtonPregunta2.setText(pregunta_actual[2]);  // Respuesta 2
            radioButtonPregunta3.setText(pregunta_actual[3]);  // Respuesta 3
            radioButtonPregunta4.setText(pregunta_actual[4]);  // Respuesta 4
            numero_rapuesta_correcta = Integer.parseInt(pregunta_actual[5]); // Respuesta 5
        } else {
            this.pantallaInicio();
            labelInicioCentro.setText("¡¡¡ Felicidades, ganaste el juego, muchas gracias por jugar !!!");
            this.gano = true;
        }

  
    }

    @FXML
    private void finDelJuego() {
        this.juego_terminado = true;

        idLabelPregunta.setText("Respuesta incorrecta, fin del juego");
        radioButtonPregunta1.setVisible(false);
        radioButtonPregunta2.setVisible(false);
        radioButtonPregunta3.setVisible(false);
        radioButtonPregunta4.setVisible(false);

        btnMeLaJuego.setText("Volver a jugar");
    }

    @FXML
    private void reiniciarJuego() {
        this.numero_pregunta = -1;
        this.juego_terminado = false;
        this.gano = false;

        radioButtonPregunta1.setVisible(true);
        radioButtonPregunta2.setVisible(true);
        radioButtonPregunta3.setVisible(true);
        radioButtonPregunta4.setVisible(true);
        
        radioButtonPregunta4.setVisible(true);
        radioButtonPregunta4.setVisible(true);
        radioButtonPregunta4.setVisible(true);
        radioButtonPregunta4.setVisible(true);
        
        labelInicioArriba.setVisible(false);
        labelInicioCentro.setVisible(false);
        labelInicioAbajo.setVisible(false);
        idLabelPregunta.setVisible(true);

        btnMeLaJuego.setText("Jugar");
        this.mostrarSiguientePregunta();
    }

}
