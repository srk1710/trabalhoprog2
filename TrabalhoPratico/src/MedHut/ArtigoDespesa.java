/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MedHut;

import java.io.Serializable;

/**
 *
 * @author srk
 */
public class ArtigoDespesa implements Serializable{
    // corresponde a um artigo de despesa numa consulta
    
    private String nomeArtigo;
    private float precoArtigo;
    private int quantidadeArtigo;

    public ArtigoDespesa(String nomeArtigo, float precoArtigo, int quantidadeArtigo){
        this.nomeArtigo=nomeArtigo;
        this.precoArtigo=precoArtigo;
        this.quantidadeArtigo=quantidadeArtigo;
    }
    
    public String getNomeArtigo() {
        return nomeArtigo;
    }

    public void setNomeArtigo(String nomeArtigo) {
        this.nomeArtigo = nomeArtigo;
    }

    public float getPrecoArtigo() {
        return precoArtigo;
    }

    public void setPrecoArtigo(float precoArtigo) {
        this.precoArtigo = precoArtigo;
    }

    public int getQuantidadeArtigo() {
        return quantidadeArtigo;
    }

    public void setQuantidadeArtigo(int quantidadeArtigo) {
        this.quantidadeArtigo = quantidadeArtigo;
    }
    
    
    
}
