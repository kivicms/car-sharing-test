<#import "../layouts/main.ftl" as m>
<#import "_form.ftl" as f>
<@m.page>
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">${pageTitle}</h3>
        </div>
        <div class="box-body">
            <@f.form></@f.form>
        </div>
    </div>
</@m.page>