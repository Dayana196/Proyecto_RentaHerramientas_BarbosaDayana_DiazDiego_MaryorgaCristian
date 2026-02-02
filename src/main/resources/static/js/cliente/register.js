const form = document.getElementById("registerForm");

form.addEventListener("submit", (e) => {
    e.preventDefault();

    const inputs = form.querySelectorAll("input");
    const password = inputs[3].value;
    const confirmPassword = inputs[4].value;

    if (password !== confirmPassword) {
        alert("Las contraseñas no coinciden");
        return;
    }

    alert("Registro exitoso 🎉");
    form.reset();
});
