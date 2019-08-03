<#import "../layouts/main.ftl" as m>
<#import "../layouts/content-header.ftl" as ch>
<@m.page>


    <@ch.contentHeader header="Автомобили" breadcrumbs=breadcrumbs></@ch.contentHeader>

    <section class="content">

        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Автомобили</h3>
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
                                <a href="/car/view/${car.id}" class="btn btn-outline-primary btn-xs">V </a>
                                <a href="/car/update/${car.id}" class="btn btn-outline-info btn-xs">U </a>
                                <a href="/car/delete/${car.id}" data-url="/car/delete/${car.id}"
                                   class="btn btn-outline-danger btn-xs delete-btn">D </a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>

            </div>
        </div>
    </section>
</@m.page>