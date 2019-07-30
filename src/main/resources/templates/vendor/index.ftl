<#import "../layouts/main.ftl" as m>
<#import "form.ftl" as f>
<@m.page>
    <h1>Производители автомобилей</h1>

    <@f.form></@f.form>

    <table class="table table-bordered table-condesed table-hover">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th class="text-center">Производитель</th>
            <th class="text-center">Оп.</th>
        </tr>
        </thead>
        <tbody>
        <#list vendors as vendor>
            <tr>
                <td class="text-center">${vendor.id}</td>
                <td class="text-left">${vendor.name}</td>
                <td class="text-center">
                    <a href="/vendor/delete/${vendor.id}" title="Удалить" aria-label="Удалить"
                       data-confirm="Вы уверены, что хотите удалить этот элемент?" data-method="get">
                        D
                    </a>
                </td>
            </tr>
        <#else >
            <tr>
                <td></td>
                <td>Нет</td>
            </tr>
        </#list>
        </tbody>
    </table>
</@m.page>
