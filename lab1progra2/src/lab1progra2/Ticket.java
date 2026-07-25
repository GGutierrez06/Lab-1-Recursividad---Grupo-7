package lab1progra2;

public class Ticket {
    private String name;
    private double finalAmount;
    public double montoOriginal;
    public double descuento;
    public boolean esPalin;

    public Ticket(String name, double finalAmount, double montoOriginal, double descuento, boolean esPalin){
        this.name=name;
        this.finalAmount = finalAmount;
        this.montoOriginal=montoOriginal;
        this.descuento=descuento;
        this.esPalin=esPalin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        System.out.println("Nombre: " + this.getName());
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
