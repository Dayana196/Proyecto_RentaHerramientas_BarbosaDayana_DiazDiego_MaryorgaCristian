const modal = document.getElementById('reservation-modal');
const closeModal = document.querySelector('.close-modal');

document.querySelectorAll('.add-to-cart').forEach(button => {
    button.addEventListener('click', (e) => {
        const card = e.target.closest('.product-card');
        const title = card.querySelector('.product-title').textContent;
        const price = card.querySelector('.product-price').textContent;
        const imgSrc = card.querySelector('img').src;

        document.getElementById('modal-tool-name').textContent = title;
        document.getElementById('modal-tool-price').textContent = price;
        document.getElementById('modal-img').src = imgSrc;

        modal.style.display = 'flex';
    });
});

closeModal.addEventListener('click', () => {
    modal.style.display = 'none';
});

window.addEventListener('click', (e) => {
    if (e.target === modal) modal.style.display = 'none';
});