const form = document.getElementById('loginForm');

form.addEventListener('submit', function(e) {
    e.preventDefault(); // Evita que se recargue la página

    const data = {
        correo: document.getElementById('email').value, // coincide con tu backend
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/auth/login', { // URL de tu endpoint Spring Boot
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
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
        // Guardamos el token recibido
        localStorage.setItem('token', result.token);

        // Redirigir a la página protegida
        window.location.href = '/index.html';
    })
    .catch(error => {
        alert(error.message); // Mensaje de error
    });
});
