//Product form for edit and new
let app;

function preload() {
    app = new Vue({
        el: '#app',
        data: {
            category: null,
            name: null,
            stock: null,
            cost: null,
        }
    })
}
function load() {
    app.category = JAVA_CONTROLLER.product.getCategory();
    app.name = JAVA_CONTROLLER.product.getName();
    app.stock = JAVA_CONTROLLER.product.getStock();
    app.cost = JAVA_CONTROLLER.product.getCost();
}

function saveProduct(){
    JAVA_CONTROLLER.saveNewProduct(app.category, app.name, app.stock, app.cost);
}
function goBack(){
    JAVA_CONTROLLER.viewProducts();
}