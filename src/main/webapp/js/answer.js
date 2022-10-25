$('#input-form').submit(function (event) {
    validate() || event.preventDefault();
})