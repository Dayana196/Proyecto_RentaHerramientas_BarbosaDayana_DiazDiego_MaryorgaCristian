document.addEventListener("DOMContentLoaded", function() {

    // --- 1. DATOS DEL INVENTARIO (60 herramientas) ---
    Dayana
dayana_barbosa
Invisible

Dayana

 — 7/11/25, 11:21
package com.dayana;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static int maxRange = 10000;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ingrese el valor minimo: ");
        var min = scan.nextInt();
        System.out.println("Ingrese el valor maximo: ");
        var max = scan.nextInt();
        int[] numbers = new int[maxRange];
        for (int a=0; a < numbers.length; a++) {
            numbers[a] = random.nextInt(min,max+1);
        }
        System.out.println("Ingrese la cantidad de numeros a buscar: ");
        var counter = scan.nextInt();
        for (int a=0; a < counter; a++) {
            System.out.println("Ingrese el indice a buscar [1 hasta "+maxRange+"]: ");
            var index = scan.nextInt();
            System.out.println("Oiga el indice es: "+ (index)+" = " + numbers[index - 1]);
        }
        scan.close();
    }
}
Dayana

 — 7/11/25, 11:38
package com.dayana;

import java.util.Random;

public class Ciclos {
    public static void main(String[] args) {
        Random r = new Random(); 

        int[] numeros = new int[10000];

        for(int a=0; a < numeros.length; a++) {
            numeros[a] = r.nextInt(100);
        }

        for(int a=0; a < 10; a++) {
            int indice = r.nextInt(10000);
            System.out.println("Oiga el indice es: "+ indice+"  = " + numeros[indice]);
        }

        // Mostrar un listado de los indices que su valor en el array de
        // numeros sean menor o igual a 55

    }
}
Dayana

 — 10/11/25, 11:08
package com.dayana.ahorcado.Game;

import java.util.Random;

public class Ahorcado {
    String palabraSecreta, palabraTablero; //Palabra secreta adivinar 
    String[] palabras; //Array de palabras posibles
    int intentosMaximos; //numero maximo de intentos permitidos
    int errores; //Numero de errores cometidos 

    public Ahorcado() { //Metodo especial - constructor 
        palabras = new String []{ "programacion",
            "java",
            "computadora",
            "teclado",
            "internet",
            "variable",
            "funcion",
            "objeto",
            "clase",
            "constructor",
            "compilador",
            "algoritmo",
            "desarrollador",
            "interfaz",
            "depuracion"};

    }

    public void iniciar () {
        var r = new Random();
        palabraSecreta = palabras[r.nextInt(palabras.length)]; //interfaz

        var flag = "_";
        for (int a = 0; a < palabraSecreta.length(); a++){
            palabraTablero += flag; //-----
        }
    }
}
package com.adrian;

public class Condicionales {
    // 4. Crea un programa que diga si un número es par o impar.

    /**
     
Esto son el bloques*/
  int input = 12;

    public void esPar() {
        if (input % 2 == 0) {
            // Par
            System.out.println("Es par");
        } else {
            // Par'nt
            System.out.println("No es Par");
        }
    }
// Declara una variable con el día de la semana (1-7) y
    // muestra su nombre con switch.
    public static void diaSemana(int dia) {
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Sabado");
                break;
        }
    }

    // Comprueba si una cadena de texto contiene una palabra concreta.
    // 1500
    public boolean estaLaPalabra(String cadena,
            String palabra) {
        return cadena.contains(palabra);
    }

    // Muestra la longitud de una cadena de texto.
    public int longitudDeText(String cadena) {
        return cadena.length();
    }

    //Elimina los espacios en blanco al principio y 
    //final de un string.

    public String cadenaFormateada(String cadena) {
        var valor = cadena.trim();
        //System.out.println(cadena == valor);
        return valor;
    }



    //Dado 3 números verifica cual es le mayor usando
    // if - else.
    public int mayor(int a, int b, int c) {
        System.out.println("");
        if(a > b && a > c) {
            return a;
        } else if(b>a && b> c) {
            return b;
        }
        return c;
    }
}
Twidied — 11/11/25, 10:39
Imagen
Twidied — 20/11/25, 12:16
package com.diego.model;

