package challenge;

public class CriptografiaCesariana implements Criptografia {

    private static final int LAST_LETTER = 122;
    private static final int FIRST_LETTER = 97;

    @Override
    public String criptografar(String texto) {
        textValidation(texto);
        char[]  encryptedResult = new char[texto.length()];
        char[] originalChars = texto.toLowerCase().toCharArray();
        for (int i = 0; i < originalChars.length; i++) {
            if(Character.isLetter(originalChars[i])) {
                int newValue = (originalChars[i])+3;
                if(newValue > LAST_LETTER){
                   newValue = FIRST_LETTER +(newValue - LAST_LETTER -1);
                }
                encryptedResult[i] = (char) newValue;
            } else {
                encryptedResult[i] = originalChars[i];
            }
        }
        return new String(encryptedResult);
    }

    private void textValidation(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException("O texto não pode ser vazio");
        }
    }

    @Override
    public String descriptografar(String texto) {
        textValidation(texto);
        char[] decryptedResult = new char[texto.length()];
        char[] originalChars = texto.toLowerCase().toCharArray();
        for(int i = 0; i < originalChars.length; i++){
            if(Character.isLetter(originalChars[i])){
                int newValue = (originalChars[i]) - 3;
                    if(newValue < FIRST_LETTER){
                        newValue = LAST_LETTER -(newValue - FIRST_LETTER +1);
                    }
                    decryptedResult[i] = (char) newValue;
            } else {
                decryptedResult[i] = originalChars[i];
            }
        }
        return new String(decryptedResult);
    }

    public static void main(String[] args) {
        Criptografia cripto = new CriptografiaCesariana();
        System.out.println(cripto.criptografar("A Zebra Feliz\n"));
        System.out.println(cripto.descriptografar("d cheud iholc"));

    }
}


