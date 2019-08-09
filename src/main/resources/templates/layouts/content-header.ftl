<#macro contentHeader>
    <section class="content-header">
        <h1>
            ${pageTitle!"Главная"}
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Главная</a></li>
            <#if breadcrumbs??>
                <#list breadcrumbs as b>
                    <#if b.url != "">
                        <li><a href="${b.url}">${b.label}</a></li>
                    <#else>
                        <li class="active">${b.label}</li>
                    </#if>
                </#list>
            </#if>
        </ol>
    </section>
</#macro>