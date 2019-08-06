
$('.delete-btn').click(function () {
    if (confirm('Удалить данный пункт?')) {
        window.location = $(this).prop('href');
    }
    return false;
});

$('.accept-car').click(function () {
    if (confirm('Принять данное ТС?')) {
        window.location = $(this).prop('href');
    }
    return false;
});

