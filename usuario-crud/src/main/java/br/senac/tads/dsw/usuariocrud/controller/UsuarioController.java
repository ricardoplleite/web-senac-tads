package br.senac.tads.dsw.usuariocrud.controller;


import br.senac.tads.dsw.usuariocrud.entity.Papel;
import br.senac.tads.dsw.usuariocrud.entity.Usuario;
import br.senac.tads.dsw.usuariocrud.services.PapelService;
import br.senac.tads.dsw.usuariocrud.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private final PapelService papelService;

    @GetMapping("/listar")
    public ModelAndView listar() {

        List<Usuario> listaUsuarios = usuarioService.listar();
        List<Papel> listaPapels = papelService.listar();

        ModelAndView mv = new ModelAndView("/listar-usuario.html");
        mv.addObject("listaUsuario", listaUsuarios);
        mv.addObject("listaPapel", listaPapels);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView cadUser() {
        List<Papel> listaPapel = papelService.listar();
        Usuario user = new Usuario();
        ModelAndView mv = new ModelAndView("/criar-usuario.html");
        mv.addObject("listaPapel", listaPapel);
        mv.addObject("usuario", user);
        mv.addObject("data", LocalDateTime.now());

        return mv;
    }

    @PostMapping(value = "/salvar")
    public String salvarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.salvar(usuario);

        return "redirect:/listar";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editarUsuario(@PathVariable(name = "id") Long id) {
        List<Papel> listaPapel = papelService.listar();

        ModelAndView mv = new ModelAndView("/edit-usuario.html");
        Usuario usuario = usuarioService.get(id);
        mv.addObject("usuario", usuario);
        mv.addObject("listaPapel", listaPapel);

        return mv;
    }

    @RequestMapping("/delete/{id}")
    public String deletarProduto(@PathVariable(name = "id") int id) {
        usuarioService.delete(id);
        return "redirect:/listar";
    }
}
