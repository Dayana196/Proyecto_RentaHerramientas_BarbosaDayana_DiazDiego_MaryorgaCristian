document.addEventListener("DOMContentLoaded", function () {

    // --- 1. DATOS DEL INVENTARIO (60 herramientas) ---
    // NOTA: Asegúrate de poner la ruta correcta en la propiedad 'img' de cada objeto.
    const inventario = [
        // --- ELÉCTRICAS (15) ---
        { id: 1, nombre: "Martillo Electroneumático SDS Max", categoria: "ELÉCTRICAS", precio: "185.00", estado: "DISPONIBLE", desc: "Mecanismo de impacto de alta energía para demolición estructural.", specs: "1500W / 13 Joules / Embrague de seguridad", img: "/src/main/resources/static/img/martillo_sds.jpg" },
        { id: 2, nombre: "Amoladora Angular Industrial 9\"", categoria: "ELÉCTRICAS", precio: "45.00", estado: "NO DISPONIBLE", desc: "Corte y desbaste de perfiles metálicos de gran calibre.", specs: "2200W / 6500 RPM / Arranque suave", img: "/src/main/resources/static/img/amoladora9.jpg" },
        { id: 3, nombre: "Rotomartillo Combinado 3 Modos", categoria: "ELÉCTRICAS", precio: "65.00", estado: "DISPONIBLE", desc: "Perforación con rotación, percusión y cincelado neumático.", specs: "800W / Encastre SDS Plus / 3.2J", img: "/src/main/resources/static/img/rotomartillo3.jpg" },
        { id: 4, nombre: "Sierra Ingleteadora Telescópica", categoria: "ELÉCTRICAS", precio: "120.00", estado: "DISPONIBLE", desc: "Cortes compuestos y biselados de alta precisión en madera.", specs: "Disco 12\" / 1800W / Brazo deslizable", img: "/src/main/resources/static/img/ingleteadora.jpg" },
        { id: 5, nombre: "Taladro de Banco 16 Velocidades", categoria: "ELÉCTRICAS", precio: "85.00", estado: "DISPONIBLE", desc: "Perforación vertical estandarizada con ajuste de profundidad.", specs: "550W / Mandril 5/8\" / Mesa inclinable", img: "/src/main/resources/static/img/taladro_banco.jpg" },
        { id: 6, nombre: "Sierra Tronzadora de Metales", categoria: "ELÉCTRICAS", precio: "75.00", estado: "DISPONIBLE", desc: "Corte rápido de perfiles metálicos y tubería industrial.", specs: "2300W / Disco 14\" / Base de acero", img: "/src/main/resources/static/img/tronzadora.jpg" },
        { id: 7, nombre: "Lijadora de Banda de Alta Capacidad", categoria: "ELÉCTRICAS", precio: "40.00", estado: "NO DISPONIBLE", desc: "Remoción agresiva de material en superficies de madera extensas.", specs: "900W / Bolsa recolectora / 75x533mm", img: "/src/main/resources/static/img/lijadora_banda.jpg" },
        { id: 8, nombre: "Soldadora Inverter MMA/TIG", categoria: "ELÉCTRICAS", precio: "110.00", estado: "DISPONIBLE", desc: "Tecnología de arco estable para soldadura de precisión.", specs: "200 Amp / Pantalla digital / Bivoltaje", img: "/src/main/resources/static/img/soldadora.jpg" },
        { id: 9, nombre: "Generador Monofásico a Gasolina", categoria: "ELÉCTRICAS", precio: "210.00", estado: "DISPONIBLE", desc: "Suministro eléctrico portátil para herramientas en obra remota.", specs: "5500W Máx / Salidas 110V-220V / 13HP", img: "/src/main/resources/static/img/generador.jpg" },
        { id: 10, nombre: "Hidrolavadora de Alta Presión", categoria: "ELÉCTRICAS", precio: "95.00", estado: "DISPONIBLE", desc: "Limpieza industrial y remoción de concreto en encofrados.", specs: "2500 PSI / Motor de inducción / 3.0 GPM", img: "/src/main/resources/static/img/hidrolavadora.jpg" },
        { id: 11, nombre: "Compresor de Aire Lubricado 50L", categoria: "ELÉCTRICAS", precio: "70.00", estado: "DISPONIBLE", desc: "Fuente de aire comprimido para sistemas neumáticos medianos.", specs: "2.5 HP / 115 PSI / Presostato automático", img: "/src/main/resources/static/img/compresor50l.jpg" },
        { id: 12, nombre: "Router Fresador de Inmersión", categoria: "ELÉCTRICAS", precio: "55.00", estado: "DISPONIBLE", desc: "Perfilado, ranurado y decorado en carpintería profesional.", specs: "1200W / Pinza 1/4\" y 1/2\" / Control de velocidad", img: "/src/main/resources/static/img/router.jpg" },
        { id: 13, nombre: "Cepillo de Banco Portátil", categoria: "ELÉCTRICAS", precio: "140.00", estado: "DISPONIBLE", desc: "Acepillado de tablas para lograr espesores exactos y planos.", specs: "1500W / Ancho máx 12\" / 2 cuchillas", img: "/src/main/resources/static/img/cepillo_banco.jpg" },
        { id: 14, nombre: "Atornillador de Impacto Hex 1/4\"", categoria: "ELÉCTRICAS", precio: "45.00", estado: "NO DISPONIBLE", desc: "Fijación de tornillería estructural con alto torque sin esfuerzo.", specs: "18V / 180 Nm / Motor Brushless", img: "/src/main/resources/static/img/atornillador_impacto.jpg" },
        { id: 15, nombre: "Sopladora Industrial Aspiradora", categoria: "ELÉCTRICAS", precio: "30.00", estado: "DISPONIBLE", desc: "Limpieza de residuos ligeros y mantenimiento de tableros.", specs: "600W / 16000 RPM / Flujo de aire variable", img: "/src/main/resources/static/img/sopladora.jpg" },

        // --- MANUALES (15) ---
        { id: 16, nombre: "Llave de Torque Micrométrica 1/2\"", categoria: "MANUALES", precio: "35.00", estado: "DISPONIBLE", desc: "Ajuste controlado de pernos según especificación del fabricante.", specs: "30-150 Lb-ft / Acero Cromo Vanadio", img: "/src/main/resources/static/img/llave_torque.jpg" },
        { id: 17, nombre: "Cizalla Cortapernos de Articulación", categoria: "MANUALES", precio: "25.00", estado: "DISPONIBLE", desc: "Corte de varilla lisa y cadena de acero templado.", specs: "36 Pulgadas / Cuchillas de acero forjado", img: "/src/main/resources/static/img/cizalla.jpg" },
        { id: 18, nombre: "Prensa de Banco para Mecánica", categoria: "MANUALES", precio: "20.00", estado: "DISPONIBLE", desc: "Sujeción de piezas metálicas para limado o corte.", specs: "Base giratoria / 6 Pulgadas / Hierro gris", img: "/src/main/resources/static/img/prensa_banco.jpg" },
        { id: 19, nombre: "Juego de Dados Estriados 1/2\"", categoria: "MANUALES", precio: "30.00", estado: "DISPONIBLE", desc: "Set de copas mecánicas para aplicaciones de alto esfuerzo.", specs: "40 Piezas / Ratchet de 72 dientes", img: "/src/main/resources/static/img/juego_dados.jpg" },
        { id: 20, nombre: "Gato Hidráulico de Botella", categoria: "MANUALES", precio: "28.00", estado: "NO DISPONIBLE", desc: "Elevación vertical de cargas pesadas y maquinaria.", specs: "Capacidad 10 Toneladas / Base de acero", img: "/src/main/resources/static/img/gato_botella.jpg" },
        { id: 21, nombre: "Doblador de Tubo Conduit", categoria: "MANUALES", precio: "18.00", estado: "DISPONIBLE", desc: "Curvado manual de tubería para instalaciones eléctricas.", specs: "Para 1/2\" y 3/4\" / Hierro maleable", img: "/src/main/resources/static/img/doblador_tubo.jpg" },
        { id: 22, nombre: "Remachadora de Acordeón", categoria: "MANUALES", precio: "22.00", estado: "DISPONIBLE", desc: "Fijación de remaches de gran diámetro con menor esfuerzo físico.", specs: "Sistema extensible / 5 Boquillas", img: "/src/main/resources/static/img/remachadora.jpg" },
        { id: 23, nombre: "Maza de Demolición Octagonal", categoria: "MANUALES", precio: "15.00", estado: "DISPONIBLE", desc: "Impacto manual de alta energía para derribo de muros.", specs: "8 Lb / Mango de fibra de vidrio", img: "/src/main/resources/static/img/maza.jpg" },
        { id: 24, nombre: "Nivel de Perfil Magnético", categoria: "MANUALES", precio: "12.00", estado: "DISPONIBLE", desc: "Verificación de plomada y nivelación en estructuras metálicas.", specs: "48 Pulgadas / 3 Gotas / Cuerpo de Aluminio", img: "/src/main/resources/static/img/nivel.jpg" },
        { id: 25, nombre: "Alicate de Presión Boca Curva", categoria: "MANUALES", precio: "10.00", estado: "DISPONIBLE", desc: "Sujeción de piezas circulares o pernos barridos.", specs: "10 Pulgadas / Ajuste rápido", img: "/src/main/resources/static/img/alicate_presion.jpg" },
        { id: 26, nombre: "Pala de Punta Carbonera", categoria: "MANUALES", precio: "12.00", estado: "DISPONIBLE", desc: "Movimiento de áridos, gravilla y mezcla de concreto.", specs: "Acero al boro / Mango con empuñadura Y", img: "/src/main/resources/static/img/pala.jpg" },
        { id: 27, nombre: "Pico de Excavación con Ojo Reforzado", categoria: "MANUALES", precio: "14.00", estado: "DISPONIBLE", desc: "Apertura de zanjas en suelos compactos y pedregosos.", specs: "5 Lb / Punta y hacha / Mango de madera tratada", img: "/src/main/resources/static/img/pico.jpg" },
        { id: 28, nombre: "Serrucho de Costilla para Ingletes", categoria: "MANUALES", precio: "11.00", estado: "NO DISPONIBLE", desc: "Cortes rectos y precisos en carpintería de ensamble.", specs: "12 Pulgadas / Dientes templados", img: "/src/main/resources/static/img/serrucho.jpg" },
        { id: 29, nombre: "Cortadora de Vidrio de Lubricación", categoria: "MANUALES", precio: "20.00", estado: "DISPONIBLE", desc: "Corte técnico de cristales con sistema de depósito de aceite.", specs: "Mango metálico / Cuchilla de carburo", img: "/src/main/resources/static/img/cortadora_vidrio.jpg" },
        { id: 30, nombre: "Extractor de Poleas de 3 Brazos", categoria: "MANUALES", precio: "24.00", estado: "DISPONIBLE", desc: "Desmontaje de rodamientos y poleas sin dañar el eje.", specs: "6 Pulgadas / Acero forjado cromado", img: "/src/main/resources/static/img/extractor.jpg" },

        // --- CONSTRUCCIÓN (15) ---
        { id: 31, nombre: "Mezcladora de Concreto Basculante", categoria: "CONSTRUCCIÓN", precio: "155.00", estado: "DISPONIBLE", desc: "Producción de concreto homogéneo para fundiciones pequeñas.", specs: "1 Bulto (250L) / Motor 2.5 HP Gasolina", img: "/src/main/resources/static/img/mezcladora.jpg" },
        { id: 32, nombre: "Vibrador de Inmersión para Concreto", categoria: "CONSTRUCCIÓN", precio: "70.00", estado: "DISPONIBLE", desc: "Eliminación de vacíos y aire atrapado en estructuras de concreto.", specs: "Motor 2 HP / Chicote de 4 metros", img: "/src/main/resources/static/img/vibrador.jpg" },
        { id: 33, nombre: "Apisonador de Impacto (Bailarina)", categoria: "CONSTRUCCIÓN", precio: "195.00", estado: "NO DISPONIBLE", desc: "Compactación de suelos granulares y arcillosos en zanjas.", specs: "Impacto 14kN / Motor 4 Tiempos", img: "/src/main/resources/static/img/bailarina.jpg" },
        { id: 34, nombre: "Plancha Compactadora Vibratoria", categoria: "CONSTRUCCIÓN", precio: "160.00", estado: "DISPONIBLE", desc: "Nivelación y compactación de bases para adoquín o asfalto.", specs: "Fuerza 15kN / Tanque de agua para asfalto", img: "/src/main/resources/static/img/plancha_compactadora.jpg" },
        { id: 35, nombre: "Allanadora de Concreto (Helicóptero)", categoria: "CONSTRUCCIÓN", precio: "225.00", estado: "DISPONIBLE", desc: "Acabado pulido de losas de concreto de gran extensión.", specs: "36 Pulgadas / 4 Aspas / Motor 5.5 HP", img: "/src/main/resources/static/img/allanadora.jpg" },
        { id: 36, nombre: "Nivel Óptico Automático", categoria: "CONSTRUCCIÓN", precio: "90.00", estado: "DISPONIBLE", desc: "Medición de desniveles y transferencia de cotas en obra.", specs: "32x Aumentos / Desviación 1.0mm", img: "/src/main/resources/static/img/nivel_optico.jpg" },
        { id: 37, nombre: "Regla Vibratoria de Superficie", categoria: "CONSTRUCCIÓN", precio: "135.00", estado: "NO DISPONIBLE", desc: "Distribución y nivelado de concreto fresco en losas.", specs: "Largo 3m / Perfil de Aluminio / Motor 1.5 HP", img: "/src/main/resources/static/img/regla_vibratoria.jpg" },
        { id: 38, nombre: "Bomba Sumergible para Lodos", categoria: "CONSTRUCCIÓN", precio: "115.00", estado: "DISPONIBLE", desc: "Drenaje de aguas cargadas en excavaciones inundadas.", specs: "2 HP / Descarga 3\" / Paso de sólidos", img: "/src/main/resources/static/img/bomba_sumergible.jpg" },
        { id: 39, nombre: "Cortadora de Ladrillo y Bloque", categoria: "CONSTRUCCIÓN", precio: "145.00", estado: "DISPONIBLE", desc: "Corte en húmedo de materiales cerámicos y piedra.", specs: "Disco 14\" / Mesa deslizante / Motor Eléctrico", img: "/src/main/resources/static/img/cortadora_ladrillo.jpg" },
        { id: 40, nombre: "Winche Eléctrico de Elevación", categoria: "CONSTRUCCIÓN", precio: "130.00", estado: "DISPONIBLE", desc: "Izaje vertical de materiales y suministros de obra.", specs: "500kg Capacidad / Cable 30m / Control", img: "/src/main/resources/static/img/winche.jpg" },
        { id: 41, nombre: "Taladro de Diamante (Saca-núcleos)", categoria: "CONSTRUCCIÓN", precio: "260.00", estado: "DISPONIBLE", desc: "Perforación de núcleos en concreto armado para tuberías.", specs: "Hasta 6\" de diámetro / Refrigerado por agua", img: "/src/main/resources/static/img/taladro_diamante.jpg" },
        { id: 42, nombre: "Dobladora Hidráulica de Varilla", categoria: "CONSTRUCCIÓN", precio: "140.00", estado: "DISPONIBLE", desc: "Formado de estribos y dobleces en acero de refuerzo.", specs: "Capacidad hasta 1 1/4\" / Manual-Hidráulica", img: "/src/main/resources/static/img/dobladora_varilla.jpg" },
        { id: 43, nombre: "Carretilla Tipo Buggy Reforzada", categoria: "CONSTRUCCIÓN", precio: "25.00", estado: "DISPONIBLE", desc: "Transporte manual de mezcla y escombros en condiciones difíciles.", specs: "Cuchara de 6ft³ / Llanta antipinchazos", img: "/src/main/resources/static/img/carretilla.jpg" },
        { id: 44, nombre: "Pistola de Fijación por Pólvora", categoria: "CONSTRUCCIÓN", precio: "70.00", estado: "NO DISPONIBLE", desc: "Anclaje directo de pernos en acero y concreto sólido.", specs: "Calibre .22 / Semiautomática / Baja velocidad", img: "/src/main/resources/static/img/pistola_polvora.jpg" },
        { id: 45, nombre: "Andamio Tubular con Escalera", categoria: "CONSTRUCCIÓN", precio: "35.00", estado: "DISPONIBLE", desc: "Estructura modular para trabajos en altura segura.", specs: "Cuerpo 2x1.5m / Acero galvanizado", img: "/src/main/resources/static/img/andamio.jpg" },

        // --- SEGURIDAD (15) ---
        { id: 46, nombre: "Arnés de Seguridad Multipropósito", categoria: "SEGURIDAD", precio: "18.00", estado: "DISPONIBLE", desc: "Sistema de protección anticaídas de cuerpo completo.", specs: "4 Puntos de anclaje / Norma ANSI Z359", img: "/src/main/resources/static/img/arnes.jpg" },
        { id: 47, nombre: "Detector de Gases Atmosférico", categoria: "SEGURIDAD", precio: "110.00", estado: "DISPONIBLE", desc: "Monitoreo de niveles de oxígeno y gases tóxicos.", specs: "4 Vías (O2, LEL, CO, H2S) / Alarma sonora", img: "/src/main/resources/static/img/detector_gases.jpg" },
        { id: 48, nombre: "Línea de Vida Retráctil de Acero", categoria: "SEGURIDAD", precio: "65.00", estado: "DISPONIBLE", desc: "Dispositivo de detención de caídas con bloqueo automático.", specs: "Longitud 10m / Cable de acero galvanizado", img: "/src/main/resources/static/img/linea_vida.jpg" },
        { id: 49, nombre: "Trípode de Rescate y Acceso", categoria: "SEGURIDAD", precio: "150.00", estado: "NO DISPONIBLE", desc: "Sistema de anclaje móvil para espacios confinados.", specs: "Altura ajustable / Incluye winche de rescate", img: "/src/main/resources/static/img/tripode.jpg" },
        { id: 50, nombre: "Careta de Soldar Fotosensible", categoria: "SEGURIDAD", precio: "20.00", estado: "DISPONIBLE", desc: "Protección ocular con oscurecimiento automático.", specs: "Sombra 9-13 / Celdas solares / Ajuste de sensibilidad", img: "/src/main/resources/static/img/careta.jpg" },
        { id: 51, nombre: "Detector de Voltaje Sin Contacto", categoria: "SEGURIDAD", precio: "12.00", estado: "DISPONIBLE", desc: "Verificación de seguridad en líneas eléctricas activas.", specs: "Rango 90V-1000V / Alerta LED y sonido", img: "/src/main/resources/static/img/detector_voltaje.jpg" },
        { id: 52, nombre: "Escalera de Extensión Dieléctrica", categoria: "SEGURIDAD", precio: "55.00", estado: "DISPONIBLE", desc: "Acceso a alturas en trabajos con riesgo eléctrico.", specs: "24 Pies / Fibra de Vidrio / Peldaños planos", img: "/src/main/resources/static/img/escalera.jpg" },
        { id: 53, nombre: "Kit de Bloqueo LOTO Industrial", categoria: "SEGURIDAD", precio: "45.00", estado: "DISPONIBLE", desc: "Aislamiento de energías peligrosas durante mantenimiento.", specs: "Candados, pinzas y etiquetas de advertencia", img: "/src/main/resources/static/img/kit_loto.jpg" },
        { id: 54, nombre: "Extintor de Polvo Químico Seco 20lb", categoria: "SEGURIDAD", precio: "22.00", estado: "DISPONIBLE", desc: "Equipo de extinción de incendios clase ABC.", specs: "Carga de PQS / Manómetro de presión", img: "/src/main/resources/static/img/extintor.jpg" },
        { id: 55, nombre: "Extractor Axial Portátil con Ducto", categoria: "SEGURIDAD", precio: "85.00", estado: "DISPONIBLE", desc: "Ventilación forzada y remoción de humos de soldadura.", specs: "12 Pulgadas / Incluye manguera de 5m", img: "/src/main/resources/static/img/extractor_axial.jpg" },
        { id: 56, nombre: "Espejo de Inspección Bajo Vehículos", categoria: "SEGURIDAD", precio: "25.00", estado: "DISPONIBLE", desc: "Revisión de seguridad y búsqueda en partes inferiores.", specs: "Mango telescópico / Iluminación LED", img: "/src/main/resources/static/img/espejo_inspeccion.jpg" },
        { id: 57, nombre: "Barrera Extensible de Seguridad", categoria: "SEGURIDAD", precio: "30.00", estado: "NO DISPONIBLE", desc: "Delimitación temporal de áreas restringidas.", specs: "PVC de alta visibilidad / 3 metros extendida", img: "/src/main/resources/static/img/barrera.jpg" },
        { id: 58, nombre: "Lámpara de Emergencia Industrial", categoria: "SEGURIDAD", precio: "28.00", estado: "DISPONIBLE", desc: "Iluminación de respaldo ante fallos eléctricos.", specs: "Doble faro LED / Autonomía 4 horas", img: "/src/main/resources/static/img/lampara_emergencia.jpg" },
        { id: 59, nombre: "Conos de Señalización Vial (Kit)", categoria: "SEGURIDAD", precio: "15.00", estado: "DISPONIBLE", desc: "Señalización de obras en vía pública o almacenes.", specs: "70cm de alto / Base pesada / Reflectivo", img: "/src/main/resources/static/img/conos.jpg" },
        { id: 60, nombre: "Botiquín de Primeros Auxilios Tipo B", categoria: "SEGURIDAD", precio: "35.00", estado: "DISPONIBLE", desc: "Dotación reglamentaria para atención de emergencias.", specs: "Gabinete metálico / Cumple normativa industrial", img: "/src/main/resources/static/img/botiquin.jpg" }
    ];

    const grid = document.getElementById('tools-grid');
    const filterSelect = document.getElementById('category-filter');

    // --- 2. FUNCIÓN PARA OBTENER IMAGEN (Usa la propiedad .img del objeto) ---
    function obtenerUrlImagen(tool) {
        // Si no tiene imagen definida, usa un placeholder por defecto
        return tool.img || "https://via.placeholder.com/300x200.png?text=Sin+Imagen";
    }

    // --- 3. RENDERIZADO DE TARJETAS ---
    function renderTools(toolsToRender) {
        if (!grid) return;
        grid.innerHTML = '';

        toolsToRender.forEach(tool => {
            const card = document.createElement('div');
            card.className = 'card';

            const statusClass = tool.estado === 'DISPONIBLE' ? 'status-available' : 'status-unavailable';

            // Obtenemos la URL de la imagen del objeto
            const imageUrl = obtenerUrlImagen(tool);

            card.innerHTML = `
                <div class="card-img-container">
                    <img src="${imageUrl}" alt="${tool.nombre}" class="card-img" onerror="this.src='https://via.placeholder.com/300x200.png?text=Error'">
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
        filterSelect.addEventListener('change', function () {
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