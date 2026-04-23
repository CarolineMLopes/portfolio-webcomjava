package com.loja.lojaVirtual.controller;

import com.loja.lojaVirtual.modelo.Produto;
import com.loja.lojaVirtual.repository.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/consulta")
    public String consultaForm() {
        return "index";
    }

    @PostMapping("/consulta")
    public String consultarProduto(@RequestParam("id") String idParam, Model model) {
        try {
            int id = Integer.parseInt(idParam.trim());
            Produto produto = produtoDAO.buscarPorId(id);

            if (produto != null) {
                model.addAttribute("produto", produto);
            } else {
                model.addAttribute("erro", "Produto com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            model.addAttribute("erro", "ID inválido. Por favor, informe um número inteiro.");
        }

        model.addAttribute("idBuscado", idParam);
        return "resultado";
    }
}
