package lab.melati.mobilwebappangularjs.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lab.melati.mobilwebappangularjs.entity.Mobil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import lab.melati.mobilwebappangularjs.repo.MobilRepo;


@RestController
public class ApiController {

	@RequestMapping("/get-nama")
	public Map<String, Object> getNama(){
		Map<String, Object> result = new HashMap();
		result.put("nama", "Lanny");

		return result;
	}
        @Autowired
        private MobilRepo mobilRepo;

	//-- aplikasi mahasiswa 
	@RequestMapping("/daftar-mobil")
        public List<Mobil> ambilDaftarMobil(){
            return mobilRepo.findAll();
        }

    @RequestMapping(value = "/tambah-mbl", method = RequestMethod.POST)
    public void tambahData(@RequestBody Mobil mbl){
    	//System.out.println("nim : " + mhs.getNim());
    	//System.out.println("nama : " + mhs.getNama());
    	//System.out.println("jurusan : " + mhs.getJurusan());
    	mobilRepo.save(mbl);
    }

    @RequestMapping("/get-mbl-by-id/{id}")
    public Mobil getMblById(@PathVariable("id") String id) {
    	return mobilRepo.findOneById(id);
    }

    @RequestMapping(value = "/hapus-data/{id}", method = RequestMethod.DELETE)
    public void hapusData(@PathVariable("id") String id){
        mobilRepo.delete(id);
    }


    @RequestMapping("/keluar")
    public void keluar(HttpServletRequest req, 
        HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder
            .getContext().getAuthentication();
        new SecurityContextLogoutHandler()
            .logout(req, resp, auth);
    }


}