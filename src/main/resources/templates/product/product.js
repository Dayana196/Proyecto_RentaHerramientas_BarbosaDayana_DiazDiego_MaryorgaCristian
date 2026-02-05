let cart = [];

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
        actualizarCarrito();
    }
});

function actualizarCarrito() {
    const list = document.getElementById('cart-items');
    const totalLabel = document.getElementById('cart-total-amount');
    const countLabel = document.querySelector('.cart-count');
    
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

window.changeQty = (name, n) => {
    const i = cart.find(p => p.name === name);
    if(i) { i.quantity += n; if(i.quantity < 1) removeItem(name); }
    actualizarCarrito();
}

window.removeItem = (name) => {
    cart = cart.filter(p => p.name !== name);
    actualizarCarrito();
}