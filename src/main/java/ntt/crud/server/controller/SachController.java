package ntt.crud.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ntt.crud.server.model.Sach;
import ntt.crud.server.repository.SachRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SachController {
	@Autowired
	SachRepository sachRepository;
	@GetMapping("/sach")
	public ResponseEntity<List<Sach>> getAllSach(@RequestParam(required = false) String tensach) {
	try {
	List<Sach> sach = new ArrayList<Sach>();
	if (tensach == null)
		sachRepository.findAll().forEach(sach::add);
	else
		sachRepository.findBySachContaining(tensach).forEach(sach::add);
	if (sach.isEmpty()) {
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(sach, HttpStatus.OK);
	} catch (Exception e) {
	return new ResponseEntity<>(null, 
	HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/sach/{masach}")
	public ResponseEntity<Sach> getSachById(@PathVariable("masach") long masach) {
	Optional<Sach> sachData = sachRepository.findById(masach);
	if (sachData.isPresent()) {
	return new ResponseEntity<>(sachData.get(), HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@PostMapping("/sach")
	public ResponseEntity<Sach> createSach(@RequestBody Sach sach) {
	try {
	Sach _sach = sachRepository
	.save(new Sach(sach.getMasach(),sach.getTensach(),sach.getLoaisach(),sach.getNgaynhap(),sach.getNgayban(),sach.getGia() ));
	return new ResponseEntity<>(_sach, HttpStatus.CREATED);
	} catch (Exception e) {
	return new ResponseEntity<>(null, 
	HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PutMapping("/sach/{masach}") 
	public ResponseEntity<Sach> updateSach(@PathVariable("masach") long masach, @RequestBody Sach sach) {
	Optional<Sach> sachData = sachRepository.findById(masach);
	if (sachData.isPresent()) {
	Sach _sach = sachData.get();
	_sach.setMasach(sach.getMasach());
	_sach.setTensach(sach.getTensach());
	_sach.setLoaisach(sach.getLoaisach());
	_sach.setNgaynhap(sach.getNgaynhap());
	_sach.setNgayban(sach.getNgayban());
	_sach.setGia(sach.getGia());
	return new ResponseEntity<>(sachRepository.save(_sach), HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("/sach/{masach}")
	public ResponseEntity<HttpStatus> deleteSach(@PathVariable("masach") long masach) {
	try {
	sachRepository.deleteById(masach);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@DeleteMapping("/sach")
	public ResponseEntity<HttpStatus> deleteAllSach() {
	try {
	sachRepository.deleteAll();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	return new
	ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
