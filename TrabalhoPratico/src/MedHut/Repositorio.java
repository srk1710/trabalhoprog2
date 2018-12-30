 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import java.io.*;
import java.util.*;
import Utilizadores.*;

/**
 *
 * @author srk
 */
public class Repositorio implements Serializable{
    
    
    private Map<Consultorio,Especialidade> ConsultorioEspecialidade;
    private Map<Consultorio, String> ConsultorioLocalidade;
    private List<Utilizador> utilizadores;
    
    
    private static Repositorio bd=null;
    
    public Repositorio(){
        this.ConsultorioEspecialidade = new HashMap<>();
        this.ConsultorioLocalidade = new HashMap<>();
        utilizadores = new ArrayList<>();
        utilizadores.add(new Admin ("admin", "admin")) ; //Utilizador por defeito
    }
    
    
    public static Repositorio getInstance(){
        if( bd == null){
            bd = new Repositorio();
        }
        
        return bd;
    }
    //MÉTODOS DE INSTÂNCIA
    // Devolve a lista de utilizadores do sistema.
         
    public synchronized List<Utilizador> getUtilizadores() {
        return utilizadores;
    }
    
    // Calcula o número de utilizadores.
    public synchronized int getNumeroUtilizadores () {
        return utilizadores.size() ;
    }
    
    
    
     public synchronized void signINConta (Conta conta){
          boolean existe = false ;
          
          for(Utilizador uti: this.utilizadores){
              if(uti instanceof Conta){
                  if (((Conta)uti).getUser().equals(conta.getUser())||((Conta)uti).getId()==conta.getId()||((Conta)uti).getNumcc()==conta.getNumcc()||((Conta)uti).getNif()==conta.getNif()||((Conta)uti).getContacto()==conta.getContacto()) {
                    existe = true ;
                    break ;
                }
            }
          }if (existe) {
              System.out.println("Erro!");
          }
          else{
              this.utilizadores.add(conta) ;
          }
     }
    
    // getter e adicionar do list e dos maps
    // da uma olhadela no repositorio do exemplo que está no moodle
    
       
    public static void serializar(String filename) {
        // Serializar um objeto para ficheiro
        try(FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(bd);
            System.out.println("Serialized data is saved in " + filename);
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
   
    public static void desserializar(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            bd = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Cliente class not found. " + ex.getMessage());
        }
    }

    
}
