package encryptdecrypt;

/**
 * Concrete class in strategy pattern
 */
class UnicodeAlgorithm implements Algorithm {

    /**
     * Encrypts a character
     *
     * @param ch  `char` to be encrypted
     * @param key `int` key to encrypted `ch` with
     * @return Encrypted `char`
     */
    @Override
    public char encryptChar(char ch, int key) {
        return (char) (ch + key);
    }

    /**
     * Decrypts a character; abstract
     *
     * @param ch  `char` to be decrypted
     * @param key `int` key to decrypted `ch` with
     * @return Decrypted `char`
     */
    @Override
    public char decryptChar(char ch, int key) {
        return (char) (ch - key);
    }
}
