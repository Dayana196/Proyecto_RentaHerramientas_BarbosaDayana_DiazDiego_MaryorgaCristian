let cart = JSON.parse(localStorage.getItem('myCart')) || [];

document.addEventListener('DOMContentLoaded', () => {
    actualizarCarrito();
});

document.addEventListener('click', (e) => {
    const btn = e.target.closest('.add-to-cart');
    if (btn) {
        const card = btn.closest('.product-card');
        const item = {
            name: card.querySelector('.product-title').innerText,
            price: parseFloat(card.querySelector('.product-price').innerText.replace('$', '')),
            quantity: 1
        };
        const exists = cart.find(i => i.name === item.name);
        if (exists) exists.quantity++;
        else cart.push(item);
        
        guardarYActualizar(); 
    }
});

function actualizarCarrito() {
    const list = document.getElementById('cart-items');
    const totalLabel = document.getElementById('cart-total-amount');
    const countLabel = document.querySelector('.cart-count');
    
    if (!list) return;

    list.innerHTML = '';
    let total = 0, count = 0;

    cart.forEach(i => {
        total += i.price * i.quantity;
        count += i.quantity;
        list.innerHTML += `
            <div class="cart-item">
                <span>${i.name}</span>
                <div class="cart-item-controls">
                    <button onclick="changeQty('${i.name}', -1)">-</button>
                    <span>${i.quantity}</span>
                    <button onclick="changeQty('${i.name}', 1)">+</button>
                    <i class="fa-solid fa-trash" onclick="removeItem('${i.name}')"></i>
                </div>
            </div>`;
    });

    if(!cart.length) list.innerHTML = '<p class="empty-msg">Vacío</p>';
    countLabel.innerText = count;
    totalLabel.innerText = `$${total.toFixed(2)}`;
}


function guardarYActualizar() {
    localStorage.setItem('myCart', JSON.stringify(cart));
    actualizarCarrito();
}

window.changeQty = (name, n) => {
    const i = cart.find(p => p.name === name);
    if(i) { 
        i.quantity += n; 
        if(i.quantity < 1) {
            cart = cart.filter(p => p.name !== name);
        }
    }
    guardarYActualizar();
}

window.removeItem = (name) => {
    cart = cart.filter(p => p.name !== name);
    guardarYActualizar();
}


window.filtrarPor = (categoria) => {
    const productos = document.querySelectorAll('.product-card');
    
    productos.forEach(prod => {
        const itemCat = prod.getAttribute('data-category');
        
        if (categoria === 'all' || itemCat === categoria) {
            prod.style.display = "block";
        } else {
            prod.style.display = "none";
        }
    });


    localStorage.setItem('categoria_actual', categoria);
};


document.addEventListener('DOMContentLoaded', () => {
    const filtroGuardado = localStorage.getItem('categoria_actual');
    
    if (filtroGuardado && filtroGuardado !== 'all') {
        filtrarPor(filtroGuardado);
    }
});


window.filtrarPor = (categoria) => {
    const productos = document.querySelectorAll('.product-card');

    productos.forEach(prod => {
        const catProducto = prod.getAttribute('data-category');

        if (categoria === 'all' || catProducto === categoria) {
            prod.style.display = "block";
            prod.style.opacity = "0";
            setTimeout(() => {
                prod.style.opacity = "1";
                prod.style.transition = "opacity 0.4s ease";
            }, 10);
        } else {
            prod.style.display = "none";
        }
    });

    localStorage.setItem('categoria_guardada', categoria);
};

document.addEventListener('DOMContentLoaded', () => {
    const seleccionPrevia = localStorage.getItem('categoria_guardada');
    if (seleccionPrevia) {
        filtrarPor(seleccionPrevia);
    }
});