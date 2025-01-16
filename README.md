
# Encryption-Decryption (Java)
This project implements encryption and decryption algorithms using two different techniques: the **shift cipher** and the **Unicode shifting** algorithm. The program is configurable through command-line arguments, allowing the user to choose the mode (encryption/decryption), the algorithm, and the key for the shift operation.
## Features
- **Shift Algorithm**: Encrypts or decrypts text by shifting letters in the alphabet. It only operates on English letters (a-z, A-Z), wrapping around the alphabet as needed.  
- **Unicode Algorithm**: Encrypts or decrypts text by shifting Unicode values.
## Usage
### Command-Line Arguments:
- `-mode`: Set the mode (`enc` for encryption, `dec` for decryption). Default is `enc`.  
- `-key`: Set the key for encryption/decryption (integer).  
- `-data`: Set the text data to encrypt/decrypt.  
- `-in`: Specify an input file for encryption/decryption.  
- `-out`: Specify an output file to write the result.  
- `-alg`: Choose the algorithm (`shift` or `unicode`). Default is `shift`.
### Examples
1. **Encrypt with Unicode Algorithm:** `java - cp .org.example.Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode` Output: `\jqhtrj%yt%m~ujwxpnqq&`  
2. **Decrypt with Unicode Algorithm:** `java - cp .org.example.Main -mode dec -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -alg unicode` Output: `Welcome to hyperskill!`  
3. **Encrypt with Shift Algorithm:** `java - cp .org.example.Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg shift` Output: `Bjqhtrj yt mdujwxpnqq!`  
4. **Decrypt with Shift Algorithm:** `java - cp .org.example.Main -mode dec -key 5 -data "Bjqhtrj yt mdujwxpnqq!" -alg shift` Output: `Welcome to hyperskill!`
## Setup
1. Clone the repository:  
   `git clone https://github.com/oscar-rvr/EncrypDecryptFixed`
2. **Compiling the Program:**  
   Navigate to the `src/main/java` directory and run the following command to compile the program:  
   `javac -d org/example/*.java`
3. **Running the Program:**  
   After compiling, run the program with the desired arguments (you have to be in EncryptDecryptFixed/src/main/java
):  
   `java -cp . org.example.Main -mode dec -data "\jqhtrj%yt%m~ujwxpnqq&" -key 5 -alg unicode`
## File Structure
- `src/encryptdecrypt/Main.java`: The main entry point of the program.  
- `src/encryptdecrypt/Config.java`: Parses and stores command-line arguments.  
- `src/encryptdecrypt/FileManager.java`: Handles file reading and writing.  
- `src/encryptdecrypt/TextProcessor.java`: Processes the text using the chosen algorithm.
## License
This project is my own creation and is not licensed.
---
