import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UMLsh {
    public static void main(String[] args) {
        System.out.println("Bienvenido a UMLsh - Suarez-sh");

        try {
            // Leer el nombre del archivo Java
            System.out.print("UMLsh => Ingrese el nombre del archivo Java: ");
            String fileName = System.console().readLine();

            // Intentar abrir el archivo
            File file = new File(fileName + ".java");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                StringBuilder code = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    code.append(line).append("\n");
                }
                reader.close();

                String umlCode = generateUML(code.toString());
                System.out.println("\nDiagrama UML generado:");
                System.out.println(umlCode);
            } else {
                System.out.println("No se encontró un archivo con ese nombre.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }
    public static String generateUML(String code) {
        String[] lines = code.split("\n");
        StringBuilder umlCode = new StringBuilder("======================\n");
    
        String currentClass = null;
        boolean insideClass = false;
        boolean isConstructor = false;
        for (String line : lines) {
            if (line.trim().startsWith("public class")) {
                // Detectar una clase.
                if (currentClass != null) {
                    umlCode.append("}\n");
                }
                currentClass = line.split(" ")[2].split("\\{")[0];
                umlCode.append("::").append(currentClass).append("\n---------------\n");
                insideClass = true;
            } else if (insideClass) {
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("private") || trimmedLine.startsWith("public") || trimmedLine.startsWith("protected")) {
                    // Campo
                    String[] parts = trimmedLine.split(" ");
                    String accessModifier = parts[0];
                    String name = parts[2].split(";")[0];
                    String type = parts[1];
                    if (accessModifier.equals("protected")) {
                        umlCode.append("#");
                    } else if (accessModifier.equals("private")) {
                        umlCode.append("-");
                    } else {
                        umlCode.append("+");
                    }
                    umlCode.append(name).append(": ").append(type).append("\n");
                    isConstructor = false;
                } else if (trimmedLine.contains(currentClass) && trimmedLine.contains("(") && trimmedLine.contains(")")) {
                    // Constructor
                    String constructorName = currentClass;
                    umlCode.append("+").append(constructorName).append("(");
                    String constructorParams = trimmedLine.substring(trimmedLine.indexOf("(") + 1, trimmedLine.indexOf(")"));
                    String[] paramParts = constructorParams.split(",");
                    for (int i = 0; i < paramParts.length; i++) {
                        String param = paramParts[i].trim();
                        String[] paramInfo = param.split(" ");
                        String paramName = paramInfo[paramInfo.length - 1];
                        umlCode.append(paramName);
                        if (i < paramParts.length - 1) {
                            umlCode.append(", ");
                        }
                    }
                    umlCode.append(")\n");
                    isConstructor = true;
                } else if (isConstructor) {
                    // Ignorar el contenido del constructor.
                } else if (trimmedLine.startsWith("public") && !trimmedLine.contains("class") && !trimmedLine.contains("(")) {
                    // Método
                    String[] parts = trimmedLine.split(" ");
                    String accessModifier = parts[0];
                    String returnType = parts[1];
                    String signature = parts[2].split("\\(")[0];
                    if (accessModifier.equals("protected")) {
                        umlCode.append("#");
                    } else if (accessModifier.equals("private")) {
                        umlCode.append("-");
                    } else {
                        umlCode.append("+");
                    }
                    umlCode.append(signature).append("(): ").append(returnType).append("\n");
                }
            }
        }
    
        if (currentClass != null) {
            umlCode.append("}\n--------------\n\n");
        }
    
        umlCode.append("==================");
    
        return umlCode.toString();
    }
    

}