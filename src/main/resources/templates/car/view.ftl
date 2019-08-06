<#import "../layouts/main.ftl" as m>
<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
                <a href="/car/update/${car.id}" class="btn btn-success float-right">Редактировать</a>&nbsp;
                <a href="/car/delete/${car.id}" class="btn btn-danger delete-btn float-right">Удалить</a>
            </div>
        </div>
        <div class="box-body">
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
                    <td>Гос. номер</td>
                    <td>${car.number}</td>
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
        </div>
    </div>
</@m.page>