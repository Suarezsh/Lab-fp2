public class Estudiante {
    private String nombre;
    private int edad;
    protected String curso;

    public Estudiante(String nombre, int edad, String curso) {
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    protected String getCurso() {
        return curso;
    }

    protected void setCurso(String curso) {
        this.curso = curso;
    }

    public void estudiar() {
        System.out.println(nombre + " está estudiando en el curso de " + curso);
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan", 20, "Ingeniería de Sistemas");
        System.out.println("Nombre: " + estudiante.getNombre());
        System.out.println("Edad: " + estudiante.getEdad());
        System.out.println("Curso: " + estudiante.getCurso());
        estudiante.estudiar();
    }
}

