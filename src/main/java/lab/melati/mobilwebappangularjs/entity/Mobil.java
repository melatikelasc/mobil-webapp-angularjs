/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.melati.mobilwebappangularjs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author User
 */
@Entity
public class Mobil {
    
    @Id @Getter @Setter
    private String id;

    @Column @Getter @Setter
    private String nopol;
    
    @Column @Getter @Setter
    private String merk_tipe;
    
}
