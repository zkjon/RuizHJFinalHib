package es.albarregas.models;

import java.util.Date;

public class Modelo {

    /**
     * Método que devuelve el texto encriptado en MD5
     * @param texto String a encriptar
     * @return String con el texto encriptado
     */
    public String md5(String texto) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error en md5: " + e.getMessage());
        }
        return null;
    }

    public static Date getFechaActual() {
        return new Date();
    }
}
