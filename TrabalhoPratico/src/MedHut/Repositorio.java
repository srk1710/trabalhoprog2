 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import Exceptions.MensagemException;
import java.io.*;
import java.util.*;
import Utilizadores.*;
import Interface_Grafica.*;

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
    
            //Adicionar uma conta
            //Garante que nao se repete o nome de utilizador , numero de cc, nif e contacto
    
     public synchronized void RegistarConta (Conta conta) throws MensagemException{
          boolean existe = false ;
          Utilizador user = null;
          for(Utilizador util: this.utilizadores){
              if(util instanceof Conta){
                  if (((Conta)util).getUser().equals(conta.getUser())||((Conta)util).getId()==conta.getId()||((Conta)util).getNumcc()==conta.getNumcc()||((Conta)util).getNif()==conta.getNif()||((Conta)util).getContacto()==conta.getContacto()) {
                    existe = true ;
                    user = util;
                    break ;
                }
            }
          }if (existe) {
             if (((Conta)user).getUser().equals(conta.getUser())) {
                 throw new MensagemException("O nome " + conta.getUser() + "já existe!");
             }
             if (((Conta)user).getNumcc()==conta.getNumcc()) {
                 throw new MensagemException("O número de CC " + conta.getNumcc()+ "já existe!");
             }
             if (((Conta)user).getNif()==conta.getNif()) {
                 throw new MensagemException("O NIF" + conta.getNif()+ "já existe!");
             }
             if (((Conta)user).getContacto()==conta.getContacto()) {
                 throw new MensagemException("O número de contacto " + conta.getContacto()+ "já existe!");
             }
             
         }
          else{
              this.utilizadores.add(conta) ;
          }
     }
    
    
    
       
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
