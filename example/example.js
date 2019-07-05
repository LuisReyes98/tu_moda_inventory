let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            products: [],
        }
    })
}

function load() {
    app.products = JAVA_CONTROLLER.products;
}