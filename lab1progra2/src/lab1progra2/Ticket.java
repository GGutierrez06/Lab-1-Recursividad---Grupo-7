package lab1progra2;

public class Ticket {
    static PalindromoAir pal = new PalindromoAir();
    private String name;
    private double finalAmount;
    public double montoOriginal;
    public double descuento;
    public boolean esPalin;

    public Ticket(String name, double finalAmout, double montoOriginal, double descuento, boolean esPalin){
        this.name="";
        this.finalAmount=0;
        this.montoOriginal=0;
        this.esPalin=false;
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

    // public void setEsPalin(boolean esPalin) {
    //     this.esPalin = pal.isPalindromo(name);
    // }

    public void print(){
        System.out.println("---Datos del Cliete---");
        System.out.println("Nombre: " + this.getName());
        System.out.println("Total a pagar: " + this.getFinalAmount());
        System.out.println("Nombre: " + this.getMontoOriginal());
        if(this.esPalin){
            System.out.println("El pasajero si recibe descuento");
        }
        else{
            System.out.println("El pasajero no recibe descuento");
        }
    }
    
}
