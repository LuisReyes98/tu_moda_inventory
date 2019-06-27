// products script
let app;
function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            products: [],
        },
        methods: {
            goToIndex: function () {
                JAVA_CONTROLLER.goToIndex();

            },
            viewProductCreate: function () {
                JAVA_CONTROLLER.viewProductsCreate();
            },
            editProduct: function(id){
                JAVA_CONTROLLER.viewProductsEdit(id);
            }
        },
        filters: {
            decimal: function(num) {
                return Math.round(num * 100) / 100
            }
        }
    })
}

function load() {
    app.products = JAVA_CONTROLLER.products;

    $(function () {
        $('[data-tooltip="tooltip"]').tooltip();
    });
}
