package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Clase de utilidades
 * @author Juan Díez-Yanguas Barber
 */
public class Tools {

    private static String transformaAHexadecimal(byte buf[]) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    public static void anadirMensaje(HttpServletRequest request, String msg) {
        if (request.getAttribute("listaResultados") == null) {
            ArrayList<String> lista = new ArrayList<String>();
            lista.add(msg);
            request.setAttribute("listaResultados", lista);
        } else {
            ArrayList<String> lista = (ArrayList<String>) request.getAttribute("listaResultados");
            lista.add(msg);
            request.setAttribute("listaResultados", lista);
        }
    }

    public static String getcontentPartText(Part input) {
        Scanner sc = null;
        String content = null;
        try {
            sc = new Scanner(input.getInputStream(), "UTF-8");
            if (sc.hasNext()) {
                content = sc.nextLine();
            } else {
                content = "";
            }
            sc.close();
            return content;
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, ex.getMessage());
        }finally{
            sc.close();
        }
        return content;
    }

    //Este se usa
    public static boolean guardarImagenDeProdructoEnElSistemaDeFicheros(InputStream input, String fileName)
            throws ServletException {
        FileOutputStream output = null;
        boolean ok = false;
        try {
            output = new FileOutputStream(fileName);
            int leido = 0;
            leido = input.read();
            while (leido != -1) {
                output.write(leido);
                leido = input.read();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, ex.getMessage());
        } finally {
            try {
                output.flush();
                output.close();
                input.close();
                ok = true;
            } catch (IOException ex) {
                Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, "Error cerrando flujo de salida", ex);
            }
        }
        return ok;
    }

    public static boolean borrarImagenDeProdructoDelSistemaDeFicheros(String ruta) {
        File imagen = new File(ruta);
        return imagen.delete();
    }

    public static boolean existeElFichero(String ruta) {
        File imagen = new File(ruta);
        return imagen.exists();
    }

    public static String leerArchivoClassPath(String ruta) {
        StringBuilder texto = new StringBuilder();
        Scanner sc = new Scanner(Tools.class.getResourceAsStream(ruta), "UTF-8");

        while (sc.hasNext()) {
            texto.append(sc.nextLine());
            texto.append("\n");
        }

        sc.close();
        return texto.toString();
    }

    public static Locale getLocale() {
        return new Locale("es", "ES");
    }
    
    public static boolean recuperarYGuardarImagenFormulario (HttpServletRequest request, HttpServletResponse response, String codigo) throws IOException, ServletException{
        if (request.getPart("foto").getContentType().contains("image") == false || request.getPart("foto").getSize() > 8388608) {
            request.setAttribute("resultados", "Archivo no válido");
            Tools.anadirMensaje(request, "Solo se admiten archivos de tipo imagen");
            Tools.anadirMensaje(request, "El tamaño máximo de archivo son 8 Mb");
            request.getRequestDispatcher("/admin/administration/products_administration.jsp").forward(request, response);
            return false;
        } else {
            String fileName = request.getServletContext().getRealPath("/images/products/" + codigo);
            boolean ok = Tools.guardarImagenDeProdructoEnElSistemaDeFicheros(request.getPart("foto").getInputStream(), fileName);
            if (ok == false) {
                request.setAttribute("resultados", "Fallo al guardar archivo");
                Tools.anadirMensaje(request, "Ocurrio un error guardando la imagen");
                request.getRequestDispatcher("/admin/administration/products_administration.jsp").forward(request, response);
                return false;
            }
        }
        return true;
    }
}
