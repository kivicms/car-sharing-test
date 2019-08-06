<#import "../layouts/main.ftl" as m>

<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
                <a class="btn btn-primary float-right" href="/car/create">Добавить</a>
            </div>
        </div>
        <div class="box-body">

            <table class="table table-bordered table-condensed table-hover tabl-sm">
                <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">Производитель</th>
                    <th class="text-center">Модель</th>
                    <th class="text-center">Гос. номер</th>
                    <th class="text-center">Статус</th>
                    <th class="text-center">Операции</th>
                </tr>
                </thead>
                <tbody>
                <#list cars as car>
                    <tr>
                        <td class="text-center">${car.id}</td>
                        <td>${car.vendorName}</td>
                        <td>${car.markName}</td>
                        <td class="text-center">${car.number}</td>
                        <td class="text-center">${car.statusName}</td>
                        <td class="text-center">
                            <a href="/car/view/${car.id}" class="btn btn-primary btn-xs">
                                <i class="fa fa-fw fa-eye"></i>
                            </a>
                            <a href="/car/update/${car.id}" class="btn btn-warning btn-xs">
                                <i class="fa fa-fw fa-pencil"></i>
                            </a>
                            <a href="/car/delete/${car.id}" class="btn btn-danger btn-xs delete-btn">
                                <i class="fa fa-fw fa-trash"></i>
                            </a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>

        </div>
    </div>
</@m.page>