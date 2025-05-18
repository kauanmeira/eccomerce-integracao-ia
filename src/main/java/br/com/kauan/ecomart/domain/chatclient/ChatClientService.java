package br.com.kauan.ecomart.domain.chatclient;

import br.com.kauan.ecomart.domain.token.TokenService;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatClientService {
    private final ChatClient chatClient;
    private final TokenService tokenService;

    public ChatClientService(ChatClient.Builder chatClientBuilder, TokenService tokenService) {
        this.chatClient = chatClientBuilder.build();
        this.tokenService = tokenService;
    }

    public String chat(String system, String promptUsuario) {
        var token = tokenService.contarTokens(system, promptUsuario);
        String model = token <= 3000 ? ModelType.GPT_4O_MINI.getName() : ModelType.GPT_4O.getName();
        return this.chatClient.prompt()
                .system(system)
                .user(promptUsuario)
                .options(ChatOptions.builder()
                        .temperature(0.85)
                        .model(model)
                        .build())
                .call()
                .content();
    }
}
