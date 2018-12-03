// Importo le libreerie java
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe File
 * Classe per aprire e leggere il contenuto di un file,
 * ritornando le righe presenti nel file come lista di stringhe
 */

public class File {

    // Dichiarazioni
    private String filePath;
    private List<String> fileContents = new ArrayList<String>();

    // Getter & Setter
    public List<String> getFileContents() {
        return fileContents;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    // Creo il metodo per l'apertura e lettura del file
    public void open() {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            while ((line = reader.readLine()) != null) {
                this.fileContents.add(line);
            }
            reader.close();
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", this.filePath);
            e.printStackTrace();
        }
    }

}