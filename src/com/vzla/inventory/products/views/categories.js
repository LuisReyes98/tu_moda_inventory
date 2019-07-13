let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            categories: JAVA_CONTROLLER.categories,
            category_name: null,
        },
        methods: {
            editCategory: function (id) {
                JAVA_CONTROLLER.updateCategory(id, $(`#category_name_${id}`).val());

            },
            deleteCategory: function (id,name) {
                $("#generic_modal_title").html("Error")
                $("#generic_modal_body").html(`No se pudo eliminar la categoria <strong>${name}</strong> \n ya que hay productos que pertenecen a ella`);

                if (!JAVA_CONTROLLER.deleteCategory(id)) {
                    $(`#delete${id}`).modal('hide');
                    $("#generic_modal").modal('show');
                }
                // JAVA_CONTROLLER.deleteCategory(id);
            },
            goToProducts: function () {
                JAVA_CONTROLLER.goToProducts();
            },
            createCategory: function () {
                JAVA_CONTROLLER.createCategory(this.category_name);
            },

        },
    })
}

function load() {
    $(function () {
        $('[data-tooltip="tooltip"]').tooltip();
    });
}