<#import "../layouts/main.ftl" as m>
<@m.page>
    <h1>Автомобили</h1>

    <p>
        <a class="btn btn-primary float-right" href="/car/create">Добавить</a>
    </p>

    <table class="table table-bordered table-condesed table-hover tabl-sm">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th class="text-center">Производитель</th>
            <th class="text-center">Модель</th>
            <th class="text-center">Гос. номер</th>
            <th class="text-center">Статус</th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
            <tr>
                <td class="text-center">${car.id}</td>
                <td>${car.vendorName}</td>
                <td>${car.markName}</td>
                <td class="text-center">${car.number}</td>
                <td class="text-center">#{car.status}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@m.page>