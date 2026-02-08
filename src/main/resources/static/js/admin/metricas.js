document.addEventListener("DOMContentLoaded", function() {
    const inventoryModal = document.getElementById("inventoryModal");
    const maintenanceModal = document.getElementById("maintenanceModal");
    const toolSelect = document.getElementById("maintenanceToolSelect");

    // --- Datos de las herramientas para mantenimiento ---
    const allTools = [
        { id: 1, nombre: "Martillo Demoledor SDS Max", categoria: "ELÉCTRICAS" },
        { id: 2, nombre: "Esmeril Angular 9\"", categoria: "ELÉCTRICAS" },
        { id: 3, nombre: "Rotomartillo Industrial", categoria: "ELÉCTRICAS" },
        { id: 4, nombre: "Sierra Circular de Banco", categoria: "ELÉCTRICAS" },
        { id: 5, nombre: "Taladro de Columna", categoria: "ELÉCTRICAS" },
        { id: 6, nombre: "Ingleteadora Telescópica", categoria: "ELÉCTRICAS" },
        { id: 7, nombre: "Tronzadora de Metales", categoria: "ELÉCTRICAS" },
        { id: 8, nombre: "Lijadora de Banda", categoria: "ELÉCTRICAS" },
        { id: 9, nombre: "Cepillo Eléctrico Pro", categoria: "ELÉCTRICAS" },
        { id: 10, nombre: "Soldadora Inverter", categoria: "ELÉCTRICAS" },
        { id: 11, nombre: "Generador Eléctrico 5kW", categoria: "ELÉCTRICAS" },
        { id: 12, nombre: "Hidrolavadora Industrial", categoria: "ELÉCTRICAS" },
        { id: 13, nombre: "Sopladora de Aire", categoria: "ELÉCTRICAS" },
        { id: 14, nombre: "Fresadora (Router)", categoria: "ELÉCTRICAS" },
        { id: 15, nombre: "Compresor de Aire 50L", categoria: "ELÉCTRICAS" },
        { id: 16, nombre: "Juego de Llaves Mixtas", categoria: "MANUALES" },
        { id: 17, nombre: "Cizalla Cortapernos 36\"", categoria: "MANUALES" },
        { id: 18, nombre: "Prensa de Banco 6\"", categoria: "MANUALES" },
        { id: 19, nombre: "Juego de Dados 1/2\"", categoria: "MANUALES" },
        { id: 20, nombre: "Dobladora de Tubos", categoria: "MANUALES" },
        { id: 21, nombre: "Gato Hidráulico Caimán", categoria: "MANUALES" },
        { id: 22, nombre: "Remachadora Industrial", categoria: "MANUALES" },
        { id: 23, nombre: "Maza de Construcción 8lb", categoria: "MANUALES" },
        { id: 24, nombre: "Serrucho de Carpintero", categoria: "MANUALES" },
        { id: 25, nombre: "Nivel de Mano 48\"", categoria: "MANUALES" },
        { id: 26, nombre: "Alicate de Presión 10\"", categoria: "MANUALES" },
        { id: 27, nombre: "Pala de Punta Cuadrada", categoria: "MANUALES" },
        { id: 28, nombre: "Pico de Obra 5lb", categoria: "MANUALES" },
        { id: 29, nombre: "Cortadora de Vidrio Pro", categoria: "MANUALES" },
        { id: 30, nombre: "Taladro Manual de Pecho", categoria: "MANUALES" },
        { id: 31, nombre: "Mezcladora de Concreto", categoria: "CONSTRUCCIÓN" },
        { id: 32, nombre: "Vibrador de Concreto", categoria: "CONSTRUCCIÓN" },
        { id: 33, nombre: "Apisonadora (Bailarina)", categoria: "CONSTRUCCIÓN" },
        { id: 34, nombre: "Plancha Compactadora", categoria: "CONSTRUCCIÓN" },
        { id: 35, nombre: "Andamio Tubular Estándar", categoria: "CONSTRUCCIÓN" },
        { id: 36, nombre: "Regla Vibratoria 3m", categoria: "CONSTRUCCIÓN" },
        { id: 37, nombre: "Allanadora de Pavimento", categoria: "CONSTRUCCIÓN" },
        { id: 38, nombre: "Nivel Óptico de Precisión", categoria: "CONSTRUCCIÓN" },
        { id: 39, nombre: "Cortadora de Ladrillo", categoria: "CONSTRUCCIÓN" },
        { id: 40, nombre: "Bomba Sumergible Lodos", categoria: "CONSTRUCCIÓN" },
        { id: 41, nombre: "Winche Eléctrico 500kg", categoria: "CONSTRUCCIÓN" },
        { id: 42, nombre: "Carretilla Reforzada", categoria: "CONSTRUCCIÓN" },
        { id: 43, nombre: "Taladro de Diamante (Core)", categoria: "CONSTRUCCIÓN" },
        { id: 44, nombre: "Doblador de Varilla Hid.", categoria: "CONSTRUCCIÓN" },
        { id: 45, nombre: "Pistola de Fijación Pólvora", categoria: "CONSTRUCCIÓN" },
        { id: 46, nombre: "Kit Arnés de Alturas Pro", categoria: "SEGURIDAD" },
        { id: 47, nombre: "Detector de Gases 4 Vías", categoria: "SEGURIDAD" },
        { id: 48, nombre: "Trípode de Rescate", categoria: "SEGURIDAD" },
        { id: 49, nombre: "Línea de Vida Retráctil", categoria: "SEGURIDAD" },
        { id: 50, nombre: "Conos de Señalización (Pack)", categoria: "SEGURIDAD" },
        { id: 51, nombre: "Lámpara de Emergencia Ind.", categoria: "SEGURIDAD" },
        { id: 52, nombre: "Escalera Dieléctrica 24'", categoria: "SEGURIDAD" },
        { id: 53, nombre: "Kit Bloqueo y Etiquetado", categoria: "SEGURIDAD" },
        { id: 54, nombre: "Extintor Multiproposito 20lb", categoria: "SEGURIDAD" },
        { id: 55, nombre: "Barrera Extensible 3m", categoria: "SEGURIDAD" },
        { id: 56, nombre: "Espejo de Inspección Vial", categoria: "SEGURIDAD" },
        { id: 57, nombre: "Careta de Soldar Electrónica", categoria: "SEGURIDAD" },
        { id: 58, nombre: "Extractor de Aire Axial", categoria: "SEGURIDAD" },
        { id: 59, nombre: "Chaleco Reflectivo (Pack 5)", categoria: "SEGURIDAD" },
        { id: 60, nombre: "Botiquín Industrial Tipo B", categoria: "SEGURIDAD" }
    ];

    // --- Funciones Inventario ---
    window.openInventoryModal = function() {
        inventoryModal.style.display = "flex";
    }

    window.closeInventoryModal = function() {
        inventoryModal.style.display = "none";
    }

    // --- Funciones Mantenimiento ---
    window.openMaintenanceModal = function() {
        populateToolSelect();
        maintenanceModal.style.display = "flex";
    }

    window.closeMaintenanceModal = function() {
        maintenanceModal.style.display = "none";
    }

    // Función para poblar el select con las 60 herramientas
    function populateToolSelect() {
        toolSelect.innerHTML = '<option value="">Seleccionar herramienta...</option>';
        
        allTools.forEach(tool => {
            const option = document.createElement("option");
            option.value = tool.id;
            option.text = `[${tool.categoria}] ${tool.nombre} (ID: ${tool.id})`;
            toolSelect.add(option);
        });
    }

    // Cerrar modales si hacen clic fuera del contenido
    window.onclick = function(event) {
        if (event.target == inventoryModal) closeInventoryModal();
        if (event.target == maintenanceModal) closeMaintenanceModal();
    }
});