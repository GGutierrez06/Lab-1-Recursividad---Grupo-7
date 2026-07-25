public class Tickets {
    private String nombre;
    private double finalAmount;
    public double montoOriginal;
    public boolean esPalin;

    public Tickets(){
        this.nombre="";
        this.finalAmount=0;
        this.montoOriginal=0;
        this.esPalin=false;
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
        System.out.println("---Datos del Cliete---");
        System.out.println("Nombre: " + this.getNombre());
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
