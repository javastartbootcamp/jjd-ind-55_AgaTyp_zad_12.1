package calculator;

import java.io.*;
import java.util.Scanner;

public class CalcApp {

    static Operation[] readFile(String fileName) throws FileNotFoundException {
        final int linesNo = countLines(fileName);
        Operation[] operations = new Operation[linesNo];

        try (Scanner sc = new Scanner(new File(fileName))) {
            for (int i = 0; i < linesNo; i++) {
                String operationLine = sc.nextLine();
                operations[i] = createOperationFromLine(operationLine);
            }
        }
        return operations;
    }

    private static Operation createOperationFromLine(String operationLine) {
        String[] data = operationLine.split(" ");
        double a = Double.parseDouble(data[0]);
        double b = Double.parseDouble(data[2]);
        String operationSign = data[1];

        return new Operation(a, b, operationSign);
    }

    private static int countLines(String filename) throws FileNotFoundException {
        int lines = 0;
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                lines++;
            }
        }
        return lines;
    }

    private static void writeFile(String finalOperation, String resultFileName) {

        try (
                var fileWriter = new FileWriter(resultFileName, true);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(finalOperation);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać do pliku: " + resultFileName);
        }
    }

    private static void createFile(String filename) {
        File file = new File(filename);
        boolean fileExists = file.exists();

        if (!fileExists) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Nie udało się utworzyć pliku: " + filename);
            }
        } else  {
            try {
                new FileWriter(filename, false).close();
            } catch (IOException e) {
                System.err.println("Nie udało się wyczyścić pliku: " + filename);
            }
        }
    }


    private static void getOperation(Operation[] operations, String filename) {
        for (Operation operation : operations) {
            double result = Calculator.calculate(operation);
            String finalOperation = operation.toString() + result;
            System.out.println(finalOperation);
            writeFile(finalOperation, filename);
        }
    }

    public void useCalculator(String filename) {
        String resultFileName = "result.txt";

        createFile(resultFileName);
        try{
            Operation[] operations = readFile(filename);
            getOperation(operations, resultFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku: " + filename);
        }

    }
}
