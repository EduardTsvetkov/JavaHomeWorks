
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;



public class FileRW {
    private String fileName;

    public FileRW(String fileName) {
        this.fileName = fileName;
    }
    
    public List<Toy> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        Scanner scan = null;
        int index = 0;
        List<Toy> toyList = new ArrayList<>();
        Toy toy;
        String [] data = new String[4];

        while ((line = reader.readLine()) != null) {
            scan = new Scanner(line);
            scan.useDelimiter(";");
            while (scan.hasNext()) {
                String dat = scan.next();
                data[index] = dat;
                index++;
            }
            index = 0;
            toy = new Toy(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
            toyList.add(toy);
        }
        reader.close();
        return toyList;
    }    


    public void writeResult(Toy toy, boolean sign){
        File file = new File(fileName);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(toy.getId() + ";");
            sb.append(toy.getName() + ";");
            sb.append(toy.getQuantity() + ";");
            sb.append(toy.getFreaquecy() + ";");
            FileWriter fr = new FileWriter(file, sign);
            fr.write(sb.toString() + "\n");
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }    

}
