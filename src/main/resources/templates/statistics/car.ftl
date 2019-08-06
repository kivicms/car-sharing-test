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
                        <th class="text-center">Производитель</th>
                        <th class="text-center">Модель</th>
                        <th class="text-center">Гос. номер</th>
                        <th class="text-center">Длительность</th>
                        <th class="text-center">Операции</th>
                    </tr>
                </thead>
                <tbody>
                    <#list carStats as stat>
                        <tr>
                            <td>${stat.car.vendor.name}</td>
                            <td>${stat.car.mark.name}</td>
                            <td class="text-center">${stat.car.number}</td>
                            <td class="text-center">${stat.durationString}</td>
                            <td class="text-center">
                                <a href="/statistics/car/${stat.car.id}">
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