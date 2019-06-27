let app;

function preload() {
    app = new Vue({
        el: '#app',
        data: {
            products: [],
        }
    })
}

function load() {
    app.products = JAVA_CONTROLLER.products;
}