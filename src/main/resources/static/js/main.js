
$('.delete-btn').click(function () {
    if (confirm('Удалить данный пункт?')) {
        window.location = $(this).data('url');
    }
    return false;
});