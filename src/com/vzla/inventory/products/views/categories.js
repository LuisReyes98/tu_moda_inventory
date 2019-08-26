let app;

function preload() {
    app = new Vue({
        el: '#tu_moda_app',
        data: {
            categories: [],
            category_name: null,
        },
        methods: {
            editCategory: function (category) {
                JAVA_CONTROLLER.updateCategory(category.id, category.newName);

            },
            deleteCategory: function (id) {

                if (!JAVA_CONTROLLER.deleteCategory(id)) {
                    $(`#delete${id}`).modal('hide');
                    $(`#error_delete_${id}`).modal('show');
                }
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
class Category {
    constructor(id,name){
        this.id = id;
        this.name = name;
        this.newName = name;
    }

    getId(){
        return this.id;
    }

    getName(){
        return this.name;
    }
}

function load() {
    let categories = JAVA_CONTROLLER.categories;
    categories.forEach(el => {
        app.categories.push(new Category(el.getId(),el.getName()));
    });

}