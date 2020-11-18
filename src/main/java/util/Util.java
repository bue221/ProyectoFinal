/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public Object[][] setJTable(ArrayList<Object> lista) {
        Object[][] objetos1 = new Object [lista.size()]   [1];
        for (int i = 0; i < lista.size(); i++) {
            objetos1[i][0] = lista.get(i);
        }
        return objetos1;
    }

    public void serializar(String nombreArchivo, Object objeto) {
        ObjectOutputStream escribiendoFichero = null;
        try {
            escribiendoFichero = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            escribiendoFichero.writeObject(objeto);
            System.out.println("Serializar " + 1);
            escribiendoFichero.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.INFO, null, ex);
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {
            try {
                escribiendoFichero.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Object desSerializar(String nombreArchivo) {
        Object obj;
        ObjectInputStream leyendoFichero = null;
        try {
            leyendoFichero = new ObjectInputStream(new FileInputStream(nombreArchivo));
            obj = leyendoFichero.readObject();
            leyendoFichero.close();
            return obj;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (leyendoFichero != null) {
                    leyendoFichero.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
