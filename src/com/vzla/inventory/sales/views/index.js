// sales index script
let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            sales: [],
        },
        methods: {
            viewSalesCreate: function () {
                JAVA_CONTROLLER.viewSalesCreate();
            },
        }
    })
}

function load() {

}
