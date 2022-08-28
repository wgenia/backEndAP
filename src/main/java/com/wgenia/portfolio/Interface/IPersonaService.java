/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wgenia.portfolio.Interface;

import com.wgenia.portfolio.Entity.Persona;
import java.util.List;


/**
 *
 * @author xang_
 */
public interface IPersonaService {
    //traer lista personas
    public List<Persona> getPersona();
    
    //guardar objeto persona
    public void savePersona(Persona persona);
    
    //eliminar un usuario por id
    public void deletePersona(Long id);
    
    //buscar persona por id
    public Persona findPersona(Long id); 
    
}
