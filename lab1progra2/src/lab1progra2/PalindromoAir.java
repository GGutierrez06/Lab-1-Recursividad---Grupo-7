/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1progra2;

/**
 *
 * @author David Suazo Palao
 */
public class PalindromoAir {
   private Ticket[] posicion;
    private static final double precio=100;
    private static final double descuento=0.20;
    
    public PalindromoAir(){
        this.posicion=new Ticket[30];
    }
    public Ticket[] getPosicion(){
        return posicion;
    }
    
    public int firstAvailable (int index){
        if (index >= posicion.length){
            return -1;
        }
        if (posicion[index] == null){
            return index;
        }
        return firstAvailable (index+1);
    }
    public int searchPassenger(String name, int index){
        if (index >= posicion.length){
            return -1;
        }
        if (posicion[index] != null && posicion[index].getname()){
            return index;
        }
        return searchPassenger (name, index + 1);
    }
    private boolean revisarpali( String palabra, int izq, int der){
        if (izq>= der){
            return true;
        }
        if (palabra.charAt(izq) != palabra.charAt(der)){
            return false;
        }
        return revisarpali(palabra, izq +1, der -1);
    }
    public boolean isPalindromo(String nombre){
        if (nombre==null || nombre.isEmpty()){
            return false;
        }
        String palabra=nombre.toLowerCase();
        return revisarpali (palabra, 0, palabra.length()-1);
    }
    public String printPassengers( int index){
        if (index >=posicion.length){
        return "";
    }
    String posactual= "";
    if (posicion[index]!=null){
        posactual =" Asiento asignado es: "+ (index+1) + posicion[index];
    }
    return posactual +printPassengers (index +1);
    }
    public double income(int index){
        if (index >= posicion.length){
            return 0;
        }
        double ingresos;
        if (posicion[index] != null) {
            ingresos = posicion[index].getFinalAmount();
        } else {
            ingresos = 0;
        }
        return ingresos + income(index + 1);       
        }
    public void reset (int index){
        if (index >=posicion.length){
            return;
        }
        posicion[index]=null;
        reset(index +1);
    }
    public int sellTicket (String nombre){
        int posindex= firstAvailable(0);
        if (posindex ==-1){
            return -1;
        }
        boolean palindromorev= isPalindromo(nombre);
        double precionormal= precio;
        double preciofinal;
        
        if (palindromorev){
            preciofinal= precionormal*0.80;
        }else{
            preciofinal=precionormal;
            Ticket newTicket = new Ticket(nombre.trim(),preciofinal, precionormal,descuento, palindromorev);
        posicion[posindex] = newTicket;

        return posindex;
        }
    }
    public boolean cancelTicket(String nombre){
        int index= searchPassenger(nombre, 0);
        if (index !=-1){
            posicion[index]= null;
            return true;
        }
        return false;
    }
    }
        
   
