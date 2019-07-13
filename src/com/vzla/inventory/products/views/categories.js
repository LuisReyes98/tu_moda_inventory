let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            categories: JAVA_CONTROLLER.categories,
            category_name: null,
            category_id: null,
        },
        methods: {
            editCategory: function (id) {
                // JAVA_CONTROLLER.viewCategoryEdit(id);
                JAVA_CONTROLLER.editCategory(id, $(`#category_name_${id}`).val());

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

            },

        },
    })
}

function load() {
    $(function () {
        $('[data-tooltip="tooltip"]').tooltip();
    });
}