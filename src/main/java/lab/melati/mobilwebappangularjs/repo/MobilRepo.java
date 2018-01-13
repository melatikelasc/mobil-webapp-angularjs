/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.melati.mobilwebappangularjs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lab.melati.mobilwebappangularjs.entity.Mobil;
/**
 *
 * @author User
 */
@Repository
public interface MobilRepo extends JpaRepository<Mobil, String> {
	Mobil findOneById(String id);
    
    
}
