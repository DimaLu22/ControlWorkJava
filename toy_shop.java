import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class toy_shop {

    private List<Toy> toys;

    public toy_shop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy){
        toys.add(toy);
    }

    public void setToyFrequency(int id, double frequency){
        for (Toy toy : toys){
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }
    
    public void getPrizeToy(){

        double totalFrequency = 0;
        double currFrequency = 0;

        Toy markToy = null;

        Random random = new Random();

        if(toys.isEmpty()){
            System.out.println("Shop is empty");
            return;
        }

        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }

        double randomNum = random.nextDouble() * totalFrequency;

        for (Toy toy : toys) {
            currFrequency += toy.getFrequency();
            if (randomNum <= currFrequency){
                markToy = toy;
                break;
            }
        }

        if(markToy != null){
            System.out.println("Congratulations! You won a toy:" + markToy.getName());
            if(markToy.getQuantity() > 0){
                markToy.setQuantity(markToy.getQuantity()-1);
            } else {
                System.out.println("The toy is over");
            }
        }else{
            System.out.println("Nothing:-)");
        }
    }
    public void saveToFile(String filename) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(toys);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println(filename + "Done");
        }catch (IOException e){
            System.out.println(filename + "File writing error");
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename){
        try{
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            toys = (List<Toy>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(filename + "Done");
        }catch (IOException | ClassNotFoundException e){
            System.out.println(filename + "File load error");
            e.printStackTrace();
        }
    }
}