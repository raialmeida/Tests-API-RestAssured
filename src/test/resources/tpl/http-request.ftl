<#ftl output_format="HTML">
<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpRequestAttachment" -->

<#function maskHeader name value>
    <#if name?? && name?lower_case == "authorization">
        <#if value?? && value?starts_with("Bearer ")>
            <#return "Bearer ********">
        <#else>
            <#return "********">
        </#if>
    </#if>
    <#return value!"null">
</#function>

<#assign maskedCurl = (data.curl!"")
    ?replace('(?i)(-H\\s+"Authorization:\\s*Bearer\\s+)([^"]+)(")', '$1********$3', 'r')
    ?replace("(?i)(-H\\s+'Authorization:\\s*Bearer\\s+)([^']+)(')", "$1********$3", "r")
    ?replace('(?i)(-H\\s+"Authorization:\\s*)([^"]+)(")', '$1********$3', 'r')
    ?replace("(?i)(-H\\s+'Authorization:\\s*)([^']+)(')", "$1********$3", "r")
>

<div style="margin-bottom: 16px;">
    <h2 style="margin: 0;">Request RestAssured</h2>
    <div style="color: #666;">Detalhes enviados para a API</div>
</div>

<div>

    <#if data.method??>${data.method}<#else>GET</#if>
    to
    <#if data.url??>${data.url}<#else>Unknown</#if>
</div>

<#if data.body??>
    <h4>Body</h4>
    <div>
        <pre class="preformated-text">
<#t>${data.body}
        </pre>
    </div>
</#if>

<#if (data.headers)?has_content>
    <h4>Headers</h4>
    <div>
        <#list data.headers as name, value>
            <div>${name}: ${maskHeader(name, value)}</div>
        </#list>
    </div>
</#if>

<#if (data.cookies)?has_content>
    <h4>Cookies</h4>
    <div>
        <#list data.cookies as name, value>
            <div>${name}: ${value!"null"}</div>
        </#list>
    </div>
</#if>

<#if data.curl??>
    <h4>Curl</h4>
    <div>
        <pre class="preformated-text">${maskedCurl}</pre>
    </div>
</#if>

<#if (data.formParams)?has_content>
    <h4>FormParams</h4>
    <div>
        <#list data.formParams as name, value>
            <div>${name}: ${value!"null"}</div>
        </#list>
    </div>
</#if>