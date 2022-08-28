/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wgenia.portfolio.Controller;

import com.wgenia.portfolio.Dto.dtoExperiencia;
import com.wgenia.portfolio.Entity.Experiencia;
import com.wgenia.portfolio.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia; 
    
    @GetMapping("/lista")    
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
      
        
   }
    @PostMapping("/crear")
    public ResponseEntity<?> create (@RequestBody dtoExperiencia dtoexp) {
        if(StringUtils.isBlank (dtoexp.getNombreE()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);   
        
        if(sExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
                    
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        sExperiencia.save(experiencia);
        return new ResponseEntity(HttpStatus.OK);
        
        
            }
    
}
