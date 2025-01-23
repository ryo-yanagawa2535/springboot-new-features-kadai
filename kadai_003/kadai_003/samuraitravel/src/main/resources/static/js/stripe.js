const stripe = Stripe('pk_test_51QgJPXKvuRgwwz3CD8t40SWVGvfteJtDNSmopcLFN1om78c9HaglRJwm9PdNSzkN9BflmS6LMPMVP70aKjFqgg4J005Ne85owI');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});