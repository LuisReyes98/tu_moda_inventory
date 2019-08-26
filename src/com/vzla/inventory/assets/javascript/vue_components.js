Vue.component('navigation_bar', {
    template: `
        <nav class="navigation__main align-self-stretch">
            <div class="navigation__contents d-flex justify-content-center flex flex-column ">
                <button class="btn bg-transparent" data-tooltip="tooltip" data-placement="right" title="Cambiar menu">
                    <i class="mdi mdi-36px text-white mdi-menu "></i>
                </button>
                <button class="btn bg-transparent" v-on:click="goToIndex" data-tooltip="tooltip" data-placement="right"
                    title="Inicio">
                    <i class="mdi mdi-36px text-white mdi-home"
                    ></i>
                </button>
                <button class="btn bg-transparent" v-on:click="goToProducts" data-tooltip="tooltip" data-placement="right"
                    title="Productos">
                    <i class="mdi mdi-36px text-white mdi-cube"
                    ></i>
                </button>
                <button class="btn bg-transparent" data-tooltip="tooltip" data-placement="right" title="Categorias"
                    v-on:click="goToCategories">
                    <i class="mdi mdi-36px text-white mdi-format-list-bulleted-square" ></i>
                </button>
                <button class="btn bg-transparent" data-tooltip="tooltip" data-placement="right" title="Ventas"
                    v-on:click="goToSales">
                    <i class="mdi mdi-36px text-white mdi-cart"
                        ></i>
                </button>
            </div>
        </nav>
    `,
    methods: {
        goToProducts: function () {
            JAVA_CONTROLLER.goToProducts();
        },
        goToSales: function () {
            JAVA_CONTROLLER.goToSales();
        },
        goToCategories: function () {
            JAVA_CONTROLLER.goToCategories();
        },
        goToIndex: function () {
            JAVA_CONTROLLER.goToIndex();
        }
    },
})


Vue.component('generic_modal', {
    props: ['id', 'title', 'message'],
    template: `
        <div class="modal fade _modal" :id="id" tabindex="-1" role="dialog"
            :aria-labelledby="id + '_title'" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header ">
                        <h5 :id = "id + '_title'"
                        class = "modal-title modal__title">
                            {{title}}
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" v-html="message">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-block btn-secondary" data-dismiss="modal"> OK </button>
                    </div>
                </div>
            </div>
        </div>
    `
})