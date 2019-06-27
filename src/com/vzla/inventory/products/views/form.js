//Product form for edit and new
let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            category: JAVA_CONTROLLER.product.getCategory(),
            name: JAVA_CONTROLLER.product.getName(),
            stock: JAVA_CONTROLLER.product.getStock(),
            cost: Math.round(JAVA_CONTROLLER.product.getCost() * 100) / 100,
            id: JAVA_CONTROLLER.product.getId(),
            modelAction: JAVA_CONTROLLER.modelAction,
        },
        methods: {
            saveProduct: function() {
                if (JAVA_CONTROLLER.isEditing) {
                    JAVA_CONTROLLER.updateProduct(this.category, this.name, this.stock, this.cost,this.id);
                }else{
                    JAVA_CONTROLLER.saveNewProduct(this.category, this.name, this.stock, this.cost);
                }
            },
            goBack: function () {
                JAVA_CONTROLLER.viewProducts();
            }
        }
        ,
        filters: {
            decimal: function (num) {
                return Math.round(num * 100) / 100
            }
        }
    })

}
function load() {

    
}
