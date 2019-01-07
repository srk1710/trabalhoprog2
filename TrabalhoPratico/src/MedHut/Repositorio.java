 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;
import Exceptions.ConsultorioRepetidoException;
import Exceptions.ContaNaoReconhecidaException;
import Exceptions.ContactoRepetidoException;
import Exceptions.ErroCrucialException;
import Exceptions.NIFRepetidoException;
import Exceptions.NomeRepetidoException;
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
    private Map<Especialidade,List<Consultorio>> ConsultorioEspecialidade;
    private Map<String, List<Consultorio>> ConsultorioLocalidade;
    private List<Utilizador> utilizadores;
    private List<Conta> contas;
    
    
    private static Repositorio bd=null;
    
    public Repositorio(){
        this.ConsultorioEspecialidade = new HashMap<>();
        this.ConsultorioLocalidade = new HashMap<>();
        utilizadores = new ArrayList<>();
        contas = new ArrayList<>();
        utilizadores.add(new Admin ("admin", "admin")) ; //Administrador por defeito
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
    
    public synchronized List<Conta> getContas(){
        return contas;
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
              this.contas.add(conta);
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
     
     public synchronized void logOutUtil(Utilizador utilizador) throws ErroCrucialException{
        for (Utilizador util : this.utilizadores) {
            if (util.equals(utilizador)) {
                util.setOnline(false) ;
                return ;
            }
        }
        //algo se passou
        throw new ErroCrucialException ("Erro crucial na aplicação. Dados não guardados.") ;
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
        Utilizador utilizador = null;
        for (Utilizador uti : this.utilizadores) {
            if (uti instanceof Cliente) {
                if (((Cliente)uti).getId() != novo.getId()) {
                    if (((Cliente)uti).getUser().equals(novo.getUser())||((Cliente)uti).getId()==novo.getId()||((Cliente)uti).getNumcc()==novo.getNumcc()||((Cliente)uti).getNif()==novo.getNif()||((Cliente)uti).getContacto()==novo.getContacto()) {
                        existe = true ;
                        utilizador = uti ;
                        break ;
                    }
                }
            }
        }
        if (existe) {
            if (((Cliente)utilizador).getUser().equals(novo.getUser())){
                throw new UsernameRepetidoException ("ERRO: o User" + novo.getUser() + "ja existe!");
            }
            if (((Cliente)utilizador).getNumcc()==novo.getNumcc()) {
                throw new NumCCRepetidoException ("ERRO: o CC" + novo.getNumcc() + "ja existe!");
            }
            if (((Cliente)utilizador).getNif()==novo.getNif()) {
                throw new NIFRepetidoException ("ERRO: o Número Fiscal" + novo.getNif() + "ja existe!");
            }
            if (((Cliente)utilizador).getContacto()==novo.getContacto()) {
                throw new ContactoRepetidoException ("ERRO: o Telefone" + novo.getContacto() + "ja existe!");
            }
        }
        else{
            antigo = novo ;
        }
    }
    
    public synchronized void alterarInfoDono (Dono novo, Dono antigo) throws UsernameRepetidoException, NumCCRepetidoException, NIFRepetidoException, ContactoRepetidoException {
        boolean existe = false ;
        Utilizador utilizador = null;
        for (Utilizador uti : this.utilizadores) {
            if (uti instanceof Dono) {
                if (((Dono)uti).getId() != novo.getId()) {
                    if (((Dono)uti).getUser().equals(novo.getUser())||((Dono)uti).getId()==novo.getId()||((Dono)uti).getNumcc()==novo.getNumcc()||((Dono)uti).getNif()==novo.getNif()||((Dono)uti).getContacto()==novo.getContacto()) {
                        existe = true ;
                        utilizador = uti ;
                        break ;
                    }
                }
            }
        }
        if (existe) {
            if (((Dono)utilizador).getUser().equals(novo.getUser())){
                throw new UsernameRepetidoException ("ERRO: o User" + novo.getUser() + "ja existe!");
            }
            if (((Dono)utilizador).getNumcc()==novo.getNumcc()) {
                throw new NumCCRepetidoException ("ERRO: o CC" + novo.getNumcc() + "ja existe!");
            }
            if (((Dono)utilizador).getNif()==novo.getNif()) {
                throw new NIFRepetidoException ("ERRO: o Número Fiscal" + novo.getNif() + "ja existe!");
            }
            if (((Dono)utilizador).getContacto()==novo.getContacto()) {
                throw new ContactoRepetidoException ("ERRO: o Telefone" + novo.getContacto() + "ja existe!");
            }
        }
        else{
            antigo = novo ;
        }
    }
    
    public synchronized void adicionaConsultorioLocalidade (String localidade, Consultorio consul) throws ConsultorioRepetidoException, NomeRepetidoException{
        List <Consultorio> consultorios = new ArrayList <> () ;
        for (Map.Entry<String, List <Consultorio>> par : this.ConsultorioLocalidade.entrySet()) {         
            for (Consultorio c : par.getValue()) {                                      
                if (c.getIdConsultorio() == consul.getIdConsultorio()) {
                    throw new ConsultorioRepetidoException ("ERRO: o Consultorio, com identificador:" + consul.getIdConsultorio() + ", ja existe!");
                }
                if (c.getNome().equals(consul.getNome())) {
                    throw new NomeRepetidoException ("ERRO: este nome ja existe !") ;
                }
            }
        }
        if (! this.ConsultorioLocalidade.containsKey(localidade)) {        
            consultorios.add(consul) ;                       
            this.ConsultorioLocalidade.put(localidade, consultorios) ;             
        }
        else{                                       
            this.ConsultorioLocalidade.get(localidade).add(consul) ;        
        }
    }
    
    public synchronized void adicionaConsultorioEspecialidade (Especialidade especialidade, Consultorio consul) throws ConsultorioRepetidoException, NomeRepetidoException{
        List <Consultorio> consultorios = new ArrayList <> () ;
        for (Map.Entry<Especialidade, List <Consultorio>> par : this.ConsultorioEspecialidade.entrySet()) {         
            for (Consultorio c : par.getValue()) {                                       
                if (c.getIdConsultorio() == consul.getIdConsultorio()) {
                    throw new ConsultorioRepetidoException ("ERRO: o Consultorio, com identificador:" + consul.getIdConsultorio() + ", ja existe!");
                }
                if (c.getNome().equals(consul.getNome())) {
                    throw new NomeRepetidoException ("ERRO: este nome ja existe !") ;
                }
            }
        }
        if (! this.ConsultorioEspecialidade.containsKey(especialidade)) {        
            consultorios.add(consul) ;                       
            this.ConsultorioEspecialidade.put(especialidade, consultorios) ;             
        }
        else{                                       
            this.ConsultorioEspecialidade.get(especialidade).add(consul) ;        
        }
    }
    
    public synchronized Set<String> getLocalidades () {
        return this.ConsultorioLocalidade.keySet() ;
    }
    
    public synchronized Set<Especialidade> getEspecialidades(){
        return this.ConsultorioEspecialidade.keySet();
    }
    
    public synchronized List<Consultorio> getTodosConsultorios () {
        List<Consultorio> consultorios = new ArrayList <> () ;
        for (Map.Entry<String, List <Consultorio>> mapConsul : this.ConsultorioLocalidade.entrySet()) {
            for (Consultorio consul : mapConsul.getValue()) {
                consultorios.add(consul) ;                 
            }
        }
        return consultorios ;
    }
    
    public synchronized Consultorio getConsultorio (int id) {
        Consultorio con = null ;
        for (Consultorio c : getTodosConsultorios()) {
            if (c.getIdConsultorio() == id) {
                con = c ;
                break ;
            }
        } 
        return con ;              
    }
    
    public synchronized Consultorio getConsultorio (String nome) {
        Consultorio con = null ;
        for (Consultorio c : getTodosConsultorios()) {
            if (c.getNome().equals(nome)) {
                con = c ;
                break ;
            }
        } 
        return con ;              
    }
    
    
    
    public synchronized void registoAdmin ( Admin admin ) throws UsernameRepetidoException{
        boolean existe = false;
        Utilizador utilizador = null;
        for(Utilizador util: this.utilizadores){
            if(util instanceof Admin){    // verifica se o nome de utilizador ja existe
                if (util.getUser().equals(admin.getUser())) {
                    existe = true;
                    utilizador = util;
                    break;
                }
                
            }
        }
        if (existe) {
            if (utilizador.getUser().equals(admin.getUser())) {
                throw new UsernameRepetidoException("Erro: o nome de Utilizador " + admin.getUser() + "já existe.");
            }
        }
        else{      // se nao existe, adiciona
            this.utilizadores.add(admin);
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
