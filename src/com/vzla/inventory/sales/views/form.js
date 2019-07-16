// sales form script
let app;

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
            
        }
    })
}

function load() {
    let soldProducts = JAVA_CONTROLLER.sale.getProductSalesRelationArray();

    soldProducts.forEach(el => {
        app.soldProducts.push({
            id: el.getId(),
            product_id: el.getProduct().getId(),
            price: el.getIndividualPrice(),
            total_price: el.getTotalPrice(),
        })
    });
}
