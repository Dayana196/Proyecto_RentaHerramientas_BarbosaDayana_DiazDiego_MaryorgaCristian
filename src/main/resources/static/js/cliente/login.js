const form = document.getElementById('loginForm');

form.addEventListener('submit', function(e) {
    e.preventDefault(); // Evita que se recargue la página

    const data = {
        correo: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/auth/login', {
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
        window.location.href = 'http://127.0.0.1:5500/src/main/resources/templates/index.html';
    })
    .catch(error => {
        alert(error.message); // Mensaje de error
    });
});
