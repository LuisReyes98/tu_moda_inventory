var app;

function load() {
    app = new Vue({
        el: '#app',
        data: {
            category: JAVA_CONTROLLER.product.getCategory(),
            name: JAVA_CONTROLLER.product.getName(),
            stock: JAVA_CONTROLLER.product.getStock(),
            cost: JAVA_CONTROLLER.product.getCost(),
        }
    })
}

function saveProduct(){
    JAVA_CONTROLLER.sout(`La categoria es ${app.category}`);
    JAVA_CONTROLLER.sout(`El nombre es ${app.name}` );
    JAVA_CONTROLLER.sout(`El stock es ${app.stock}` );
    JAVA_CONTROLLER.sout(`El cost es ${app.cost}`);
}
function goBack(){
    JAVA_CONTROLLER.goToProducts();
}