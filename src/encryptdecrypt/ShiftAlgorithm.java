package encryptdecrypt;

/**
 * Concrete algorithm in strategy pattern
 */
class ShiftAlgorithm implements Algorithm {

    final static char MIN_CHAR_UP = 'A'; // 65 (dec)
    final static char MAX_CHAR_UP = 'Z'; // 90
    final static char MIN_CHAR_LO = 'a'; // 97
    final static char MAX_CHAR_LO = 'z'; // 122

    /**
     * Encrypts a character
     *
     * @param ch  `char` to be encrypted
     * @param key `int` key to encrypted `ch` with
     * @return Encrypted `char`
     */
    @Override
    public char encryptChar(char ch, int key) {

        if (MIN_CHAR_UP <= ch && ch <= MAX_CHAR_UP) { // upper case chars 'A'-'Z'
            return (char) (MIN_CHAR_UP + (ch - MIN_CHAR_UP + key) % (MAX_CHAR_UP - MIN_CHAR_UP + 1));
        } else if (MIN_CHAR_LO <= ch && ch <= MAX_CHAR_LO) { // lower case chars 'a'-'z'
            return (char) (MIN_CHAR_LO + (ch - MIN_CHAR_LO + key) % (MAX_CHAR_LO - MIN_CHAR_LO + 1));
        } else {
            return ch;
        }
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

        if (MIN_CHAR_UP <= ch && ch <= MAX_CHAR_UP) {
            return (char) (MAX_CHAR_UP - (MAX_CHAR_UP - ch + key) % (MAX_CHAR_UP - MIN_CHAR_UP + 1));
        } else if (MIN_CHAR_LO <= ch && ch <= MAX_CHAR_LO) {
            return (char) (MAX_CHAR_LO - (MAX_CHAR_LO - ch + key) % (MAX_CHAR_LO - MIN_CHAR_LO + 1));
        } else {
            return ch;
        }
    }
}
