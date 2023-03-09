import java.io.File;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class CodeProgram {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            System.out.println("Welcome to the Cipher program\n" +
                    "Type 1 for Substitution Cipher.\n" +
                    "Type 2 for Shuffle Cipher.");
            int num = userInput.nextInt();
            while (num != 1 && num != 2) {
                System.out.println("Type 1 for Substitution Cipher.\n" +
                        "Type 2 for Shuffle Cipher.");
                num = userInput.nextInt();
            }

            if (num == 1) {
                System.out.println("What is the key (shift amount) for your code?");
                num = userInput.nextInt();
                userInput.nextLine();
                SubstitutionCipher a = new SubstitutionCipher(num);
                System.out.println(a.cipherType() + "-shift amount = " + num);
                System.out.println("Enter input file name");
                String inputFileName = userInput.nextLine();
                System.out.println("Enter output file name");
                String outputFileName = userInput.nextLine();
                System.out.println("Encode (E) or Decode (D)");
                String encType = userInput.nextLine();
                while((encType.compareTo("E") != 0) && (encType.compareTo("D") != 0)){
                    System.out.println("Encode (E) or Decode (D)");
                    encType = userInput.nextLine();
                }
                try {
                    Scanner inFile = new Scanner(new File(inputFileName));
                    PrintWriter output = new PrintWriter(outputFileName);
                    String content = "";
                    while (inFile.hasNextLine()) {
                        if (encType.compareTo("E") == 0) {
                            content = content.concat(a.encode(inFile.nextLine()) + "\n");
                        } else {
                            content = content.concat(a.decode(inFile.nextLine()) + "\n");
                        }
                    }
                    content = content.substring(0, content.length()-1);
                    output.write(content);
                    if (encType.compareTo("E") == 0) {
                        System.out.println("Encoded text is saved in " + outputFileName);
                    } else {
                        System.out.println("Decoded text is saved in " + outputFileName);
                    }
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("What is the key (shuffle amount) for your code?");
                num = userInput.nextInt();
                userInput.nextLine();
                ShuffleCipher a = new ShuffleCipher(num);
                System.out.println(a.cipherType() + "-shuffle amount = " + num);
                System.out.println("Enter input file name");
                String inputFileName = userInput.nextLine();
                System.out.println("Enter output file name");
                String outputFileName = userInput.nextLine();
                System.out.println("Encode (E) or Decode (D)");
                String encType = userInput.nextLine();
                while((encType.compareTo("E") != 0) && (encType.compareTo("D") != 0)){
                    System.out.println("Encode (E) or Decode (D)");
                    encType = userInput.nextLine();
                }
                try {
                    Scanner inFile = new Scanner(new File(inputFileName));
                    PrintWriter output = new PrintWriter(outputFileName);
                    String content = "";
                    while (inFile.hasNextLine()) {
                        if (encType.compareTo("E") == 0) {
                            content = content.concat(a.encode(inFile.nextLine()) + "\n");
                        } else {
                            content = content.concat(a.decode(inFile.nextLine()) + "\n");
                        }
                    }
                    //remove last newline char
                    content = content.substring(0, content.length()-1);
                    output.write(content);
                    if (encType.compareTo("E") == 0) {
                        System.out.println("Encoded text is saved in " + outputFileName);
                    } else {
                        System.out.println("Decoded text is saved in " + outputFileName);
                    }
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Do you want to do another message (Y)");
            String response = userInput.nextLine();
            while ((response.compareToIgnoreCase("Y") != 0) && (response.compareToIgnoreCase("N") != 0)){
                System.out.println("Do you want to do another message (Y)");
                response = userInput.nextLine();
            }
            if (response.compareToIgnoreCase("N") == 0){
                flag = true;
            }
        }
    }
}
