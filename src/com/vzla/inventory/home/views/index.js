function preload() {
    var app = new Vue({
        el: '#tu_moda_app',
        methods: {
            goToProducts: function () {
                JAVA_CONTROLLER.goToProducts();
            },
            goToSales: function () {
                JAVA_CONTROLLER.goToSales();
            }
        },

    })
}

function load() {
    
}



