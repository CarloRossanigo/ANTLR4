
# ANTLR4 Java Projects

This repository contains a pdf that introduces the topic of parsing and three initial projects that utilize **ANTLR4** for language parsing and code generation in **Java**. The projects focus on constructing grammars (with or without a visitor pattern) for a calculator that supports basic operations (definition, arithmetic operations, functions) and set theory (definition, unary and binary operations). The semantics of these languages are implemented in **Java**.

Below are the steps to compile and run the project in three different ways: via terminal, Eclipse, and using a JAR file.

## Prerequisites

- **Java** (version 8 or higher)
- **ANTLR4** (download from [ANTLR Downloads](https://www.antlr.org/download.html))

## Compilation and Execution Methods

### 1. Compile via Terminal

#### Step 1: Set up ANTLR4 aliases
Make sure you have ANTLR4 downloaded (for example, in `/usr/local/lib/antlr-4.13.1-complete.jar`). To simplify the use of ANTLR4, you can define aliases in your terminal:

```bash
antlr4='java -jar /usr/local/lib/antlr-4.13.1-complete.jar'
grun='java org.antlr.v4.gui.TestRig'
```

You can add these lines to your shell configuration file (e.g., `~/.bashrc` or `~/.zshrc`) so that they are automatically executed every time you open a terminal.

#### Step 2: Compile `.g4` grammar files
Once ANTLR4 is set up, you can compile the grammar file (`.g4`). Run the following command:

```bash
$ antlr4 YourGrammar.g4
```

Depending on the project, the grammar file may be configured to use the Visitor or Listener pattern. If your project requires the Visitor pattern, compile it like this:

```bash
$ antlr4 Calc.g4 -visitor
```
(In our case, Calc.g4 is a grammar which utilize the visitor)

Refer to *The Definitive ANTLR4 Reference* by Terence Parr for more guidance.

#### Step 3: Compile generated Java files
After ANTLR generates the Java files, compile them using `javac`:

```bash
$ javac path_to_folder/src/*.java
```

Alternatively, you can compile just the main application (e.g., `EspressioneApp`):

```bash
$ javac src/App/EspressioneApp.java
```

#### Step 4: Run the program
Now, you can run the main application (e.g., `EspressioneApp`) and specify the input file path:

```bash
$ java src/App/EspressioneApp src/test/test0.txt
```

### 2. Compile via Eclipse

#### Step 1: Set up the project in Eclipse

1. **Import the project**: If you haven’t imported the project yet, go to `File -> Import -> Existing Projects into Workspace` and select the project folder.
2. **Add the ANTLR4 library to the Java Build Path**:
   - Right-click on the project, and select `Properties`.
   - Go to `Java Build Path`, and then the `Libraries` tab.
   - Click on `Add External JARs` and select the ANTLR4 JAR (e.g., `antlr-4.13.1-complete.jar`).
   - Make sure it is marked for compilation by selecting it in the `Order and Export` tab.

#### Step 2: Configure the Run Configuration

1. Go to `Run -> Run Configurations`.
2. Select your project or create a new run configuration.
3. In the `Main` tab, set `EspressioneApp` as the main class.
4. In the `Arguments` tab, add the file path of the input file to the `Program arguments` (e.g., `${file_prompt}`).
5. Ensure ANTLR4 is included in the dependencies (as described above).

#### Step 3: Run the program
You can now run the application directly from Eclipse by clicking on `Run`. The application will prompt you for an input file and process it accordingly.


### 3. Compile and Run via JAR

#### Step 1: Run the JAR

To run the program with an input file via the JAR, use the following command:

```bash
$ java -jar EspressioneApp.jar /path_to_file.txt
```

Replace `/path/to/file.txt` with the actual path to the text file you want to analyze, for istance in our case: src/test/test0.txt

#### Step 2: How to create the JAR file
If you've already compiled the project and generated a JAR file, you can execute the program via the `java -jar` command.

If you haven't created a JAR file yet, you can do so from Eclipse by going to `File -> Export -> Java -> Runnable JAR file`. This will generate an executable JAR file (e.g., `EspressioneApp.jar`).

## Example Input File

The input file, depending on the grammar, could contain expressions such as:

```
(1+2)
EULER*3
ABS(ROUND(-5.6))
```
```
A:{1,2,c}
B:{6,c,ciao}
A+B
```

The program will analyze these files and produce the output based on the logic defined in the project.
