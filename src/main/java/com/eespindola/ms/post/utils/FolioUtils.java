package com.eespindola.ms.post.utils;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;

public class FolioUtils {

    public static String createFolioRequest() {
        Random random = new Random();

        String[] numeros = new String[20];
        //StringBuilder numeroAleatorio = new StringBuilder();

        for (int i = 0; i < numeros.length; i++) {
            int numero = random.nextInt(0, 9);
            numeros[i] = Integer.toString(numero);
            //numeroAleatorio.append(numero);
        }

        String numeroAleatorio = Arrays.stream(numeros).reduce("", String::concat);
        LocalDateTime localDateTime = getFecha();

        return (numeroAleatorio + "-" + localDateTime);
    }


    public static String createFolioId() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime localDateTime = getFecha();

        return MessageFormat.format("{0}-{1}", uuid, localDateTime);
    }


    private static LocalDateTime getFecha(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String text = date.format(formatter);
        return  LocalDateTime.parse(text, formatter);
    }

}
