Vue.component('blog_post', {
    props: ['title'],
    template: '<h3>{{ title }}</h3>'
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