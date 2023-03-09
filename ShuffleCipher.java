//Create a class ShuffleCipher that extends class Cipher and implements interface
//MessageEncoder and interface MessageDecoder. . The class has a private int NoShuffle.
//The constructor should have one parameter to initialize NoShuffle. Define method
//cipherType so that the method returns the string “ShuffleCipher”. Define the method
//encode so that the message is shuffled NoShufle times. To perform one shuffle, split the
//message in half and then take characters from each half alternately. For example, if the
//message is “abcdefghi”, the halves are “abcde” and “fghi”. The shuffled message is
//“afbgchdie”. Method encode returns encoded message. Define the method decode.
//Method decode returns the decoded message.
public class ShuffleCipher extends Cipher implements MessageEncoder, MessageDecoder{
    private int NoShuffle;

    ShuffleCipher(int x){
        this.NoShuffle = x;
    }

    @Override
    String cipherType(){
        return "ShuffleCipher";
    }

    @Override
    public String encode(String plainText) {
        if (plainText.length() == 1){
            return plainText;
        } else {
            String temp = "";
            String fHalf = plainText.substring(0, (plainText.length() / 2 ) + 1);
            String lHalf = plainText.substring(plainText.length() / 2);
            for (int i = 0; i < NoShuffle; i++){
                if (i != 0){
                    fHalf = temp.substring(0, (temp.length() / 2 ) + 1);
                    lHalf = temp.substring(temp.length() / 2);
                    temp = "";
                }
                for (int j = 0; j < plainText.length()/2; j++) {
                    if (j == plainText.length() - 1){
                        if (plainText.length() % 2 != 0){
                            temp = temp + fHalf.charAt(j);
                        } else {
                            temp = temp + fHalf.charAt(j) + lHalf.charAt(j);
                        }
                    } else {
                        temp = temp + fHalf.charAt(j) + lHalf.charAt(j);
                    }
                }
            }
            return temp;
        }
    }

    @Override
    public String decode(String cipherText) {
        if (cipherText.length() == 1 || this.NoShuffle == 0){
            return cipherText;
        } else {
            char[] holder = cipherText.toCharArray();
            String temp = "";
            String fHalf = "";
            String lHalf = "";

            for (int i = 0; i < holder.length; i+=2){
                fHalf += holder[i];
            }
            for (int i = 1; i < holder.length; i+=2){
                lHalf += holder[i];
            }

            temp = fHalf;
            temp += lHalf;

            if (this.NoShuffle > 1){
                int count = 1;

                while (count != this.NoShuffle){
                    fHalf = "";
                    lHalf = "";
                    holder = temp.toCharArray();
                    temp = "";
                    for (int i = 0; i < holder.length; i+=2){
                        fHalf += holder[i];
                    }
                    for (int i = 1; i < holder.length; i+=2){
                        lHalf += holder[i];
                    }

                    temp = fHalf;
                    temp += lHalf;
                    count++;
                }
            }
            return temp;
        }
    }
}
