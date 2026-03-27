# JVM Basics

## What is JDK, JRE, JVM?

JDK (Java Development Kit) is the complete package used to develop Java applications. It includes tools like the compiler (javac) and also contains JRE.

JRE (Java Runtime Environment) is used to run Java programs. It provides the libraries and environment required to execute the code.

JVM (Java Virtual Machine) is a part of JRE. It is responsible for actually running the Java program by converting bytecode into machine code.

In simple terms:
JDK → for development  
JRE → for running programs  
JVM → executes the code  


## What is Bytecode?

When we write a Java program and compile it using javac, it does not convert directly into machine code. Instead, it generates an intermediate code called bytecode.

This bytecode is stored in a .class file and is not specific to any operating system. The JVM reads this bytecode and converts it into machine code at runtime.



## What does "Write Once, Run Anywhere" mean?

Java follows the principle of "Write Once, Run Anywhere". This means that a Java program can be written once and then run on any system without modifying the code.

This is possible because Java code is first converted into bytecode, which is platform-independent. The JVM on each system takes care of converting that bytecode into machine-specific instructions.

Because of this, the same Java program can run on Windows, Linux, or Mac without any changes.