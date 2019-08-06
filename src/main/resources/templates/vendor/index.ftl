<#import "../layouts/main.ftl" as m>
<#import "form.ftl" as f>

<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
            <div class="box-tools pull-right">
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#markForm"
                        aria-expanded="false" aria-controls="collapseExample">
                    Добавить
                </button>
            </div>
        </div>
        <div class="box-body">
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
                            <a href="/vendor/delete/${vendor.id}" class="btn btn-danger btn-xs delete-btn">
                                <i class="fa fa-fw fa-trash"></i>
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
        </div>
    </div>
</@m.page>
