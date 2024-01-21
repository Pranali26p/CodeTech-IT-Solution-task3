import java.io.*;

public class Encoder {

    public static void main(String[] args) {
        String fileName = "sample.txt"; // You can change this to your file name
        int key = 3; // Change this to your desired key

        encryptFile(fileName, key);
        decryptFile(fileName, key);
    }

    private static void encryptFile(String fileName, int key) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String encryptedText = "";
            int currentChar;

            while ((currentChar = bufferedReader.read()) != -1) {
                if (Character.isLetter(currentChar)) {
                    char encryptedChar = (char) (currentChar + key);
                    encryptedText += encryptedChar;
                } else {
                    encryptedText += (char) currentChar;
                }
            }

            bufferedReader.close();

            FileWriter fileWriter = new FileWriter("encrypted_" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(encryptedText);

            bufferedWriter.close();

            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decryptFile(String fileName, int key) {
        try {
            FileReader fileReader = new FileReader("encrypted_" + fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String decryptedText = "";
            int currentChar;

            while ((currentChar = bufferedReader.read()) != -1) {
                if (Character.isLetter(currentChar)) {
                    char decryptedChar = (char) (currentChar - key);
                    decryptedText += decryptedChar;
                } else {
                    decryptedText += (char) currentChar;
                }
            }

            bufferedReader.close();

            FileWriter fileWriter = new FileWriter("decrypted_" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(decryptedText);

            bufferedWriter.close();

            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
