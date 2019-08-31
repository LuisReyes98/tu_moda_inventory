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
            referencedProducts: Array.from(JAVA_CONTROLLER.products),
            frontendKey: 2,
            soldProducts: [],
            productsHash: JAVA_CONTROLLER.productsHash,
            todayDate: JAVA_CONTROLLER.getCurrentDateStr("dd-MMMMM-yyyy hh:mm a"),
        },
        methods: {
            addProductToSale: function (product) {
                console.log(product.getId());
                if (this.productsHash.get(product.getId()) !== null) {
                    this.referencedProducts = this.referencedProducts.filter(function (value, index, arr) {
                        return value !== product;
                    })
                    this.soldProducts.push(product);
                }
            },
            resetProducts: function () {
                this.referencedProducts = this.products.slice();
                this.soldProducts = [];
            },
            removeProductFromSale: function (soldProduct){
                console.log(soldProduct.getId());

                if (this.productsHash.get(soldProduct.getId()) !== null) {
                    this.soldProducts = this.soldProducts.filter(function (value, index, arr) {
                        return value !== soldProduct;
                    })
                    this.referencedProducts.push(soldProduct);
                }
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
