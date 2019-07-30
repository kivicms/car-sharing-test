<#import "../layouts/main.ftl" as m>
<#import "form.ftl" as f>
<@m.page>
    <h1>Модели автомобилей</h1>

    <@f.form></@f.form>

    <table class="table table-bordered table-condesed table-hover tabl-sm">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th class="text-center">Производитель</th>
            <th class="text-center">Модель</th>
        </tr>
        </thead>
        <tbody>
        <#list marks as mark>
            <tr>
                <td class="text-center">${mark.id}</td>
                <td>${mark.vendorName}</td>
                <td>${mark.name}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@m.page>