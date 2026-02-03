const form = document.getElementById('registerForm');

form.addEventListener('submit', async (e) => {
    e.preventDefault();

    alert("Iniciando registro...");

    const datos = {
        usuario: document.getElementById('username').value,
        correo: document.getElementById('correo').value,
        password: document.getElementById('password').value,
        roles: ["CLIENTE"]
    };

    console.log("Datos a enviar:", datos);

    try {
        const response = await fetch('http://localhost:8080/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)
        });

        if (response.ok) {
            const resultado = await response.json();
            alert("¡Éxito! Usuario registrado con ID: " + resultado.id);
            form.reset();
        } else {
            alert("El Username ya esta en uso");
        }

    } catch (error) {
        alert("No se pudo conectar con el servidor");
        console.error(error);
    }
});
