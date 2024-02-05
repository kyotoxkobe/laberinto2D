/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juego2laberinto;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Lienzo extends Canvas implements MouseListener, KeyListener {

    // linea ganar
    int[] ganar = { 695, 144, 695, 44 };
    // lineas que dibujan el laberinto
    int[] linea = { 0, 629, 270, 629 };
    int[] linea2 = { 270, 629, 270, 438 };
    int[] linea3 = { 270, 438, 145, 310 };
    int[] linea4 = { 145, 310, 145, 45 };
    int[] linea5 = { 145, 45, 700, 45 };
    // lineas parte derecha
    int[] lineaIzq1 = { 700, 629, 410, 629 };
    int[] lineaIzq2 = { 410, 629, 410, 426 };
    int[] lineaIzq3 = { 410, 426, 282, 293 };
    int[] lineaIzq4 = { 282, 293, 282, 145 };
    int[] lineaIzq5 = { 282, 145, 700, 145 };
    int[] colisionInicial = { 2, 700, 2, 626 };
    // personaje
    int[] puntosCuboX = { 36, 36, 70, 70, 36 };
    int[] puntosCuboY = { 640, 676, 676, 640, 640 };
    // escaladores de personaje
    int[] escalador = { 410, 629, 345, 629 };
    int []obstaculo={272,438,320,438};
    // array Para guardar puntos
    ArrayList<int[]> arrayLineas;
    // arrayColisiones
    ArrayList<Line2D> arrayLine2D;
    // x & y para el moviento del jugador
    int x = 0;
    int y = 0;
    // double rotacion
    double rotar = Math.random() * 270;
    // ------------------
    int avanzoEnx = 0;
    int avanzoEny = 0;
    // vidas jugador
    int vidas = 4;
    int puntos = 100;

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.PINK);
        g2d.drawLine(linea[0], linea[1], linea[2], linea[3]);
        g2d.drawLine(linea2[0], linea2[1], linea2[2], linea2[3]);
        g2d.drawLine(linea3[0], linea3[1], linea3[2], linea3[3]);
        g2d.drawLine(linea4[0], linea4[1], linea4[2], linea4[3]);
        g2d.drawLine(linea5[0], linea5[1], linea5[2], linea5[3]);
        g2d.drawLine(colisionInicial[0], colisionInicial[1], colisionInicial[2], colisionInicial[3]);
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.PINK);
        g2d.drawLine(lineaIzq1[0], lineaIzq1[1], lineaIzq1[2], lineaIzq1[3]);
        g2d.drawLine(lineaIzq2[0], lineaIzq2[1], lineaIzq2[2], lineaIzq2[3]);
        g2d.drawLine(lineaIzq3[0], lineaIzq3[1], lineaIzq3[2], lineaIzq3[3]);
        g2d.drawLine(lineaIzq4[0], lineaIzq4[1], lineaIzq4[2], lineaIzq4[3]);
        g2d.drawLine(lineaIzq5[0], lineaIzq5[1], lineaIzq5[2], lineaIzq5[3]);
        // escaladores de personaje
        g2d.setColor(Color.BLUE);
        g2d.drawLine(escalador[0], escalador[1], escalador[2], escalador[3]);
        //obstaculo 1
        g2d.setColor(Color.CYAN);
        g2d.drawLine(obstaculo[0], obstaculo[1], obstaculo[2], obstaculo[3]);
        //------------------------
        g2d.setColor(Color.YELLOW);
        g2d.drawLine(ganar[0], ganar[1], ganar[2], ganar[3]);
        // arrayList de lineas
        arrayLineas = new ArrayList<>();
        arrayLineas.add(linea);
        arrayLineas.add(linea2);
        arrayLineas.add(linea3);
        arrayLineas.add(linea4);
        arrayLineas.add(linea5);
        arrayLineas.add(colisionInicial);
        arrayLineas.add(lineaIzq1);
        arrayLineas.add(lineaIzq2);
        arrayLineas.add(lineaIzq3);
        arrayLineas.add(lineaIzq4);
        arrayLineas.add(lineaIzq5);
        arrayLineas.add(obstaculo);
        // ----------------------------------
        // objetos Line2d Para la colision con lineas
        Line2D lineaC1 = new Line2D.Float(linea[0], linea[1], linea[2], linea[3]);
        Line2D lineaC2 = new Line2D.Float(linea2[0], linea2[1], linea2[2], linea2[3]);
        Line2D lineaC3 = new Line2D.Float(linea3[0], linea3[1], linea3[2], linea3[3]);
        Line2D lineaC4 = new Line2D.Float(linea4[0], linea4[1], linea4[2], linea4[3]);
        Line2D lineaC5 = new Line2D.Float(linea5[0], linea5[1], linea5[2], linea5[3]);
        Line2D lineaColisionInicial = new Line2D.Float(colisionInicial[0], colisionInicial[1], colisionInicial[2],
                colisionInicial[3]);
        // lineas izquierda
        Line2D lineaIzqC1 = new Line2D.Float(lineaIzq1[0], lineaIzq1[1], lineaIzq1[2], lineaIzq1[3]);
        Line2D lineaIzqC2 = new Line2D.Float(lineaIzq2[0], lineaIzq2[1], lineaIzq2[2], lineaIzq2[3]);
        Line2D lineaIzqC3 = new Line2D.Float(lineaIzq3[0], lineaIzq3[1], lineaIzq3[2], lineaIzq3[3]);
        Line2D lineaIzqC4 = new Line2D.Float(lineaIzq4[0], lineaIzq4[1], lineaIzq4[2], lineaIzq4[3]);
        Line2D lineaIzqC5 = new Line2D.Float(lineaIzq5[0], lineaIzq5[1], lineaIzq5[2], lineaIzq5[3]);
        Line2D lineaJugador = new Line2D.Float(puntosCuboX[0], puntosCuboY[0], puntosCuboX[1], puntosCuboY[1]);
        Line2D lineaJugadorDos = new Line2D.Float(puntosCuboX[2], puntosCuboY[2], puntosCuboX[3], puntosCuboY[3]);
        Line2D lineaJugadorTres = new Line2D.Float(puntosCuboX[3], puntosCuboY[3], puntosCuboX[0], puntosCuboY[0]);
        // linea de ganar colison
        Line2D lineaGanar = new Line2D.Float(ganar[0], ganar[1], ganar[2], ganar[3]);
        // Lineas de escalador
        Line2D lineaEscalador = new Line2D.Float(escalador[0], escalador[1], escalador[2], escalador[3]);
        //obstaculo
        Line2D obstaculoC = new Line2D.Float(obstaculo[0], obstaculo[1], obstaculo[2], obstaculo[3]);
        // --------------------------------
        // array colision
        arrayLine2D = new ArrayList<>();
        arrayLine2D.add(lineaC1);
        arrayLine2D.add(lineaC2);
        arrayLine2D.add(lineaC3);
        arrayLine2D.add(lineaC4);
        arrayLine2D.add(lineaC5);
        arrayLine2D.add(lineaColisionInicial);
        arrayLine2D.add(lineaIzqC1);
        arrayLine2D.add(lineaIzqC2);
        arrayLine2D.add(lineaIzqC3);
        arrayLine2D.add(lineaIzqC4);
        arrayLine2D.add(lineaIzqC5);
        arrayLine2D.add(lineaGanar);
        // escaladores
        arrayLine2D.add(lineaEscalador);
        // --------------------------------
        // int keyCode = KeyEvent.VK_R;
        // System.out.println("Key code for 'R': " + keyCode);
        int[][] jugador = dibujarJugador(g2d);
        avanzoEnx = avanzoEnx + x;
        avanzoEny = avanzoEny + y;
        mover(jugador, x, y);
        System.out.println("Avanzo en X: " + avanzoEnx);
        System.out.println("Avanzo en Y: " + avanzoEny);
        // colision
        if (lineaColisionInicial.intersectsLine(lineaJugador) || lineaColisionInicial.intersectsLine(lineaJugadorDos)
                || lineaColisionInicial.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada!");
            vidas = vidas - 1;
            puntos = puntos - 25;
            escalar(jugador, 0.6, 0.5);
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaC1.intersectsLine(lineaJugador) || lineaC1.intersectsLine(lineaJugadorDos)
                || lineaC1.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada!");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaC2.intersectsLine(lineaJugador) || lineaC2.intersectsLine(lineaJugadorDos)
                || lineaC2.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la linea 2");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaC3.intersectsLine(lineaJugador) || lineaC3.intersectsLine(lineaJugadorDos)
                || lineaC3.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la linea 3");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaC4.intersectsLine(lineaJugador) || lineaC4.intersectsLine(lineaJugadorDos)
                || lineaC4.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la linea 4");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaC5.intersectsLine(lineaJugador) || lineaC5.intersectsLine(lineaJugadorDos)
                || lineaC5.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la linea 5");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaIzqC1.intersectsLine(lineaJugador) || lineaIzqC1.intersectsLine(lineaJugadorDos)
                || lineaIzqC1.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la C1");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaIzqC2.intersectsLine(lineaJugador) || lineaIzqC2.intersectsLine(lineaJugadorDos)
                || lineaIzqC2.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la C2");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaIzqC3.intersectsLine(lineaJugador) || lineaIzqC3.intersectsLine(lineaJugadorDos)
                || lineaIzqC3.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la C3");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaIzqC4.intersectsLine(lineaJugador) || lineaIzqC4.intersectsLine(lineaJugadorDos)
                || lineaIzqC4.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la C4");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaIzqC5.intersectsLine(lineaJugador) || lineaIzqC5.intersectsLine(lineaJugadorDos)
                || lineaIzqC5.intersectsLine(lineaJugadorTres)) {
            System.out.println("¡Colisión detectada en la C5");
            vidas = vidas - 1;
            puntos = puntos - 25;
            rotar(jugador, rotar);
            int[][] jugadorAux = dibujarJugador(g2d);
            jugador = jugadorAux;
            mover(jugadorAux, -avanzoEnx, -avanzoEny);
            avanzoEnx = 0;
            avanzoEny = 0;
        }
        if (lineaGanar.intersectsLine(lineaJugador) || lineaGanar.intersectsLine(lineaJugadorDos)
                || lineaGanar.intersectsLine(lineaJugadorTres)) {
            JOptionPane.showMessageDialog(null, "Has ganado!!..." + "Puntaje: " + puntos);
            System.exit(0);
        }
        if (vidas == 0) {
            JOptionPane.showMessageDialog(null, "Tienes " + vidas + " Vidas, por lo tanto has perdido");
            System.exit(0);
        }
        if (lineaEscalador.intersectsLine(lineaJugador) || lineaEscalador.intersectsLine(lineaJugadorDos)
                || lineaEscalador.intersectsLine(lineaJugadorTres)) {
            escalar(jugador, 1.75, 1.50);
            puntos = 0;
            vidas = 0;
        }if(obstaculoC.intersectsLine(lineaJugador) || obstaculoC.intersectsLine(lineaJugadorDos)
        || obstaculoC.intersectsLine(lineaJugadorTres)){
            vidas = 1;
            puntos = puntos -35;
        }
    }

    public int[][] dibujarJugador(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.magenta);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolyline(puntosCuboX, puntosCuboY, 5);

        int[][] puntosCubo = new int[2][6];
        puntosCubo[0] = puntosCuboX;
        puntosCubo[1] = puntosCuboY;

        return puntosCubo;
    }

    public void reiniciar(int[][] puntos, int x, int y) {
        for (int i = 0; i < puntos[0].length; i++) {
            x = 36;
            y = 640;
            puntos[0][i] = x;
            puntos[1][i] = y;

        }
    }

    public void mover(int[][] puntosCubo, int deltaX, int deltaY) {
        for (int i = 0; i < puntosCubo[0].length; i++) {
            puntosCubo[0][i] += deltaX;
            puntosCubo[1][i] += deltaY;
            // repaint();
        }
    }

    // metodos de prueba
    public void rotar(int[][] puntosCubo, double angulo) {
        double anguloRad = Math.toRadians(angulo);
        int centroX = calcularCentroX(puntosCubo);
        int centroY = calcularCentroY(puntosCubo);

        for (int i = 0; i < puntosCubo[0].length; i++) {
            int x = puntosCubo[0][i];
            int y = puntosCubo[1][i];

            int deltaX = x - centroX;
            int deltaY = y - centroY;

            int nuevoX = (int) (deltaX * Math.cos(anguloRad) - deltaY * Math.sin(anguloRad));
            int nuevoY = (int) (deltaX * Math.sin(anguloRad) + deltaY * Math.cos(anguloRad));

            puntosCubo[0][i] = nuevoX + centroX;
            puntosCubo[1][i] = nuevoY + centroY;
        }
    }

    private int calcularCentroX(int[][] puntosCubo) {
        int sumaX = 0;
        for (int i = 0; i < puntosCubo[0].length; i++) {
            sumaX += puntosCubo[0][i];
        }
        return sumaX / puntosCubo[0].length;
    }

    private int calcularCentroY(int[][] puntosCubo) {
        int sumaY = 0;
        for (int i = 0; i < puntosCubo[1].length; i++) {
            sumaY += puntosCubo[1][i];
        }
        return sumaY / puntosCubo[1].length;
    }

    // escalar
    public void escalar(int[][] puntosCubo, double factorX, double factorY) {
        int centroX = calcularCentroX(puntosCubo);
        int centroY = calcularCentroY(puntosCubo);

        for (int i = 0; i < puntosCubo[0].length; i++) {
            int x = puntosCubo[0][i];
            int y = puntosCubo[1][i];

            int deltaX = x - centroX;
            int deltaY = y - centroY;

            int nuevoX = (int) (deltaX * factorX);
            int nuevoY = (int) (deltaY * factorY);

            puntosCubo[0][i] = nuevoX + centroX;
            puntosCubo[1][i] = nuevoY + centroY;
        }
    }

    // -----------------
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 39) {// Tecla de la derecha
            x = 5;
            y = 0;
            repaint();

        }
        if (e.getKeyCode() == 37) {
            x = -5;
            y = 0;
            repaint();

        }
        if (e.getKeyCode() == 38) {
            x = 0;
            y = -5;
            repaint();
        }
        if (e.getKeyCode() == 40) {
            x = 0;
            y = 5;

            repaint();
            // tecla abajo
        }
        if (e.getKeyCode() == 39) {// Tecla de la derecha

            x = 5;
            y = 0;
            repaint();

            repaint();

        }
        if (e.getKeyCode() == 86) {
            JOptionPane.showMessageDialog(null, "Tienes " + vidas + " Vidas ¡¡¡Sigue Jugando!!!");
        }
        if (e.getKeyCode() == 80) {
            JOptionPane.showMessageDialog(null, "Puntuacion Actual: "+ puntos);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
