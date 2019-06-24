// products script
var app;
function load() {
    app = new Vue({
        el: '#app',
        data: {
        }
    })
}

function goToIndex() {
    JAVA_CONTROLLER.goToIndex();
}

function goToProductCreate(){
    JAVA_CONTROLLER.goToProductCreate();
}