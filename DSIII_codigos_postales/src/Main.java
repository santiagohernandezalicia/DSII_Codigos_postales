import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader archivoFisico = new FileReader("codigos_postales.csv");
            BufferedReader archivoLogico = new BufferedReader(archivoFisico);

            String registro;
            int cntUrbano = 0;
            int cntRural = 0;
            archivoLogico.readLine();
            String[] campos;

            while ((registro = archivoLogico.readLine()) != null) {
                campos = registro.split(",");

                String tipo = campos[2].trim();

                if (tipo.equalsIgnoreCase("Urbano")) {
                    cntUrbano++;
                } else if (tipo.equalsIgnoreCase("Rural")) {
                    cntRural++;
                }
            }
            System.out.println("Total de asentamientos urbanos: " + cntUrbano);
            System.out.println("Total de asentamientos rurales: " + cntRural);
            archivoLogico.close();
            archivoFisico.close();

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
