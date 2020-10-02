package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Driver class
 */
public class Main {

    /**
     * Reads file contents as string
     *
     * @param file file to return contents of
     * @return file contents as string
     */
    private static String readFileAsString(File file) {

        String filePathStr = file.getAbsolutePath();
        String returnStr;

        try {
            returnStr = new String(Files.readAllBytes(Paths.get(filePathStr)));
        } catch (IOException e) {
            System.err.println("Reading file failed: " + filePathStr);
            returnStr = "";
        }

        return returnStr;
    }

    /**
     * Writes string to file
     *
     * @param textOut String to write
     * @param fileOut File to write to
     */
    private static void writeStringToFile(String textOut, File fileOut) {

        String filePathStr = fileOut.getAbsolutePath();

        try (PrintWriter printWriter = new PrintWriter(fileOut)) {
            printWriter.print(textOut);
        } catch (FileNotFoundException e) {
            System.err.println("Writing to file failed: " + filePathStr);
        }
    }

    public static void main(String[] args) {

        String modeStr = null;
        String algStr = null;
        String data = null;
        String keyStr = null;
        String fileInPathStr = null;
        String fileOutPathStr = null;

        CryptMode mode;
        AlgorithmOption alg = null;
        int key;
        File fileIn;
        File fileOut;
        String textIn;
        Message message;
        AlgorithmFinder algorithmFinder;

        // Capture arguments passed to options
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    modeStr = args[i + 1];
                    break;
                case "-alg":
                    algStr = args[i + 1];
                    break;
                case "-key":
                    keyStr = args[i + 1];
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    fileInPathStr = args[i + 1];
                    break;
                case "-out":
                    fileOutPathStr = args[i + 1];
                    break;
            }
        }

        // Logic for handling default option arguments or overlapping arguments (-data, -in)
        mode = modeStr == null || "enc".equals(modeStr) ? CryptMode.ENCRYPT : CryptMode.DECRYPT;
        switch (algStr) {
            case "shift":
                alg = AlgorithmOption.SHIFT;
                break;
            case "unicode":
                alg = AlgorithmOption.UNICODE;
                break;
        }
        keyStr = keyStr == null ? "0" : keyStr;
        key = Integer.parseInt(keyStr);
        fileIn = fileInPathStr == null ? null : new File(fileInPathStr);
        fileOut = fileOutPathStr == null ? null : new File(fileOutPathStr);
        textIn = data != null ? data : readFileAsString(fileIn);

        message = new Message(textIn, mode, key);

        // Use strategy pattern to set algorithm
        if (alg == AlgorithmOption.SHIFT) {
            algorithmFinder = new AlgorithmFinder(new ShiftAlgorithm());
        } else if (alg == AlgorithmOption.UNICODE) {
            algorithmFinder = new AlgorithmFinder(new UnicodeAlgorithm());
        } else {
            algorithmFinder = null;
        }

        // Get encrypted or decrypted message
        String textOut = (algorithmFinder != null) ? algorithmFinder.crypt(message) : "";

        // Write file to STDOUT or file
        if (fileOut == null) {
            System.out.println(textOut);
        } else {
            writeStringToFile(textOut, fileOut);
        }
    }
}
