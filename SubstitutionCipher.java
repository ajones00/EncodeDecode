//Create a class SubstitutionCipher that extends class Cipher and implements interface
//MessageEncoder and interface MessageDecoder. The class has a private int shift. The
//constructor should have one parameter to initialize shift. Define method cipherType so
//that the method returns the string “SubstitutionCipher”. Define the method encode so that
//each letter is shifted by the value in shift. For example, if shift is 3, a will be replaced by
//d, b will be replaced by e, c will be replaced by f, and so on. Method encode returns
//encoded message. Define the method decode. Method decode returns the decoded
//message.

public class SubstitutionCipher extends Cipher implements MessageEncoder, MessageDecoder {
    private int shift;

    SubstitutionCipher(int shift) {
        this.shift = shift;
    }

    @Override
    String cipherType() {
        return "SubstitutionCipher";
    }

    public String encode(String letter) {
        char[] arr = new char[letter.length()];
        for (int i = 0; i < letter.length(); i++){
            arr[i] = letter.charAt(i);
        }
        String temp = "";
        for (int i = 0; i < arr.length; i++){
            arr[i] += this.shift;
            temp += arr[i];
        }
        return temp;
    }

    public String decode(String letter) {
        char[] arr = letter.toCharArray();
        String temp = "";
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 32){
                arr[i] -= this.shift;
            }
            temp += arr[i];
        }
        return temp;
    }
}
