package com.fibeso.captacion.pfuneraria.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fibeso.captacion.pfuneraria.entity.Roles;
import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;
//import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;
import com.fibeso.captacion.pfuneraria.repository.UsuariosOperadorRepository;

@Service
@Transactional
public class UsuariosOperadorDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuariosOperadorRepository usuariosOperadorRepo;
	
	@Override
	public UserDetails loadUserByUsername(String idOperador) throws UsernameNotFoundException {
		
		com.fibeso.captacion.pfuneraria.entity.UsuariosOperador appUsuariosOperador = usuariosOperadorRepo.findByIdOperador(idOperador).orElseThrow(() -> new UsernameNotFoundException("Nombre de usuario inválido"));
		Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
		for (Roles rol: appUsuariosOperador.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getDescripcionRol());
			grantList.add(grantedAuthority);
		}
		
		UserDetails usuarioS = (UserDetails) new User(idOperador, appUsuariosOperador.getPass(),grantList);
		return usuarioS;
	}

}
