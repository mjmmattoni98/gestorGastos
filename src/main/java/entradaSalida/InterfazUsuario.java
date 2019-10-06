package entradaSalida;

import cmamut.BaseDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class InterfazUsuario {
    private Scanner scannerLinea;
    private Scanner scannerPalabra;
    private BaseDatos datos;

    public InterfazUsuario(){
        this.scannerLinea = new Scanner(System.in);
        this.scannerPalabra = new Scanner(System.in);
        this.datos = new BaseDatos();

        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("misDatos.bin");
            ois = new ObjectInputStream(fis);
            datos = (BaseDatos) ois.readObject();
            fis.close();
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("No hay gastos aun.");
            e.printStackTrace();
        }
    }



}
