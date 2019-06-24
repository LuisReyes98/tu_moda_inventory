function load() {
    var app = new Vue({
        el: '#app',
        data: {
            message: JAVA_CONTROLLER.dummy,
        }
    })
}

function goToProducts() {
    JAVA_CONTROLLER.goToProducts();
}

function goToSales() {
    JAVA_CONTROLLER.goToSales();
}