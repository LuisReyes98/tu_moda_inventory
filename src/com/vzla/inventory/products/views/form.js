//Product form for edit and new
let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            name: JAVA_CONTROLLER.product.getName(),
            stock: JAVA_CONTROLLER.product.getStock(),
            price: Math.round(JAVA_CONTROLLER.product.getPrice() * 100) / 100,
            id: JAVA_CONTROLLER.product.getId(),
            modelAction: JAVA_CONTROLLER.modelAction,
            newCategory: false,
            categoryNewName : '',
            categories: JAVA_CONTROLLER.categories,
            isEditing: JAVA_CONTROLLER.isEditing,
            selectedCategory: JAVA_CONTROLLER.product.getCategory().getId(),
        },
        methods: {
            saveProduct: function() {
                let nameCat;
                let idCat;
                if (this.newCategory) {
                    idCat = 0;
                    nameCat = this.categoryNewName;
                } else{
                    idCat = this.selectedCategory;
                    nameCat = '';
                }
                if (this.isEditing) {
                    JAVA_CONTROLLER.updateProduct(nameCat, idCat, this.name, this.stock, this.price, this.id);
                }else{
                    JAVA_CONTROLLER.createProduct(nameCat, idCat, this.name, this.stock, this.price);
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
