<#import "../layouts/main.ftl" as m>
<@m.page>
    <h1>Арендаторы</h1>

    <p>
        <a class="btn btn-primary float-right" href="/renter/create">Добавить</a>
    </p>

    <table class="table table-bordered table-condesed table-hover tabl-sm">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th class="text-center">ФИО</th>
            <th class="text-center">Телефон</th>
            <th class="text-center">Адрес</th>
        </tr>
        </thead>
        <tbody>
        <#list renters as renter>
            <tr>
                <td class="text-center">${renter.id}</td>
                <td>${renter.fio}</td>
                <td>${renter.phone}</td>
                <td>${renter.address}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@m.page>