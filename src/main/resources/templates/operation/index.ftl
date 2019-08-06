<#--<#assign breadcrumbs = [{"url": "/operation", "label": "Операции"}, {"url": "", "label": "Список"}] >-->
<#import "../layouts/main.ftl" as m>

<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
                <a class="btn btn-primary float-right" href="/operation/issue">Выдать ТС</a>
            </div>
        </div>
        <div class="box-body">
            <table class="table table-bordered table-condensed table-hover">
                <thead>
                <tr>
                    <th class="text-center">#</th>
                    <th class="text-center">ТС</th>
                    <th class="text-center">Арендатор</th>
                    <th class="text-center">Выдана</th>
                    <th class="text-center">Принята</th>
                    <th class="text-center">Операции</th>
                </tr>
                </thead>
                <tbody>
                <#list operations as o>
                    <tr>
                        <td class="text-center">${o.id}</td>
                        <td>${o.car.number} / ${o.car.vendor.name} / ${o.car.mark.name}</td>
                        <td>${o.renter.fio}</td>
                        <td>${o.startDateTime}</td>
                        <td>${o.endDateTime!""}</td>
                        <td class="text-center">
                            <#if o.endDateTime??>
                            <#else >
                                <a class="accept-car" href="/operation/accept/${o.id}" title="Принять ТС">
                                    <i class="fa fa-fw fa-car"> </i>
                                </a>
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@m.page>