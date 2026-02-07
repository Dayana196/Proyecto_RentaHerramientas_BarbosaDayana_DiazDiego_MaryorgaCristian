document.addEventListener('DOMContentLoaded', () => {
    const tablaBody = document.getElementById('lista-alquilados');
    
    const alquileres = JSON.parse(localStorage.getItem('alquileresToolsX')) || [];

    if (alquileres.length === 0) {
        tablaBody.innerHTML = `<tr><td colspan="5" style="text-align:center; padding: 20px; color: white;">No tienes equipos alquilados aún.</td></tr>`;
        return;
    }

    tablaBody.innerHTML = alquileres.map(item => `
        <tr>
            <td><div style="font-weight: bold; color: #ff7a00;">${item.equipo}</div></td>
            <td>
                <div>${item.cliente}</div>
                <small style="color: #888;">${item.email}</small>
            </td>
            <td style="text-transform: capitalize;">${item.metodo}</td>
            <td>$${item.abono}</td>
            <td>
                <span class="status-badge ${item.momento === 'ahora' ? 'status-pagado' : 'status-pendiente'}">
                    ${item.momento === 'ahora' ? 'PAGADO' : 'PENDIENTE'}
                </span>
            </td>
        </tr>
    `).join('');
});