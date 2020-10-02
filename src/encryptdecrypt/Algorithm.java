package encryptdecrypt;

/**
 * Strategy pattern interface to represent abstract algorithm
 */
interface Algorithm {

    /**
     * Retrieves encrypted or decrypted message
     *
     * @param message `Message` to be encrypted or decrypted
     * @return Encrypted or decrypted `String`
     */
    default String getResult(Message message) {

        String textIn = message.getTextIn();
        CryptMode mode = message.getMode();
        int key = message.getKey();

        char[] textInCharArray = new char[textIn.length()];

        for (int i = 0; i < textIn.length(); i++) {
            if (mode == CryptMode.ENCRYPT) {
                textInCharArray[i] = encryptChar(textIn.charAt(i), key);
            } else if (mode == CryptMode.DECRYPT) {
                textInCharArray[i] = decryptChar(textIn.charAt(i), key);
            }
        }

        return new String(textInCharArray);
    }

    /**
     * Encrypts a character; abstract
     *
     * @param ch  `char` to be encrypted
     * @param key `int` key to encrypted `ch` with
     * @return Encrypted `char`
     */
    char encryptChar(char ch, int key);

    /**
     * Decrypts a character; abstract
     *
     * @param ch  `char` to be decrypted
     * @param key `int` key to decrypted `ch` with
     * @return Decrypted `char`
     */
    char decryptChar(char ch, int key);
}

