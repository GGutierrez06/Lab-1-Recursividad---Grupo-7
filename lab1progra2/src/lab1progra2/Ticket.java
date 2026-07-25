package lab1progra2;

public class Ticket {
    private String nombre;
    private double finalAmount;
    public double montoOriginal;
    public double descuento;
    public boolean esPalin;

    public Ticket(String nombre, double finalAmount, double montoOriginal, double descuento, boolean esPalin){
        this.nombre=nombre;
        this.finalAmount = finalAmount;
        this.montoOriginal=montoOriginal;
        this.descuento=descuento;
        this.esPalin=esPalin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }


    public double getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }
    

    public boolean isEsPalin() {
        return esPalin;
    }

    public void setEsPalin(boolean esPalin) {
        this.esPalin = esPalin;
    }

    public void print(){
        System.out.println("Datos del Cliente");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Monto Original: " + this.getMontoOriginal());
        System.out.println("Total a pagar: " + this.getFinalAmount());
        if(this.esPalin){
            System.out.println("El pasajero si recibe descuento");
        }
        else{
            System.out.println("El pasajero no recibe descuento");
        }
    }
    
}
