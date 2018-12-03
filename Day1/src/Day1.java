import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {

        int frequency = 0;
        List<Integer> inputList = new ArrayList<Integer>();

        File fileInput = new File();
        fileInput.setFilePath("input.txt");
        fileInput.open();

        // Parte 1
        for (String line : fileInput.getFileContents()) {
            frequency += Integer.parseInt(line);
            inputList.add(Integer.parseInt(line));
        }
        System.out.println("Frequency: " + frequency);

        // Parte 2
        Set<Integer> frequencies = new HashSet<>();
        frequency = 0;
        int i = 0;
        while (!frequencies.contains(frequency)) {
            frequencies.add(frequency);
            frequency += inputList.get(i++ % inputList.size());
        }
        System.out.println("The first frequency reached twice: " + frequency);
    }
}
