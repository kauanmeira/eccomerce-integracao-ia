package br.com.kauan.ecomart.controller;

import br.com.kauan.ecomart.domain.chatclient.ChatClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorizador")
public class CategorizadorDeProdutosController {

    private final ChatClientService chatService;

    public CategorizadorDeProdutosController(ChatClientService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public String categorizar(String produto) {
        var system = """
                Você é um categorizador de produtos e deve responder apenas o nome da categoria do produto informado
                
                Escolha uma categoria dentre a lista abaixo:
                
                1. Higiene pessoal
                2. Eletronicos
                3. Esportes
                4. Outros
                
                #### exemplos de uso:
                
                Pergunta: Bola de futebol
                Resposta: Esportes
                """;

        return chatService.chat(system, produto);
    }

}
