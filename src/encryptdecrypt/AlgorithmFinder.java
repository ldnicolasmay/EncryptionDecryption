package encryptdecrypt;

/**
 * Strategy pattern context class
 */
class AlgorithmFinder {

    private final Algorithm algorithm;

    /**
     * Constructor for context object; Sets algorithm for the context
     *
     * @param algorithm Concrete strategy class that implements `Algorithm` interface
     */
    public AlgorithmFinder(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Encrypts or decrypts a message
     *
     * @param message `Message` to be encrypted or decrypted
     * @return Encrypted or decrypted `String`
     */
    public String crypt(Message message) {
        return algorithm.getResult(message);
    }
}

