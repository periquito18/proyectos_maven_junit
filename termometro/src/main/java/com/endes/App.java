package com.endes;

import com.endes.instrumento.Termometro;

/**
 * Ejemplo de uso 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Crear un termómetro con una temperatura inicial de 25°C
        Termometro termometro = new Termometro(25.0);

        // Mostrar la temperatura inicial
        System.out.println("Temperatura inicial en Celsius: " + termometro.getTemperaturaCelsius() + "°C");

        // Convertir a Fahrenheit
        double fahrenheit = termometro.convertirAFahrenheit();
        System.out.println("Temperatura en Fahrenheit: " + fahrenheit + "°F");

        // Convertir a Kelvin
        try {
            double kelvin = termometro.convertirAKelvin();
            System.out.println("Temperatura en Kelvin: " + kelvin + " K");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ajustar la temperatura
        termometro.ajustarTemperatura(-10.0);
        System.out.println("Temperatura después de ajuste (-10°C): " + termometro.getTemperaturaCelsius() + "°C");

        // Verificar si está en rango
        boolean enRango = termometro.estaEnRango(0, 30);
        System.out.println("¿Está la temperatura entre 0°C y 30°C? " + (enRango ? "Sí" : "No"));

        // Detectar congelación
        boolean esCongelacion = termometro.esCongelacion();
        System.out.println("¿Está la temperatura en estado de congelación? " + (esCongelacion ? "Sí" : "No"));

        // Detectar ebullición
        boolean esEbullicion = termometro.esEbullicion();
        System.out.println("¿Está la temperatura en estado de ebullición? " + (esEbullicion ? "Sí" : "No"));

        // Probar un caso de temperatura extremadamente baja
        try {
            termometro.setTemperaturaCelsius(-300);
            double kelvin = termometro.convertirAKelvin();
            System.out.println("Temperatura extrema en Kelvin: " + kelvin + " K");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al establecer temperatura extrema: " + e.getMessage());
        }
    }
}
