// sales form script
let app;
class SoldProduct{
    constructor(id,frontendKey,product_id,amount){
        this.id = id;
        this.frontendKey = frontendKey;
        this.productId = product_id;
        this.amount = amount;
    }

}

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            sale: JAVA_CONTROLLER.sale,
            products: JAVA_CONTROLLER.products,
            frontendKey: 1,
            soldProducts: [],
            productsHash: JAVA_CONTROLLER.productsHash,
        },
        methods: {
            viewSales: function () {
                JAVA_CONTROLLER.viewSales();
            },
            addProduct: function () {
                this.soldProducts.push(new SoldProduct(0,this.frontendKey++,0,1,));
            },
            productTotalPrice: function(productPrice,amount) {
                return productPrice * amount;
            }
        },

    })
}

function load() {
    
}
