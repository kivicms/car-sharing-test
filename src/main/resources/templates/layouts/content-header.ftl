<#macro contentHeader>
    <section class="content-header">
        <h1>
            ${pageTitle!"Главная"}
        </h1>
        <ol class="breadcrumb">
            <li><a href="/"><i class="fa fa-dashboard"></i> Главная</a></li>

                <#if breadcrumbs??>
                    <#list breadcrumbs as b>
                        <#if b[0] != "">
                            <li><a href="${b[0]}">${b[1]}</a></li>
                        <#else>
                            <li class="active">${b[1]}</li>
                        </#if>
                    </#list>
                </#if>

            <#--Как передать хешированный массив-->

            <#--<#list breadcrumbs?values as b>
                <#if b.url != "">
                    <li><a href="${b.url}">${b.label}</a></li>
                <#else>
                    <li class="active">${b.label}</li>
                </#if>
            </#list>-->


        </ol>
    </section>
</#macro>