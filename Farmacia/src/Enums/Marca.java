package Enums;

/**
 *
 * @authors Jopaquin Gutierrez, Ian Teixeira, Felipe Lorca
 */
public enum Marca {
 
    Bayer,
    Knop_Laboratorios,
    Pfizer_Chile,
    Vichy,
    CeraVe,
    Isdin,
    L_Oréal,
    Eucerin,
    SimiVit,
    Pediasure,
    Ensure,
    Wild_Protein,
    ProteinMix;
    
    public static Marca getPorPos(int indice){
        return values()[indice];
    }
    
    public static void listarMarcas(){
        for(Marca m: Marca.values()){
            System.out.println(m.name());
        }
    }
    
    public static int getCantidad(){
        int val = Marca.values().length;
        return val;
    }
}