import java.time.LocalDateTime;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private LocalDateTime horaIngreso;

    public Vehiculo(String placa, String modelo, LocalDateTime horaIngreso) {
        this.placa = placa;
        this.modelo = modelo;
        this.horaIngreso = horaIngreso;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }




}
Twidied — 20/11/25, 12:31
{
import java.time.LocalDateTime;

public class Carro extends Vehiculo {

    public Carro(String placa, String modelo, LocalDateTime horaIngreso) {
        super(placa, modelo, horaIngreso);
    }

}
Twidied — 16/12/25, 10:35
crediya_db
docker run --name crediya_db -e MYSQL_ROOT_PASSWORD=admin123 -p 3309:3306 -d mysql:8.4.3

docker exec -it crediya_db mysql -h localhost -u root -P 3306 -p 


CREATE DATABASE crediya_db;

USE crediya_db;
Dayana

 — 18/12/25, 16:43
taller herencia 

/ 1. Crea una clase Vehicle con un método move(). Luego crea una subclase Car que herede de Vehicle y agrega el método honk().

        // 2. Define una clase Person con los atributos name y age. Luego crea una clase Student que agregue el atributo grade y un método study().

        // 3. Crea una clase Animal con el método makeSound(). Haz que Dog diga “Woof” y Cat diga “Meow” sobrescribiendo ese método.

        // 4. La clase Employee tiene los atributos name y salary. Manager hereda de Employee y agrega el atributo department.

        // 5. Crea una clase abstracta Shape con un método calculateArea(). Luego implementa ese método en Circle y Rectangle.

        // 6. Crea una clase Bird con el método fly(). Luego crea Eagle que sobrescriba fly() pero también llame al método original con super.fly().

        // 7. Haz una clase Device con un constructor que imprima “Device created”. Luego crea Phone que herede de Device y en su constructor imprima “Phone ready”.

        // 8. Account tiene un saldo y métodos para deposit() y withdraw(). SavingsAccount hereda y agrega un método addInterest().

        // 9. Crea una clase Vehicle y tres subclases: Car, Bike y Truck, cada una con un método describe() sobrescrito.

        // 10. Crea un ArrayList<Animal> que contenga instancias de Dog, Cat y Bird. Recorre la lista y llama a makeSound().
Twidied — 18/12/25, 16:43
🔥
Gracias
Dayana

 — 18/12/25, 16:43
multihilos
# Taller - 🏃♂️  La Gran Carrera de Relevos Multihilo



**Objetivo:** Comprender el ciclo de vida de un hilo, la coordinación entre tareas dependientes (`join`) y la ejecución paralela de grupos independientes (Equipos) utilizando Java.

13. Taller - 🏃_♂️ La Gran Carrera de Relevos Multihilo.md
13 KB
falta el otro q no lo encuentro
Dayana

 — 7/1/26, 11:33
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class HelloWorldController {

    @GetMapping("/greetings")
    public String HelloWorld(){
        return "Hello Camper";
    }
}
Twidied — 7/1/26, 11:42
spring.application.name=firststep
spring.datasource.url=jdboth2 mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H20ialect
Dayana

 — 7/1/26, 11:57
<dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.40</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
</dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
Dayana

 — 7/1/26, 12:04
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.40</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webmvc-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>2.3.230</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
Twidied — 9/1/26, 11:29
Reenviado
https://github.com/AddsDev/firststep_hero
GitHub
GitHub - AddsDev/firststep_hero
Contribute to AddsDev/firststep_hero development by creating an account on GitHub.
GitHub - AddsDev/firststep_hero
Twidied — 19/1/26, 10:53
Imagen
Twidied — 23/1/26, 12:12
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.bkseducate</groupId>
    <artifactId>ddd-app</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>
    <modules>
        <module>domain</module>
        <module>application</module>
        <module>infrastructure</module>
    </modules>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring-boot.version>3.2.2</spring-boot.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
    <pluginManagement>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        <plugin>
        <groupId>io.takari</groupId>
        <artifactId>maven-wrapper-plugin</artifactId>
        <version>3.1.1</version>
        <executions>
            <execution>
            <goals>
                <goal>wrapper</goal>
            </goals>
            </execution>
        </executions>
        </plugin>
    </plugins>
    </pluginManagement>
</build>

</project>
Dayana

 — 30/1/26, 15:05
https://discord.gg/sNve4DM4
Twidied — 30/1/26, 16:06
https://www.istockphoto.com/photos
iStockPhoto.com
Royalty-Free Stock Photos | Stock Images & Pictures - iStock
Search iStock's expansive picture library to find the perfect images for your project. Cool stock photos you won't find anywhere else. Search now.
Imagen
https://www.istockphoto.com/photo/electric-wheel-grinding-on-steel-structure-in-factory-gm839900178-136733763
iStock
Electric wheel grinding on steel structure in factory. Sparks from...
Electric wheel grinding on steel structure in factory. Sparks from the grinding wheel
Electric wheel grinding on steel structure in factory. Sparks from...
Dayana

 — ayer a las 12:08
PASO 3: VISTAS DEL CLIENTE (más completas)

Aquí es donde se ve la experiencia de usuario 👀

Vistas necesarias:

📌 Explorar herramientas

Cards con:

Imagen

Precio

Disponibilidad

Botón “Alquilar”

📌 Detalle de herramienta

Imagen grande

Descripción

Precio

Calendario de fechas

Botón reservar

📌 Reserva

Selección fecha inicio / fin

Resumen del costo

Confirmar alquiler

📌 Historial de alquileres

Tabla:

Herramienta

Fecha

Estado

Factura (descargar)
Twidied — ayer a las 13:28
font-family: 'Orbitron', sans-serif;
Twidied — ayer a las 18:00
Imagen
Imagen
const inventario = [
    // --- ELÉCTRICAS (15) ---
    { id: 1, nombre: "Martillo Demoledor SDS Max", categoria: "ELÉCTRICAS", precio: "45.00", estado: "DISPONIBLE", desc: "Motor de 1500W, ideal para concreto duro.", specs: "13 Joules / 10kg", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 2, nombre: "Esmeril Angular 9\"", categoria: "ELÉCTRICAS", precio: "25.00", estado: "NO DISPONIBLE", desc: "Corte y desbaste industrial de metales.", specs: "6500 RPM / Disco 9\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 3, nombre: "Rotomartillo Industrial", categoria: "ELÉCTRICAS", precio: "35.00", estado: "DISPONIBLE", desc: "Perforación en piedra y concreto armado.", specs: "800W / 3 Modos de uso", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 4, nombre: "Sierra Circular de Banco", categoria: "ELÉCTRICAS", precio: "55.00", estado: "DISPONIBLE", desc: "Cortes de precisión en madera y tableros.", specs: "2000W / Hoja 10\"", img: "/src/main/resources/static/img/FOTOO.png" },

message.txt
15 KB
Twidied — 17:05
const inventario = [
    // --- ELÉCTRICAS (15) ---
    { id: 1, nombre: "Martillo Electroneumático SDS Max", categoria: "ELÉCTRICAS", precio: "185.00", estado: "DISPONIBLE", desc: "Mecanismo de impacto de alta energía para demolición estructural.", specs: "1500W / 13 Joules / Embrague de seguridad", img: "" },
    { id: 2, nombre: "Amoladora Angular Industrial 9\"", categoria: "ELÉCTRICAS", precio: "45.00", estado: "NO DISPONIBLE", desc: "Corte y desbaste de perfiles metálicos de gran calibre.", specs: "2200W / 6500 RPM / Arranque suave", img: "" },
    { id: 3, nombre: "Rotomartillo Combinado 3 Modos", categoria: "ELÉCTRICAS", precio: "65.00", estado: "DISPONIBLE", desc: "Perforación con rotación, percusión y cincelado neumático.", specs: "800W / Encastre SDS Plus / 3.2J", img: "" },
    { id: 4, nombre: "Sierra Ingleteadora Telescópica", categoria: "ELÉCTRICAS", precio: "120.00", estado: "DISPONIBLE", desc: "Cortes compuestos y biselados de alta precisión en madera.", specs: "Disco 12\" / 1800W / Brazo deslizable", img: "" },

message.txt
16 KB
﻿
Twidied
twidied
🫧
 
 
 
 
˚   ❕     ︵‿︵‿୨♡୧‿︵‿︵     ❕    ₊
    ⊹    ₊     ₊   @Twidied_   ₊     ₊    ⊹
const inventario = [
    // --- ELÉCTRICAS (15) ---
    { id: 1, nombre: "Martillo Electroneumático SDS Max", categoria: "ELÉCTRICAS", precio: "185.00", estado: "DISPONIBLE", desc: "Mecanismo de impacto de alta energía para demolición estructural.", specs: "1500W / 13 Joules / Embrague de seguridad", img: "" },
    { id: 2, nombre: "Amoladora Angular Industrial 9\"", categoria: "ELÉCTRICAS", precio: "45.00", estado: "NO DISPONIBLE", desc: "Corte y desbaste de perfiles metálicos de gran calibre.", specs: "2200W / 6500 RPM / Arranque suave", img: "" },
    { id: 3, nombre: "Rotomartillo Combinado 3 Modos", categoria: "ELÉCTRICAS", precio: "65.00", estado: "DISPONIBLE", desc: "Perforación con rotación, percusión y cincelado neumático.", specs: "800W / Encastre SDS Plus / 3.2J", img: "" },
    { id: 4, nombre: "Sierra Ingleteadora Telescópica", categoria: "ELÉCTRICAS", precio: "120.00", estado: "DISPONIBLE", desc: "Cortes compuestos y biselados de alta precisión en madera.", specs: "Disco 12\" / 1800W / Brazo deslizable", img: "" },
    { id: 5, nombre: "Taladro de Banco 16 Velocidades", categoria: "ELÉCTRICAS", precio: "85.00", estado: "DISPONIBLE", desc: "Perforación vertical estandarizada con ajuste de profundidad.", specs: "550W / Mandril 5/8\" / Mesa inclinable", img: "" },
    { id: 6, nombre: "Sierra Tronzadora de Metales", categoria: "ELÉCTRICAS", precio: "75.00", estado: "DISPONIBLE", desc: "Corte rápido de perfiles metálicos y tubería industrial.", specs: "2300W / Disco 14\" / Base de acero", img: "" },
    { id: 7, nombre: "Lijadora de Banda de Alta Capacidad", categoria: "ELÉCTRICAS", precio: "40.00", estado: "NO DISPONIBLE", desc: "Remoción agresiva de material en superficies de madera extensas.", specs: "900W / Bolsa recolectora / 75x533mm", img: "" },
    { id: 8, nombre: "Soldadora Inverter MMA/TIG", categoria: "ELÉCTRICAS", precio: "110.00", estado: "DISPONIBLE", desc: "Tecnología de arco estable para soldadura de precisión.", specs: "200 Amp / Pantalla digital / Bivoltaje", img: "" },
    { id: 9, nombre: "Generador Monofásico a Gasolina", categoria: "ELÉCTRICAS", precio: "210.00", estado: "DISPONIBLE", desc: "Suministro eléctrico portátil para herramientas en obra remota.", specs: "5500W Máx / Salidas 110V-220V / 13HP", img: "" },
    { id: 10, nombre: "Hidrolavadora de Alta Presión", categoria: "ELÉCTRICAS", precio: "95.00", estado: "DISPONIBLE", desc: "Limpieza industrial y remoción de concreto en encofrados.", specs: "2500 PSI / Motor de inducción / 3.0 GPM", img: "" },
    { id: 11, nombre: "Compresor de Aire Lubricado 50L", categoria: "ELÉCTRICAS", precio: "70.00", estado: "DISPONIBLE", desc: "Fuente de aire comprimido para sistemas neumáticos medianos.", specs: "2.5 HP / 115 PSI / Presostato automático", img: "" },
    { id: 12, nombre: "Router Fresador de Inmersión", categoria: "ELÉCTRICAS", precio: "55.00", estado: "DISPONIBLE", desc: "Perfilado, ranurado y decorado en carpintería profesional.", specs: "1200W / Pinza 1/4\" y 1/2\" / Control de velocidad", img: "" },
    { id: 13, nombre: "Cepillo de Banco Portátil", categoria: "ELÉCTRICAS", precio: "140.00", estado: "DISPONIBLE", desc: "Acepillado de tablas para lograr espesores exactos y planos.", specs: "1500W / Ancho máx 12\" / 2 cuchillas", img: "" },
    { id: 14, nombre: "Atornillador de Impacto Hex 1/4\"", categoria: "ELÉCTRICAS", precio: "45.00", estado: "NO DISPONIBLE", desc: "Fijación de tornillería estructural con alto torque sin esfuerzo.", specs: "18V / 180 Nm / Motor Brushless", img: "" },
    { id: 15, nombre: "Sopladora Industrial Aspiradora", categoria: "ELÉCTRICAS", precio: "30.00", estado: "DISPONIBLE", desc: "Limpieza de residuos ligeros y mantenimiento de tableros.", specs: "600W / 16000 RPM / Flujo de aire variable", img: "" },

    // --- MANUALES (15) ---
    { id: 16, nombre: "Llave de Torque Micrométrica 1/2\"", categoria: "MANUALES", precio: "35.00", estado: "DISPONIBLE", desc: "Ajuste controlado de pernos según especificación del fabricante.", specs: "30-150 Lb-ft / Acero Cromo Vanadio", img: "" },
    { id: 17, nombre: "Cizalla Cortapernos de Articulación", categoria: "MANUALES", precio: "25.00", estado: "DISPONIBLE", desc: "Corte de varilla lisa y cadena de acero templado.", specs: "36 Pulgadas / Cuchillas de acero forjado", img: "" },
    { id: 18, nombre: "Prensa de Banco para Mecánica", categoria: "MANUALES", precio: "20.00", estado: "DISPONIBLE", desc: "Sujeción de piezas metálicas para limado o corte.", specs: "Base giratoria / 6 Pulgadas / Hierro gris", img: "" },
    { id: 19, nombre: "Juego de Dados Estriados 1/2\"", categoria: "MANUALES", precio: "30.00", estado: "DISPONIBLE", desc: "Set de copas mecánicas para aplicaciones de alto esfuerzo.", specs: "40 Piezas / Ratchet de 72 dientes", img: "" },
    { id: 20, nombre: "Gato Hidráulico de Botella", categoria: "MANUALES", precio: "28.00", estado: "NO DISPONIBLE", desc: "Elevación vertical de cargas pesadas y maquinaria.", specs: "Capacidad 10 Toneladas / Base de acero", img: "" },
    { id: 21, nombre: "Doblador de Tubo Conduit", categoria: "MANUALES", precio: "18.00", estado: "DISPONIBLE", desc: "Curvado manual de tubería para instalaciones eléctricas.", specs: "Para 1/2\" y 3/4\" / Hierro maleable", img: "" },
    { id: 22, nombre: "Remachadora de Acordeón", categoria: "MANUALES", precio: "22.00", estado: "DISPONIBLE", desc: "Fijación de remaches de gran diámetro con menor esfuerzo físico.", specs: "Sistema extensible / 5 Boquillas", img: "" },
    { id: 23, nombre: "Maza de Demolición Octagonal", categoria: "MANUALES", precio: "15.00", estado: "DISPONIBLE", desc: "Impacto manual de alta energía para derribo de muros.", specs: "8 Lb / Mango de fibra de vidrio", img: "" },
    { id: 24, nombre: "Nivel de Perfil Magnético", categoria: "MANUALES", precio: "12.00", estado: "DISPONIBLE", desc: "Verificación de plomada y nivelación en estructuras metálicas.", specs: "48 Pulgadas / 3 Gotas / Cuerpo de Aluminio", img: "" },
    { id: 25, nombre: "Alicate de Presión Boca Curva", categoria: "MANUALES", precio: "10.00", estado: "DISPONIBLE", desc: "Sujeción de piezas circulares o pernos barridos.", specs: "10 Pulgadas / Ajuste rápido", img: "" },
    { id: 26, nombre: "Pala de Punta Carbonera", categoria: "MANUALES", precio: "12.00", estado: "DISPONIBLE", desc: "Movimiento de áridos, gravilla y mezcla de concreto.", specs: "Acero al boro / Mango con empuñadura Y", img: "" },
    { id: 27, nombre: "Pico de Excavación con Ojo Reforzado", categoria: "MANUALES", precio: "14.00", estado: "DISPONIBLE", desc: "Apertura de zanjas en suelos compactos y pedregosos.", specs: "5 Lb / Punta y hacha / Mango de madera tratada", img: "" },
    { id: 28, nombre: "Serrucho de Costilla para Ingletes", categoria: "MANUALES", precio: "11.00", estado: "NO DISPONIBLE", desc: "Cortes rectos y precisos en carpintería de ensamble.", specs: "12 Pulgadas / Dientes templados", img: "" },
    { id: 29, nombre: "Cortadora de Vidrio de Lubricación", categoria: "MANUALES", precio: "20.00", estado: "DISPONIBLE", desc: "Corte técnico de cristales con sistema de depósito de aceite.", specs: "Mango metálico / Cuchilla de carburo", img: "" },
    { id: 30, nombre: "Extractor de Poleas de 3 Brazos", categoria: "MANUALES", precio: "24.00", estado: "DISPONIBLE", desc: "Desmontaje de rodamientos y poleas sin dañar el eje.", specs: "6 Pulgadas / Acero forjado cromado", img: "" },

    // --- CONSTRUCCIÓN (15) ---
    { id: 31, nombre: "Mezcladora de Concreto Basculante", categoria: "CONSTRUCCIÓN", precio: "155.00", estado: "DISPONIBLE", desc: "Producción de concreto homogéneo para fundiciones pequeñas.", specs: "1 Bulto (250L) / Motor 2.5 HP Gasolina", img: "" },
    { id: 32, nombre: "Vibrador de Inmersión para Concreto", categoria: "CONSTRUCCIÓN", precio: "70.00", estado: "DISPONIBLE", desc: "Eliminación de vacíos y aire atrapado en estructuras de concreto.", specs: "Motor 2 HP / Chicote de 4 metros", img: "" },
    { id: 33, nombre: "Apisonador de Impacto (Bailarina)", categoria: "CONSTRUCCIÓN", precio: "195.00", estado: "NO DISPONIBLE", desc: "Compactación de suelos granulares y arcillosos en zanjas.", specs: "Impacto 14kN / Motor 4 Tiempos", img: "" },
    { id: 34, nombre: "Plancha Compactadora Vibratoria", categoria: "CONSTRUCCIÓN", precio: "160.00", estado: "DISPONIBLE", desc: "Nivelación y compactación de bases para adoquín o asfalto.", specs: "Fuerza 15kN / Tanque de agua para asfalto", img: "" },
    { id: 35, nombre: "Allanadora de Concreto (Helicóptero)", categoria: "CONSTRUCCIÓN", precio: "225.00", estado: "DISPONIBLE", desc: "Acabado pulido de losas de concreto de gran extensión.", specs: "36 Pulgadas / 4 Aspas / Motor 5.5 HP", img: "" },
    { id: 36, nombre: "Nivel Óptico Automático", categoria: "CONSTRUCCIÓN", precio: "90.00", estado: "DISPONIBLE", desc: "Medición de desniveles y transferencia de cotas en obra.", specs: "32x Aumentos / Desviación 1.0mm", img: "" },
    { id: 37, nombre: "Regla Vibratoria de Superficie", categoria: "CONSTRUCCIÓN", precio: "135.00", estado: "NO DISPONIBLE", desc: "Distribución y nivelado de concreto fresco en losas.", specs: "Largo 3m / Perfil de Aluminio / Motor 1.5 HP", img: "" },
    { id: 38, nombre: "Bomba Sumergible para Lodos", categoria: "CONSTRUCCIÓN", precio: "115.00", estado: "DISPONIBLE", desc: "Drenaje de aguas cargadas en excavaciones inundadas.", specs: "2 HP / Descarga 3\" / Paso de sólidos", img: "" },
    { id: 39, nombre: "Cortadora de Ladrillo y Bloque", categoria: "CONSTRUCCIÓN", precio: "145.00", estado: "DISPONIBLE", desc: "Corte en húmedo de materiales cerámicos y piedra.", specs: "Disco 14\" / Mesa deslizante / Motor Eléctrico", img: "" },
    { id: 40, nombre: "Winche Eléctrico de Elevación", categoria: "CONSTRUCCIÓN", precio: "130.00", estado: "DISPONIBLE", desc: "Izaje vertical de materiales y suministros de obra.", specs: "500kg Capacidad / Cable 30m / Control", img: "" },
    { id: 41, nombre: "Taladro de Diamante (Saca-núcleos)", categoria: "CONSTRUCCIÓN", precio: "260.00", estado: "DISPONIBLE", desc: "Perforación de núcleos en concreto armado para tuberías.", specs: "Hasta 6\" de diámetro / Refrigerado por agua", img: "" },
    { id: 42, nombre: "Dobladora Hidráulica de Varilla", categoria: "CONSTRUCCIÓN", precio: "140.00", estado: "DISPONIBLE", desc: "Formado de estribos y dobleces en acero de refuerzo.", specs: "Capacidad hasta 1 1/4\" / Manual-Hidráulica", img: "" },
    { id: 43, nombre: "Carretilla Tipo Buggy Reforzada", categoria: "CONSTRUCCIÓN", precio: "25.00", estado: "DISPONIBLE", desc: "Transporte manual de mezcla y escombros en condiciones difíciles.", specs: "Cuchara de 6ft³ / Llanta antipinchazos", img: "" },
    { id: 44, nombre: "Pistola de Fijación por Pólvora", categoria: "CONSTRUCCIÓN", precio: "70.00", estado: "NO DISPONIBLE", desc: "Anclaje directo de pernos en acero y concreto sólido.", specs: "Calibre .22 / Semiautomática / Baja velocidad", img: "" },
    { id: 45, nombre: "Andamio Tubular con Escalera", categoria: "CONSTRUCCIÓN", precio: "35.00", estado: "DISPONIBLE", desc: "Estructura modular para trabajos en altura segura.", specs: "Cuerpo 2x1.5m / Acero galvanizado", img: "" },

    // --- SEGURIDAD (15) ---
    { id: 46, nombre: "Arnés de Seguridad Multipropósito", categoria: "SEGURIDAD", precio: "18.00", estado: "DISPONIBLE", desc: "Sistema de protección anticaídas de cuerpo completo.", specs: "4 Puntos de anclaje / Norma ANSI Z359", img: "" },
    { id: 47, nombre: "Detector de Gases Atmosférico", categoria: "SEGURIDAD", precio: "110.00", estado: "DISPONIBLE", desc: "Monitoreo de niveles de oxígeno y gases tóxicos.", specs: "4 Vías (O2, LEL, CO, H2S) / Alarma sonora", img: "" },
    { id: 48, nombre: "Línea de Vida Retráctil de Acero", categoria: "SEGURIDAD", precio: "65.00", estado: "DISPONIBLE", desc: "Dispositivo de detención de caídas con bloqueo automático.", specs: "Longitud 10m / Cable de acero galvanizado", img: "" },
    { id: 49, nombre: "Trípode de Rescate y Acceso", categoria: "SEGURIDAD", precio: "150.00", estado: "NO DISPONIBLE", desc: "Sistema de anclaje móvil para espacios confinados.", specs: "Altura ajustable / Incluye winche de rescate", img: "" },
    { id: 50, nombre: "Careta de Soldar Fotosensible", categoria: "SEGURIDAD", precio: "20.00", estado: "DISPONIBLE", desc: "Protección ocular con oscurecimiento automático.", specs: "Sombra 9-13 / Celdas solares / Ajuste de sensibilidad", img: "" },
    { id: 51, nombre: "Detector de Voltaje Sin Contacto", categoria: "SEGURIDAD", precio: "12.00", estado: "DISPONIBLE", desc: "Verificación de seguridad en líneas eléctricas activas.", specs: "Rango 90V-1000V / Alerta LED y sonido", img: "" },
    { id: 52, nombre: "Escalera de Extensión Dieléctrica", categoria: "SEGURIDAD", precio: "55.00", estado: "DISPONIBLE", desc: "Acceso a alturas en trabajos con riesgo eléctrico.", specs: "24 Pies / Fibra de Vidrio / Peldaños planos", img: "" },
    { id: 53, nombre: "Kit de Bloqueo LOTO Industrial", categoria: "SEGURIDAD", precio: "45.00", estado: "DISPONIBLE", desc: "Aislamiento de energías peligrosas durante mantenimiento.", specs: "Candados, pinzas y etiquetas de advertencia", img: "" },
    { id: 54, nombre: "Extintor de Polvo Químico Seco 20lb", categoria: "SEGURIDAD", precio: "22.00", estado: "DISPONIBLE", desc: "Equipo de extinción de incendios clase ABC.", specs: "Carga de PQS / Manómetro de presión", img: "" },
    { id: 55, nombre: "Extractor Axial Portátil con Ducto", categoria: "SEGURIDAD", precio: "85.00", estado: "DISPONIBLE", desc: "Ventilación forzada y remoción de humos de soldadura.", specs: "12 Pulgadas / Incluye manguera de 5m", img: "" },
    { id: 56, nombre: "Espejo de Inspección Bajo Vehículos", categoria: "SEGURIDAD", precio: "25.00", estado: "DISPONIBLE", desc: "Revisión de seguridad y búsqueda en partes inferiores.", specs: "Mango telescópico / Iluminación LED", img: "" },
    { id: 57, nombre: "Barrera Extensible de Seguridad", categoria: "SEGURIDAD", precio: "30.00", estado: "NO DISPONIBLE", desc: "Delimitación temporal de áreas restringidas.", specs: "PVC de alta visibilidad / 3 metros extendida", img: "" },
    { id: 58, nombre: "Lámpara de Emergencia Industrial", categoria: "SEGURIDAD", precio: "28.00", estado: "DISPONIBLE", desc: "Iluminación de respaldo ante fallos eléctricos.", specs: "Doble faro LED / Autonomía 4 horas", img: "" },
    { id: 59, nombre: "Conos de Señalización Vial (Kit)", categoria: "SEGURIDAD", precio: "15.00", estado: "DISPONIBLE", desc: "Señalización de obras en vía pública o almacenes.", specs: "70cm de alto / Base pesada / Reflectivo", img: "" },
    { id: 60, nombre: "Botiquín de Primeros Auxilios Tipo B", categoria: "SEGURIDAD", precio: "35.00", estado: "DISPONIBLE", desc: "Dotación reglamentaria para atención de emergencias.", specs: "Gabinete metálico / Cumple normativa industrial", img: "" }
];
message.txt
16 KB

    const grid = document.getElementById('tools-grid');
    const filterSelect = document.getElementById('category-filter');

    // --- 2. FUNCIÓN PARA OBTENER IMAGEN (Placeholder Seguro) ---
    function obtenerUrlImagen(nombreTool) {
        // MODO 1: Placeholder Seguro (Carga instantánea)
        return "https://via.placeholder.com/300x200.png?text=ToolsX";

        // MODO 2: Imágenes Reales (Descomenta la línea de abajo cuando tengas tus imágenes en /img/)
        // return `/src/main/resources/static/img/${nombreTool.toLowerCase().replace(/ /g, "_")}.jpg`;
    }

    // --- 3. RENDERIZADO DE TARJETAS ---
    function renderTools(toolsToRender) {
        if (!grid) return;
        grid.innerHTML = ''; 

        toolsToRender.forEach(tool => {
            const card = document.createElement('div');
            card.className = 'card';
            
            const statusClass = tool.estado === 'DISPONIBLE' ? 'status-available' : 'status-unavailable';
            
            // Obtenemos la URL de la imagen (placeholder por ahora)
            const imageUrl = obtenerUrlImagen(tool.nombre);

            card.innerHTML = `
                <div class="card-img-container">
                    <img src="${imageUrl}" alt="${tool.nombre}" class="card-img">
                </div>
                <div class="card-status ${statusClass}">${tool.estado}</div>
                <h3 class="card-title">${tool.nombre}</h3>
                <p class="card-specs">${tool.specs}</p>
                <p class="card-desc">${tool.desc}</p>
                <p class="card-price">$${tool.precio}</p>
            `;
            
            grid.appendChild(card);
        });
    }

    // --- 4. LÓGICA DE FILTRADO ---
    if (filterSelect) {
        filterSelect.addEventListener('change', function() {
            const selectedCategory = this.value;
            
            if (selectedCategory === 'ALL') {
                renderTools(inventario); 
            } else {
                const filteredTools = inventario.filter(tool => tool.categoria === selectedCategory);
                renderTools(filteredTools);
            }
        });
    }

    // --- 5. CARGA INICIAL ---
    renderTools(inventario);
});