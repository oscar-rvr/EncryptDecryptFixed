package org.example;

public class Config {
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String inFile = null;
    private String outFile = null;
    private String alg = "shift";

    public static Config parseArgs(String[] args) {
        Config config = new Config();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> config.mode = args[i + 1];
                case "-key" -> config.key = Integer.parseInt(args[i + 1]);
                case "-data" -> config.data = args[i + 1];
                case "-in" -> config.inFile = args[i + 1];
                case "-out" -> config.outFile = args[i + 1];
                case "-alg" -> config.alg = args[i + 1];
            }
        }
        return config;
    }

    public String getMode() { return mode; }
    public int getKey() { return key; }
    public String getData() { return data; }
    public String getInFile() { return inFile; }
    public String getOutFile() { return outFile; }
    public String getAlg() { return alg; }
}
