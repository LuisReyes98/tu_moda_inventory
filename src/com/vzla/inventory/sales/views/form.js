// sales form script
let app;
class SoldProduct{
    constructor(id,listId,product,amount){
        this.id = id;
        this.listId = listId;
        this.product = product;
        this.productId = product.getId();
        this.amount = amount;
        this.individualPrice = product.getCost();
    }

    totalCost(){
        return this.amount * this.individualPrice
    }
}

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            sale: JAVA_CONTROLLER.sale,
            products: JAVA_CONTROLLER.products,
            soldProducts: [],
            soldProductListId: 1,
            productsHash: JAVA_CONTROLLER.productsHash,
        },
        methods: {
            viewSales: function () {
                JAVA_CONTROLLER.viewSales();
            },
            addProduct: function () {
                this.soldProducts.push(new SoldProduct(
                    0,//id
                    this.soldProductListId++,//list id
                    JAVA_CONTROLLER.getEmptyProduct(),//product
                    1//amount
                    )
                    );
            },
            productTotalCost: function(productCost,amount) {
                return productCost * amount;
            }
        },

    })
}

function load() {
    // let soldProducts = JAVA_CONTROLLER.sale.getProductSalesRelationArray();

    // soldProducts.forEach(el => {
    //     app.soldProducts.push(new SoldProduct(el.getId(), el.getProduct(), el.getAmount()))
    // });
}
