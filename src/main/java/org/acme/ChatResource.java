package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Objects;

@ApplicationScoped
@Path("")
public class ChatResource {

    private final Bot bot;

    public ChatResource(final Bot bot) {
        this.bot = Objects.requireNonNull(bot);
    }

    // "Réponds-moi en une seule phrase. Quel est le nom de l'héroïne du livre "la philosophie dans le boudoir" du marquis de Sade ?"
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String chat(final String q) {
        final String response = bot.chat(q);
        return response;
    }
}
