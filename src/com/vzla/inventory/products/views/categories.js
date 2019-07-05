let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            categories: JAVA_CONTROLLER.categories,
        },
        methods: {
            editCategory: function (id) {
                JAVA_CONTROLLER.viewCategoryEdit(id);
            },
            deleteCategory: function (id) {
                JAVA_CONTROLLER.deleteCategory(id);
            },
            goToProducts: function () {
                JAVA_CONTROLLER.goToProducts();
            }
        },
    })
}

function load() {
    $(function () {
        $('[data-tooltip="tooltip"]').tooltip();
    });
}