document.addEventListener("DOMContentLoaded", function() {
    const searchInput = document.getElementById("searchEquipment");
    const tableBody = document.querySelector("tbody");

    // Filtrado de búsqueda
    searchInput.addEventListener('keyup', (e) => {
        const term = e.target.value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr');
        rows.forEach(row => {
            const tool = row.cells[1].innerText.toLowerCase();
            const user = row.cells[2].innerText.toLowerCase();
            if (tool.includes(term) || user.includes(term)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });

    // Delegación de eventos para botones de acciones
    tableBody.addEventListener('click', (e) => {
        const button = e.target.closest('button');
        if (!button) return;

        const row = button.closest('tr');
        const toolName = row.cells[1].innerText;

        if (button.classList.contains('btn-edit')) {
            alert(`Acción: Extender alquiler de ${toolName}`);
        } else if (button.classList.contains('btn-delete')) {
            alert(`Acción: Reportar daño en ${toolName}`);
        }
    });
});