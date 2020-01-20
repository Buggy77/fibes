package com.fibeso.captacion.pfuneraria.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.fibeso.captacion.pfuneraria.entity.Paquetespfs;
import com.fibeso.captacion.pfuneraria.entity.Pfdetalle;

@Repository
public interface PfdetalleRepository extends CrudRepository<Pfdetalle,Integer> {

	@Query("SELECT p FROM Pfdetalle p\r\n" + 
			"WHERE p.paquetespfs.idPaqPF = (:pIdPF) and p.activo = true and p.fchVigPrecPaq = (:pFchVigPF) and p.anioPF = (:pAnioPF)")
	public Pfdetalle findByIdPFAndActivoAndFchVigPrecPaqAndAnioPFActual(@Param("pIdPF") String idPF, @Param("pFchVigPF") LocalDateTime fchVigPF, @Param("pAnioPF") String anioPF);
	
}
