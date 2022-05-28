import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder
                .createDefault("OTc5ODU5MTk4MTY0NzI5ODk4.G1Ybxl.CZdy8mMG4RjjyEpowP16zqb74Uy-doHJKPqWmA")
                .setStatus(OnlineStatus.IDLE)
                .setActivity(Activity.listening("Passarinho na escuta"))
                .build();

        jda.getPresence().setStatus(OnlineStatus.OFFLINE);

        jda.addEventListener(new Comandos());

        System.out.println("Rodando...");
    }
}
