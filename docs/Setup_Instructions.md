# Setup Instructions

## Java Setup

For this project, I installed Java JDK version 25 on my system (Windows 11).

To verify the installation, I used the following command in the terminal:

java -version

C:\Users\tejae>java --version
java 25.0.2 2026-01-20 LTS
Java(TM) SE Runtime Environment (build 25.0.2+10-LTS-69)
Java HotSpot(TM) 64-Bit Server VM (build 25.0.2+10-LTS-69, mixed mode, sharing)

This confirmed that Java was installed correctly and ready to use.



## Hello World Program

To test the setup, I created a simple Hello World program.

File name: HelloWorld.java

Code:
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}



## Compile and Run

I compiled the program using:

javac HelloWorld.java

Then I ran it using:

java HelloWorld


## Output

The program printed:

Hello, World!

PS C:\Users\tejae\OneDrive\Desktop\Java_Practice> javac .\HelloWorld.java 
PS C:\Users\tejae\OneDrive\Desktop\Java_Practice> java HelloWorld        
Hello, World!

## Notes

- I used VS Code as my IDE
- Terminal inside VS Code was used to compile and run the program
- This confirmed that my Java environment is properly set up