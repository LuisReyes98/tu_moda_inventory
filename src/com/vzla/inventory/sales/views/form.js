// sales form script
let app;
class SoldProduct{
    constructor(id,frontendKey,productId,amount){
        this.id = id;
        this.frontendKey = frontendKey;
        this.productId = productId;
        this.amount = amount;
    }

}

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            sale: JAVA_CONTROLLER.sale,
            products: JAVA_CONTROLLER.products,
            referenced_products: Array.from(JAVA_CONTROLLER.products),
            frontendKey: 2,
            soldProducts: [],
            productsHash: JAVA_CONTROLLER.productsHash,
            todayDate: JAVA_CONTROLLER.getCurrentDateStr("dd-MMMMM-yyyy hh:mm a"),
        },
        methods: {
            addProduct: function (product) {
                
            },
            removeProduct: function (soldProduct){
                this.soldProducts.splice(this.soldProducts.indexOf(soldProduct) ,1);
            },
            totalPrice: function () {
                self = this;
                return this.soldProducts.reduce(
                    function(acum, soldProduct){
                        if (self.productsHash.get(soldProduct.productId)) {
                            return acum + (self.productsHash.get(soldProduct.productId).getPrice() * soldProduct.amount);
                        }
                        return acum;
                }, 0);
            },
            createSale: function () {
                if (this.isProductsClean()) {
                    JAVA_CONTROLLER.resetSoldProducts();
                    this.soldProducts.forEach(function (soldProduct) {
                        JAVA_CONTROLLER.addSoldProduct(
                            soldProduct.id,
                            soldProduct.productId,
                            soldProduct.amount
                        );
                    });
                    JAVA_CONTROLLER.createSale(this.totalPrice());
                }else{
                    $('#creation_error').modal('show');
                }

            },
            isProductsClean: function () {
                let self = this;
                let result = true;
                this.soldProducts.forEach(function(soldProduct){
                    if (!self.productsHash.get(soldProduct.productId) || soldProduct.amount <= 0) {
                        result = false;
                    }
                });
                return result;
            }
        },

    })
}

function load() {
    
}
