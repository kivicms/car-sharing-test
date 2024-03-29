<#import "../layouts/main.ftl" as m>
<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
                <a class="btn btn-primary float-right" href="/renter/create">Добавить</a>
            </div>
        </div>
        <div class="box-body">

            <table class="table table-bordered table-condesed table-hover">
                <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">ФИО</th>
                    <th class="text-center">Телефон</th>
                    <th class="text-center">Адрес</th>
                    <th class="text-center">Операции</th>
                </tr>
                </thead>
                <tbody>
                <#list renters as renter>
                    <tr>
                        <td class="text-center">${renter.id}</td>
                        <td>${renter.fio}</td>
                        <td>${renter.phone}</td>
                        <td>${renter.address}</td>
                        <td class="text-center">
                            <a href="/renter/delete/${renter.id}" class="btn btn-danger btn-xs delete-btn">
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