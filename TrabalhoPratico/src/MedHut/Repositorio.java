 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import Exceptions.ContaNaoReconhecidaException;
import Exceptions.ContactoRepetidoException;
import Exceptions.NIFRepetidoException;
import Exceptions.NumCCRepetidoException;
import Exceptions.UsernameRepetidoException;
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
    
     public synchronized void RegistarConta (Conta conta) throws UsernameRepetidoException, NumCCRepetidoException, NIFRepetidoException, ContactoRepetidoException{
          boolean existe = false ;
          Utilizador utilizador = null;
          for(Utilizador util: this.utilizadores){
              if(util instanceof Conta){
                  if (((Conta)util).getUser().equals(conta.getUser())||((Conta)util).getId()==conta.getId()||((Conta)util).getNumcc()==conta.getNumcc()||((Conta)util).getNif()==conta.getNif()||((Conta)util).getContacto()==conta.getContacto()) {
                    existe = true ;
                    utilizador = util;
                    break ;
                }
            }
          }if (existe) {
             if (((Conta)utilizador).getUser().equals(conta.getUser())) {
                 throw new UsernameRepetidoException("O nome " + conta.getUser() + "já existe!");
             }
             if (((Conta)utilizador).getNumcc()==conta.getNumcc()) {
                 throw new NumCCRepetidoException("O número de CC " + conta.getNumcc()+ "já existe!");
             }
             if (((Conta)utilizador).getNif()==conta.getNif()) {
                 throw new NIFRepetidoException("O NIF" + conta.getNif()+ "já existe!");
             }
             if (((Conta)utilizador).getContacto()==conta.getContacto()) {
                 throw new ContactoRepetidoException("O número de contacto " + conta.getContacto()+ "já existe!");
             }
             
         }
          else{
              this.utilizadores.add(conta) ;
          }
     }
     
     public synchronized Utilizador logInUtil (String user, String passwd) throws ContaNaoReconhecidaException{
        Utilizador utilizador = null ;
        for (Utilizador util : this.utilizadores) {
            if (util.getUser().equals(user) && util.getPasswd().equals(passwd) && util.isAtivo() && !util.isOnline()) {
                util.setOnline(true);
                utilizador = util ;
                return utilizador ;
            }
        }
        // a conta não foi reconhecida, lança a exception. utilizador = null
        throw new ContaNaoReconhecidaException ("ERRO: a conta não foi reconhecida. Confirme se o user e a password que introduziu estão corretos.");
    }
            // devolve o número de clientes
    public synchronized int getNumeroClientes(){
        int count=0;
        for(Utilizador u: this.utilizadores){
            if(u instanceof Cliente){
                count++;
            }
        }
        return count;
    }
    
            //devolve o número de admins
    public synchronized int getNumeroAdmins(){
        int count=0;
        for(Utilizador u: this.utilizadores){
            if(u instanceof Admin){
                count++;
            }
        }
        return count;
    }
    
            //devolve o número de donos
    public synchronized int getNumeroDonos(){
        int count=0;
        for(Utilizador u: this.utilizadores){
            if(u instanceof Dono){
                count++;
            }
        }
        return count;
    }
    
            //Altera os Dados Pessoais do Cliente
    public synchronized void alterarInfoCliente (Cliente novo, Cliente antigo) throws UsernameRepetidoException, NumCCRepetidoException, NIFRepetidoException, ContactoRepetidoException {
        boolean existe = false ;
        Utilizador hold = null;
        for (Utilizador uti : this.utilizadores) {
            if (uti instanceof Cliente) {
                if (((Cliente)uti).getId() != novo.getId()) {
                    if (((Cliente)uti).getUser().equals(novo.getUser())||((Cliente)uti).getId()==novo.getId()||((Cliente)uti).getNumcc()==novo.getNumcc()||((Cliente)uti).getNif()==novo.getNif()||((Cliente)uti).getContacto()==novo.getContacto()) {
                        existe = true ;
                        hold = uti ;
                        break ;
                    }
                }
            }
        }
        if (existe) {
            if (((Cliente)hold).getUser().equals(novo.getUser())){
                throw new UsernameRepetidoException ("ERRO: o User" + novo.getUser() + "ja existe!");
            }
            if (((Cliente)hold).getNumcc()==novo.getNumcc()) {
                throw new NumCCRepetidoException ("ERRO: o CC" + novo.getNumcc() + "ja existe!");
            }
            if (((Cliente)hold).getNif()==novo.getNif()) {
                throw new NIFRepetidoException ("ERRO: o Número Fiscal" + novo.getNif() + "ja existe!");
            }
            if (((Cliente)hold).getContacto()==novo.getContacto()) {
                throw new ContactoRepetidoException ("ERRO: o Telefone" + novo.getContacto() + "ja existe!");
            }
        }
        else{
            antigo = novo ;
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
    
    public synchronized void atribuirNumeração () {
        Utilizador.setNumUtilizador(Repositorio.getInstance().getNumeroUtilizadores());
    }

    
}
