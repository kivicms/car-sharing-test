<#macro contentHeader header breadcrumbs>
    <section class="content-header">
        <h1>
            ${header}
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Главная</a></li>

            <#list breadcrumbs as b>
                <#if b[0] != "">
                <li><a href="${b[0]}">${b[1]}</a></li>
                <#else>
                <li class="active">${b[1]}</li>
                </#if>
            </#list>
        </ol>
    </section>
</#macro>