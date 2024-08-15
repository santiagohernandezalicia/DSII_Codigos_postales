import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Proporciona al menos un código postal como argumento desde la Terminal");
            return;
        }

        Set<String> codigosPostales = new HashSet<>();
        for (String arg : args) {
            codigosPostales.add(arg.trim());
        }

        try {
            FileReader archivoFisico = new FileReader("codigos_postales.csv");
            BufferedReader archivoLogico = new BufferedReader(archivoFisico);

            String registro;
            String[] campos;

            while ((registro = archivoLogico.readLine()) != null) {
                campos = registro.split(",");
                String codigoPostal = campos[0].trim();

                if (codigosPostales.contains(codigoPostal)) {
                    String asentamiento = campos[1].trim();
                    String tipo = campos[2].trim();
                    System.out.println("Código Postal: " + codigoPostal + ", Asentamiento: " + asentamiento + ", Tipo: " + tipo);
                }
            }
            archivoLogico.close();
            archivoFisico.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}