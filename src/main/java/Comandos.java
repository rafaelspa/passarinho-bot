import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Comandos extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()){return;}

        if (!event.getChannel().getName().equals("para-bot")) {
            return;
        }

        String mensagem = event.getMessage().getContentRaw();

        // !info
        // !soma 10 11true
        String[] argumentos = mensagem.split(" ");
        String comando = argumentos[0];

        if (comando.equals("!info")) {
            MessageEmbed messageEmbed = new EmbedBuilder()
                    .setTitle("Informações")
                    .setDescription("Aqui estão as informações")
                    .addField("Campo1", "VAlor do campo 1", true)
                    .addField("Campo2", "VAlor do campo 2", true)
                    .addField("Campo3", "VAlor do campo 3", true)
                    .setColor(Color.BLUE)
                    .setFooter("Gerado pelo Passarinho para " + event.getAuthor().getName(), event.getMember().getUser().getAvatarUrl())
                    .build();

//            event.getChannel().sendMessage("Informações para " + event.getAuthor().getName()).queue();
            System.out.println(messageEmbed);
            event.getChannel().sendMessageEmbeds(messageEmbed).queue();
        }

        if (comando.equals("!somar")) {
            try {
                double numero1 = Double.parseDouble(argumentos[1]);
                double numero2 = Double.parseDouble(argumentos[2]);
                double soma = numero1 + numero2;
                event.getChannel().sendMessage("O resultado da soma é: " + soma).queue();
            } catch (ArrayIndexOutOfBoundsException exception) {
                event.getChannel().sendMessage("Você precisa passar o número 1 e o número 2. Dessa forma: !somar 1 2").queue();
            } catch (NumberFormatException exception) {
                event.getChannel().sendMessage("Você precisa passar dois numeros. Ex: !somar 10 11").queue();

            }

        }

//        System.out.println(event.getMessage().getContentRaw());
//        System.out.println(event.getAuthor().getId());
//        System.out.println(event.getAuthor().getName());
//        event.getChannel().sendMessage("Olá " + event.getAuthor().getName()).queue();
    }

}
