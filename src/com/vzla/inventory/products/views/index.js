// products script
let app;
function preload() {
    app = new Vue({
        el: '#app',
        data: {
            products: [],
        }
    })
}

function load() {
    app.products = JAVA_CONTROLLER.products;

}
function goToIndex() {
    JAVA_CONTROLLER.goToIndex();
}

function viewProductCreate(){
    JAVA_CONTROLLER.viewProductsCreate();
}