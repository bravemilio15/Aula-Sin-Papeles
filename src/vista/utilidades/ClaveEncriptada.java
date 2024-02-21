/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ClaveEncriptada {

    // Genera una clave aleatoria de 128 bits
    public static SecretKey generarClave() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Tamaño de la clave
        return keyGenerator.generateKey();
    }

    // Encripta una cadena utilizando AES
    public static String encriptar(String cadena) throws Exception {
        // Generar una clave aleatoria de 128 bits
        SecretKey clave = generarClave();

        // Encriptar la cadena utilizando la clave generada
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] bytesEncriptados = cipher.doFinal(cadena.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    // Desencripta una cadena utilizando AES
    public static String desencriptar(String cadenaEncriptada, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] bytesDesencriptados = cipher.doFinal(Base64.getDecoder().decode(cadenaEncriptada));
        return new String(bytesDesencriptados, StandardCharsets.UTF_8);
    }

    // Método para generar una clave alfanumérica de 10 caracteres
    public static String generarClaveAlfanumerica() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder clave = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int indice = (int) (caracteres.length() * Math.random());
            clave.append(caracteres.charAt(indice));
        }
        return clave.toString();
    }
}
