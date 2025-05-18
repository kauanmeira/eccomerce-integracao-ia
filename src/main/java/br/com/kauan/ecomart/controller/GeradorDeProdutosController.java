package br.com.kauan.ecomart.controller;

import br.com.kauan.ecomart.domain.chatclient.ChatClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador")
public class GeradorDeProdutosController {

    private final ChatClientService chatClient;

    public GeradorDeProdutosController(ChatClientService chatClient) {
        this.chatClient = chatClient;
    }


    @GetMapping
    public String gerarProduto() {
        var pergunta = "Gere 5 produtos ecologicos";

        return chatClient.chat("Você é um gerador de produtos e deve responder apenas o nome do produto", pergunta);
    }

}
