// products script
var app;
function load() {
    app = new Vue({
        el: '#app',
        data: {
            products: JAVA_CONTROLLER.products,
        }
    })
}

function goToIndex() {
    JAVA_CONTROLLER.goToIndex();
}

function viewProductCreate(){
    JAVA_CONTROLLER.viewProductsCreate();
}