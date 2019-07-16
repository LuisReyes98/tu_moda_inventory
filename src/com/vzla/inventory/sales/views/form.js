// sales form script
let app;
class SoldProduct{
    constructor(id,memberProduct,amount){
        this.id = id;
        this.memberProduct = memberProduct;
        this.amount = amount;
        this.individualPrice = memberProduct.getCost();
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
        },
        methods: {
            viewSales: function () {
                JAVA_CONTROLLER.viewSales();
            },
            addProduct: function () {
                this.soldProducts.push(new SoldProduct(0, JAVA_CONTROLLER.getEmptyProduct(), 1));
            },
        }
    })
}

function load() {
    // let soldProducts = JAVA_CONTROLLER.sale.getProductSalesRelationArray();

    // soldProducts.forEach(el => {
    //     app.soldProducts.push(new SoldProduct(el.getId(), el.getProduct(), el.getAmount()))
    // });
}
