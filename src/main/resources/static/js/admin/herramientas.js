document.addEventListener("DOMContentLoaded", function() {

    const inventario = [

    { id: 1, nombre: "Martillo Demoledor SDS Max", categoria: "ELÉCTRICAS", precio: "45.00", estado: "DISPONIBLE", desc: "Motor de 1500W, ideal para concreto duro.", specs: "13 Joules / 10kg", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 2, nombre: "Esmeril Angular 9\"", categoria: "ELÉCTRICAS", precio: "25.00", estado: "NO DISPONIBLE", desc: "Corte y desbaste industrial de metales.", specs: "6500 RPM / Disco 9\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 3, nombre: "Rotomartillo Industrial", categoria: "ELÉCTRICAS", precio: "35.00", estado: "DISPONIBLE", desc: "Perforación en piedra y concreto armado.", specs: "800W / 3 Modos de uso", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 4, nombre: "Sierra Circular de Banco", categoria: "ELÉCTRICAS", precio: "55.00", estado: "DISPONIBLE", desc: "Cortes de precisión en madera y tableros.", specs: "2000W / Hoja 10\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 5, nombre: "Taladro de Columna", categoria: "ELÉCTRICAS", precio: "40.00", estado: "DISPONIBLE", desc: "Perforación vertical precisa en metales.", specs: "16 Velocidades / 550W", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 6, nombre: "Ingleteadora Telescópica", categoria: "ELÉCTRICAS", precio: "48.00", estado: "DISPONIBLE", desc: "Cortes angulares y biselados exactos.", specs: "1800W / Disco 12\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 7, nombre: "Tronzadora de Metales", categoria: "ELÉCTRICAS", precio: "32.00", estado: "NO DISPONIBLE", desc: "Corte rápido de perfiles y tuberías.", specs: "2300W / Disco abrasivo", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 8, nombre: "Lijadora de Banda", categoria: "ELÉCTRICAS", precio: "22.00", estado: "DISPONIBLE", desc: "Desbaste rápido de grandes superficies.", specs: "900W / 75x533mm", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 9, nombre: "Cepillo Eléctrico Pro", categoria: "ELÉCTRICAS", precio: "28.00", estado: "DISPONIBLE", desc: "Alisado y rebajado de maderas duras.", specs: "82mm ancho / 750W", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 10, nombre: "Soldadora Inverter", categoria: "ELÉCTRICAS", precio: "50.00", estado: "DISPONIBLE", desc: "Soldadura MMA y TIG para estructuras.", specs: "200 Amp / Ciclo 60%", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 11, nombre: "Generador Eléctrico 5kW", categoria: "ELÉCTRICAS", precio: "75.00", estado: "DISPONIBLE", desc: "Fuente de energía en sitios sin red.", specs: "5500W / Autonomía 8h", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 12, nombre: "Hidrolavadora Industrial", categoria: "ELÉCTRICAS", precio: "42.00", estado: "DISPONIBLE", desc: "Limpieza a presión de fachadas y pisos.", specs: "2500 PSI / Agua fría", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 13, nombre: "Sopladora de Aire", categoria: "ELÉCTRICAS", precio: "18.00", estado: "DISPONIBLE", desc: "Limpieza de escombros ligeros y polvo.", specs: "600W / 16000 RPM", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 14, nombre: "Fresadora (Router)", categoria: "ELÉCTRICAS", precio: "30.00", estado: "NO DISPONIBLE", desc: "Ranurado y decorado de madera fina.", specs: "1200W / Pinza 1/4\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 15, nombre: "Compresor de Aire 50L", categoria: "ELÉCTRICAS", precio: "38.00", estado: "DISPONIBLE", desc: "Suministro para herramientas neumáticas.", specs: "2.5 HP / 115 PSI", img: "/src/main/resources/static/img/FOTOO.png" },


    { id: 16, nombre: "Juego de Llaves Mixtas", categoria: "MANUALES", precio: "12.00", estado: "DISPONIBLE", desc: "Set completo para mecánica general.", specs: "24 Piezas / Cromo Vanadio", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 17, nombre: "Cizalla Cortapernos 36\"", categoria: "MANUALES", precio: "15.00", estado: "DISPONIBLE", desc: "Corte de varillas y cadenas gruesas.", specs: "Largo 90cm / Acero Forjado", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 18, nombre: "Prensa de Banco 6\"", categoria: "MANUALES", precio: "10.00", estado: "DISPONIBLE", desc: "Sujeción firme para piezas pesadas.", specs: "Apertura 150mm / Hierro", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 19, nombre: "Juego de Dados 1/2\"", categoria: "MANUALES", precio: "14.00", estado: "DISPONIBLE", desc: "Maletín de copas para trabajo pesado.", specs: "40 Piezas / Ratchet 72D", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 20, nombre: "Dobladora de Tubos", categoria: "MANUALES", precio: "18.00", estado: "NO DISPONIBLE", desc: "Curvado preciso de tubería conduit.", specs: "Capacidad 1/2\" a 1\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 21, nombre: "Gato Hidráulico Caimán", categoria: "MANUALES", precio: "20.00", estado: "DISPONIBLE", desc: "Elevación de vehículos y carga.", specs: "Capacidad 3 Toneladas", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 22, nombre: "Remachadora Industrial", categoria: "MANUALES", precio: "9.00", estado: "DISPONIBLE", desc: "Fijación permanente en láminas.", specs: "Boquillas intercambiables", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 23, nombre: "Maza de Construcción 8lb", categoria: "MANUALES", precio: "8.50", estado: "DISPONIBLE", desc: "Impacto pesado para demolición manual.", specs: "Mango Fibra de Vidrio", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 24, nombre: "Serrucho de Carpintero", categoria: "MANUALES", precio: "6.00", estado: "DISPONIBLE", desc: "Corte manual de madera y derivados.", specs: "22 Pulgadas / Triple filo", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 25, nombre: "Nivel de Mano 48\"", categoria: "MANUALES", precio: "7.00", estado: "DISPONIBLE", desc: "Verificación de plomada y nivel.", specs: "3 Gotas / Magnético", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 26, nombre: "Alicate de Presión 10\"", categoria: "MANUALES", precio: "5.50", estado: "DISPONIBLE", desc: "Agarre firme de pernos desgastados.", specs: "Mandíbula curva / Ajustable", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 27, nombre: "Pala de Punta Cuadrada", categoria: "MANUALES", precio: "6.50", estado: "DISPONIBLE", desc: "Movimiento de tierra y agregados.", specs: "Acero al carbono / Mango Y", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 28, nombre: "Pico de Obra 5lb", categoria: "MANUALES", precio: "7.50", estado: "NO DISPONIBLE", desc: "Excavación en terrenos compactos.", specs: "Ojo reforzado / Punta y hacha", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 29, nombre: "Cortadora de Vidrio Pro", categoria: "MANUALES", precio: "11.00", estado: "DISPONIBLE", desc: "Cortes limpios en cristales y espejos.", specs: "Cuchilla de carburo tungsteno", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 30, nombre: "Taladro Manual de Pecho", categoria: "MANUALES", precio: "8.00", estado: "DISPONIBLE", desc: "Perforación sin electricidad.", specs: "Doble engranaje / Mandril 1/2\"", img: "/src/main/resources/static/img/FOTOO.png" },


    { id: 31, nombre: "Mezcladora de Concreto", categoria: "CONSTRUCCIÓN", precio: "65.00", estado: "DISPONIBLE", desc: "Mezclado homogéneo de materiales.", specs: "9 pies³ / Motor Gasolina", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 32, nombre: "Vibrador de Concreto", categoria: "CONSTRUCCIÓN", precio: "35.00", estado: "DISPONIBLE", desc: "Eliminación de burbujas en vaciado.", specs: "Motor 2HP / Chicote 4m", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 33, nombre: "Apisonadora (Bailarina)", categoria: "CONSTRUCCIÓN", precio: "85.00", estado: "NO DISPONIBLE", desc: "Compactación de suelos en zanjas.", specs: "Impacto 14kN / Motor 4T", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 34, nombre: "Plancha Compactadora", categoria: "CONSTRUCCIÓN", precio: "75.00", estado: "DISPONIBLE", desc: "Compactación de asfalto y granulares.", specs: "Fuerza 15kN / Base 50cm", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 35, nombre: "Andamio Tubular Estándar", categoria: "CONSTRUCCIÓN", precio: "15.00", estado: "DISPONIBLE", desc: "Estructura para trabajos en fachada.", specs: "2.0 x 1.5m / Acero Galv.", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 36, nombre: "Regla Vibratoria 3m", categoria: "CONSTRUCCIÓN", precio: "42.00", estado: "DISPONIBLE", desc: "Nivelado y acabado de losas.", specs: "Largo 3m / Perfil Aluminio", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 37, nombre: "Allanadora de Pavimento", categoria: "CONSTRUCCIÓN", precio: "90.00", estado: "DISPONIBLE", desc: "Acabado espejo en pisos industriales.", specs: "Diámetro 36\" / Motor Honda", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 38, nombre: "Nivel Óptico de Precisión", categoria: "CONSTRUCCIÓN", precio: "40.00", estado: "NO DISPONIBLE", desc: "Topografía y nivelación de terrenos.", specs: "Aumento 32x / Trípode incl.", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 39, nombre: "Cortadora de Ladrillo", categoria: "CONSTRUCCIÓN", precio: "55.00", estado: "DISPONIBLE", desc: "Corte de bloques, ladrillos y tejas.", specs: "Disco diamante 14\" / Agua", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 40, nombre: "Bomba Sumergible Lodos", categoria: "CONSTRUCCIÓN", precio: "48.00", estado: "DISPONIBLE", desc: "Drenaje de excavaciones inundadas.", specs: "2 HP / Descarga 3\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 41, nombre: "Winche Eléctrico 500kg", categoria: "CONSTRUCCIÓN", precio: "45.00", estado: "DISPONIBLE", desc: "Elevación vertical de materiales.", specs: "Cable 30m / Control remoto", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 42, nombre: "Carretilla Reforzada", categoria: "CONSTRUCCIÓN", precio: "10.00", estado: "DISPONIBLE", desc: "Transporte de carga en obra.", specs: "Cuchara 6ft³ / Rueda anti-pinchazo", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 43, nombre: "Taladro de Diamante (Core)", categoria: "CONSTRUCCIÓN", precio: "110.00", estado: "DISPONIBLE", desc: "Extracción de núcleos en concreto.", specs: "Hasta 6\" diám. / Refrigerado", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 44, nombre: "Doblador de Varilla Hid.", categoria: "CONSTRUCCIÓN", precio: "58.00", estado: "DISPONIBLE", desc: "Doblado de acero de refuerzo.", specs: "Capacidad hasta 1 1/4\"", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 45, nombre: "Pistola de Fijación Pólvora", categoria: "CONSTRUCCIÓN", precio: "30.00", estado: "NO DISPONIBLE", desc: "Clavado en acero y concreto.", specs: "Calibre .22 / Semi-auto", img: "/src/main/resources/static/img/FOTOO.png" },


    { id: 46, nombre: "Kit Arnés de Alturas Pro", categoria: "SEGURIDAD", precio: "12.00", estado: "DISPONIBLE", desc: "Equipo completo anticaídas.", specs: "Línea de vida + Absorbedor", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 47, nombre: "Detector de Gases 4 Vías", categoria: "SEGURIDAD", precio: "55.00", estado: "DISPONIBLE", desc: "Monitoreo en espacios confinados.", specs: "O2, LEL, CO, H2S / Alarma", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 48, nombre: "Trípode de Rescate", categoria: "SEGURIDAD", precio: "65.00", estado: "NO DISPONIBLE", desc: "Acceso y rescate en alcantarillas.", specs: "Carga 500kg / Aluminio", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 49, nombre: "Línea de Vida Retráctil", categoria: "SEGURIDAD", precio: "35.00", estado: "DISPONIBLE", desc: "Bloqueo inmediato ante caída libre.", specs: "Cable acero 10m / Certificada", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 50, nombre: "Conos de Señalización (Pack)", categoria: "SEGURIDAD", precio: "8.00", estado: "DISPONIBLE", desc: "Delimitación de áreas de trabajo.", specs: "10 Unidades / 70cm Reflejan.", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 51, nombre: "Lámpara de Emergencia Ind.", categoria: "SEGURIDAD", precio: "14.00", estado: "DISPONIBLE", desc: "Iluminación autónoma en túneles.", specs: "LED 20W / Batería 4h", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 52, nombre: "Escalera Dieléctrica 24'", categoria: "SEGURIDAD", precio: "25.00", estado: "DISPONIBLE", desc: "Trabajos cerca de redes eléctricas.", specs: "Fibra de Vidrio / Extensible", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 53, nombre: "Kit Bloqueo y Etiquetado", categoria: "SEGURIDAD", precio: "20.00", estado: "DISPONIBLE", desc: "Seguridad en mantenimiento eléctrico.", specs: "15 Candados / Pinzas / Tags", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 54, nombre: "Extintor Multiproposito 20lb", categoria: "SEGURIDAD", precio: "10.00", estado: "DISPONIBLE", desc: "Protección contra incendios A-B-C.", specs: "Polvo Químico Seco", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 55, nombre: "Barrera Extensible 3m", categoria: "SEGURIDAD", precio: "15.00", estado: "NO DISPONIBLE", desc: "Cierre temporal de pasillos y vías.", specs: "PVC Alta Densidad / Reflectiva", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 56, nombre: "Espejo de Inspección Vial", categoria: "SEGURIDAD", precio: "11.00", estado: "DISPONIBLE", desc: "Revisión de partes bajas de vehículos.", specs: "Ruedas y linterna LED", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 57, nombre: "Careta de Soldar Electrónica", categoria: "SEGURIDAD", precio: "9.00", estado: "DISPONIBLE", desc: "Protección ocular oscurecimiento auto.", specs: "Sombra 9-13 / Solar", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 58, nombre: "Extractor de Aire Axial", categoria: "SEGURIDAD", precio: "38.00", estado: "DISPONIBLE", desc: "Ventilación de humos y gases tóxicos.", specs: "Diámetro 12\" / Ducto 5m", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 59, nombre: "Chaleco Reflectivo (Pack 5)", categoria: "SEGURIDAD", precio: "5.00", estado: "DISPONIBLE", desc: "Visibilidad para personal en obra.", specs: "Clase 2 / Malla respirable", img: "/src/main/resources/static/img/FOTOO.png" },
    { id: 60, nombre: "Botiquín Industrial Tipo B", categoria: "SEGURIDAD", precio: "12.00", estado: "DISPONIBLE", desc: "Primeros auxilios normativos.", specs: "Gabinete Metálico / Dotado", img: "/src/main/resources/static/img/FOTOO.png" }
];

    const grid = document.getElementById('tools-grid');
    const filterSelect = document.getElementById('category-filter');


    function renderTools(toolsToRender) {
        if (!grid) return;
        grid.innerHTML = ''; 

        toolsToRender.forEach(tool => {
            const card = document.createElement('div');
            card.className = 'card';
            
            const statusClass = tool.estado === 'DISPONIBLE' ? 'status-available' : 'status-unavailable';

            card.innerHTML = `
                <img src="${tool.img}" alt="${tool.nombre}" class="card-img">
                <div class="card-status ${statusClass}">${tool.estado}</div>
                <h3 class="card-title">${tool.nombre}</h3>
                <p class="card-specs">${tool.specs}</p>
                <p class="card-desc">${tool.desc}</p>
                <p class="card-price">$${tool.precio}</p>
            `;
            
            grid.appendChild(card);
        });
    }


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


    renderTools(inventario);
});