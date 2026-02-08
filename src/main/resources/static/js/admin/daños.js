document.addEventListener("DOMContentLoaded", function() {
    const modal = document.getElementById("damageModal");
    const closeBtn = document.querySelector(".close-modal");
    const damageForm = document.getElementById("damageForm");
    const tableBody = document.querySelector("tbody");
    const searchInput = document.getElementById("searchDamage");

    // Abrir modal y cargar datos de la fila
    tableBody.addEventListener('click', (e) => {
        if (e.target.closest('.btn-edit')) {
            const row = e.target.closest('tr');
            const toolName = row.cells[0].innerText;
            
            document.getElementById('damageTool').value = toolName;
            modal.style.display = "flex";
        }
    });

    closeBtn.addEventListener('click', () => {
        modal.style.display = "none";
    });

    window.addEventListener('click', (e) => {
        if (e.target == modal) {
            modal.style.display = "none";
        }
    });

    damageForm.addEventListener('submit', (e) => {
        e.preventDefault();
        alert("¡Reporte de daño actualizado!");
        modal.style.display = "none";
    });

    // Funcionalidad de búsqueda
    searchInput.addEventListener('keyup', (e) => {
        const term = e.target.value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr');
        rows.forEach(row => {
            const tool = row.cells[0].innerText.toLowerCase();
            const user = row.cells[1].innerText.toLowerCase();
            if (tool.includes(term) || user.includes(term)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });
});