import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class shUml {
    private JFrame frame;
    private JTextArea codeTextArea;
    private JPanel umlPanel;
    private JTextArea umlTextArea;

    public shUml() {
        frame = new JFrame("shUml - Convertidor de Java a UML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new GridLayout(1, 2));

        // Panel izquierdo (código Java)
        JPanel codePanel = new JPanel(new BorderLayout());
        JButton openButton = new JButton("Abrir Archivo Java");
        codeTextArea = new JTextArea(20, 30);
        codeTextArea.setEditable(false);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                        }
                        reader.close();
                        codeTextArea.setText(content.toString());
                        generateUML(content.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error al abrir el archivo.");
                    }
                }
            }
        });

        codePanel.add(openButton, BorderLayout.NORTH);
        codePanel.add(new JScrollPane(codeTextArea), BorderLayout.CENTER);

        // Panel derecho (UML)
        umlPanel = new JPanel(new BorderLayout());
        umlTextArea = new JTextArea(20, 30);
        umlTextArea.setEditable(false);
        umlPanel.add(new JScrollPane(umlTextArea), BorderLayout.CENTER);

        frame.add(codePanel);
        frame.add(umlPanel);
    }

    public void display() {
        frame.setVisible(true);
    }

    public void generateUML(String code) {
        String[] lines = code.split("\n");
        StringBuilder umlCode = new StringBuilder("@startuml\n");
    
        String currentClass = null;
        boolean insideClass = false;
        for (String line : lines) {
            if (line.trim().startsWith("public class")) {
                // Detectar una clase.
                if (currentClass != null) {
                    umlCode.append("}\n");
                }
                currentClass = line.split(" ")[2].split("\\{")[0];
                umlCode.append("::").append(currentClass).append("\n--\n");
                insideClass = true;
            } else if (insideClass) {
                // Detectar campos y métodos.
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
                } else if (trimmedLine.startsWith("public") && !trimmedLine.contains("class")) {
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
            umlCode.append("--\n}\n");
        }
    
        umlCode.append("@enduml");
    
        umlTextArea.setText(umlCode.toString());
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                shUml shUmlApp = new shUml();
                shUmlApp.display();
            }
        });
    }
}