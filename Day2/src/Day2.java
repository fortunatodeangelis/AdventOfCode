import java.util.*;

public class Day2 {


    public static void main(String[] args) {

        File fileInput = new File();
        fileInput.setFilePath("Day2/input.txt");
        fileInput.open();

        int doubleChars = 0;
        int tripleChars = 0;

        // Part 1
        for(String item : fileInput.getFileContents()) {

            Map<Character,Integer> mapLine = new HashMap<>();
            // Single Char of Line
            for(char c : item.toCharArray()) {
                // Insert in Map line the character, and increment it every occurence
                mapLine.put(c, mapLine.getOrDefault(c, 0) + 1);
            }

            // Search Occurence 2
            if(Collections.frequency(mapLine.values(),2) > 0){
                doubleChars++;
            }
            // Search Occurence 3
            if(Collections.frequency(mapLine.values(),3) > 0){
                tripleChars++;
            }
        }
        System.out.println("Checksum: " + (doubleChars * tripleChars));


        // Part 2

        List<String> listString = fileInput.getFileContents();
        boolean founded = false;

        StringBuilder similarString = new StringBuilder();

        for(int i = 0; i < listString.size(); i++) {

            String processString = fileInput.getFileContents().get(i);

            for(int j = 0; j < listString.size(); j++) {
                String stringCompare = listString.get(j);

                similarString.setLength(0);
                for(int x = 0; x < processString.length(); x++) {
                    if(processString.charAt(x) == stringCompare.charAt(x)) {
                        similarString.append(processString.charAt(x));
                    }
                }
                if (similarString.length() == processString.length() -1) {
                    founded = true;
                    break;
                }
            }
            if(founded){
                break;
            }
        }
        System.out.println("Result of Part 2: " + similarString.toString());
    }

}
