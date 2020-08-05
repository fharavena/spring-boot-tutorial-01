package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("${texto.index.controller.index.titulo}")
	private String textoIndex;
	@Value("${texto.index.controller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.index.controller.listar.titulo}")
	private String textoListar;

	@GetMapping({ "/index", "", "/", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("nombre1");
		usuario.setApellido("apellido1");
		usuario.setEmail("nombre1@correo.cl");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil);
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("nombre1", "apellido1", "correo1@n.cl"));
		usuarios.add(new Usuario("nombre2", "apellido2", "correo2@n.cl"));
		usuarios.add(new Usuario("nombre3", "apellido3", "correo3@n.cl"));
		return usuarios;
	}
}
