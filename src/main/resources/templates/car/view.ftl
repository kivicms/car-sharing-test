<#import "../layouts/main.ftl" as m>
<@m.page>
    <h1>Гос. номер: ${car.number}</h1>

    <a href="/car/update/${car.id}" class="btn btn-success">Редактировать</a>&nbsp;
    <a href="/car/delete/${car.id}" class="btn btn-danger car-delete">Удалить</a>
    <br>
    <table class="table table-responsive table-bordered table-info">
        <thead>
            <tr>
                <th class="text-center">Наименование</th>
                <th class="text-center">Значение</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Производитель</td>
                <td>${car.vendor.name}</td>
            </tr>
            <tr>
                <td>Модель</td>
                <td>${car.mark.name}</td>
            </tr>
            <tr>
                <td>Статус</td>
                <td>${car.statusName}</td>
            </tr>
            <tr>
                <td>Последний арендатор</td>
                <td>${car.getRenterFio()}</td>
            </tr>
        </tbody>
    </table>

</@m.page>