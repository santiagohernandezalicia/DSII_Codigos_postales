import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) {
        try {
            FileReader archivoFisico = new FileReader("codigos_postales.csv");
            BufferedReader archivoLogico = new BufferedReader(archivoFisico);

            String registro;
            String campos[];

            Map<String, Integer> conteoUrbanos = new TreeMap<>();
            Map<String, Integer> conteoRurales = new TreeMap<>();

            while ((registro = archivoLogico.readLine()) != null) {
                campos = registro.split(",");
                if (campos.length > 2) {
                    String codigoPostal = campos[0];
                    String tipoAsentamiento = campos[2];

                    if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                        conteoUrbanos.put(codigoPostal, conteoUrbanos.getOrDefault(codigoPostal, 0) + 1);
                    } else if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                        conteoRurales.put(codigoPostal, conteoRurales.getOrDefault(codigoPostal, 0) + 1);
                    }
                }
            }

            System.out.println("Código Postal | Asentamientos Urbanos | Asentamientos Rurales");
            for (String codigoPostal : conteoUrbanos.keySet()) {
                int urbanos = conteoUrbanos.getOrDefault(codigoPostal, 0);
                int rurales = conteoRurales.getOrDefault(codigoPostal, 0);
                System.out.println(" " + codigoPostal + "             " + urbanos + "                  " + rurales);
            }

            archivoLogico.close();
            archivoFisico.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
