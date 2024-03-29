// products script
let app;
function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            products: JAVA_CONTROLLER.products,
        },
        methods: {
            goToIndex: function () {
                JAVA_CONTROLLER.goToIndex();

            },
            goToCategories: function () {  
                JAVA_CONTROLLER.goToCategories();
            },
            viewProductCreate: function () {
                JAVA_CONTROLLER.viewProductsCreate();
            },
            editProduct: function(id){
                JAVA_CONTROLLER.viewProductsEdit(id);
            },
            deleteProduct: function (id) {
                JAVA_CONTROLLER.deleteProduct(id);
            },
        },
        filters: {
            decimal: function(num) {
                return Math.round(num * 100) / 100
            }
        }
    })
}

function load() {

}
