document.addEventListener("DOMContentLoaded", function() {

    const modal = document.getElementById("editModal");
    const closeBtn = document.querySelector(".close-modal");
    const editForm = document.getElementById("editForm");
    const searchInput = document.getElementById("searchClient");
    const filterStatus = document.getElementById("filterStatus");
    const tableBody = document.querySelector("tbody");


    tableBody.addEventListener('click', (e) => {
        if (e.target.closest('.btn-edit')) {
            const button = e.target.closest('.btn-edit');
            const row = button.closest('tr');
            const name = row.cells[0].innerText;
            const email = row.cells[1].innerText;
            

            document.getElementById('editName').value = name;
            document.getElementById('editEmail').value = email;

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

    editForm.addEventListener('submit', (e) => {
        e.preventDefault();
        alert("¡Datos actualizados!");
        modal.style.display = "none";
    });


    function filterTable() {
        const searchTerm = searchInput.value.toLowerCase();
        const statusTerm = filterStatus.value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr');

        rows.forEach(row => {
            const name = row.cells[0].innerText.toLowerCase();
            const email = row.cells[1].innerText.toLowerCase();
            

            const statusBadge = row.cells[3].querySelector('.badge');

            if (!statusBadge) return;
            
            const status = statusBadge.classList.contains('activo') ? 'activo' : 'inactivo';


            const matchesSearch = name.includes(searchTerm) || email.includes(searchTerm);
            const matchesStatus = statusTerm === "" || status === statusTerm;

            if (matchesSearch && matchesStatus) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    }


    searchInput.addEventListener('keyup', filterTable);
    filterStatus.addEventListener('change', filterTable);
});