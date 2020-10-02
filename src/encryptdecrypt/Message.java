package encryptdecrypt;

/**
 * Class to package all data needed for a message
 */
class Message {

    private final String textIn;
    private final CryptMode mode;
    private final int key;

    /**
     * Constructor
     *
     * @param textIn `String` to be encrypted or decrypted
     * @param mode   Encrypt or decrypted
     * @param key    `int` key to encrypted or decrypt `String` with
     */
    public Message(String textIn, CryptMode mode, int key) {

        this.textIn = textIn;
        this.mode = mode;
        this.key = key;
    }

    /**
     * Gets `textIn`
     *
     * @return `textIn`
     */
    public String getTextIn() {
        return textIn;
    }

    /**
     * Gets `mode`
     *
     * @return `mode`
     */
    public CryptMode getMode() {
        return mode;
    }

    /**
     * Gets `key`
     *
     * @return `key`
     */
    public int getKey() {
        return key;
    }
}
