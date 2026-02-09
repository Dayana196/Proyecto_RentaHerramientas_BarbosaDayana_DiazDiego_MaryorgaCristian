const form = document.getElementById('loginForm');

form.addEventListener('submit', function(e) {
    e.preventDefault(); // Evita recarga

    const data = {
        correo: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(async response => {
        if (!response.ok) {
            const text = await response.text();
            throw new Error(text || 'Error en el login');
        }
        return response.json();
    })
    .then(result => {
        const token = result.token;
        localStorage.setItem('token', token);

        // Decodificar el JWT para obtener el rol
        const payload = JSON.parse(atob(token.split('.')[1]));
        const role = payload.role || payload.roles?.[0]; // según cómo envíe tu backend

        // Redirigir según rol
        if (role === 'CLIENTE') {
            window.location.href = '/src/main/resources/templates/cliente/dashboard.html';
        } else if (role === 'ADMIN') {
            window.location.href = '/src/main/resources/templates/admin/dashboard.html';
        } else if (role === 'PROVEEDOR') {
            window.location.href = '/src/main/resources/templates/proveedor/dashboard.html';
        } else {
            alert('Rol no reconocido');
        }
    })
    .catch(error => {
        alert(error.message);
    });
});