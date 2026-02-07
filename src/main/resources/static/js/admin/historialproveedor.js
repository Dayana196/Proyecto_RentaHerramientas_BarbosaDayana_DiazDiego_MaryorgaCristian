document.addEventListener("DOMContentLoaded", function() {
    const searchInput = document.getElementById("searchHistory");
    const filterStatus = document.getElementById("filterStatus");
    const tableBody = document.querySelector("tbody");

    function filterHistoryTable() {
        const searchTerm = searchInput.value.toLowerCase();
        const statusTerm = filterStatus.value.toLowerCase();
        const rows = document.querySelectorAll('tbody tr');

        rows.forEach(row => {
            const user = row.cells[0].innerText.toLowerCase();
            const tool = row.cells[1].innerText.toLowerCase();
            const statusBadge = row.cells[4].querySelector('.badge');
            
            if (!statusBadge) return;
            
            const status = statusBadge.innerText.toLowerCase();

            const matchesSearch = user.includes(searchTerm) || tool.includes(searchTerm);
            const matchesStatus = statusTerm === "" || status.includes(statusTerm);

            if (matchesSearch && matchesStatus) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    }

    searchInput.addEventListener('keyup', filterHistoryTable);
    filterStatus.addEventListener('change', filterHistoryTable);
});