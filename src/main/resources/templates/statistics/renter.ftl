<#import "../layouts/main.ftl" as m>

<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">

            </div>
        </div>
        <div class="box-body">
            <h5>Общее время сдачи в аренду ТС: <strong>${totalTimeString}</strong></h5>

            <table class="table table-bordered table-condensed table-hover">
                <thead>
                <tr>
                    <th class="text-center">ФИО</th>
                    <th class="text-center">Телефон</th>
                    <th class="text-center">Длительность</th>
                    <th class="text-center">Операции</th>
                </tr>
                </thead>
                <tbody>
                <#list renterStats as stat>
                    <tr>
                        <td>${stat.renter.fio}</td>
                        <td class="text-center">${stat.renter.phone}</td>
                        <td class="text-center">${stat.durationString}</td>
                        <td class="text-center">
                            <a href="/statistics/renter/${stat.renter.id}">
                                <i class="fa fa-fw fa-list-ul"> </i>
                            </a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@m.page>